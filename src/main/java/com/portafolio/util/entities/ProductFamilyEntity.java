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
@Table(name="FAMILIA_PRODUCTO")
@Data
public class ProductFamilyEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1320118574356990222L;
	
	@Id
	@Column(name="ID_FAMILIA_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FAMILIA_PRODUCTO")
	private String productFamily;

}
