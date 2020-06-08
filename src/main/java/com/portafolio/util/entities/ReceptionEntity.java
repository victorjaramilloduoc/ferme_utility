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
import com.google.gson.annotations.SerializedName;

import lombok.Data;


@Entity
@Table(name="RECEPCION")
@Data
public class ReceptionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4982162414237545310L;
	
	@Id
	@Column(name = "ID_RECEPCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="ID_USUARIO", nullable = false)
	@JsonProperty("reception_user")
	@SerializedName("reception_user")
	private UserEntity receptionUser = new UserEntity();
	
	@Column(name = "FECHA_RECEPCION")
	@JsonProperty("reception_date")
	@SerializedName("reception_date")
	private Date receptionDate = new Date();
	
	@Column(name = "OBSERVACIONES")
	private String obsevations;

}
