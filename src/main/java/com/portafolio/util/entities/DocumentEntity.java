package com.portafolio.util.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="ID_TIPO_DOCUMENTO", nullable = false)
	private DocumentTypeEntity docuemntType;
	
	@Column(name="FECHA_DOCUMENTO")
	private Date documentDate;

}
