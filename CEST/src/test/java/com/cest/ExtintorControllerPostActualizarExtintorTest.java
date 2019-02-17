package com.cest;


import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cest.Controllers.ExtintorController;
import com.cest.Models.Extintor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerPostActualizarExtintorTest {

	@Autowired
	private ExtintorController extintorController;
	
	/*
	 * 
	 *  prueba modifica un extintor existente
	 *  se modifica los valores del extintor y se
	 *  prueba que sea distinto al mismo extinto
	 */
	@Test
	public void modificarExtintorExistenteTest() {
		Extintor extintorAntes = extintorController.getExtintor("1606");
		String[] datosAntes = { ""+extintorAntes.getIdelemento(), extintorAntes.getTamanio(),
				""+extintorAntes.getFechaultimarecarga(), ""+extintorAntes.getFechavencimiento(),
				extintorAntes.getEstado(),
				
		};
		extintorController.postActualizar("1606", "9876", "999", "20 Libras", "ABC", "2018-05-16", "3", "2021-09-16", "Activo", "Central", "C", "1");
		Extintor extintorDespues = extintorController.getExtintor("1606");
		String datosDespues[] = { ""+extintorDespues.getIdelemento(), extintorDespues.getTamanio(),
				""+extintorDespues.getFechaultimarecarga(), ""+extintorDespues.getFechavencimiento(),
				extintorDespues.getEstado(),
		};
		for (int i = 0; i < datosAntes.length; i++) {
			assertNotSame(datosAntes[i], datosDespues[i]);
		}
	}
	
	/**
	 * prueba para modificar el tamaño de
	 * un extintor existente
	 */
	@Test
	public void noModificarExtintorExistenteTest() {
		Extintor extintorAntes = extintorController.getExtintor("2020");
		String[] datosAntes = { ""+extintorAntes.getIdelemento(), extintorAntes.getTamanio(),
				""+extintorAntes.getFechaultimarecarga(), ""+extintorAntes.getFechavencimiento(),
				extintorAntes.getEstado(),
		};
		extintorController.postActualizar("2020", "9876", "888", "15 Libras", "CO2", "2018-05-16", "4", "2022-05-16", "Activo", "Central", "C", "1");
		Extintor extintorDespues = extintorController.getExtintor("1606");
		String datosDespues[] = { ""+extintorDespues.getIdelemento(), extintorDespues.getTamanio(),
				""+extintorDespues.getFechaultimarecarga(), ""+extintorDespues.getFechavencimiento(),
				extintorDespues.getEstado(),
		};
		for (int i = 0; i < datosAntes.length; i++) {
			assertNotSame(datosAntes[i], datosDespues[i]);
		}	
	}
	
	@Test
	public void modificarExtintorNoExistenteTest() {
		extintorController.postActualizar("12", "9876", "888", "40 Libras", "CO2", "2018-05-16", "4", "2021-05-16", "Activo", "Central", "C", "1");
		Extintor extintor = extintorController.getExtintor("12"); 
		assertNull(extintor);
	}
}
