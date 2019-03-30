package comV.javaV.haitae;

import java.util.ArrayList;
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

@Controller
public class MyController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		DBprocess proc = new DBprocess();
		String sQueryNotice = "SELECT num, title, contents, reg_date FROM h_notice ORDER BY num DESC LIMIT 5";
		ArrayList<Indexinfo> Notice = proc.getList(sQueryNotice);
		String sQueryNews = "SELECT num, title, contents, reg_date FROM h_news ORDER BY num DESC LIMIT 5";
		ArrayList<Indexinfo> News = proc.getList(sQueryNews);
		String sQueryEvent = "SELECT num, title, contents, reg_date FROM h_event ORDER BY num DESC LIMIT 5";
		ArrayList<Indexinfo> Event = proc.getList(sQueryEvent);
		
		model.addAttribute("notice", Notice);
		model.addAttribute("news", News);
		model.addAttribute("event", Event);
		return "index";
		// 
	}
	
	// private static final Logger logger = (Logger) LoggerFactory.getLogger(DBController.class);
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method=RequestMethod.POST, value="/Mybatis")
	public String list(HttpServletRequest request, Model model) {
		
		String register = request.getParameter("register");
		System.out.println("@@@@@@@@@@@@@@");
		
		model.addAttribute("register", mapper.get_notice("register"));
		return "Mybatis_practice";
	}
	
}
