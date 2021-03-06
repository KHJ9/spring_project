package com.dbtest.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import comV.javaV.DB.DBprocess;
import comV.javaV.arrayClass.DtoList;
import comV.javaV.common.PageMaker;

@Controller
public class NewsController {
	
	@RequestMapping("news_r")
	public String news_r(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
        PageMaker pagemaker = new PageMaker();
        String pagenum = request.getParameter("pagenum");//??΄μ§? κ°μ ?? ₯ λ°λ?€.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int ??Όλ‘? λͺ? λ²? ??΄μ§??Έμ§? ??΄μ§? κ°? ?λ³??
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_news WHERE title LIKE '%"+search+"%'";
        int totalC = proc.getTotalCount(sQueryCount);
        
    /*---------??΄μ§? κ°μ²΄? ?λ‘μ΄ ? λ³? ?€? μ§?? ?΄μ£Όλ λΆ?λΆ?------------------*/
        pagemaker.setTotalcount(totalC);//? μ²? κ²μκΈ? κ°μ μ§?? ??€
        pagemaker.setPagenum(cpagenum-1);//??¬ ??΄μ§?λ₯? ??΄μ§? κ°μ²΄? ?€? μ§?? ?΄μ€??€//λͺλ² ??΄μ§??Έμ§? PageMaker? ?Έ???€
        pagemaker.setCurrentblock(cpagenum);//??¬ ??΄μ§?λΈλ‘?΄ λͺλ²?Έμ§? ??¬ ??΄μ§? λ²νΈλ₯? ?΅?΄? μ§?? ??€
        pagemaker.setLastblock(totalC);//λ§μ?λ§? λΈλ‘ λ²νΈλ₯? ? μ²? κ²μκΈ? ?λ₯? ?΅?΄? ? ??€
    /*---------??΄μ§? κ°μ²΄? ?λ‘μ΄ ? λ³? ?€? μ§?? ?΄μ£Όλ λΆ?λΆ?------------------*/
        
        pagemaker.prevnext(cpagenum);//??¬ ??΄μ§? λ²νΈλ‘? ??΄? ????Όμ§? κ²°μ ??€
        pagemaker.setStartPage(pagemaker.getCurrentblock());//????΄μ§? λ²νΈλ₯? ??¬ ??΄μ§? λΈλ‘?Όλ‘? ? ??€
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //??¬ λΈλ‘ λ²νΈ?? λ§μ?λ§? λΈλ‘ λ²νΈλ₯? λ³΄λ΄? ??μ‘°νκ³? ??΄μ§? λΈλ‘? λ§μ?λ§? λ²νΈλ₯? μ§?? ??€
        
        String sQuery = "select num, title, reg_date, contents, hit  from h_news "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
		ArrayList<DtoList> newsList = proc.getNoticeList(sQuery);
		//System.out.println(newsList.get(0).getTitle());
        //λ§€νΌλ‘? ? ??΄μ§?? λͺκ° λ³΄μΌμ§? ,λͺλ² ??΄μ§? ?Έμ§? ? ?¬//λ§€νΌ.xml ?? ?¬?©?κΈ? ??΄? κ³±νκΈ? 10? ??€
 
        request.setAttribute("newsList", newsList);//sqlλ‘? ?»?? λ¦¬μ€?Έλ₯? .jsp??΄μ§?λ‘? ? ?¬
        request.setAttribute("page", pagemaker);//??΄μ§? λ²νΈ κ°μ²΄ .jsp??΄μ§?λ‘? ? ?¬		
        
        model.addAttribute("news", newsList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1λΆ??° ???? ??΄μ§? λ²νΈ
        model.addAttribute("nowPage", pagemaker.getPagenum()+1);
        
        model.addAttribute("totalPage", pagemaker.calcpage(totalC, pagemaker.getContentnum()));
		// κ²½λ‘ : views
		return "news/news_r";
	}
	
	@RequestMapping("news_w")
	public String news_w(HttpServletRequest request, Model model) {
		return "news/news_w";
	}
	
	@RequestMapping("news_t")
	public String news_t(HttpServletRequest request, Model model) {
		
		/* ?΄?© ?? ₯ μ²λ¦¬λ¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String num = proc.getNum("SELECT IFNULL(COUNT(*), 0)+1 AS number FROM h_news");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // κΈ??°κΈ?
			sQuery = "INSERT INTO h_news SET num='"+num+"', title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r? λ§€ν?? ?΄??€λ‘? ?΄???€.
		return "redirect:news_r";
	}
	
	@RequestMapping("news_v")
	public String news_v(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		String hitQuery = "UPDATE h_news SET hit=hit+1 "+
						  "WHERE num = '"+newsNum+"'";
		proc.save(hitQuery);
		String sQuery = "SELECT num, title, contents, reg_date, hit FROM h_news "+
						"WHERE num = '"+newsNum+"'";
		DtoList news = proc.view(sQuery);	
		
		model.addAttribute("news", news);
		return "news/news_v";
	}
	
	@RequestMapping("news_u")
	public String news_u(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		String sQuery = "SELECT num, title, contents, reg_date, hit FROM h_news "+
						"WHERE num = '"+newsNum+"'";
		DtoList news = proc.view(sQuery);	
		
		model.addAttribute("news", news);
		return "news/news_u";
	}
	
	@RequestMapping("news_update")
	public String news_update(HttpServletRequest request, Model model) {
		
		/* ?΄?© ?? ₯ μ²λ¦¬λ¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String newsNum = request.getParameter("t_news_num"); 
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		sQuery = "UPDATE h_news SET title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"' WHERE num = '"+newsNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r? λ§€ν?? ?΄??€λ‘? ?΄???€.
		return "redirect:news_r";
	}
	
	@RequestMapping("news_delete")
	public String news_delete(HttpServletRequest request, Model model) {
		
		/* ?΄?© ?? ₯ μ²λ¦¬λ¬? */
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_news WHERE num = '"+newsNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r? λ§€ν?? ?΄??€λ‘? ?΄???€.
		return "redirect:news_r";
	}
	
}
