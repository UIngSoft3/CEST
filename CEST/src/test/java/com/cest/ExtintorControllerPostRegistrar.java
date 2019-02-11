package com.cest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import com.cest.Controllers.ExtintorController;
import com.cest.Models.Extintor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostRegistrar {

	@Autowired
	private ExtintorController extintorCtrl;

	Extintor extintor = new Extintor();

	// antes de que se ejeute cada prueba
	// se realiza esta comfiguracion
	@Before
	@Sql()
	public void setup() {
		extintor.setIdelemento(9989);
		extintor.setTamanio("15 Libras");
		extintor.setCaducidadanios("2");
		extintor.setEstado("Activo");
	}

	@Test
	@Sql("cestlt.sql")
	public void RegistrarExtintorTest() {

		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "12345678", "999", "Central", "A",
				"2", "ABC", "2018-03-11");
		assertNotNull(model);
		// assertEquals(new ModelAndView("redirect:/consulta?tipo=extintor"), model);
	}

}
