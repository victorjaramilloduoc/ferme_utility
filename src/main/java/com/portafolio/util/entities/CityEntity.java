package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Table(name="CIUDAD")
@Data
@Immutable
public class CityEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6350980852155943997L;
	
	@Id
	@Column(name="ID_CIUDAD", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CIUDAD", nullable = false, updatable = false)
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name ="ID_REGION", nullable = false)
	private RegionEntity region;

}
