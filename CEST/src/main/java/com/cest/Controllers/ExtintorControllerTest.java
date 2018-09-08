package com.cest.Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import com.cest.Models.Extintor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

class ExtintorControllerTest {
	
	@BeforeEach
	void setup() {
		
	}

	@Test
	void RegistrarExtintor() {
		ExtintorController extintorController = new ExtintorController();
		
		
		Extintor extintor = new Extintor();
		
		
		extintorController.postRegistrarExtintor(null, 
												extintor, 
												null, 
												"1053410269", 
												"1111", 
												"Central", 
												"A", 
												"2", 
												"ABC", 
												"2018-03-11");
		
		
	}

}
