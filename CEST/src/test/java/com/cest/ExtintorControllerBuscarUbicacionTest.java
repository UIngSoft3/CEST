package com.cest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.cest.Controllers.ExtintorController;
import com.cest.Models.Extintor;

/*
 * Pruebas para el método buscarUbicacion de ExtintorController
 * el cual devuelve una lista de los extintores que se encuentren
 * en la ubicación solicita, la cual se compone por sede, bloque y piso. 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerBuscarUbicacionTest {

	@Autowired
	private ExtintorController extintorCtrl;

	/*
	 * Prueba para buscar extintores en una ubicación donde SI hay extintores y se
	 * busca por sede, bloque y piso
	 */
	@Test
	@Sql("cestlt.sql")
	public void ExisteExtintorEnUbicacionCompletaTest() {
		List<Integer> esperados = new LinkedList<Integer>();
		esperados.add(1606);
		esperados.add(13);
		esperados.add(2431);
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Central", "C", "1");
		assertNotNull(extintores);
		assertEquals(3, extintores.size());
		List<Integer> actuales = new LinkedList<Integer>();
		for (Extintor extintor : extintores) {
			actuales.add(extintor.getIdelemento());
		}
		
		assertEquals(esperados, actuales);
	}

	/*
	 * Prueba para buscar extintores en una ubicación existente donde NO hay
	 * extintores y se busca por sede, bloque y piso
	 */
	@Test
	public void NoExisteExtintorEnUbicacionCompletaTest() {
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Central", "A", "1");
		assertEquals(0, extintores.size());
	}

	/*
	 * Prueba para buscar extintores en una ubicación existente donde SI hay
	 * extintores y solo se especifica la sede
	 */
	@Test
	public void ExisteExtintorEnUbicacionSedeTest() {
		List<Integer> esperados = new LinkedList<Integer>();
		esperados.add(3030);
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Palogrande", "", "");
		assertNotNull(extintores);
		assertEquals(1, extintores.size());
		List<Integer> actuales = new LinkedList<Integer>();
		for (Extintor extintor : extintores) {
			actuales.add(extintor.getIdelemento());
		}
		
		assertEquals(esperados, actuales);
	}

}
