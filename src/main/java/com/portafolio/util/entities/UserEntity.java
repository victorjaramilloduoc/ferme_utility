package com.portafolio.util.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="USUARIO")
@Data
public class UserEntity implements Serializable {

	/**
	 * Serializado de la clase
	 */
	private static final long serialVersionUID = -3492697663152327734L;
	
	//Este Tag hace referencia al id de la tabla en la base de datos.
	@Id
	// Este Tag hace referencia a la columna de la tabla en base de datos.
	@Column(name="ID_USUARIO")
	// Este tag nos ayudará en el caso que se agreguen nuevos usuarios, este tag creará automáticamente un id secuencial.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRE")
	private String name;

	@Column(name="APELLIDO")
	private String lastName;
	
	@Column(name ="CORREO_ELECTRONICO")
	private String email;

	@Column(name="RUT_USUARIO")
	private Long rut;
	
	@Column(name="DV_USUARIO")
	private char dv;
	
	@Column(name="SEXO_USUARIO")
	private char genere;
	
	@Column(name="FECHA_NACIMIENTO_USUARIO")
	private Date birthDate;
	
	@Column(name="PASS_USUARIO")
	private String password;
	
	@Column(name="DIRECCION")
	private String address;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="ID_COMUNA", nullable = false)
	private LocationEntity location;
	
	@Column(name="HABILITADO")
	private boolean enable;

}
