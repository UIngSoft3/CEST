package com.cest.Controllers;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ContratoDAO;
import com.cest.Models.Contrato;

@Controller
@RequestMapping
public class ContratoController {
	@Autowired
	private ContratoDAO contratoDao;
	
	@GetMapping(value="/registrarContrato")
	public String getRegistrarContrato() {
		return "registrarContrato";
	}
	
	@PostMapping(value="/registrarContrato")
	public ModelAndView postRegistrarContrato(@RequestParam String numero
			,@RequestParam String nitemepresa
			,@RequestParam String fecha
			,@RequestParam String valor
			,@RequestParam String descripcion)
	{
		Contrato contrato = buscarContrato(Integer.valueOf(numero));
		if (contrato == null) {
			contrato = new Contrato();
			contrato.setNumero(Integer.valueOf(numero));
			String[] fechaa = fecha.split("-");
			contrato.setFecha(LocalDate.of(Integer.valueOf(fechaa[0])
					,Integer.valueOf(fechaa[1])
					,Integer.valueOf(fechaa[2])));
			
		}
		return new ModelAndView("redirect:/registrarExtintor");
	}
	
	public Contrato buscarContrato(int numero) {
		for (Contrato contrato : contratoDao.findAll()) {
			if (contrato.getNumero() == numero) {
				return contrato;
			}
		}
		return null;
	}

}
