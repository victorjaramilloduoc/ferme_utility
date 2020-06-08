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
@Table(name="ESTADO_ORDEN_COMPRA")
@Data
public class StatusPurchaseOrderEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4374788951515564495L;
	
	@Id
	@Column(name = "ID_ESTADO_ORDEN_COMPRA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ESTADO_ORDEN_COMPRA")
	@JsonProperty("status_purchase_order")
	@SerializedName("status_purchase_order")
	private String statusPurchaseOrder;
	
	@Column(name = "FECHA_ESTADO_ORDEN_COMPRA")
	@JsonProperty("date_status_purchase_order")
	@SerializedName("date_status_purchase_order")
	private Date dateStatusPurchaseOrder = new Date();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="ID_ORDEN_COMPRA", nullable = false)
	@JsonProperty("purchase_order")
	@SerializedName("purchase_order")
	private PurchaseOrderEntity purchaseOrder = new PurchaseOrderEntity();

}
