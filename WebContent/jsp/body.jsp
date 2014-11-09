<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/home.css">
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

</style>

<script>
	
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<section>
		<img alt="nen" src="../image/banner03-v1.jpg" width="100%" height="350px">

		<article>
			<form action="timve.jsp" class="login-form">
				<table id="tb-datve" width="200px">
					<tr>
						<td><img alt="a" src="../image/tim ve xe.jpg" height="50px"></td>
					</tr>
					<tr>
						<td><span id="title-datve" class="title-datvedi">Nơi
								đi:</span><input type="text" name="noidi" placeholder="Nơi đi" />
							<div id="menu-noidi">
								<div class="noidi-nam">
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
								<div class="noidi-trung">
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
								<div class="noidi-bac">
									<div  id="noidi-den">Miền Bắc</div>
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
								<div class="noidi-nam">
									<div  id="noidi-den">Miền Nam</div>
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
								<div class="noidi-trung">
									<div  id="noidi-den">Miền Trung</div>
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
								<div class="noidi-bac">
									<div  id="noidi-den">Miền Bắc</div>
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
						<td colspan="2" align="right"><input type="submit"
							value="Tìm vé" /></td>
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
	<div style="width:100%;height:40px;background:#145CA1;font-size:30px;color:white;"> Trang chủ</div>
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
		 <!-- <div
			style="width: 80%; font-size: 32px; color: white; font-family: arial; position: absolute; margin-top: 100px; background: #1E62A3;">Tìm
			vé nhanh:</div>
		<div>
			<div
				style="margin-top: 145px; margin-left: 10px; width: 80%; float: left; clear: right; border: double;">
				<ul class="" style="margin-left: 20px; font-size: 22px;">
					<li>Hà Nội → TP Hồ Chí Minh 900.000 vnd/vé</li>
					<li>TP Hồ Chí Minh → Hà Nội 900.000 vnd/vé</li>
					<li>Hà Nội → Đà Nẵng 380.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Đà Nẵng 380.000 vnd/vé</li>
					<li>Hà Nội → Hải Phòng 80.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Vũng Tàu 65.000 vnd/vé</li>
					<li>Hà Nội → Thanh Hóa 90.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Đồng Nai 60.000 vnd/vé</li>
					<li>Hà Nội → Quảng Ninh 120.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Cần Thơ 110.000 vnd/vé</li>
					<li>Hà Nội → Lào Cai 250.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Bình Thuận 130.000 vnd/vé</li>
					<li>Hà Nội → Thái Bình 80.000 vnd/vé</li>
					<li>TP Hồ Chí minh → An Giang 150.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Lâm Đồng 220.000 vnd/vé</li>
					<li>Hà Nội → Nam Định 70.000 vnd/vé</li>
					<li>TP Hồ Chí minh → Đắk Lắk 220.000 vnd/vé</li>
					<li>Hà Nội → Sơn La 220.000 vnd/vé</li>
				</ul>
			</div> 
			
		</div> -->
	</section>
	<%@ include file="footer.jsp"%>


</body>
</html>