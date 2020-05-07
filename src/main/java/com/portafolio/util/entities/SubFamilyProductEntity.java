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
@Table(name="SUBFAMILIA_PRODUCTO")
@Data
public class SubFamilyProductEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5478310281193456657L;
	
	
	@Id
	@Column(name="ID_SUBFAMILIA_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SUBFAMILIA_PRODUCTO")
	private String subFamilyProductName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ID_FAMILIA_PRODUCTO", nullable = false)
	private ProductFamilyEntity productFamily;
	
}
