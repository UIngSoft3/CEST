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

<<<<<<< HEAD
=======
import net.bytebuddy.asm.Advice.Thrown;

/**
 * clase para probar el metodo postRegistrarExtintor
 * con tres pruebas unitarias 
 * @author ARES
 *
 */
>>>>>>> 9507f744099927f2a51ed9edbbdc6be5d245c124
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostRegistrar {

	@Autowired
	private ExtintorController extintorCtrl;

	Extintor extintor = new Extintor();
<<<<<<< HEAD

	// antes de que se ejeute cada prueba
	// se realiza esta comfiguracion
	@Before
	@Sql()
	public void setup() {
=======
	
<<<<<<< HEAD
	/**
	 * prueba unitaria para registrar un extintor normalmente
	 */
	@Test
	@Sql("cestlt.sql")
	public void RegistrarExtintorTest() {
		
=======
	
	// antes de que se ejeute cada prueba 
	// se realiza esta comfiguracion
	@Before
	@Sql()
	public void setup() {		
>>>>>>> 71bc1aa671f113442e1b1654ba28e6dbee91c835
>>>>>>> 9507f744099927f2a51ed9edbbdc6be5d245c124
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
<<<<<<< HEAD

	@Test
	@Sql("cestlt.sql")
	public void RegistrarExtintorTest() {

		ModelAndView model = extintorCtrl.postRegistrarExtintor(null, extintor, null, "12345678", "999", "Central", "A",
				"2", "ABC", "2018-03-11");
		assertNotNull(model);
		// assertEquals(new ModelAndView("redirect:/consulta?tipo=extintor"), model);
=======
	
	
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
>>>>>>> 9507f744099927f2a51ed9edbbdc6be5d245c124
	}

}
