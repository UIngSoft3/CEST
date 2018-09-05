package com.cest.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class IndexController {

	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping(value = "/navBar")
	public String getNavbar() {
		return "navBar";
	}
	
}
