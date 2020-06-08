package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="REGIÓN")
@Data
public class RegionEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2868380745983370952L;
	
	@Id
	@Column(name="ID_REGIÓN", nullable = false, updatable = false) 
	private Long id;
	
	@Column(name="REGION", nullable = false, updatable = false)
	private String regionName;
	
}
