package com.uca.parcial2.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.parcial2.dao.ContribuyenteDAO;
import com.uca.parcial2.dao.ImportanciaDAO;
import com.uca.parcial2.domain.Contribuyente;
import com.uca.parcial2.domain.Importancia;

@Transactional
@Controller
public class MainController {

	@Autowired
	private ContribuyenteDAO contribuyenteDao;
	
	@Autowired
	private ImportanciaDAO importanciaDao;
	
	@GetMapping("/inicio")
	public ModelAndView init() {
		ModelAndView mav=new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> listImportancia = importanciaDao.findAll();
		
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancia", listImportancia);
		
		mav.setViewName("index");
		return mav;		
	}
	
	@PostMapping(value="/agregar")
	public ModelAndView agregar(@ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();		
		try {			
				long millis=System.currentTimeMillis();
				Date date= new Date(millis);	     
				Importancia cod = new Importancia();
		        
		        cod.setCodigoImportancia(Integer.parseInt(result.getFieldValue("codigoImportancia").toString()));
		        contribuyente.setCodigoImportancia(cod);				
				contribuyente.setFechaIngreso(date);
				
				contribuyenteDao.insert(contribuyente);
				mav.setViewName("agregado");
								
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return mav;				
	}
	
	@GetMapping(value="/all")
	public ModelAndView showAll() {
		ModelAndView mav= new ModelAndView();
		
		List<Contribuyente> contribuyentes =null;
		try {
			contribuyentes=contribuyenteDao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		
		return mav;		
		
	}
	
	
	
}
