package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ElementoDAO;
import com.cest.Models.Elemento;

@Controller
@RequestMapping
public class ElementoController {
	
	@Autowired
	private ElementoDAO elementoDao;
	
	@GetMapping(value = "/registrarElementos")
	public String getRegistro(Model modelo) {
		modelo.addAttribute("elemento", new Elemento());
		return "registro";
	}
	
	@PostMapping(value = "/registrarElementos")
	public ModelAndView Post(Model modelo,@ModelAttribute Elemento elemento) {
		elementoDao.save(elemento);
		ModelAndView modelandview = new ModelAndView("redirect:/");
		return modelandview; 
	}

}
