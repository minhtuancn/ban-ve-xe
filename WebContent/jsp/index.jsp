<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.Tuyen"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DiaDiem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/BanVeXe/js/easySlider1.7.js"></script>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/home.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script>
	$(document).ready(function() {

		$("#menu-noidi li").click(function() {
			$("input[id='noidi']").val($(this).text());
			$("#idnoidi").val($(this).attr('id'));
			$("#menu-noidi").slideUp(100);
		});
		$("input[id='noidi']").mouseenter(function() {
			$("#menu-noidi").slideDown(100);
		});
		$("input[id='noidi']").mouseleave(function() {
			$("#menu-noidi").slideUp(100);
		});
		$("#menu-noidi").mouseenter(function() {
			$("#menu-noidi").slideDown(100);
		});
		$("#menu-noidi").mouseleave(function() {
			$("#menu-noidi").slideUp(100);
		});

		$("#menu-noiden li").click(function() {
			$("input[id='noiden']").val($(this).text());
			$("#idnoiden").val($(this).attr('id'));
			$("#menu-noiden").slideUp(100);
		});
		$("input[id='noiden']").mouseenter(function() {
			$("#menu-noiden").slideDown(100);
		});
		$("input[id='noiden']").mouseleave(function() {
			$("#menu-noiden").slideUp(100);
		});
		$("#menu-noiden").mouseenter(function() {
			$("#menu-noiden").slideDown(100);
		});
		$("#menu-noiden").mouseleave(function() {
			$("#menu-noiden").slideUp(100);
		});
		$("#slider").easySlider({
			auto : true,
			continuous : true,
			speed : 1800,
			pause : 3000,
		});
		//scroll
		//Check to see if the window is top if not then display button
		$(window).scroll(function() {
			if ($(this).scrollTop() > 560) {
				$(".autoScroll").animate({
					top : 10
				}, 0, function() {

				});
				// 				$("#imgleft").attr("top", offset.top + "px");
			} else {
				$(".autoScroll").animate({
					top : 560 - $(this).scrollTop()
				}, 0, function() {

				});
			}
		});
		//Click event to scroll to top
		// 			$('.scrollToTop').click(function(){
		// 				$('html, body').animate({scrollTop : 0},800);
		// 				return false;
		// 			});

	});
	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
		}
	};
	function al(mes, type) {
		swal({
			title : mes,
			type : type
		});
	}
	function submits() {
		if ($("#noidi").val().length == 0) {
			al("Bạn chưa chọn nơi đi!", "warning");
		} else if ($("#noiden").val().length == 0) {
			al("Bạn chưa chọn nơi đến!", "warning");
		} else if ($("input[name='ngaydi']").val() == 0) {
			al("Bạn chưa chọn ngày đi!", "warning");
		} else if ($("input[name='laKhuHoi']").is(':checked')
				&& $("input[name='ngayve']").val() == 0) {
			al("Bạn chưa chọn ngày về!", "warning");
		} else {
			var ngayDi = new Date(($("input[name='ngaydi']").val()));
			var ngayVe = new Date(($("input[name='ngayve']").val()));
			var now = new Date();
			now.setHours(0, 0, 0, 0);
			if (ngayDi < now) {
				al("Ngày đi không được nhỏ hơn ngày hiện tại!", "warning");
			} else {
				if (ngayDi > ngayVe)
					al("Ngày về phải lớn hơn ngày đi!", "warning");
				else {
					$("#formtimve").submit();
				}
			}
		}
	}
	$(window).load(function() {
		checkEr();
		setMenu();
	});
	function setMenu() {
		$("#"+$("#menuSelect").val()).addClass("select");
	}
</script>


</head>
<body>
	<%@ include file="header.jsp"%>
	<input type="hidden" value="trangchu" id="menuSelect"/>
	<div id="container-body">
		<section id="section-2">
			<div id="slider" style="width: 80%; height: 300px;">
				<ul>
					<li><a href="#"><img src="/BanVeXe/image/slider/06.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>
					<li><a href="#"><img src="/BanVeXe/image/slider/xe.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>
					<li><a href="#"><img src="/BanVeXe/image/slider/06.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>
					<li><a href="#"><img src="/BanVeXe/image/slider/05.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>
					<li><a href="#"><img src="/BanVeXe/image/slider/06.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>
					<li><a href="#"><img src="/BanVeXe/image/slider/04.jpg"
							alt="Css Template Preview" id="img-1" alt="home" /></a></li>

				</ul>
			</div>

			<article id="article-body">
				<%
					String mes = "";
																																																		if((String) request.getAttribute("mes")!= null)
																																																	mes = (String) request.getAttribute("mes");
																																																		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
																																																		Date now = new Date();
				%>
				<%
					Locale here = request.getLocale();
						NumberFormat cf = NumberFormat.getCurrencyInstance(here);
						cf.setMaximumFractionDigits(0);
						cf.setMinimumFractionDigits(0);
				%>
				<input type="hidden" value="<%=mes%>" id="error" />
				<form action="<%=DuongDan.TIM_TUYEN_SV%>" class="login-form bg"
					id="formtimve">
					<input type="hidden" id="idnoidi" name="idnoidi" value="" /> <input
						type="hidden" id="idnoiden" name="idnoiden" value="" />
					<table id="tb-datve" width="200px">
						<tr>
							<td><img alt="a" src="/BanVeXe/image/tim ve xe.jpg"
								height="50px"></td>
						</tr>
						<%
							List<DiaDiem> listmb = new ArrayList();
								if(session.getAttribute("listDiaDiem") != null){
								listmb = (List<DiaDiem>) session.getAttribute("listDiaDiem");
								}
											List<Tuyen> tuyen = new ArrayList();
										if(session.getAttribute("listTuyen") != null){
										tuyen = (List<Tuyen>) session.getAttribute("listTuyen");	}
						%>
						<tr>
							<td><span id="title-datve" class="title-datvedi">Nơi
									đi:</span><input type="text" id="noidi" placeholder="Nơi đi" readonly
								value="" />								<div id="menu-noidi">
									<%
										int sl = listmb.size();
										int slOnCol = sl/4 + (sl%4 > 0 ?1:0 );
										int n = 0; for(int i=0; i<sl;){
									%>
									<div class="noidi-nam bg">
										<div id="noidi-den"></div>
										<%
											for(int k =0; k<2; k++){
										%>
										<ul class="diadiem">
											<%
												for(int j = 0;i < sl && j < slOnCol; i++, j++){
											%>
											<li id="<%=listmb.get(i).getIdDiaDiem()%>"><%=listmb.get(i).getTenDiaDiem()%></li>
											<%
												}
											%>
										</ul>
										<%
											}
										%>
									</div>
									<%
										}
									%>
								</div></td>
							<td><span id="title-datve" class="title-datveden">Nơi
									đến:</span><input type="text" id="noiden" placeholder="Nơi đến"
								value="" readonly />								<div id="menu-noiden">
									<%
										n = 0; for(int i=0; i<sl;){
									%>
									<div class="noidi-nam bg">
										<div id="noidi-den"></div>
										<%
											for(int k =0; k<2; k++){
										%>
										<ul class="diadiem">
											<%
												for(int j = 0;i < sl && j < slOnCol; i++, j++){
											%>
											<li id="<%=listmb.get(i).getIdDiaDiem()%>"><%=listmb.get(i).getTenDiaDiem()%></li>
											<%
												}
											%>
										</ul>
										<%
											}
										%>
									</div>
									<%
										}
									%>
								</div></td>
						</tr>
						<tr>
							<td><span id="title-datve">Ngày đi:</span><input type="date"
								name="ngaydi" min="<%=f.format(now)%>"  /></td>
							<td><span id="title-datve">Ngày về:</span><input type="date"
								name="ngayve" min="<%=f.format(now)%>" /></td>

						</tr>
						<tr>
							<td id="checkbox" align="left"><input type="checkbox"
								name="laKhuHoi" />&nbsp;Vé khứ hồi</td>
							<td align="right"><input type="button" value="Tìm vé"
								onclick="submits()" /></td>
						</tr>
					</table>

				</form>
			</article>
			<script>
				$("#menu-noidi").slideUp();
				$("#menu-noiden").slideUp();
			</script>
		</section>
		<section class="section1">
			<div class="bg title">
				<marquee behavior="alternate" width="10%">>></marquee>
				Trang chủ
				<marquee behavior="alternate" width="10%"> << </marquee>
			</div>
			<div class="test">
				<marquee direction="left">Chào mừng quý khách đã đến với
					VeXeOnline.com, chúng tôi xin đảm bảo quý khách sẽ được phục vụ tận
					tình, chu đáo!</marquee>
			</div>
			<div class="center">
				<div id="left">
					<img id="imgleft" class="autoScroll" alt="left"
						src="/BanVeXe/image/cau-doi-l.png" />
				</div>
				<div id="bodys">
					<div>
						<div>
							<fieldset>
								<legend>Các vé được đặt nhiều trong ngày</legend>
								<div id="vexe-nhieu">
									<%
										for (int i = 0; i < 4; i++) {
									%>
									<div id="nhieu-01">
										<a
											href="<%=DuongDan.TIM_TUYEN_SV + "?idTuyen="
						+ tuyen.get(i).getIdTuyen()%>"
											class="a-01"><p>
												<span id="tuyen"><marquee direction="up"
														width="100%" height="30px" behavior="slide"><%=tuyen.get(i).getTuyenXe()%></marquee></span><br>
												<span id="gia"><%=cf.format(tuyen.get(i).getDanhSachChuyen().get(0).getGia())%></span><br>
												<span id="gio"><%=tuyen.get(i).getDanhSachChuyen().get(0).getGioKhoiHanh()%></span>
											</p></a>
									</div>
									<%
										}
									%>
								</div>
							</fieldset>

						</div>
						<div></div>
					</div>
					<fieldset>
						<legend>Hướng dẫn quy trình đặt vé</legend>
						<img alt="huong dan" src="/BanVeXe/image/banvexe.png"
							style="width: 100%; height: 100%;">
					</fieldset>

				</div>
				<div id="right">
					<img id="imgright" class="autoScroll " alt="right"
						src="/BanVeXe/image/cau-doi-r.png" />
				</div>
			</div>
		</section>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>