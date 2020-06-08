package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="RUBRO")
@Data
public class HeadingEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8866371739750675950L;
	
	@Id
	@Column(name="ID_RUBRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TIPO_RUBRO")
	private String headingType;
	

}
