package com.cest.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ContratoDAO;
import com.cest.Dao.EmpresaDAO;
import com.cest.Models.Contrato;
import com.cest.Models.Empresa;

@Controller
@RequestMapping
public class EmpresaController {
	
	
	@Autowired
	private EmpresaDAO empresaDao;

	@Autowired
	private ContratoDAO contratoDao;
	
	@GetMapping(value = "/registrarEmpresa")
	public String getRegistrarEmpresa(Model modelo) {
		modelo.addAttribute("empresa", new Empresa());
		return "registrarEmpresa";
	}
	@GetMapping(value = "/consultarEmpresa")
	public List<Empresa> getConsultarEmpresas(Model modelo) {
		List<Empresa> empresas = new LinkedList<>();
		modelo.addAttribute("empresas", empresaDao.findAll());
		return empresas;
	}
	
	@GetMapping(value = "/modificarEmpresa")
	public Empresa getModificarEmpresa(@RequestParam int nit) {
		for (Empresa empresa : empresaDao.findAll()) {
			if (empresa.getNit() == nit) {			
				empresaDao.save(empresa);
				return empresa;
			}
		}
		return null;
	}
	

	
	@PostMapping(value = "/modificarEmpresa")
	@ResponseBody
	public ModelAndView postModificarEmpresa(@RequestParam("nit") int nit,
			@RequestParam("direccion") String direccion,
			@RequestParam("nombre") String nombre,
			@RequestParam("telefono") int telefono
			) {
		
		for (Empresa empresa1 : empresaDao.findAll()) {
			if (empresa1.getNit() == nit) {
				Empresa empresa = empresa1;
				empresa.setDireccion(direccion);
				empresa.setNombre(nombre);
				empresa.setTelefono(telefono);
				empresaDao.save(empresa);
				
				return new ModelAndView("redirect:/crudEmpresa");
			}
		}
		
		return null;
	}
	
	
	@PostMapping(value="/registrarEmpresa")
	public ModelAndView postRegistrarEmpresa(Model modelo, @ModelAttribute("empresa") Empresa empresa){
		empresaDao.save(empresa);
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping(value = "/crudEmpresaE")
	public ModelAndView postEliminarEmpresa(@RequestParam("nit") int nit) {
		for (Empresa empresa : empresaDao.findAll()) {
			if (empresa.getNit() == nit) {
				empresaDao.delete(empresa);
				return new ModelAndView("redirect:/crudEmpresa");
			}
		}
		
		return null;
	}
	 
	@PostMapping(value = "/obtenerEmpresa")
	@ResponseBody
	public String getEmpresa(@RequestParam String numerocontrato) {
		String nombreempresa = null;
		for (Contrato contrato : contratoDao.findAll()) {
			if (contrato.getNumero() == Integer.valueOf(numerocontrato)) {
				nombreempresa = contrato.getEmpresa().getNombre();
			}
		}
		return nombreempresa;
	}
	

	
}
