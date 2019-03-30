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
        String pagenum = request.getParameter("pagenum");//?˜?´ì§? ê°’ì„ ?…? ¥ ë°›ëŠ”?‹¤.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int ?˜•?œ¼ë¡? ëª? ë²? ?˜?´ì§??¸ì§? ?˜?´ì§? ê°? ?˜•ë³??™˜
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_news WHERE title LIKE '%"+search+"%'";
        int totalC = proc.getTotalCount(sQueryCount);
        
    /*---------?˜?´ì§? ê°ì²´?— ?ƒˆë¡œìš´ ? •ë³? ?‹¤?‹œ ì§?? •?•´ì£¼ëŠ” ë¶?ë¶?------------------*/
        pagemaker.setTotalcount(totalC);//? „ì²? ê²Œì‹œê¸? ê°œìˆ˜ ì§?? •?•œ?‹¤
        pagemaker.setPagenum(cpagenum-1);//?˜„?¬ ?˜?´ì§?ë¥? ?˜?´ì§? ê°ì²´?— ?‹¤?‹œ ì§?? •?•´ì¤??‹¤//ëª‡ë²ˆ ?˜?´ì§??¸ì§? PageMaker?— ?„¸?Œ…?•œ?‹¤
        pagemaker.setCurrentblock(cpagenum);//?˜„?¬ ?˜?´ì§?ë¸”ë¡?´ ëª‡ë²ˆ?¸ì§? ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ë¥? ?†µ?•´?„œ ì§?? •?•œ?‹¤
        pagemaker.setLastblock(totalC);//ë§ˆì?ë§? ë¸”ë¡ ë²ˆí˜¸ë¥? ? „ì²? ê²Œì‹œê¸? ?ˆ˜ë¥? ?†µ?•´?„œ ? •?•œ?‹¤
    /*---------?˜?´ì§? ê°ì²´?— ?ƒˆë¡œìš´ ? •ë³? ?‹¤?‹œ ì§?? •?•´ì£¼ëŠ” ë¶?ë¶?------------------*/
        
        pagemaker.prevnext(cpagenum);//?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ë¡? ?™”?‚´?‘œ ?‚˜???‚¼ì§? ê²°ì •?•œ?‹¤
        pagemaker.setStartPage(pagemaker.getCurrentblock());//?‹œ?‘?˜?´ì§? ë²ˆí˜¸ë¥? ?˜„?¬ ?˜?´ì§? ë¸”ë¡?œ¼ë¡? ? •?•œ?‹¤
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //?˜„?¬ ë¸”ë¡ ë²ˆí˜¸?? ë§ˆì?ë§? ë¸”ë¡ ë²ˆí˜¸ë¥? ë³´ë‚´?„œ ??ì¡°í•˜ê³? ?˜?´ì§? ë¸”ë¡?˜ ë§ˆì?ë§? ë²ˆí˜¸ë¥? ì§?? •?•œ?‹¤
        
        String sQuery = "select num, title, reg_date, contents, hit  from h_news "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
		ArrayList<DtoList> newsList = proc.getNoticeList(sQuery);
		//System.out.println(newsList.get(0).getTitle());
        //ë§¤í¼ë¡? ?•œ ?˜?´ì§??— ëª‡ê°œ ë³´ì¼ì§? ,ëª‡ë²ˆ ?˜?´ì§? ?¸ì§? ? „?‹¬//ë§¤í¼.xml ?—?„œ ?‚¬?š©?•˜ê¸? ?œ„?•´?„œ ê³±í•˜ê¸? 10?„ ?•œ?‹¤
 
        request.setAttribute("newsList", newsList);//sqlë¡? ?–»?? ë¦¬ìŠ¤?Š¸ë¥? .jsp?˜?´ì§?ë¡? ? „?‹¬
        request.setAttribute("page", pagemaker);//?˜?´ì§? ë²ˆí˜¸ ê°ì²´ .jsp?˜?´ì§?ë¡? ? „?‹¬		
        
        model.addAttribute("news", newsList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1ë¶??„° ?‹œ?‘?•˜?Š” ?˜?´ì§? ë²ˆí˜¸
        model.addAttribute("nowPage", pagemaker.getPagenum()+1);
        
        model.addAttribute("totalPage", pagemaker.calcpage(totalC, pagemaker.getContentnum()));
		// ê²½ë¡œ : views
		return "news/news_r";
	}
	
	@RequestMapping("news_w")
	public String news_w(HttpServletRequest request, Model model) {
		return "news/news_w";
	}
	
	@RequestMapping("news_t")
	public String news_t(HttpServletRequest request, Model model) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String num = proc.getNum("SELECT IFNULL(COUNT(*), 0)+1 AS number FROM h_news");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // ê¸??“°ê¸?
			sQuery = "INSERT INTO h_news SET num='"+num+"', title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
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
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
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
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:news_r";
	}
	
	@RequestMapping("news_delete")
	public String news_delete(HttpServletRequest request, Model model) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_news WHERE num = '"+newsNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:news_r";
	}
	
}
