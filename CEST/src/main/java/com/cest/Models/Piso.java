package com.cest.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cest.LlavesCompuestas.PisoPK;


/**
 * Un piso perteneciente a un bloque de la sede
 * @author IngeSoftII
 * @version
 * fecha: 12/07/2018
 */
@Entity
public class Piso{
	
	public Piso() {
		// TODO Auto-generated constructor stub
	}
	
	//Llave compuesta
	
	 //Se define la llave primaria compuesta 
    //metodo getter que representa la llave primaria compuesta
    public PisoPK getPisoPk() {
        if (this.pisoPk == null) {
            this.pisoPk = new PisoPK();        
        }
        return pisoPk;
    }

    /** Metodo setter que representa la llave primaria compuesta */
    public void setPisoPk(final PisoPK pisoPk) {
        this.pisoPk = pisoPk;
    }

    /** @generated */
    @EmbeddedId
    private PisoPK pisoPk = new PisoPK();
	
	//Fin llave compuesta
    
    @ManyToOne
	private Bloque bloque;

	/**
	 * @return the bloque
	 */
	public Bloque getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
}
