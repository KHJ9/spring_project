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
					</div>
				</div>
			</div> <!-- path-layout end -->
<form name="noticeform">			
			<div class="sub-contents">
				<section id="content">
					<h2 id="stitle" class="stitle">SYSTEM ERROR</h2>
				</section>
<aside id="side">
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