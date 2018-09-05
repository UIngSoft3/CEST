package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Ficha tecnica de un extintor
 */
@Entity
public class Fichatecnica {
	@Id
	private String tipo;
	
	private String componentes;
	
	private String descripcion;

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the componentes
	 */
	public String getComponentes() {
		return componentes;
	}

	/**
	 * @param componentes the componentes to set
	 */
	public void setComponentes(String componentes) {
		this.componentes = componentes;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	
	
}
