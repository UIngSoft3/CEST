package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author IngeSoftII
 * @version
 * fecha: 12/07/2018
 */
@Entity
public class Camilla{
	/*Primary Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	private String tipocamilla;
	private int encargado;
	
	/**
	 * @return the tipocamilla
	 */
	public String getTipocamilla() {
		return tipocamilla;
	}

	/*
	 * @param tipocamilla the tipocamilla to set
	 */
	public void setTipocamilla(String tipocamilla) {
		this.tipocamilla = tipocamilla;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public int getEncargado() {
		return encargado;
	}

	public void setEncargado(int encargado) {
		this.encargado = encargado;
	}

	public int getIdelemento() {
		return idelemento;
	}

	public void setIdelemento(int idelemento) {
		this.idelemento = idelemento;
	}
	
}
