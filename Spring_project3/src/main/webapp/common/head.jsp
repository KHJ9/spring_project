<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%> --%>
<%
/* 	request.setCharacterEncoding("UTF-8"); */
/* 	String sessionName	= pwk.checkNull((String)session.getAttribute("session_name")); */
/* 	String sessionId	= pwk.checkNull((String)session.getAttribute("session_id")); */
/* 	String sessionLevel	= pwk.checkNull((String)session.getAttribute("session_level")); */
	
 	String sessionName	= "관리자";
	String sessionId	= "manager";
	String sessionLevel	= "manager"; 
	
%>
<header id="header">
	<script>
		function goNotice(){
			var form = document.indexForm;
			form.method = "post";
			form.action="notice_r";
			form.submit();
		}
	</script>
	<div class="tsidemenu">
		<form name="indexForm">
			<div class="tsidecont">
				<ul class="type">
					<li><a href="/product/product_r.jsp">제품소개</a></li>
					<li><a href="javascript:goNotice()">고객센터</a></li>
					<li><a href="/intro/intro.jsp">회사소개</a></li>						
				</ul>
				<ul class="menu">
				<% if(sessionName.equals("")){ %>
					<li><a href="/login.jsp">로그인</a></li>
				<% } else { %>
					<li><a href="javascript:logout()">로그아웃</a></li>
					<li><a href="javascript:my_info()">My Information</a></li>
				<% } %>
					<li><a href="sitemap.html">사이트맵</a></li>
					<li><a href="#">KOR</a></li>
				<% if(sessionId.equals("manager")){ %>
					<li><a href="/tmanager/member_r.jsp" class="manager_btn">MANAGER</a></li>
				<% } %>
				</ul>
			</div>
		</form>
	</div>
</header>
<div class="gnb-layout">
	<h1 class="logo"><a href="index">아쿠아필드</a></h1>
	<nav id="navigation" class="navi">
		<h2 class="readonly">주메뉴</h2>
		<ul>
			<li><a href="intro">회사소개</a></li>
			<li><a href="product_r">제품소개</a></li>
			<li><a href="main_event">이벤트</a></li>
			<li><a href="notice_r">고객센터</a></li>
			<li><a href="sweet_r">달콤한 세상</a></li>
		</ul>
	</nav>	
</div>

<script>
	function logout(){
		var form = document.indexForm;
		form.method = "post";
		form.action = "/member/member_logout";
		form.submit();
	}
	function my_info(){
		var form = document.indexForm;
		form.method = "post";
		form.action = "/member/member_myinfo";
		form.submit();
	}
</script>