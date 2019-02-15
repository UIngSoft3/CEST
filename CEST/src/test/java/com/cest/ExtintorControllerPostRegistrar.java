package com.cest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import com.cest.Controllers.ExtintorController;
import com.cest.Models.Extintor;


/**
 * clase para realizar pruebas unitarias 
 * del metodo postRegistrarExtintor
 * @author ARES
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostRegistrar {

	private Extintor extintor;
	
	@Autowired
	private ExtintorController extintorCtrl;

	public ExtintorControllerPostRegistrar() {
		 this.extintor = new Extintor();
	}	
	
	
	/**
	 * prueba para registrar un extintor 
	 * con un id no registrado en la BD
	 */
	@Test
	@Sql("cestlt.sql")
	public void extintorNoRegistrado() {	
		
		extintor.setIdelemento(1789);
		extintor.setTamanio("10 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "9876147", "777", 
																"Central", "A", "1", "ABC", "2018-03-11");
		
		
		assertNotNull(model);		
	}
	

	/**
	 * prueba para registrar un extintor 
	 * con un id registrado en la BD
	 */
	@Test
	@Sql("cestlt.sql")
	public void ExtintorRegistrado() {

		extintor.setIdelemento(1606);
		extintor.setTamanio("10 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "12344541", "999", 
																"Central", "A", "2", "ABC", "2018-03-11");
		
		
		assertNull(model);	
	}
	
	
	/**
	 * prueba para registrar un extintor 
	 * con un encargado no registrado
	 */
	@Test
	@Sql("cestlt.sql")
	public void ExtintorEncargadoNoRegistrado() {	
		
		extintor.setIdelemento(2431);
		extintor.setTamanio("15 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "10369874", "555", 
																"Palogrande", "H",	"2", "ABC",	"2018-03-11");
		
		assertNull(model);
	}

}
