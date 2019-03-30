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
        String pagenum = request.getParameter("pagenum");//?��?���? 값을 ?��?�� 받는?��.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int ?��?���? �? �? ?��?���??���? ?��?���? �? ?���??��
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_notice WHERE title LIKE '%"+search+"%'";
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
        
        String sQuery = "select num, title, reg_date, contents, file_name, hit  from h_notice "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
        
		ArrayList<DtoList> noticeList = proc.getNoticeList(sQuery);
        //매퍼�? ?�� ?��?���??�� 몇개 보일�? ,몇번 ?��?���? ?���? ?��?��//매퍼.xml ?��?�� ?��?��?���? ?��?��?�� 곱하�? 10?�� ?��?��
 
        request.setAttribute("noticeList", noticeList);//sql�? ?��?? 리스?���? .jsp?��?���?�? ?��?��
        request.setAttribute("page", pagemaker);//?��?���? 번호 객체 .jsp?��?���?�? ?��?��		
        
        model.addAttribute("noti", noticeList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1�??�� ?��?��?��?�� ?��?���? 번호
        model.addAttribute("nowPage", pagemaker.getPagenum()+1);
        
        model.addAttribute("totalPage", pagemaker.calcpage(totalC, pagemaker.getContentnum()));
		// 경로 : views
		return "notice/notice_r";
	}
	
	@RequestMapping("notice_w")
	public String notice_w(HttpServletRequest request, Model model) {
		return "notice/notice_w";
	}
	
	@RequestMapping("notice_t")
	public String notice_t(HttpServletRequest request, Model model, @RequestParam("file1") MultipartFile file) {
		
		/* ?��?�� ?��?�� 처리�? */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String fSaveName = file.getOriginalFilename();
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		String file_url = null;
		
		// file : ?��?�� ?��?��?�� ?��?��?��?�� �??��
		
		// ?��?��처리
		if(!fSaveName.equals("")) {
			String fileDBSaveName = (Math.random()*500+200)+"_"+fSaveName;
			FileUploadService upload = new FileUploadService();
			file_url = upload.restore(file, fileDBSaveName, "noticeDir");
		}
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // �??���?
			sQuery = "INSERT INTO h_notice SET title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', file_name='"+file_url+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
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
		
		/* ?��?�� ?��?�� 처리�? */
		
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
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
		return "redirect:notice_r";
	}
	
	// 첨�??��?�� 처리 ?��고리즘이 ?��?��?�� update 구문
	@RequestMapping("notice_update2")
	public String notice_update2(HttpServletRequest request, Model model, @RequestParam("file1") MultipartFile file) {
		
		/* ?��?�� ?��?�� 처리�? */
		
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
			// ?��?�� ?��?��
			if(delFile != null) {
				File dFa = new File(Common.noticeDir, delFile);
				dFa.delete();
			}
			// ?��?��처리
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
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
		return "redirect:notice_r";
	}
	
	@RequestMapping("notice_delete")
	public String notice_delete(HttpServletRequest request, Model model) {
		
		/* ?��?�� ?��?�� 처리�? */
		
		DBprocess proc = new DBprocess();
		String noticeNum = request.getParameter("t_notice_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_notice WHERE num = '"+noticeNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r?�� 매핑?��?�� ?��?��?���? ?��?��?��?��.
		return "redirect:notice_r";
	}
	
}
