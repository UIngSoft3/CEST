package com.cest.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.FichatecnicaDAO;
import com.cest.Models.Fichatecnica;

@Controller
@RequestMapping
public class FichaTecnicaController {
	
	@Autowired
	private FichatecnicaDAO  fichatecnicaDao;

	
	@GetMapping(value = "/registrarFichaTecnica")
	public String getRegistrarFichaTecnica(Model modelo) {
		modelo.addAttribute("fichatecnica", new Fichatecnica());
		return "registrarFichaTecnica";
	}
	
	@GetMapping(value = "/consultarFichaTecnica")
	public String getConsultarFichasTecnicas(Model modelo) {
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "consultarFichaTecnica";
	}	
	
	@GetMapping(value = "/modificarFichaTecnica")
	public Fichatecnica getModificarFichaTecnica(@RequestParam String tipo) {
		for (Fichatecnica fichatecnica : fichatecnicaDao.findAll()) {
			if (fichatecnica.getTipo().equals(tipo)) {			
				fichatecnicaDao.save(fichatecnica);
				return fichatecnica;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/modificarFichaTecnica")
	@ResponseBody
	public ModelAndView postModificarFichaTecnica(Model modelo, @ModelAttribute("fichatecnica") Fichatecnica fichatecnica, BindingResult rsult) {
		fichatecnicaDao.save(fichatecnica);
		return new ModelAndView("redirect:/consultarFichaTecnica");
	}
	
	
	@PostMapping(value="/registrarFichaTecnica")
	public ModelAndView postRegistrarFichaTecnica(@ModelAttribute("fichatecnica") Fichatecnica fichatecnica){
		fichatecnicaDao.save(fichatecnica);
		return new ModelAndView("redirect:/consultarFichaTecnica");
	}
	
	@PostMapping(value = "/eliminarFichaTecnica")
	@ResponseBody
	public boolean postEliminarFichaTecnica(@RequestParam("tipo") String tipo) {
		
		for (Fichatecnica fichatecnica : fichatecnicaDao.findAll()) {
			if (fichatecnica.getTipo().equals(tipo)) {
				fichatecnicaDao.delete(fichatecnica);
				return true;
			}
		}
		return false;
	}
	 
	

}
