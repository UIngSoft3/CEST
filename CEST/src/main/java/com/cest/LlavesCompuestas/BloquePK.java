package com.cest.LlavesCompuestas;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class BloquePK implements Serializable, Cloneable{
	/*generated*/
	private static final long serialVersionUID = 1L;
	
	public BloquePK() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the letra
	 */
	public String getLetra() {	
		return letra;
	}

	/**
	 * @param numero the letra to set
	 */
	public void setLetra(String letra) {
		this.letra = letra;
	}

	/**
	 * @return the idSede
	 */
	public int getIdsede() {
		return idSede;
	}

	/**
	 * @param bloque the idSede to set
	 */
	public void setIdsede(int idSede) {
		this.idSede = idSede;
	}

	private String letra = null;
	
	private int idSede;
	
	public int hashCode() {
		return (int)(idSede + letra.hashCode());
	}
	
	public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof BloquePK)) return false;
        BloquePK pk = (BloquePK) obj;
        return pk.idSede == idSede && pk.letra.equals(letra);
    }
	
	

}
