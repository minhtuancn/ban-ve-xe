<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/home.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script>
	$(document).ready(function() {
		$("#menu-noidi li").click(function() {
			$("input[name='noidi']").val($(this).text());
			$("#menu-noidi").hide();
		});
		$("input[name='noidi']").mouseenter(function() {
			$("#menu-noidi").show(300);
		});
		$("input[name='noidi']").mouseleave(function() {
			$("#menu-noidi").hide();
		});
		$("#menu-noidi").mouseenter(function() {
			$("#menu-noidi").show();
		});
		$("#menu-noidi").mouseleave(function() {
			$("#menu-noidi").hide();
		});

		$("#menu-noiden li").click(function() {
			$("input[name='noiden']").val($(this).text());
			$("#menu-noiden").hide();
		});
		$("input[name='noiden']").mouseenter(function() {
			$("#menu-noiden").show(300);
		});
		$("input[name='noiden']").mouseleave(function() {
			$("#menu-noiden").hide();
		});
		$("#menu-noiden").mouseenter(function() {
			$("#menu-noiden").show();
		});
		$("#menu-noiden").mouseleave(function() {
			$("#menu-noiden").hide();
		});
	});
</script>


</head>
<body>
	<div id="container">
		<%@ include file="header.jsp"%>
		<section>
			<img alt="nen" src="../image/banner03-v1.jpg" width="100%"
				height="350px">

			<article>
				<form action="/BanVeXe/TimTuyen" class="login-form bg">
					<table id="tb-datve" width="200px">
						<tr>
							<td><img alt="a" src="../image/tim ve xe.jpg" height="50px"></td>
						</tr>
						<tr>
							<td><span id="title-datve" class="title-datvedi">Nơi
									đi:</span><input type="text" name="noidi" placeholder="Nơi đi" />
								<div id="menu-noidi">
									<div class="noidi-nam bg">
										<div id="noidi-den">Miền Nam</div>
										<ul class="noidi-nam1">
											<li class="lis"">Hồ Chí Minh</li>
											<li>Cần Thơ</li>
											<li>Bà Rịa Vũng Tàu</li>
										</ul>
										<ul class="noidi-nam2">
											<li>Kiên Giang</li>
											<li>Long An</li>
											<li>Sóc Trăng</li>
										</ul>
									</div>
									<div class="noidi-trung bg">
										<div id="noidi-den">Miền Trung</div>
										<ul class="noidi-trung1">
											<li>Đà Nẵng</li>
											<li>Quãng Ngãi</li>
											<li>Khánh Hòa</li>
										</ul>
										<ul class="noidi-trung2">
											<li>Hà Tĩnh</li>
											<li>Kon Tum</li>
											<li>Ninh Thuận</li>
										</ul>
									</div>
									<div class="noidi-bac bg">
										<div id="noidi-den">Miền Bắc</div>
										<ul class="noidi-bac1">
											<li>Hà Nội</li>
											<li>Hải Phòng</li>
											<li>Quảng Ninh</li>
										</ul>
										<ul class="noidi-bac2">
											<li>Hưng Yên</li>
											<li>Lai Châu</li>
											<li>Lạng Sơn</li>
										</ul>
									</div>
								</div></td>



							<td><span id="title-datve" class="title-datveden">Nơi
									đến:</span><input type="text" name="noiden" placeholder="Nơi đến" />
								<div id="menu-noiden">
									<div class="noidi-nam bg">
										<div id="noidi-den">Miền Nam</div>
										<ul class="noidi-nam1">
											<li class="lis"">Hồ Chí Minh</li>
											<li>Cần Thơ</li>
											<li>Bà Rịa Vũng Tàu</li>
										</ul>
										<ul class="noidi-nam2">
											<li>Kiên Giang</li>
											<li>Long An</li>
											<li>Sóc Trăng</li>
										</ul>
									</div>
									<div class="noidi-trung bg">
										<div id="noidi-den">Miền Trung</div>
										<ul class="noidi-trung1">
											<li>Đà Nẵng</li>
											<li>Quãng Ngãi</li>
											<li>Khánh Hòa</li>
										</ul>
										<ul class="noidi-trung2">
											<li>Hà Tĩnh</li>
											<li>Kon Tum</li>
											<li>Ninh Thuận</li>
										</ul>
									</div>
									<div class="noidi-bac bg">
										<div id="noidi-den">Miền Bắc</div>
										<ul class="noidi-bac1">
											<li>Hà Nội</li>
											<li>Hải Phòng</li>
											<li>Quảng Ninh</li>
										</ul>
										<ul class="noidi-bac2">
											<li>Hưng Yên</li>
											<li>Lai Châu</li>
											<li>Lạng Sơn</li>
										</ul>
									</div>
								</div></td>

						</tr>
						<tr>
							<td><span id="title-datve">Ngày đi:</span><input type="date"
								name="ngay" min="12/12/2000" max="12/12/2014" /></td>
							<td><span id="title-datve">Ngày về:</span><input type="date"
								name="ngay" min="12/12/2000" max="12/12/2014" /></td>

						</tr>
						<tr>
							<td id="checkbox" align="left"><input type="checkbox"
								value="Vé khứ hồi" />&nbsp;Vé khứ hồi</td>
							<td align="right"><input type="submit" value="Tìm vé" /></td>
						</tr>
					</table>

				</form>
			</article>
			<script>
				$("#menu-noidi").hide();
				$("#menu-noiden").hide();
			</script>
		</section>
		<section class="section1">
			<div class="bg title">
				<marquee behavior="alternate" width="10%">>></marquee>
				Trang chủ
				<marquee behavior="alternate" width="10%"> << </marquee>
			</div>
			<div class="test"><marquee direction="left">Chào mừng quý khách đã đến với VeXeOnline.com, chúng tôi xin đảm bảo quý khách sẽ được phục vụ tận tình, chu đáo!</marquee></div>
			<!-- <div style="margin-left: 200px; position: absolute;" align="center" z-index=-1>
			<a href="http://kialongbien.oto-xemay.vn/" target="_blank"
				style="margin-right: 15px;" rel="nofollow"> <img
				src="http://113.160.50.25/banner/top/banner/1412384609_oto-long-bien.gif"
				border="1"></a> <a
				href="http://oto-xemay.vn/xem-tin-tuc/thong-tin-quang-cao-3.html"
				target="_blank" style="margin-right: 15px;" rel="nofollow"> <img
				src="http://113.160.50.25/banner/top/banner/1404352074_lien-he-quang-cao_ngang.gif"
				border="1"></a> <a href="http://quanmuiauto.oto-xemay.vn/"
				target="_blank" style="margin-right: 15px;" rel="nofollow"> <img
				src="http://113.160.50.25/banner/top/banner/1395905620_quan-mui-auto11.gif"
				border="1"></a>
		</div> -->

		</section>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>