<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tin tức</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/tintuc.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="tt-container">
		<div class="title bg">
			<marquee behavior="alternate" width="10%">>></marquee>
			Tin tức
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div id="timvenhanh" class="bg">Tìm vé nhanh:</div>
		<div id="listve">
			<ul>
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
		<div id="link">
			<div id="DS-link">Thông tin khác</div>
			<div id="ds">
				<ul>
					<li><a href="#">Danh sách các chuyến xe khách từ bến xe
							Giáp Bát đi Hòa Bình </a> 30.10.2014</li>
					<li><a href="#">Danh sách các nhà xe chạy tuyến bến xe
							Giáp Bát đi Quảng Ninh </a> 30.10.2014</li>
					<li><a href="#">Lịch trình vận chuyển của xe khách Minh
							Tơ Bình Thuận </a> 29.10.2014</li>
					<li><a href="#">Lịch trình vận chuyển của xe khách Sang
							Hoa Bình Thuận </a> 28.10.2014</li>
					<li><a href="#">Lịch trình vận chuyển của xe khách Văn
							Tín Bến Tre </a> 28.10.2014</li>
					<li><a href="#">Lịch trình xe khách Thảo Nga An Giang </a>
						28.10.2014:</li>
					<li><a href="#">Lịch trình xe khách Hoàng Yến tuyến Bạc
							Liêu – TP Hồ Chí Minh </a> 24.10.2014</li>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>