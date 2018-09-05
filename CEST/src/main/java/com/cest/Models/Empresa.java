package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una empresa que suministra los elementos
 */
@Entity
public class Empresa {
	@Id
	private int nit;
	
	private String nombre;
	private int telefono;
	private String direccion;
	/**
	 * @return the nit
	 */
	public int getNit() {
		return nit;
	}
	/**
	 * @param nit the nit to set
	 */
	public void setNit(int nit) {
		this.nit = nit;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
