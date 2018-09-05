package com.cest.Controllers;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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

import com.cest.Dao.BloqueDAO;
import com.cest.Dao.ContratoDAO;
import com.cest.Dao.ElementoDAO;
import com.cest.Dao.EncargadoDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.FichatecnicaDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Contrato;
import com.cest.Models.Elemento;
import com.cest.Models.Encargado;
import com.cest.Models.Extintor;
import com.cest.Models.Fichatecnica;
import com.cest.Models.Piso;
import com.cest.Models.Sede;



/*
 * Contrador para el index
 */
@Controller
@RequestMapping
public class ExtintorController {
	
	@Autowired
	private FichatecnicaDAO fichatecnicaDao;
	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private ExtintorDAO extintorDao;
	@Autowired
	private EncargadoDAO encargadoDao;
	@Autowired
	private ContratoDAO contratoDao;
	@Autowired
	private ElementoDAO elementoDao;
	@Autowired
	private BloqueDAO bloqueDao;
	@Autowired 
	private PisoDAO pisoDao;
	


	/*
	 * Visualiza pagina index
	 */
	@GetMapping(value = "/registrarExtintor")
	public String getRegistrarExtintor(Model modelo) {
		modelo.addAttribute("extintor", new Extintor());
		modelo.addAttribute("sedes", sedeDao.findAll());
		modelo.addAttribute("fichastecnicas", fichatecnicaDao.findAll());
		return "registrarExtintor";
	}
	
	@PostMapping(value = "/registrarExtintor")
	public ModelAndView postRegistrarExtintor(Model modelo, @ModelAttribute("extintor") Extintor extintor, BindingResult rsult
			, @RequestParam("cedulaencargado") String cedulaencargado
			, @RequestParam("numerocontrato") String numerocontrato
			, @RequestParam("sede") String nombresede
			, @RequestParam("bloque") String letrabloque
			, @RequestParam("piso") String numeropiso
			, @RequestParam("fichatecnica") String tipo
			, @RequestParam("fechaultimarecarga") String fecharecarga)
	{
		Elemento elemento = BuscarElemento(extintor.getIdelemento());
		if (elemento != null) {
			extintor.setElemento(elemento);
		}else {
			elemento = registrarElemento(extintor.getIdelemento(), nombresede, letrabloque, numeropiso, cedulaencargado, numerocontrato);
			extintor.setElemento(elemento);
		}
		String[] fechaRecarga = fecharecarga.split("-");
		Fichatecnica fichatecnica = BuscarFichatecnica(tipo);
		extintor.setFichatecnica(fichatecnica);	
		extintor.setFechaultimarecarga(LocalDate.of(Integer.valueOf(fechaRecarga[0])
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		extintor.setFechavencimiento(LocalDate.of(Integer.valueOf(fechaRecarga[0])+Integer.valueOf(extintor.getCaducidadanios())
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		extintorDao.save(extintor);
		return new ModelAndView("redirect:/consulta?tipo=extintor");
	}
	
	@PostMapping(value = "/existeExtintor")
	@ResponseBody
	public boolean existeExtintor(@RequestParam("id") String id) {
		for (Extintor extintor : extintorDao.findAll()) {
			if (extintor.getIdelemento() == Integer.valueOf(id)) {
				return true;
			}
		}
		return false;		
	}

	public Elemento BuscarElemento(int idelemento) {
		Elemento elemento = null;
		for (Elemento e : elementoDao.findAll()) {
			if (e.getId() == idelemento) {
				elemento = e;
			}
		}
		return elemento;
	}
	
	public Fichatecnica BuscarFichatecnica(String tipo) {
		Fichatecnica fichatecnica = null;
		for (Fichatecnica f : fichatecnicaDao.findAll()) {
			if (f.getTipo().equals(tipo)) {
				fichatecnica = f;
			}
		}
		return fichatecnica;
	}
	
	@GetMapping(value = "/actualizarExtintor")
	public String getActualizar(Model modelo) {
		modelo.addAttribute("sedes", sedeDao.findAll());
		modelo.addAttribute("fichastecnicas",fichatecnicaDao.findAll());
		return "actualizarExtintor";
	}
	
	@PostMapping(value = "/obtenerExtintor")
	@ResponseBody
	public Extintor getExtintor(@RequestParam String id) {
		for (Extintor extintor : extintorDao.findAll()) {
			if (extintor.getIdelemento() == Integer.valueOf(id)) {
				return  extintor;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/actualizarExtintor")
	public ModelAndView postActualizar(@RequestParam("id") String id
			, @RequestParam("cedulaencargado") String cedulaencargado
			, @RequestParam("numerocontrato") String numerocontrato
			, @RequestParam("tamanio") String tamanio
			, @RequestParam("fichatecnica") String tipo
			, @RequestParam("fechaultimarecarga") String fecharecarga
			, @RequestParam("caducidad") String caducidad
			, @RequestParam("fechavencimiento") String fechavencimiento
			, @RequestParam("estado") String estado
			, @RequestParam("sede") String nombresede
			, @RequestParam("bloque") String letrabloque
			, @RequestParam("piso") String numeropiso			
			)
	{
		Extintor extintor = null;
		for (Extintor extintorr : extintorDao.findAll()) {
			if (extintorr.getIdelemento() == Integer.valueOf(id)) {
				extintor = extintorr;
			}
		}
		Contrato contrato = null;
		for (Contrato contratoo : contratoDao.findAll()) {
			if (contratoo.getNumero() == Integer.valueOf(numerocontrato)) {
				contrato = contratoo;
			}
		}
		Encargado encargado = null;
		for (Encargado encargadoo : encargadoDao.findAll()) {
			if (encargadoo.getCedula() == Integer.valueOf(cedulaencargado)) {
				encargado = encargadoo;
			}
		}
		Fichatecnica fichatecnica = null;
		for (Fichatecnica fichatecnicaa : fichatecnicaDao.findAll()) {
			if (fichatecnicaa.getTipo().equals(tipo)) {
				fichatecnica = fichatecnicaa;
			}
		}
		Sede sede = null;
		for (Sede s : sedeDao.findAll()) {
			if (s.getNombre().equals(nombresede)) {
				sede = s;
			}
		}
		Bloque bloque = null;
		for (Bloque b : bloqueDao.findAll()) {
			if (b.getBloquePk().getLetra().equals(letrabloque) && b.getSede().equals(sede)) {
				bloque = b;
			}
		}
		Piso piso = null;
		for (Piso p : pisoDao.findAll()) {
			if (p.getPisoPk().getNumero() == Integer.valueOf(numeropiso) && p.getBloque().equals(bloque)) {
				piso = p;
			}
		}
		extintor.getElemento().setContrato(contrato);
		extintor.getElemento().setEncargado(encargado);
		extintor.setFichatecnica(fichatecnica);
		extintor.getElemento().setPiso(piso);
		extintor.setEstado(estado);
		extintor.setTamanio(tamanio);
		extintor.setCaducidadanios(caducidad);
		String[] fechaRecarga = fecharecarga.split("-");
		extintor.setFechaultimarecarga(LocalDate.of(Integer.valueOf(fechaRecarga[0])
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		extintor.setFechavencimiento(LocalDate.of(Integer.valueOf(fechaRecarga[0])+Integer.valueOf(caducidad)
				,Integer.valueOf(fechaRecarga[1])
				,Integer.valueOf(fechaRecarga[2])));
		
		extintorDao.save(extintor);
		
		return new ModelAndView("redirect:/consulta?tipo=extintor");
	}
	
	/*
	 * Registra un elemento en la base de datos
	 */
	public Elemento registrarElemento(int id, String nombresede
			, String letrabloque, String numeropiso
			, String cedulaencargado, String numerocontrato)
	{
		Encargado encargado = null;
		for (Encargado e : encargadoDao.findAll()) {
			if (e.getCedula() == Integer.valueOf(cedulaencargado)) {
				encargado = e;
			}
		}
		Contrato contrato = null;
		for (Contrato c : contratoDao.findAll()) {
			if (c.getNumero() == Integer.valueOf(numerocontrato)) {
				contrato = c;
			}
		}
		Sede sede = null;
		for (Sede s : sedeDao.findAll()) {
			if (s.getNombre().equals(nombresede)) {
				sede = s;
			}
		}
		Bloque bloque = null;
		for (Bloque b : bloqueDao.findAll()) {
			if (b.getBloquePk().getLetra().equals(letrabloque) && b.getSede().equals(sede)) {
				bloque = b;
			}
		}
		Piso piso = null;
		for (Piso p : pisoDao.findAll()) {
			if (p.getPisoPk().getNumero() == Integer.valueOf(numeropiso) && p.getBloque().equals(bloque)) {
				piso = p;
			}
		}
		Elemento elemento = null;
		if (encargado != null) {
			if (contrato != null) {
				elemento = new Elemento();
				elemento.setId(id);
				elemento.setContrato(contrato);
				elemento.setEncargado(encargado);
				elemento.setPiso(piso);
				elementoDao.save(elemento);
			}
		}
		return elemento;
	}
	
	@PostMapping(value = "/buscarID")
	@ResponseBody
	public List<Extintor> buscarID(@RequestParam("id") String id){
		List<Extintor> extintores = new LinkedList<>();
		if (id.equals("")) {
			extintores = (List<Extintor>)extintorDao.findAll();
		}else {
			for (Extintor extintor : extintorDao.findAll()) {
				if (extintor.getIdelemento() == Integer.valueOf(id)) {
					extintores.add(extintor);
				}
			}
		}
		return extintores;
	}

	@PostMapping(value = "/buscarUbicacion")
	@ResponseBody
	public List<Extintor> buscarUbicacion(@RequestParam("sede") String sede, @RequestParam("bloque") String bloque, @RequestParam("piso") String piso){
		List<Extintor> extintores = null;
		if (!sede.equals("")) {
			if (!bloque.equals("Seleccione") && !bloque.equals("")) {
				if (!piso.equals("Seleccione") && !piso.equals("")) {
					//Busqueda por Sede, Bloque y Piso
					extintores = new LinkedList<>();
					for (Extintor extintor : extintorDao.findAll()) {
						if (extintor.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
							if (extintor.getElemento().getPiso().getBloque().getBloquePk().getLetra().equals(bloque)) {
								if (extintor.getElemento().getPiso().getPisoPk().getNumero() == Integer.valueOf(piso)) {
									extintores.add(extintor);
								}
							}
						}
					}
				}else {
					//Busqueda por Sede y Bloque
					extintores = new LinkedList<>();
					for (Extintor extintor : extintorDao.findAll()) {
						if (extintor.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
							if (extintor.getElemento().getPiso().getBloque().getBloquePk().getLetra().equals(bloque)) {
								extintores.add(extintor);
							}
						}
					}
				}
			}else {
				//Busqueda por Sede
				extintores = new LinkedList<>();
				for (Extintor extintor : extintorDao.findAll()) {
					if (extintor.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
						extintores.add(extintor);
					}
				}
			}
		}else {
			extintores = (List<Extintor>) extintorDao.findAll();
		}
		return extintores;
	}
}