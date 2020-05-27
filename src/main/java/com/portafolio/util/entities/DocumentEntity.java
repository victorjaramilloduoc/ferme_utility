package com.portafolio.util.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="DOCUMENTO")
@Data
public class DocumentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389098533963648608L;
	
	@Id
	@Column(name="ID_DOCUMENTO", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="ID_TIPO_DOCUMENTO", nullable = false)
	@JsonProperty("document_type")
	private DocumentTypeEntity documentType;
	
	@Column(name="FECHA_DOCUMENTO")
	@JsonProperty("document_date")
	private Date documentDate = new Date();

}
