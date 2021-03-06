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

import lombok.Data;

@Entity
@Table(name="PRODUCTO_VENTA")
@Data
public class ProductSaleEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004573782168067326L;
	
	@Id
	@Column(name="ID_PRODUCTO_VENTA", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="ID_PRODUCTO", nullable = false)
	private ProductEntity product;
	
	@Column(name = "CANTIDAD")
	private Long quantity;
}
