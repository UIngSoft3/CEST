package com.cest.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Una sede de la Universidad
 */
@Entity
public class Sede {
	@Id
	private int id;
	
	private String nombre;
	
	public Sede() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
