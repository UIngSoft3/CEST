package com.cest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.UsuarioDAO;
import com.cest.Models.Usuario;

/**
 * Controla el ingreso a sesiones 
 * @author Santiago granada aguirre
 * @author Luis Trejos
 */
@Controller
@RequestMapping
public class LoginController {

    /**
     * verifica que el usuario exista y ademas que coincida con la contraseña
     * ingresada
     *
     * @param user usuario con el cual se ingresa sesion
     * @param password contraseña correspondiente a este usuario
     * @return vista principal
     */
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@GetMapping(value = "/iniciarSesion")
	public String GET(Model modelo) {
		modelo.addAttribute("usuario",new Usuario());
		return "login";
	}
	
	@PostMapping(value = "/iniciarSesion")
	public ModelAndView POST(Model modelo, @ModelAttribute Usuario usuario) {
		ModelAndView modelandview = null;
		Usuario userLogin = null;
		for (Usuario user : usuarioDao.findAll()) {
			if (usuario.getUsuario().equals(user.getUsuario()) && usuario.getContrasena().equals(user.getContrasena())) {
				userLogin = user;
				break;
			}
		}
		if(userLogin != null) {
			modelandview = new ModelAndView("redirect:/home");
		}else {
			modelandview = new ModelAndView("redirect:/iniciarSesion");
		}
		return modelandview; 
	}

}
