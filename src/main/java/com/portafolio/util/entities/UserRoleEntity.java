package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="USUARIO_ROL")
@Data
public class UserRoleEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_USUARIO_ROL", nullable = false, updatable = false) 
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="ID_USUARIO", nullable = false, updatable = false)
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name ="ID_ROL", nullable = false, updatable = false)
	private RoleEntity role;
}
