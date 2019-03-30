package com.dbtest.dao;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import comV.javaV.DB.DBprocess;
import comV.javaV.arrayClass.DtoList;
import comV.javaV.common.Common;
import comV.javaV.common.FileUploadService;
import comV.javaV.common.PageMaker;

@Controller
public class NoticeController {
	
	@RequestMapping("notice_r")
	public String notice_r(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
        PageMaker pagemaker = new PageMaker();
        String pagenum = request.getParameter("pagenum");//?˜?´ì§? ê°’ì„ ?…? ¥ ë°›ëŠ”?‹¤.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int ?˜•?œ¼ë¡? ëª? ë²? ?˜?´ì§??¸ì§? ?˜?´ì§? ê°? ?˜•ë³??™˜
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_notice WHERE title LIKE '%"+search+"%'";
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
        
        String sQuery = "select num, title, reg_date, contents, file_name, hit  from h_notice "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
        
		ArrayList<DtoList> noticeList = proc.getNoticeList(sQuery);
        //ë§¤í¼ë¡? ?•œ ?˜?´ì§??— ëª‡ê°œ ë³´ì¼ì§? ,ëª‡ë²ˆ ?˜?´ì§? ?¸ì§? ? „?‹¬//ë§¤í¼.xml ?—?„œ ?‚¬?š©?•˜ê¸? ?œ„?•´?„œ ê³±í•˜ê¸? 10?„ ?•œ?‹¤
 
        request.setAttribute("noticeList", noticeList);//sqlë¡? ?–»?? ë¦¬ìŠ¤?Š¸ë¥? .jsp?˜?´ì§?ë¡? ? „?‹¬
        request.setAttribute("page", pagemaker);//?˜?´ì§? ë²ˆí˜¸ ê°ì²´ .jsp?˜?´ì§?ë¡? ? „?‹¬		
        
        model.addAttribute("noti", noticeList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1ë¶??„° ?‹œ?‘?•˜?Š” ?˜?´ì§? ë²ˆí˜¸
        model.addAttribute("nowPage", pagemaker.getPagenum()+1);
        
        model.addAttribute("totalPage", pagemaker.calcpage(totalC, pagemaker.getContentnum()));
		// ê²½ë¡œ : views
		return "notice/notice_r";
	}
	
	@RequestMapping("notice_w")
	public String notice_w(HttpServletRequest request, Model model) {
		return "notice/notice_w";
	}
	
	@RequestMapping("notice_t")
	public String notice_t(HttpServletRequest request, Model model, @RequestParam("file1") MultipartFile file) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String fSaveName = file.getOriginalFilename();
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		String file_url = null;
		
		// file : ?‹¤? œ ?ŒŒ?¼?´ ?“¤?–´?ˆ?Š” ë³??ˆ˜
		
		// ?ŒŒ?¼ì²˜ë¦¬
		if(!fSaveName.equals("")) {
			String fileDBSaveName = (Math.random()*500+200)+"_"+fSaveName;
			FileUploadService upload = new FileUploadService();
			file_url = upload.restore(file, fileDBSaveName, "noticeDir");
		}
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // ê¸??“°ê¸?
			sQuery = "INSERT INTO h_notice SET title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', file_name='"+file_url+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:notice_r";
	}
	
	@RequestMapping("notice_v")
	public String notice_v(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
		String noticeNum = request.getParameter("t_notice_num"); 
		String hitQuery = "UPDATE h_notice SET hit=hit+1 "+
						  "WHERE num = '"+noticeNum+"'";
		proc.save(hitQuery);
		String sQuery = "SELECT num, title, contents, reg_date, hit, file_name FROM h_notice "+
						"WHERE num = '"+noticeNum+"'";
		DtoList notice = proc.view(sQuery);	
		
		model.addAttribute("notice", notice);
		return "notice/notice_v";
	}
	
	@RequestMapping("notice_u")
	public String notice_u(HttpServletRequest request, Model model) {
		
		DBprocess proc = new DBprocess();
		String noticeNum = request.getParameter("t_notice_num"); 
		String sQuery = "SELECT num, title, contents, ifnull(file_name, ' ') as file_name, reg_date, hit, file_name FROM h_notice "+
						"WHERE num = '"+noticeNum+"'";
		DtoList notice = proc.view(sQuery);	
		
		model.addAttribute("notice", notice);
		return "notice/notice_u";
	}
	
	@RequestMapping("notice_update")
	public String notice_update(HttpServletRequest request, Model model) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String noticeNum = request.getParameter("t_notice_num"); 
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		sQuery = "UPDATE h_notice SET title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"' WHERE num = '"+noticeNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:notice_r";
	}
	
	// ì²¨ë??ŒŒ?¼ ì²˜ë¦¬ ?•Œê³ ë¦¬ì¦˜ì´ ?¬?•¨?œ update êµ¬ë¬¸
	@RequestMapping("notice_update2")
	public String notice_update2(HttpServletRequest request, Model model, @RequestParam("file1") MultipartFile file) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String noticeNum = request.getParameter("t_notice_num"); 
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		
		String delFile = request.getParameter("t_del_fileName");
		String oriDelFile = request.getParameter("t_ori_fileName");
		String fSaveName = file.getOriginalFilename();
		String fileDBSaveName = "";
		
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		if(delFile == null && fSaveName.equals("")) {
			fileDBSaveName = oriDelFile;
		} else {
			// ?ŒŒ?¼ ?‚­? œ
			if(delFile != null) {
				File dFa = new File(Common.noticeDir, delFile);
				dFa.delete();
			}
			// ?ŒŒ?¼ì²˜ë¦¬
			if(!fSaveName.equals("")) {
				if(oriDelFile != null) {
					File dFa = new File(Common.noticeDir, oriDelFile);
					dFa.delete();
				}
				
				fileDBSaveName = noticeNum+"_"+fSaveName;
				FileUploadService upload = new FileUploadService();
				upload.restore(file, fileDBSaveName, "noticeDir");
			}
		}
		
		sQuery = "UPDATE h_notice SET title='"+title+"', contents='"+contents+"', file_name='"+fileDBSaveName+"', reg_id='"+sessionId+"', reg_date='"+date+"' WHERE num = '"+noticeNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:notice_r";
	}
	
	@RequestMapping("notice_delete")
	public String notice_delete(HttpServletRequest request, Model model) {
		
		/* ?‚´?š© ?…? ¥ ì²˜ë¦¬ë¬? */
		
		DBprocess proc = new DBprocess();
		String noticeNum = request.getParameter("t_notice_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_notice WHERE num = '"+noticeNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?„ ë§¤í•‘?•˜?Š” ?´?˜?Š¤ë¡? ?´?™?•œ?‹¤.
		return "redirect:notice_r";
	}
	
}
