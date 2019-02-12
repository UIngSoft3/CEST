package com.cest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	 * Prueba para buscar extintores en una ubicación donde SI hay extintores y los
	 * 3 parámetros son especificados ll
	 */
	@Test
	public void ExisteExtintorEnUbicacionCompletaTest() {
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Central", "C", "1");
		assertEquals(3, extintores.size());

	}

	/*
	 * Prueba para buscar extintores en una ubicación existente donde NO hay
	 * extintores y los 3 parámetros son especificados
	 */
	@Test
	public void NoExisteExtintorEnUbicacionTest() {
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Central", "A", "1");
		assertEquals(0, extintores.size());

	}

	/*
	 * Prueba para buscar extintores en una ubicación existente donde SI hay
	 * extintores y solo se especifica la sede
	 */
	@Test
	public void NoExisteExtintorEnUbicacionSedeTest() {
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Palogrande", "", "");
		assertEquals(1, extintores.size());

	}

}
