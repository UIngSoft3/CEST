package com.cest.Models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Botiquin{
	/*Foreign Key*/
	@Id
	private int idelemento;
	
	@ManyToOne
	private Elemento elemento;
	
	private int numerorecibdo;
	private LocalDate fechavencimiento;
	private String esparadrapo;
	private int cantidadesparadrapo;
	private LocalDate fechavencimientoesparadrapo;
	private String tapabocas;
	private String parcheocular;
	private String vendaalgodon;
	private String curaestandar;
	private String alcoholantiseptico;
	private String linterna;
	private String algodon;
	private String pito;
	private String solucionsalina;
	private String termometro;
	private String solucionyodada;
	private String saleshidratantes;
}
