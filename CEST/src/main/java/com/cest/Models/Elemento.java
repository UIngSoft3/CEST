package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Un elemento que será registrado en el sistema
 * @author IngeSoftII
 * @version
 * fecha: 12/07/2018
 */
@Entity
public class Elemento{
	
	@Id
	private int id;

	@NotNull
	@ManyToOne
	private Piso piso;
	
	@ManyToOne
	private Contrato contrato;

	@NotNull
	@ManyToOne
	private Encargado encargado;
	
	public Elemento() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the piso
	 */
	public Piso getPiso() {
		return piso;
	}

	/**
	 * @param piso the piso to set
	 */
	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	/**
	 * @return the contrato
	 */
	public Contrato getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the encargado
	 */
	public Encargado getEncargado() {
		return encargado;
	}

	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}
	
}
