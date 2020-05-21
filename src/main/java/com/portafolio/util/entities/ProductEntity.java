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

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name="PRODUCTO")
@Where(clause = "HABILITADO = 1")
@Data
public class ProductEntity implements Serializable {

	/**
	 * Serializado de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CODIGO_PRODUCTO")
	private Long productCode;
	
	@Column(name ="NOMBRE")
	private String name;
	
	@Column(name="DESCRIPCION")
	private String description;
	
	@Column(name = "PRECIO")
	private Long price;
	
	@Column(name = "STOCK")
	private Long stock;
	
	@ManyToOne
	@JoinColumn(name ="ID_PROVEEDOR", nullable = false)
	private SupplierEntity supplier = new SupplierEntity();
	
	@ManyToOne
	@JoinColumn(name ="ID_SUBFAMILIA_PRODUCTO", nullable = false)
	private ProductSubFamilyEntity subFamilyProduct = new ProductSubFamilyEntity();
	
	@Column(name = "MARCA_PRODUCTO")
	private String brandProduct;
	
	@Column(name = "IMAGEN_PRODUCTO")
	private String productImage;
	
	@Column(name="HABILITADO")
	private boolean enable;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Date expirationDate;

}
