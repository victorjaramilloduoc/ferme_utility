package com.portafolio.util.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Entity
@Table(name="FORMA_PAGO")
@Data
public class PaymentMethodEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7110654726467182626L;
	
	@Id
	@Column(name="ID_FORMA_PAGO", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FORMA_PAGO")
	@JsonProperty("payment_method")
	@SerializedName("payment_method")
	private String paymentMethod;

}
