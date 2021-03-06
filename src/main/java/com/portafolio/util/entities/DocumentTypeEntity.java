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
@Table(name="TIPO_DOCUMENTO")
@Data
public class DocumentTypeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1768107872111293708L;
	
	@Id
	@Column(name="ID_TIPO_DOCUMENTO", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TIPO_DOCUMENTO")
	@JsonProperty("document_type")
	@SerializedName("document_type")
	private String documentType;

}
