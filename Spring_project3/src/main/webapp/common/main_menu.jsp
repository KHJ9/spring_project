<div class="gnb-layout">
	<h1 class="logo"><a href="/index.jsp">해태</a></h1>
	<nav id="navigation" class="navi">
		<h2 class="readonly">주메뉴</h2>
		<ul>
			<li><a href="/intro/intro.jsp">회사소개</a></li>
			<li><a href="/product/product_r.jsp">제품소개</a></li>
			<li><a href="/event/main_event.jsp">이벤트</a></li>
			<li><a href="/notice/notice_r.jsp">고객센터</a></li>
			<li><a href="/sweetstory/sweet_r.jsp">달콤한 세상</a></li>
		</ul>
	</nav>	
</div>

<script>
	function logout(){
		var form = document.indexForm;
		form.method = "post";
		form.action = "/member/member_logout.jsp";
		form.submit();
	}
	function my_info(){
		var form = document.indexForm;
		form.method = "post";
		form.action = "/member/member_myinfo.jsp";
		form.submit();
	}
</script>