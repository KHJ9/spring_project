<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>    
<!doctype html>	
<html lang="ko">
	<head>
		<title>공지사항</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/haitai.css">
<%@ include file="/common/head.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function page(idx){
        var pagenum = idx;
        var contentnum = "2";   
        location.href="notice_r?pagenum="+pagenum;    
    }
</script>
<script type="text/javascript">	
	function formSearch() {
		var form = document.noticeform;
		form.method='post';
		form.action='notice_r';
		form.submit();		
	}
</script>
	</head>
	<body>
<%-- <jsp:include page="/common/main_menu.jsp">
	<jsp:param name="sessionId" value="<%=sessionId%>"/>
	<jsp:param name="sessionName" value="<%=sessionName%>"/>
	<jsp:param name="sessionLevel" value="<%=sessionLevel%>"/>
</jsp:include> --%>
			
			
			<!-- sub contents start -->
			<div class="path-layout">
	<div class="path-inner">
		<p class="home"><i class="fas fa-home"></i><span class="hidden">홈</span></p>
		<div class="group">
			<p><a href="#">고객센터</a></p>
		</div>
		<div class="group">
			<p><a href="/haitai/notice_r">NOTICE</a></p> <!-- toggle -->
			<ul class="sub1-depth2">
				<li><a href="/haitai/notice_r">NOTICE</a></li>
				<li><a href="/haitai/news_r">NEWS</a></li>
				<li><a href="/haitai/event_r">EVENT</a></li>
				<li><a href="/haitai/faq_r">FAQ</a></li>
			</ul>
		</div>
	</div>
</div> <!-- path-layout end -->
<form name="noticeform">			
			<div class="sub-contents">
				<section id="content">
					<h2 id="stitle" class="stitle">NOTICE</h2>
					<div class="sub-wrap">
						<div class="board-count">
							<p>전체<span class="color-blue">${totalPage}</span></p>
							<p>현재페이지<span class="color-blue">${nowPage}/${totalPage}</span></p>
						</div>
						<div class="board-count2">
							<p>
							<input type="text" name="t_search" value="${search}" class="board_search" maxlength="10">
							<a href="javascript:formSearch()" class="btn-write2">검 색</a>
							</p>
						</div>
						<div class="board-list">
							<table class="tstyle-list"> <!-- 표태그 -->
								<caption>공지사항 - 번호, 제목, 첨부, 작성일, 조회수</caption> <!-- 표 제목 -->
								<colgroup>
									<col width="7%">
									<col width="*">
									<col width="7%">
									<col width="15%">
									<col width="10%">
								</colgroup>
								<thead> <!-- 웹접근성 -->
									<tr> <!-- 한 줄의 시작 -->
										<th scope="col">번호</th> <!-- 필드명 -->
										<th scope="col">제목</th>
										<th scope="col">첨부</th>
										<th scope="col">작성일</th>
										<th scope="col">조회수</th>
									</tr>
								</thead>
								<tbody> <!-- 웹접근성 -->

								<c:forEach items="${noticeList}"  var="noti">
									<tr>
										<td>${noti.num}</td> <!-- 하나의 셀 -->
										<td><a href="notice_v?t_notice_num=${noti.num}">${noti.title}</a></td>
										<td>
											<c:if test="${noti.file_name != null}">
												<a href="${noti.file_name}" class="notice_clip">
													<img src="${pageContext.request.contextPath}/resources/images/clip.png" alt="clip"/>
												</a>
											</c:if>
										</td>
										<td>${noti.reg_date}</td>
										<td>${noti.hit}</td>
									</tr>
								</c:forEach>


            <tr>
                <td colspan="5">
                    <!-- 왼쪽 화살표 -->
                    <c:if test="${page.prev}">
                        <a style="text-decoration:none;" href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
                    </c:if>
                    
                    <!-- 페이지 숫자 표시 -->
                    <c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" var="idx">
                        <a style="text-decoration: none;" href="javascript:page(${idx});">${idx}</a>
                    </c:forEach>
                    
                    <!-- 오른쪽 화살표 -->
                    <c:if test="${page.next}">
                        <a style="text-decoration:none;" href="javascript:page(${page.getEndPage()+1});">&raquo;</a>
                    </c:if>
                    
                </td>
            </tr>


 									

								</tbody>	
							</table>
						</div>
						
						<div class="paging">
<%
						if(sessionLevel.equals("manager")){
%>
							<a href="notice_w" class="btn-write">글쓰기</a>
<%						} %>
						</div>
						
					</div>
				</section>
				<aside id="side">
					<h2 class="title">고객센터</h2>
					<ul class="side-menu">
						<li class="active"><a href="/haitai/notice_r">NOTICE</a></li>
						<li><a href="/haitai/news_r">NEWS</a></li>
						<li><a href="/haitai/event_r">EVENT</a></li>
						<li><a href="/haitai/faq_r">FAQ</a></li>
					</ul>
				</aside>
			</div>
</form>			
			<!-- sub contents end -->
			
			<footer id="footer">
				<%@ include file="/common/footer.jsp" %> 
			</footer>
			
		<!-- wrap end -->
		
		<script>
			$(document).ready(function() {
				$(".tab-style > li > a").click(function() {
					$(".tab-style > li").removeClass("active");
					$(this).parent().addClass("active"); /* jQuery의 체인 방식 */
				});
				
				$(".path-inner > .group > p > a").click(function() {
					$(".path-inner > .group > .sub1-depth2").toggle();
				});
				
			});/* 해당 문서가 로딩(준비)이 다 되었으면 어떤 기능을 실행하세요 */
			
			
		</script>
	</body>
</html>