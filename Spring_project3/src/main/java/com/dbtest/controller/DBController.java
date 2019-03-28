package com.dbtest.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbtest.dao.Mapper;

@Controller
public class DBController {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(DBController.class);
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method=RequestMethod.POST, value="/Mybatis")
	public String list(HttpServletRequest request, Model model) {
		
		String register = request.getParameter("register");
		
		model.addAttribute("register", mapper.primary_num("register"));
		return "Mybatis_practice";
	}
	
}





