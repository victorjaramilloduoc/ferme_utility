package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PROVEEDOR")
@Data
public class SupplierEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6235816196865768641L;
	
	@Id
	@Column(name="ID_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE")
	private String name;
	
	@Column(name="RUT_PROVEEDOR")
	private Long rut;
	
	@Column(name="DV_RUT_PROVEEDOR")
	private char dv;
	
	@Column(name="DIRECCION")
	private String address;
	
	@Column(name="RAZON_SOCIAL")
	private String businessName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ID_RUBRO", nullable = false)
	private HeadingEntity heading;
	
	@Column(name = "CELULAR")
	private Long phoneNumber;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ID_COMUNA", nullable = false)
	private LocationEntity location;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ID_USUARIO", nullable = false)
	private UserEntity user;
	

}
