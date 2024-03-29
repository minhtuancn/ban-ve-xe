<%@page import="model.NhanVien"%>
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
			<div style="float: right; margin-top: -120px; margin-bottom: 10px;">
				<%  NhanVien nv = (NhanVien) session.getAttribute("admin");
				if(nv == null){
				%>
				<div id="dn"><a id="taga" href=<%=DuongDan.DANG_NHAP_ADMIN %>>Đăng nhập</a> &nbsp;
				<a id="taga" href=<%=DuongDan.DANG_KY %>>Đăng kí</a></div>
				<%}else { %>
				<div id="dn"><a id="taga" href=<%=DuongDan.XAC_NHAN_THANH_TOAN %>><%= nv.getHoTen()%></a> &nbsp;
				<a id="taga" href=<%=DuongDan.DANG_XUAT_ADMIN_SV %>>Thoát</a></div>
				<%} %>
				</div>
			<nav>
				<ul>
					<li><a href="<%=DuongDan.LIST_TUYEN_SV %>">Thêm Tuyến</a></li>
					<li><a href="<%=DuongDan.KIEM_TRA_CHUYEN_SV %>">Thêm Chuyến</a></li>
					<li><a href="<%=DuongDan.LIST_DIA_DIEM_SV %>">Thêm Địa Điểm</a></li>
					<li><a href="<%=DuongDan.THEM_KHACHHANG_SV %>">Thêm Khách Hàng</a></li>
					<li><a href="<%=DuongDan.XAC_NHAN_THANH_TOAN_SV %>">Xác Nhận Thanh Toán</a></li>
					
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>