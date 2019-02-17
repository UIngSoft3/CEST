package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Contacto de la persona que ha realizado un reporte
 * @author Luis Trejos
 * @version 15/02/2019
 */
@Entity
public class ContactoReporte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	private int telefono;
	private String correo;
	
	/**
	 * Constructor para un contacto
	 * @param nombre Nombre del contacto
	 * @param telefono Teléfono del contacto
	 * @param correo Correo del contacto
	 */
	public ContactoReporte(String nombre, int telefono, String correo) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
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
}
