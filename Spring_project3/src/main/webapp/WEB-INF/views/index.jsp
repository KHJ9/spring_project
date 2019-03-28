<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="/common/head.jsp" %>
<!doctype html>
<html lang="ko">
	<head>
		<title>아쿠아필드</title>
		<meta charset="utf-8">
		<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/resources/css/haitai.css" rel="stylesheet" type="text/css">
		<link href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" rel="stylesheet" >
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		<!-- skip navigation -->
		<dl id="access"> <!-- 제목이 나오고 설명이 나오는 것이 반복 -->
			<dt>바로가기 및 건너띄기 링크</dt>
			<dd><a href="#contents">본문 바로가기</a></dd>
			<dd><a href="#navigation">주메뉴 바로가기</a></dd>
		</dl>
		<hr>
		
		<div id="wrap" class="active">
			
			<section id="main-visual">
				<div class="m_slider">
					<ul class="list">
						<li></li>
						<li></li>
					</ul>
				</div>
				<div class="inner">
					<div class="v-text">
						<!-- <p class="line01">생각을 비우다</p> -->
						<p class="line02" style="font-size:45px;">나를 위한 인생을 가꾸다</p>
					</div>
				</div>
			</section> <!-- mainvisual end -->
			
			
			<!-- 0번째부터 0번째까지만 -->
							<!-- 	<c:forEach items="${noticeList}" begin="0" end="0" var="noti">
									<li>
										<a href="">
											<p class="p1">${noti.title}</p>
										</a>
										<p class="p2">${noti.contents}</p>
										<span>${year}<span class="date">${month}.${day}</span></span>
									</li>
								</c:forEach>
								
			 -->
			
			<section class="tab-cont">
				<h2 class="readonly">탭메뉴게시판</h2>
				<div class="inner">
					<ul class="tab-style">
						<li class="active">
							<a href="javascript:void(0);">NOTICE</a>
							<ul class="inner-tab">
								<c:forEach items="${notice}" var="n" varStatus="s">

								<c:if test="${s.count == 1}">
								<li><a href="notice_v?t_notice_num=${n.num}">
									<p class="p1">${n.title}</p>
									<p class="p2">${n.contents}</p>
									</a>
									<span>2018.<span class="date">04.09</span></span>
								</li>
								</c:if>
								<c:if test="${s.count == 2}">
								<li><a href="notice_r" style="float:right">.....more</a></li>
								</c:if>
								<c:if test="${s.count != 1}">
								<li>
									<a href="notice_v?t_notice_num=${n.num}">${n.title}</a>
									<span>${n.reg_date}</span>
								</li>
								</c:if>
								
								</c:forEach>
							</ul>
						</li>
						<li>
							<a href="javascript:void(0);">NEWS</a>
							<ul class="inner-tab">
								<c:forEach items="${news}" var="n" varStatus="s">

								<c:if test="${s.count == 1}">
								<li><a href="news_v?t_news_num=${n.num}">
									<p class="p1">${n.title}</p>
									<p class="p2">${n.contents}</p>
									</a>
									<span>2018.<span class="date">04.09</span></span>
								</li>
								</c:if>
								<c:if test="${s.count == 2}">
								<li><a href="news_r" style="float:right">.....more</a></li>
								</c:if>
								<c:if test="${s.count != 1}">
								<li>
									<a href="news_v?t_news_num=${n.num}">${n.title}</a>
									<span>${n.reg_date}</span>
								</li>
								</c:if>
								
								</c:forEach>
							</ul>
						</li>
						<li>
							<a href="javascript:void(0);">EVENT</a>
							<ul class="inner-tab">
								<c:forEach items="${event}" var="n" varStatus="s">

								<c:if test="${s.count == 1}">
								<li><a href="event_v?t_event_num=${n.num}">
									<p class="p1">${n.title}</p>
									<p class="p2">${n.contents}</p>
									</a>
									<span>2018.<span class="date">04.09</span></span>
								</li>
								</c:if>
								<c:if test="${s.count == 2}">
								<li><a href="event_r" style="float:right">.....more</a></li>
								</c:if>
								<c:if test="${s.count != 1}">
								<li>
									<a href="event_v?t_event_num=${n.num}">${n.title}</a>
									<span>${n.reg_date}</span>
								</li>
								</c:if>
								
								</c:forEach>
							</ul>
						</li>
					</ul>
				</div>
			</section>
			
			<div class="sidebar">
				<div class="side-inner">
					<h2>새로운 <span>이야기</span></h2>
					<ul class="side-list">
						<li>
							<a href="#">
								<p class="text-style20">NEW PRODUCT</p>
								<p class="text-style40">쌍쌍바 포도</p>
								<p class="text-style17">화낙신낙</p>
							</a>
						</li>
						<li>
							<a href="#">
								<p class="text-style20">EVENT</p>
								<p class="text-style40">현재 참여 가능한<br>이벤트가 없습니다</p>
							</a>
								<p class="text-style1730"><a href="#">자세히 보기</a></p>
						</li>
						<li>
							<a href="#">
								<p class="text-style32">AQUAFIELD MALL</p>
								<p class="text-style17">Premium Pack<br>과자 선물 세트</p>
							</a>
						</li>
					</ul>
				</div>
			</div><!-- sidebar end -->
			
			<footer id="footer">
				<div class="footer-inner">
					<ul class="footer-banner">
						<li class="one">
							<h3><span>대표전화</span></h3>
							<p class="phone">010-1234-5678</p>
							<p class="time"><strong>평일</strong>09:00 ~ 18:00<strong> 토/일 공휴일</strong>10:00 ~ 17:00</p>
							<p class="btn"><a href="#" class="que">질문답변</a><a href="#">부서전화번호</a></p>
						</li>
						<li class="two">
							<h3><span>아쿠아필드 SNS</span></h3>
							<p class="txt">(주)아쿠아필드 SNS입니다</p>
							<ul>
								<li><a href="#"><span class="hidden">blog</span><i class="fab fa-blogger fa-2x"></i></a></li>
								<li><a href="#"><span class="hidden">youtube</span><i class="fab fa-youtube fa-2x"></i></a></li>
								<li><a href="#"><span class="hidden">twitter</span><i class="fab fa-twitter fa-2x"></i></a></li>
								<li><a href="#"><span class="hidden">facebook</span><i class="fab fa-facebook fa-2x"></i></a></li>
							</ul>
						</li>
						<li class="three">
							<h3><span>상담안내</span></h3>
							<p class="whatever">무엇이든 상담하세요.</p>
							<p class="help">도와드립니다.</p>
							<p class="btn"><a href="#" class="que">해결가이드</a><a href="#">원격상담</a></p>
						</li>
					</ul>
				</div>
				
				<div class="siteinfo">
					<span class="flogo">아쿠아필드</span>
					<div class="fzone">
						<address>
							35643 대전광역시 동구 대전로 994번길 75
							<br>
							대표전화 042-123-4567 팩스 042-987-6543 E-mail hatahata@naver.com 고유번호 101-82-12345
						</address> <!-- 폰트가 15도 정도 기울어져서 보임 -->
						<p class="copyright">Copyright &copy 2017 HAI of korea. &nbsp;&nbsp;&nbsp; ALL RIGHTS RESERVED.</p> 
					</div>
					<span class="map"><a href="#">FamilySite</a></span>
				</div>
				
			</footer>
			
		</div> <!-- wrap end -->
		
		<script>
			$(document).ready(function() {
				$(".tab-style > li > a").click(function() {
					$(".tab-style > li").removeClass("active");
					$(this).parent().addClass("active"); /* jQuery의 체인 방식 */
				});
			});/* 해당 문서가 로딩(준비)이 다 되었으면 어떤 기능을 실행하세요 */
			
		</script>
	</body>
</html>