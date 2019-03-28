package comV.javaV.haitae;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	}
	
}
