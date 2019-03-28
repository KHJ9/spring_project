package comV.javaV.haitae;

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
        String pagenum = request.getParameter("pagenum");//페이지 값을 입력 받는다.
        String search = request.getParameter("t_search");
        if(pagenum == null) pagenum ="1";
        int cpagenum = Integer.parseInt(pagenum);//int 형으로 몇 번 페이지인지 페이지 값 형변환
        
        if(search == null) search = "";
        String sQueryCount = "SELECT COUNT(*) AS count FROM h_news WHERE title LIKE '%"+search+"%'";
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
        
        String sQuery = "select num, title, reg_date, contents, hit  from h_news "+
        							 "where title like '%"+search+"%' "+
        							 "order by num desc  limit "+pagemaker.getPagenum()*pagemaker.contentnum+","+pagemaker.getContentnum();
		ArrayList<DtoList> newsList = proc.getNoticeList(sQuery);
		//System.out.println(newsList.get(0).getTitle());
        //매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다
 
        request.setAttribute("newsList", newsList);//sql로 얻은 리스트를 .jsp페이지로 전달
        request.setAttribute("page", pagemaker);//페이지 번호 객체 .jsp페이지로 전달		
        
        model.addAttribute("news", newsList);
        model.addAttribute("page", pagemaker);
        model.addAttribute("totalCount", totalC);
        model.addAttribute("search", search);
        // 0+1부터 시작하는 페이지 번호
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
		
		/* 내용 입력 처리문 */
		
		DBprocess proc = new DBprocess();
		String sessionId = request.getParameter("sessionid");
		String sessionName = request.getParameter("sessionname");
		String num = proc.getNum("SELECT IFNULL(COUNT(*), 0)+1 AS number FROM h_news");
		String title = request.getParameter("t_title");
		String contents = request.getParameter("t_contents");
		String gubun = request.getParameter("work_gubun");
		String date = proc.getYear()+"-"+proc.getMonth()+"-"+proc.getDay();
		
		String sQuery = "";
		
		if(gubun.equals("insert")) { // 글쓰기
			sQuery = "INSERT INTO h_news SET num='"+num+"', title='"+title+"', contents='"+contents+"', reg_id='"+sessionId+"', reg_date='"+date+"', hit=0";
			boolean check = proc.save(sQuery) ;
		}
		
		// notice_r을 매핑하는 클래스로 이동한다.
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
		
		/* 내용 입력 처리문 */
		
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
		
		// notice_r을 매핑하는 클래스로 이동한다.
		return "redirect:news_r";
	}
	
	@RequestMapping("news_delete")
	public String news_delete(HttpServletRequest request, Model model) {
		
		/* 내용 입력 처리문 */
		
		DBprocess proc = new DBprocess();
		String newsNum = request.getParameter("t_news_num"); 
		
		String sQuery = "";
		
		sQuery = "DELETE FROM h_news WHERE num = '"+newsNum+"'";
		boolean check = proc.save(sQuery) ;
		
		// notice_r을 매핑하는 클래스로 이동한다.
		return "redirect:news_r";
	}
	
}
