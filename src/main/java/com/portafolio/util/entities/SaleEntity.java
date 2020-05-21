package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	
	@ManyToOne
	@JoinColumn(name ="ID_USUARIO", nullable = false)
	private UserEntity user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ID_DOCUMENTO", nullable = false)
	private DocumentEntity document;
	
	@ManyToOne
	@JoinColumn(name ="ID_FORMA_PAGO", nullable = false)
	private PaymentMethodEntity paymentMethod; 

}
