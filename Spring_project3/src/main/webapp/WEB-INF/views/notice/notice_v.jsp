<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>  
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!doctype html>	
<html lang="ko">
	<head>
		<title>해태제과</title>
		<meta charset="utf-8">
		<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/common/head.jsp" > --%>
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/haitai.css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="../js/jquery-3.3.1.min.js"></script>
	</head>
<script type="text/javascript">	
	function formUpdate() {
		var form = document.noticeform;
		form.method='post';
		form.action='notice_u';
		form.submit();		
	}	
	function formDelete() {
		var yn = confirm("삭제 하시겠습니까?");
		if(yn == true){
			var form = document.noticeform;
			form.work_gubun.value = "delete";
			form.method = 'post';
			form.action = 'notice_delete';
			form.submit();
		}
	}
	
</script>
<style>
</style>


	</head>
	<body>
<%@ include file="/common/head.jsp" %>
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
			<input type="hidden" name="t_notice_num" value="${notice.num}">
			<input type="hidden" name="work_gubun">
			<div class="sub-contents">
				<section id="content">
					<h2 id="stitle" class="stitle">NOTICE</h2>
					<div class="sub-wrap">
						<div class="board_board-list">
							<table class="tstyle-list" border=0> <!-- 표태그 -->
								<colgroup>
									<col width="15%">
									<col width="*">
									<col width="25%">
								</colgroup>
								<tbody> <!-- 웹접근성 -->
									<tr>
										<td><span class="board_tit_font">제 목</span></td>
										<td><span class="board_con_font">${notice.title}</span></td>
										<td>
											<span class="board_tit_font">조회수 :</span>
											&nbsp;<span class="board_hit">${notice.hit}</span>
										</td>
									</tr>
									<tr> 
										<td><span class="board_tit_font">내 용</span></td>
										<td colspan="2"><textarea name="t_contents" class="board_textarea_H250_noBorder" maxlength="500" readonly>${notice.contents}</textarea></td>
									</tr>
									<tr> 
										<td><span class="board_tit_font">첨부파일</span></td>
										<td colspan="2"></td>
									</tr>
									<tr> 
										<td><span class="board_tit_font">등록일자</span></td>
										<td colspan="2"><span class="board_con_font">${notice.reg_date}</span></td>
									</tr>
								</tbody>	
							</table>
						</div>
						
						<div class="paging">
							<table class="tstyle-list" border=0> <!-- 표태그 -->
								<tbody>

									<tr>
										<td>
											<a href="notice_r"><img src="${pageContext.request.contextPath}/resources/images/button/list.gif"></a>
											<% if(sessionId.equals("manager")){ %>
												<a href="javascript:formUpdate()"><img src="${pageContext.request.contextPath}/resources/images/button/upd.gif"></a>
												<a href="javascript:formDelete()"><img src="${pageContext.request.contextPath}/resources/images/button/del.gif"></a>
											<% } %>
										</td>
									</tr>
								</tbody>	
							</table>
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
			
		</div> <!-- wrap end -->
		
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