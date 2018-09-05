package com.cest.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cest.LlavesCompuestas.BloquePK;

/*
 * Un bloque perteneciente a una sede de la Universidad
 */
@Entity
public class Bloque {
	
	private String nombre;
	
	public Bloque() {
		// TODO Auto-generated constructor stub
	}
	
	//Llave compuesta
	
		 //Se define la llave primaria compuesta 
	    //metodo getter que representa la llave primaria compuesta
	    public BloquePK getBloquePk() {
	        if (this.bloquePk == null) {
	            this.bloquePk = new BloquePK();        
	        }
	        return bloquePk;
	    }

	    /** Metodo setter que representa la llave primaria compuesta */
	    public void setPisoPk(final BloquePK bloquePk) {
	        this.bloquePk = bloquePk;
	    }

	    /** @generated */
	    @EmbeddedId
	    public BloquePK bloquePk = new BloquePK();
		
		//Fin llave compuesta
	    
	    @ManyToOne
		private Sede sede;

		/**
		 * @return the sede
		 */
		public Sede getSede() {
			return sede;
		}

		/**
		 * @param bloque the sede to set
		 */
		public void setSede(Sede sede) {
			this.sede = sede;
		}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
