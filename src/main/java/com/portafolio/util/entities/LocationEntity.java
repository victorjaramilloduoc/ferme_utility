package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Table(name="COMUNA")
@Immutable
@Data
public class LocationEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2638670185229658099L;
	
	@Id
	@Column(name="ID_COMUNA", nullable = false, updatable = false)
	private Long id;
	
	@Column(name="COMUNA", nullable = false, updatable = false)
	private String locatioName;
	
	@ManyToOne
	@JoinColumn(name ="ID_CIUDAD", nullable = false)
	private CityEntity city;

}
