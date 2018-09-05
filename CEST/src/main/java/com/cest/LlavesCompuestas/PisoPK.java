package com.cest.LlavesCompuestas;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class PisoPK implements Serializable, Cloneable{
	/*generated*/
	private static final long serialVersionUID = 1L;
	
	public PisoPK() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the letraBloque
	 */
	public String getLetrabloque() {
		return letraBloque;
	}

	/**
	 * @param bloque the letraBloque to set
	 */
	public void setLetrabloque(String bloque) {
		this.letraBloque = bloque;
	}

	private int numero;
	
	private String letraBloque = null;
	
	public int hashCode() {
		return (int)(numero + letraBloque.hashCode());
	}
	
	public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof PisoPK)) return false;
        PisoPK pk = (PisoPK) obj;
        return pk.numero == numero && pk.letraBloque.equals(letraBloque);
    }
	
	

}
