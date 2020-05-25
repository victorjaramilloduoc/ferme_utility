package com.portafolio.util.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
//	@JoinColumn(name ="ID_PRODUCTO", nullable = false)
	private List<ProductEntity> products;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ID_VENTA", nullable = false)
	private SaleEntity sale;
	
	@Column(name = "CANTIDAD")
	private Long quantity;
}
