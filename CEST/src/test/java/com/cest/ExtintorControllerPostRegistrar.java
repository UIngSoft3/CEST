package com.cest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import com.cest.Controllers.ExtintorController;
import com.cest.Models.Elemento;
import com.cest.Models.Extintor;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostRegistrar {
	
	@Autowired
	private ExtintorController extintorCtrl;
	
	Extintor extintor = new Extintor();
	
	@Before
	public void setup() {		
		extintor.setIdelemento(1011);
		extintor.setTamanio("15 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
	}
	
	
	@Test
	public void RegistrarExtintorTest() {		
		
		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, 
												extintor, 
												null, 
												"1234", 
												"999", 
												"Central", 
												"A", 
												"2", 
												"ABC", 
												"2018-03-11");
		assertNotNull(model);
		//assertEquals(new ModelAndView("redirect:/consulta?tipo=extintor"), model);
	}
	
	@Test
	public void BuscarElelemtoTest() {
		
		Elemento ele = extintorCtrl.BuscarElemento(1011);
		
		assertNull(ele);
	}
}
