package com.portafolio.util.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;


@Entity
@Table(name="ORDEN_COMPRA")
@Data
public class PurchaseOrderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1087585964567193600L;
	
	@Id
	@Column(name = "ID_ORDEN_COMPRA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FECHA_COMPRA")
	@JsonProperty("date_purchase")
	@SerializedName("date_purchase")
	private Date datePurchase = new Date();
	
	@ManyToOne
	@JoinColumn(name ="ID_USUARIO", nullable = false)
	private UserEntity user = new UserEntity();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ID_RECEPCION", nullable = false)
	private ReceptionEntity reception = new ReceptionEntity();
	
	@ManyToOne
	@JoinColumn(name ="ID_PRODUCTO", nullable = false)
	private ProductEntity product = new ProductEntity();
	
	@Column(name = "CANTIDAD_PRODUCTO_OC")
	@JsonProperty("product_quantity")
	@SerializedName("product_quantity")
	private Long productQuantity;

}
