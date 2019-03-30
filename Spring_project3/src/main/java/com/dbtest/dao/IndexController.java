package com.dbtest.dao;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbtest.controller.DBController;
import com.dbtest.dao.Mapper;

import comV.javaV.DB.DBprocess;
import comV.javaV.arrayClass.Indexinfo;
import java.util.*;

@Controller(value="/haitai")
public class IndexController {
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getList")
	public String list(HttpServletRequest request, Model model) {
		
		// String register = request.getParameter("register");
		// mybatis(xml)을 이용하여 DB값 가져오기 예제
		
		List<Map> result = new ArrayList<Map>();
		
		System.out.println("데이터 불러오기 준비");
		
		result.add(mapper.get_notice());
		result.add(mapper.get_news());
		result.add(mapper.get_event());
		
		System.out.println(result.toString());
		
		model.addAttribute("list", result);
		model.addAttribute("test", "test");
		System.out.println("@@@@@@@@@@@@@@"+model.toString());
		return "redirect:index";
	}
	
}
