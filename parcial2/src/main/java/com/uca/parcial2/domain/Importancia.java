package com.uca.parcial2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(schema="public",name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	private Integer codigoImportancia;
	
	@Column(name="s_importancia")
	private String nombreImportancia;
	
	@OneToMany(mappedBy="codigoImportancia", fetch=FetchType.EAGER)//SI NO FUNCIONA, CAMBIAR A CONTRIBUYENTE
	private List<Contribuyente> contribuyentes;
	
	

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}

	public Integer getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Integer codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public String getNombreImportancia() {
		return nombreImportancia;
	}

	public void setNombreImportancia(String nombreImportancia) {
		this.nombreImportancia = nombreImportancia;
	}
	
	
	public Importancia() {}
	

}
