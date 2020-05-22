package com.uca.parcial2.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer codigoContribuyente;
	/*
	@Column(name="c_importancia")
	private Integer codigoImportancia;*/
	@JoinColumn(name="c_importancia")
	@ManyToOne(fetch=FetchType.EAGER)
	Importancia codigoImportancia;
	
	@Column(name="s_nombre")
	private String nombreContribuyente;
	
	@Column(name="s_apellido")
	private String apellidoContribuyente;
	
	@Column(name="s_nit")
	private String nitContribuyente;
	
	@Column(name="f_fecha_ingreso")
	private Date fechaIngreso;

	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}

	

	public Importancia getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Importancia codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public String getNombreContribuyente() {
		return nombreContribuyente;
	}

	public void setNombreContribuyente(String nombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}

	public String getApellidoContribuyente() {
		return apellidoContribuyente;
	}

	public void setApellidoContribuyente(String apellidoContribuyente) {
		this.apellidoContribuyente = apellidoContribuyente;
	}

	public String getNitContribuyente() {
		return nitContribuyente;
	}

	public void setNitContribuyente(String nitContribuyente) {
		this.nitContribuyente = nitContribuyente;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}	
	
	public void setFechaIngreso(Date date) {		
        this.fechaIngreso=date;        
	}
	
	//FUNCION DELEGATE
	public String getNombreImportancia() {
		if(this.codigoImportancia==null)return "-";
		else {
			switch(this.codigoImportancia.getCodigoImportancia()) {
				case 1:
					return "Grandes";
				case 2: 
					return "Medianos";
				case 3: 
					return "Otros";
				
				default:
					return"";			
			}
		}
	}
	
	
	
	public Contribuyente() {}
	
	
	

}
