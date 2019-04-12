package com.cest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cest.Dao.CamillaDAO;
import com.cest.Dao.ExtintorDAO;
import com.cest.Dao.ReporteDAO;
import com.google.gson.Gson;

@Controller
public class WebServiceConcertirJSON {
	
	@Autowired
	private ExtintorDAO extintorDao;
	
	@Autowired
	private CamillaDAO camillaDao;
	
	@Autowired
	private ReporteDAO reporteDao;
	
	@GetMapping("/convertir")
	@ResponseBody
	public String Convertir() {
		Gson gson = new Gson();
		char comillas = 34;
		String extintoresJson = gson.toJson(extintorDao.findAll());
		extintoresJson = comillas+"extintores"+comillas+":"+extintoresJson;
		String camillasJson = gson.toJson(camillaDao.findAll());
		camillasJson = comillas+"camillas"+comillas+":"+camillasJson;
		String reportesJson = gson.toJson(reporteDao.findAll());
		reportesJson = comillas+"reportes"+comillas+":"+reportesJson;
		return "{"+extintoresJson+","+camillasJson+","+reportesJson+"}";
	}

}
