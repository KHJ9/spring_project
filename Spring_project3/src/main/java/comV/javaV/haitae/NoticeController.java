package comV.javaV.haitae;

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
        String pagenum = request.getParameter("pagenum");//페이지 값을 입력 받는다.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int 형으로 몇 번 페이지인지 페이지 값 형변환
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_notice WHERE title LIKE '%"+search+"%'";
        int totalC = proc.getTotalCount(sQueryCount);
        
    /*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
        pagemaker.setTotalcount(totalC);//전체 게시글 개수 지정한다
        pagemaker.setPagenum(cpagenum-1);//현재 페이지를 페이지 객체에 다시 지정해준다//몇번 페이지인지 PageMaker에 세팅한다
        pagemaker.setCurrentblock(cpagenum);//현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
        pagemaker.setLastblock(totalC);//마지막 블록 번호를 전체 게시글 수를 통해서 정한다
    /*---------페이지 객체에 새로운 정보 다시 지정해주는 부분------------------*/
        
        pagemaker.prevnext(cpagenum);//현재 페이지 번호로 화살표 나타낼지 결정한다
        pagemaker.setStartPage(pagemaker.getCurrentblock());//시작페이지 번호를 현재 페이지 블록으로 정한다
        pagemaker.setEndPage(pagemaker.getLastblock(),pagemaker.getCurrentblock());
        //현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다
        
        String sQuery = "select num, title, reg_date, contents, file_name, hit  from h_notice "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
        
		ArrayList<DtoList> noticeList = proc.getNoticeList(sQuery);
        //매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다
 
        request.setAttribute("noticeList", noticeList);//sql로 얻은 리스트를 .jsp페이지로 전달
        request.setAttribute("page", pagemaker);//페이지 번호 객체 .jsp페이지로 전달		
        
        model.addAttribute("noti", noticeList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1부터 시작하는 페이지 번호
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
		
		/* 내용 입력 처리문 */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String fSaveName = file.getOriginalFilename();
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		String file_url = null;
		
		// file : 실제 파일이 들어있는 변수
		
		// 파일처리
		if(!fSaveName.equals("")) {
			String fileDBSaveName = (Math.random()*500+200)+"_"+fSaveName;
			FileUploadService upload = new FileUploadService();
			file_url = upload.restore(file, fileDBSaveName, "noticeDir");
		}
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // 글쓰기
			sQuery = "INSERT INTO h_notice SET title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', file_name='"+file_url+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r을 매핑하는 클래스로 이동한다.
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
		
		/* 내용 입력 처리문 */
		
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
		
		// notice_r을 매핑하는 클래스로 이동한다.
		return "redirect:notice_r";
	}
	
	// 첨부파일 처리 알고리즘이 포함된 update 구문
	@RequestMapping("notice_update2")
	public String notice_update2(HttpServletRequest request, Model model, @RequestParam("file1") MultipartFile file) {
		
		/* 내용 입력 처리문 */
		
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
			// 파일 삭제
			if(delFile != null) {
				File dFa = new File(Common.noticeDir, delFile);
				dFa.delete();
			}
			// 파일처리
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
		
		// notice_r을 매핑하는 클래스로 이동한다.
		return "redirect:notice_r";
	}
	
	@RequestMapping("notice_delete")
	public String notice_delete(HttpServletRequest request, Model model) {
		
		/* 내용 입력 처리문 */
		
		DBprocess proc = new DBprocess();
		String noticeNum = request.getParameter("t_notice_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_notice WHERE num = '"+noticeNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r을 매핑하는 클래스로 이동한다.
		return "redirect:notice_r";
	}
	
}
