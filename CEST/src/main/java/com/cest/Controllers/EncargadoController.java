package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.EncargadoDAO;
import com.cest.Models.Encargado;

@Controller
@RequestMapping
public class EncargadoController {
	
	@Autowired
	private EncargadoDAO encargadoDao;
	
	@GetMapping(value="/registrarEncargado")
	public String getRegistrarEncargado(Model modelo) {
		return "CRUD_Encargado";
	}
	
	@PostMapping(value="/registrarEncargado")
	public ModelAndView postRegistrarEncargado(@RequestParam int cedula,@RequestParam String nombre) {
		Encargado encargado = new Encargado();
		encargado.setCedula(cedula);
		encargado.setNombre(nombre);
		
		encargadoDao.save(encargado);
		return new ModelAndView("redirect:/registrarExtintor");
	}
	
	@PostMapping(value="/buscarEncargado")
	@ResponseBody
	public String buscarEncargado(@RequestParam String cedula) {
		for (Encargado encargado : encargadoDao.findAll()) {
			if ( encargado.getCedula() == Integer.valueOf(cedula) ) {
				return encargado.getNombre();
			}
		}
		return "";
	}
}
