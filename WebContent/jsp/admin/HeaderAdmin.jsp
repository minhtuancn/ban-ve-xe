<%@page import="util.DuongDan"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/header.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
</head>
<body>
	<div id="containers" style="margin-bottom:50px;" >
		<header class="bg overflow">
			<div>
				<img  alt="logo"  src="/BanVeXe/image/logo5.png" width="300"
				height="100"  >
			</div>
			<nav>
				<ul>
					<li><a href="<%=DuongDan.THEM_TUYEN_SV %>">Thêm Tuyến</a></li>
					<li><a href="<%=DuongDan.KIEM_TRA_CHUYEN_SV %>">Thêm Chuyến</a></li>
					<li><a href="<%=DuongDan.THEM_DIADIEM_SV %>">Thêm Địa Điểm</a></li>
					<li><a href="<%=DuongDan.THEM_KHACHHANG_SV %>">Thêm Khách Hàng</a></li>
					<li><a href="<%=DuongDan.XAC_NHAN_THANH_TOAN %>">Xác Nhận Thanh Toán</a></li>
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>