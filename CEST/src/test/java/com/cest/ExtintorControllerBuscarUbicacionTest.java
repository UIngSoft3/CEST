package com.cest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cest.Controllers.ExtintorController;
import com.cest.Models.Extintor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtintorControllerBuscarUbicacionTest {

	@Autowired
	private ExtintorController extintorCtrl;
	
	@Test
	public void BuscarUbicacionTest() throws Exception {
		List<Extintor> extintores = extintorCtrl.buscarUbicacion("Central", "C", "1");
		for (Extintor extintor : extintores) {
			System.out.println("Extintor: "+extintor.getIdelemento());
		}
		
	}

}
