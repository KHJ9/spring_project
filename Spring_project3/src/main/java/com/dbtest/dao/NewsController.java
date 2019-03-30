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
        String pagenum = request.getParameter("pagenum");//?��?���? 값을 ?��?�� 받는?��.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int ?��?���? �? �? ?��?���??���? ?��?���? �? ?���??��
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_news WHERE title LIKE '%"+search+"%'";
        int totalC = proc.getTotalCount(sQueryCount);
        
    /*---------?��?���? 객체?�� ?��로운 ?���? ?��?�� �??��?��주는 �?�?------------------*/
        pagemaker.setTotalcount(totalC);//?���? 게시�? 개수 �??��?��?��
        pagemaker.setPagenum(cpagenum-1);//?��?�� ?��?���?�? ?��?���? 객체?�� ?��?�� �??��?���??��//몇번 ?��?���??���? PageMaker?�� ?��?��?��?��
        pagemaker.setCurrentblock(cpagenum);//?��?�� ?��?���?블록?�� 몇번?���? ?��?�� ?��?���? 번호�? ?��?��?�� �??��?��?��
        pagemaker.setLastblock(totalC);//마�?�? 블록 번호�? ?���? 게시�? ?���? ?��?��?�� ?��?��?��
    /*---------?��?���? 객체?�� ?��로운 ?���? ?��?�� �??��?��주는 �?�?------------------*/
        
        pagemaker.prevnext(cpagenum);//?��?�� ?��?���? 번호�? ?��?��?�� ?��???���? 결정?��?��
        pagemaker.setStartPage(pagemaker.getCurrentblock());//?��?��?��?���? 번호�? ?��?�� ?��?���? 블록?���? ?��?��?��
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //?��?�� 블록 번호?? 마�?�? 블록 번호�? 보내?�� ??조하�? ?��?���? 블록?�� 마�?�? 번호�? �??��?��?��
        
        String sQuery = "select num, title, reg_date, contents, hit  from h_news "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
		ArrayList<DtoList> newsList = proc.getNoticeList(sQuery);
		//System.out.println(newsList.get(0).getTitle());
        //매퍼�? ?�� ?��?���??�� 몇개 보일�? ,몇번 ?��?���? ?���? ?��?��//매퍼.xml ?��?�� ?��?��?���? ?��?��?�� 곱하�? 10?�� ?��?��
 
        request.setAttribute("newsList", newsList);//sql�? ?��?? 리스?���? .jsp?��?���?�? ?��?��
        request.setAttribute("page", pagemaker);//?��?���? 번호 객체 .jsp?��?���?�? ?��?��		
        
        model.addAttribute("news", newsList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1�??�� ?��?��?��?�� ?��?���? 번호
        model.addAttribute("nowPage", pagemaker.getPagenum()+1);
        
        model.addAttribute("totalPage", pagemaker.calcpage(totalC, pagemaker.getContentnum()));
		// 경로 : views
		return "news/news_r";
	}
	
	@RequestMapping("news_w")
	public String news_w(HttpServletRequest request, Model model) {
		return "news/news_w";
	}
	
	@RequestMapping("news_t")
	public String news_t(HttpServletRequest request, Model model) {
		
		/* ?��?�� ?��?�� 처리�? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String num = proc.getNum("SELECT IFNULL(COUNT(*), 0)+1 AS number FROM h_news");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // �??���?
			sQuery = "INSERT INTO h_news SET num='"+num+"', title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
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
		
		/* ?��?�� ?��?�� 처리�? */
		
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
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
		return "redirect:news_r";
	}
	
	@RequestMapping("news_delete")
	public String news_delete(HttpServletRequest request, Model model) {
		
		/* ?��?�� ?��?�� 처리�? */
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_news WHERE num = '"+newsNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
		return "redirect:news_r";
	}
	
}
