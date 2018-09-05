package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Esta clase contiene los atributos que tiene un reporte
 * se hace un reporte sobre el estado de un elemento
 */
@Entity
public class Reporte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tipoelemento;
	private LocalDate fechareporte;
	private String descripcion;
	private String argumento;
	private String estado;
	private String ubicacion;
	private String leido;
	private String notificado;
	
	public Reporte() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
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
	 * Este es el tipo de elemento que puede existir
	 * ya sea extintor, camilla o botiquin.
	 * @return the tipoelemento
	 */
	public String getTipoelemento() {
		return tipoelemento;
	}

	/**
	 * 
	 * @param tipoelemento the tipoelemento to set
	 */
	public void setTipoelemento(String tipoelemento) {
		this.tipoelemento = tipoelemento;
	}

	/**
	 * Fecha que se toma automaticamente cuando se registra
	 * un nuevo reporte
	 * @return the fechareporte
	 */
	public LocalDate getFechareporte() {
		return fechareporte;
	}

	/**
	 * @param fechareporte the fechareporte to set
	 */
	public void setFechareporte(LocalDate fechareporte) {
		this.fechareporte = fechareporte;
	}

	/**
	 * esta es la descripcion del estado en que se
	 * encontro cierto elemento para realizar un reporte
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

	/**
	 * este argumento sera modificado al momento de revisar 
	 * un reporte, en este campo se ingresara si ya se cambio el elemento 
	 * o se le hizo mantenimiento, la fecha o si esta pendiente el porque?
	 * @return the argumento
	 */
	public String getArgumento() {
		return argumento;
	}
	

	/**
	 * @param argumento the argumento to set
	 */
	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

	/**
	 * este es el estado del reporte que puede ser:
	 * pendiente, atendido, 
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * esta ubicacion esta compuesta por sede, bloque y piso
	 * donde se encontro el elemento a reportar.
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * este es un estado si el administrador ya leyo el reporte o no
	 * este estado se cambia automaticamente en caso de que el administrador
	 * abra el reporte y lo lea 
	 * @return the leido
	 */
	public String getLeido() {
		return leido;
	}

	/**
	 * @param leido the leido to set
	 */
	public void setLeido(String leido) {
		this.leido = leido;
	}

	/**
	 * 
	 * @return the notificado
	 */
	public String getNotificado() {
		return notificado;
	}

	/**
	 * @param notificado the notificado to set
	 */
	public void setNotificado(String notificado) {
		this.notificado = notificado;
	}
	
}
