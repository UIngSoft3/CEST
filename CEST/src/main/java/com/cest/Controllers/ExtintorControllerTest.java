package com.cest.Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Models.Elemento;
import com.cest.Models.Extintor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

class ExtintorControllerTest {
	ExtintorController extintorController;
	@BeforeEach
	void setup() {
		extintorController= new ExtintorController();
	}

	@Test
	public void RegistrarExtintorTest() {
		 
		
		
		Extintor extintor = new Extintor();
		extintor.setIdelemento(1011);
		
		
		ModelAndView model = extintorController.postRegistrarExtintor(null, 
												extintor, 
												null, 
												"1053410269", 
												"1111", 
												"Central", 
												"A", 
												"2", 
												"ABC", 
												"2018-03-11");
		
		assertEquals(new ModelAndView("redirect:/consulta?tipo=extintor"), model);
		
	}
	
	
	@Test
	public void BuscarElelemtoTest() {
		
		Elemento ele = extintorController.BuscarElemento(1010);
		
		assertNull(ele);
	}

}
