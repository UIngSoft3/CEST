package com.cest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import com.cest.Controllers.ExtintorController;
import com.cest.Models.Elemento;
import com.cest.Models.Extintor;

import net.bytebuddy.asm.Advice.Thrown;

/**
 * clase para probar el metodo postRegistrarExtintor
 * con tres pruebas unitarias 
 * @author ARES
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostRegistrar {
	
	@Autowired
	private ExtintorController extintorCtrl;
	
	Extintor extintor = new Extintor();
	
	/**
	 * prueba unitaria para registrar un extintor normalmente
	 */
	@Test
	@Sql("cestlt.sql")
	public void RegistrarExtintorTest() {
		
		extintor.setIdelemento(9989);
		extintor.setTamanio("15 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "12345678","999", 
																"Central", "A", "2", "ABC",	"2018-03-11");
		
		assertNotNull(model);
	}
	
	
	/**
	 * prueba unitari para intenar registrar un extintor
	 * con el nuúmero de contrato no registrado
	 */
	@Test
	@Sql("cestlt.sql")
	public void ExtintorContratoNoRegistrado() {	
		
		extintor.setIdelemento(9986);
		extintor.setTamanio("10 Libras");
		extintor.setCaducidadanios("3");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "10279174", "111", 
																"Central", "D", "1", "CO2", "2018-03-11");
		
		
		assertNotNull(model);		
	}
	
	
	/**
	 * prueba unitaria para intenta registrar un extintor 
	 * con un encargado no registrado
	 * el metodo no registra ingun cambio en la base de datos 
	 */
	@Test
	@Sql("cestlt.sql")
	public void ExtintorEncargadoNoRegistrado() {	
		
		extintor.setIdelemento(9987);
		extintor.setTamanio("15 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "12345688", "999", 
																"Central", "A",	"2", "ABC",	"2018-03-11");
		
		assertNotNull(model);
	}
	
}
