package com.cest.Controllers;


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
import com.cest.Dao.CamillaDAO;
import com.cest.Dao.ElementoDAO;
import com.cest.Dao.EncargadoDAO;
import com.cest.Dao.PisoDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Bloque;
import com.cest.Models.Camilla;
import com.cest.Models.Contrato;
import com.cest.Models.Elemento;
import com.cest.Models.Encargado;
import com.cest.Models.Piso;
import com.cest.Models.Sede;

/**
 * esta clase se encagar de registar, midifcar, consutar las camillas
 * @author IngeSoftII
 * @version
 * fecha: 12/07/2018
 */
@Controller
@RequestMapping
public class CamillaController {
	
	@Autowired
	private SedeDAO sedeDao;
	@Autowired
	private BloqueDAO bloqueDao;
	@Autowired 
	private PisoDAO pisoDao;
	@Autowired
	private ElementoDAO elementoDao;
	@Autowired
	private CamillaDAO camillaDao;
	@Autowired
	private EncargadoDAO encargadoDao;
	
	/**	
	 * @author Lorenzo Zuluaga Urrea
	 * @version 6/7/2018
	 * 
	 * @param idelemento	
	 * @return
	 */
	@GetMapping(value = "/modificarCamilla")
	public String getModificarEmpresa(Model modelo, @RequestParam int id) {
		for (Camilla camilla : camillaDao.findAll()) {
			if (camilla.getIdelemento() == id) {			
				modelo.addAttribute("camilla", camilla);
				modelo.addAttribute("sedes", sedeDao.findAll());
			}
		}
		return "modificarCamilla";
	}

	/**	
	 * @author Lorenzo Zuluaga Urrea
	 * @version 6/7/2018
	 * @return
	 */
	@PostMapping(value = "/modificarCamilla")
	public ModelAndView postModificarCamilla(Model modelo, @ModelAttribute("camilla") Camilla camilla, BindingResult rsult,
			@RequestParam("cedulaencargado") String cedulaencargado,
			@RequestParam("sede") String nombresede,
			@RequestParam("bloque") String letrabloque,
			@RequestParam("piso") String numeropiso) 
	{
		Encargado encargado = null;
		for (Encargado e : encargadoDao.findAll()) {
			if (e.getCedula() == Integer.valueOf(cedulaencargado)) {
				encargado = e;
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
		camilla.getElemento().setPiso(piso);
		camilla.getElemento().setEncargado(encargado);
		camillaDao.save(camilla);
		return new ModelAndView("redirect:/consulta?tipo=camilla");
	}
	
	/**
	 * realiza una solicitud get de la vista consultar Camilla
	 * @param modelo
	 * @return string consutlarCamilla que es la ruta de la vista
	 * @author Santiago Granada
	 */
	@GetMapping(value = "/consultarCamilla")
	public String getConsultarCamilla(Model modelo) {
		modelo.addAttribute("camillas", camillaDao.findAll());
		return "consultaCamilla";
	}
	
	/**
	 * realiza una solicitud get de la vista con la ruta registrarCamilla
	 * @param modelo
	 * @return string registraCamilla que es la ruta de la vista
	 */
	@GetMapping(value = "/registrarCamilla")
	public String getRegistrarCamilla(Model modelo) {
		modelo.addAttribute("camilla", new Camilla());
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "registrarCamilla";
	}
	
	/**
	 * realiza la insercion a la base de datos de la camilla con sus parametros
	 * @param modelo
	 * @param camilla
	 * @param cedulaencargado
	 * @param nombresede
	 * @param letrabloque
	 * @param numeropiso
	 * @return
	 */
	@PostMapping(value = "/registrarCamilla")
	public ModelAndView postRegistrarCamilla(Model modelo, 
			@ModelAttribute("camilla") Camilla camilla, 
			@RequestParam("cedulaencargado") String cedulaencargado, 
			@RequestParam("sede") String nombresede, 
			@RequestParam("bloque") String letrabloque,
			@RequestParam("piso") String numeropiso) 
	{
		
		Elemento elemento = buscarElemento(camilla.getIdelemento());
		
		if (elemento != null) {
			camilla.setElemento(elemento);
		}else {
			elemento = registrarElemento(camilla.getIdelemento(), nombresede, letrabloque, numeropiso, cedulaencargado, "0");
			camilla.setElemento(elemento);
		}
		
		camillaDao.save(camilla);
		
		return new ModelAndView("redirect:/consulta?tipo=camilla");
	}
	
	@PostMapping(value = "/existeCamilla")
	@ResponseBody
	public boolean existeCamilla(@RequestParam("id") String id) {
		for (Camilla camilla : camillaDao.findAll()) {
			if (camilla.getIdelemento() == Integer.valueOf(id)) {
				return true;
			}
		}
		return false;		
	}
	
	/**
	 * busca un elemnto por codigo en la table elemento
	 * @param codigo del elemento a buscar
	 * @return el elemnto que coincide el codigo con el id
	 */
	public Elemento buscarElemento(int codigo) {
		Elemento elemento = null;
		for (Elemento e : elementoDao.findAll()) {
			if (e.getId() == codigo) {
				elemento = e;
			}
		}
		return elemento;
	}
	
	
	/**
	 * Registra un elemento en la base de datos
	 * @param id
	 * @param nombresede
	 * @param letrabloque
	 * @param numeropiso
	 * @param cedulaencargado
	 * @param numerocontrato
	 * @return
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
				elemento = new Elemento();
				elemento.setId(id);
				elemento.setContrato(contrato);
				elemento.setEncargado(encargado);
				elemento.setPiso(piso);
				elementoDao.save(elemento);
			
		}
		return elemento;
	}
	
	/**
	 * realiza una solicitud post la cuel permite filtrar las camillas por ubicacion, 
	 * ya sea por sede, bloque o piso
	 * @author Santiago Granada Aguirre
	 * @param sede
	 * @param bloque
	 * @param piso
	 * @return List<camilla> lista de camillas con las camillas filtradas
	 */
	@PostMapping(value = "/buscarUbicacionCamilla")
	@ResponseBody
	public List<Camilla> buscarUbicacion(@RequestParam("sede") String sede, @RequestParam("bloque") String bloque, @RequestParam("piso") String piso){
		List<Camilla> camillas = null;
		if (!sede.equals("")) {
			if (!bloque.equals("Seleccione") && !bloque.equals("")) {
				if (!piso.equals("Seleccione") && !piso.equals("")) {
					//Busqueda por Sede, Bloque y Piso
					camillas = new LinkedList<>();
					for (Camilla camilla : camillaDao.findAll()) {
						if (camilla.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
							if (camilla.getElemento().getPiso().getBloque().getBloquePk().getLetra().equals(bloque)) {
								if (camilla.getElemento().getPiso().getPisoPk().getNumero() == Integer.valueOf(piso)) {
									camillas.add(camilla);
								}
							}
						}
					}
				}else {
					//Busqueda por Sede y Bloque
					camillas = new LinkedList<>();
					for (Camilla camilla : camillaDao.findAll()) {
						if (camilla.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
							if (camilla.getElemento().getPiso().getBloque().getBloquePk().getLetra().equals(bloque)) {
							camillas.add(camilla);
							}
						}
					}
				}
			}else {
				//Busqueda por Sede
				camillas = new LinkedList<>();
				for (Camilla camilla : camillaDao.findAll()) {
					if (camilla.getElemento().getPiso().getBloque().getSede().getNombre().equals(sede)) {
						camillas.add(camilla);
					}
				}
			}
		}else {
			camillas = (List<Camilla>) camillaDao.findAll();
		}
		return camillas;
	}
}
