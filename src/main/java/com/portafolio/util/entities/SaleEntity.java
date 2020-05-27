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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity(name = "SaleEntity")
@Table(name="VENTA")
@Data
public class SaleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4558158873613155002L;
	
	@Id
	@Column(name="ID_VENTA", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="ID_VENTA", referencedColumnName="ID_VENTA", nullable = false)
	@JsonProperty("products_sale")
	private List<ProductSaleEntity> productsSale;
	
	@ManyToOne
	@JoinColumn(name ="ID_USUARIO", nullable = false)
	private UserEntity user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ID_DOCUMENTO", nullable = false)
	private DocumentEntity document;
	
	@ManyToOne
	@JoinColumn(name ="ID_FORMA_PAGO", nullable = false)
	@JsonProperty("payment_method")
	private PaymentMethodEntity paymentMethod; 

}
