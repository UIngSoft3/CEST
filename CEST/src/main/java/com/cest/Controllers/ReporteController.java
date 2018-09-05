package com.cest.Controllers;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Dao.ReporteDAO;
import com.cest.Dao.SedeDAO;
import com.cest.Models.Reporte;


/**
 * esta clase es el controllador de reporte encargada de realizar todos los 
 * metodos  relacionados con el reporte, tanto el registro, la modificacion,
 * como cambio de la notificacion, de estados y de leido o no. 
 * @author IngSostII
 *
 */

/*
 * @author Lorenzo Zuluaga Urrea
 * @version 07/22/2018
 */
@Controller
@RequestMapping
public class ReporteController {
	@Autowired
	private SedeDAO sedeDao;
	
	@Autowired
	private ReporteDAO reporteDao;
	
	
	@GetMapping(value="/registrarReporte")
	public String getRegistrarReporte(Model modelo) {
		modelo.addAttribute("sedes", sedeDao.findAll());
		return "VentanaRegistrarReporte";
	}
	
	/**
	 * este metodo es el encargado de tomar los datos ingresados de un nuevo 
	 * reporte y almacenarlos. 
	 * @param tipoelemento
	 * @param sede
	 * @param bloque
	 * @param piso
	 * @param descripcion
	 * @return
	 */
	@PostMapping(value="/registrarReporte")
	public ModelAndView postRegistrarReporte(@RequestParam("tipoelemento") String tipoelemento
			,@RequestParam("sede") String sede
			,@RequestParam("bloque") String bloque
			,@RequestParam("piso") String piso
			,@RequestParam("descripcion") String descripcion) 
	{
		Reporte reporte = new Reporte();
		reporte.setTipoelemento(tipoelemento);
		Calendar fecha = new GregorianCalendar();
		reporte.setFechareporte(LocalDate.of(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH) + 1,fecha.get(Calendar.DAY_OF_MONTH)));
		reporte.setDescripcion(descripcion);
		reporte.setEstado("Pendiente");
		reporte.setUbicacion("Sede: "+sede+" Bloque: "+bloque+" Piso: "+piso);
		reporte.setLeido("No");
		reporte.setNotificado("No");
		reporteDao.save(reporte);
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	/**
	 * metodo encargado de cambiar estado de la notificacion, 
	 * se cambia su estado "notificado" si ya fue mostrado  de 
	 * NO A SI
	 * @param id
	 * @return
	 */
	@PostMapping(value="/cambiarNotificado")
	@ResponseBody
	public Reporte cambiarNotificado(@RequestParam int id){
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getId() == id) {
				reporte.setNotificado("Si");
				reporteDao.save(reporte);
				return reporte;
			}
		}
		return null;
	}

	
	
	/**
	 * 
	 * @return
	 */
	@PostMapping(value = "/buscarCambioBD")
	@ResponseBody
	public List<Reporte> getCambio() {
		List<Reporte> reportes = new LinkedList<>();
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getLeido().equalsIgnoreCase("No")) {
				reportes.add(reporte);
			}
		}
		return reportes;
	}
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/consultarReporteId")
	public String getConsultarReporteId(Model modelo, @RequestParam String id) {
		if (Integer.valueOf(id) == -1) {
			modelo.addAttribute("reportes", reporteDao.findAll());
		}else {
			List<Reporte> reportes = new LinkedList<>();
			for (Reporte reporte : reporteDao.findAll()) {
				if (reporte.getId() == Integer.valueOf(id)) {

					reportes.add(reporte);
				}
			}
			modelo.addAttribute("reportes", reportes);
		}
		return "consultarReporte";
	}
	
	@GetMapping(value = "/consultarReporteEstado")
	public String getConsultarReporteEstado(Model modelo, @RequestParam String estado) {
		List<Reporte> reportes = new LinkedList<>();
		if(estado.equals("")) {
			modelo.addAttribute("reportes", reporteDao.findAll());
		}else{
			for (Reporte reporte : reporteDao.findAll()) {
				if (reporte.getEstado().equals(estado)) {
					reportes.add(reporte);
				}
			}
			modelo.addAttribute("reportes", reportes);
		}
		return "consultarReporte";
	}
	

	@GetMapping(value = "/modificarReporte")
	public Reporte getModificarReporte(@RequestParam int id) {
		for (Reporte reporte : reporteDao.findAll()) {
			if (reporte.getId() == id) {
				reporte.setLeido("Si");
				
				reporteDao.save(reporte);
				return reporte;
			}
		}
		return null;
	}
	
	
	@PostMapping(value = "/modificarReporte")
	@ResponseBody
	public ModelAndView postModificarReporte(@RequestParam("id") int id,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("argumentacion") String argumentacion
			) {
		
		for (Reporte reporte1 : reporteDao.findAll()) {
			if (reporte1.getId() == id) {
				Reporte reporte = reporte1;
				reporte.setEstado("Revisado");
				reporte.setDescripcion(descripcion);
				reporte.setArgumento(argumentacion);
				reporteDao.save(reporte);
				
				return new ModelAndView("redirect:/consultarReporte");
			}
		}
		
		return null;
	}
	
}
