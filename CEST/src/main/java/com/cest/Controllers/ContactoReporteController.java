package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cest.Dao.ContactoReporteDAO;
import com.cest.Models.ContactoReporte;

/**
 * Controlador de la entidad Contacto.
 * Se encarga de hacer de la interface ContactoReporteDAO
 * para registrar la información de contacto de una persona 
 * que realiza un reporte
 * @author Luis Trejos
 * @version 15/02/2019 
 */
@Controller
public class ContactoReporteController {
	
	@Autowired
	private ContactoReporteDAO contactoDao;
	
	public ContactoReporteController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método que guarda un CaontactoReporte en la base de datos
	 * @param nombre Nombre del contacto
	 * @param telefono Teléfono del contacto
	 * @param correo Correo del contacto
	 * @return contacto El contacto que ha sido guardado en la base de datos
	 */
	public ContactoReporte guardarContactoReporte(String nombre, int telefono, String correo) {
		ContactoReporte contacto = new ContactoReporte(nombre, telefono, correo);
		contactoDao.save(contacto);		
		return contacto;		
	}

}
