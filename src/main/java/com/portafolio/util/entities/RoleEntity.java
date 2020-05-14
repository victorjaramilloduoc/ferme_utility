package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ROL")
@Data
public class RoleEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_ROL", nullable = false, updatable = false) 
	private Long id;
	
	@Column(name="TIPO_ROL", nullable = false, updatable = false) 
	private String roleType;
	
}
