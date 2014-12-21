<%@page import="util.DuongDan"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/header.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script type="text/javascript">
</script>
</head>
<body>
<%KhachHang khachHang= (KhachHang)session.getAttribute("khachHang");
String pageLink = "";
if(khachHang!=null)
	pageLink = DuongDan.KIEM_TRA_VE;
else pageLink = DuongDan.KIEM_TRA_VE_CHUA_DANG_NHAP;
%>
	<div id="container">
		<header class="bg overflow">
		<a href=<%=DuongDan.TRANG_CHU %>>
			<img alt="logo"  src="/BanVeXe/image/logo2.png" width="480"
				height="120"  >
				</a> 
				<%KhachHang khs = (KhachHang) session.getAttribute("khachHang");
				if(khs == null){
				%>
				<div id="dn"><a id="taga" href=<%=DuongDan.DANG_NHAP %>>Đăng nhập</a> &nbsp;
				<a id="taga" href=<%=DuongDan.DANG_KY %>>Đăng kí</a></div>
				<%}else { %>
				<div id="dn"><a id="taga" href=<%=DuongDan.KIEM_TRA_THONG_TIN %>><%=khs.getTenKhachHang() %></a> &nbsp;
				<a id="taga" href=<%=DuongDan.DANG_XUAT %>>Thoát</a></div>
				<%} %>
		</header>
		<nav>
			<ul>
				<li><a href="/BanVeXe/jsp/body.jsp">Trang chủ</a></li>
				<li><a href="/BanVeXe/jsp/gioithieu.jsp">Giới thiệu</a></li>
				<li><a href=<%=pageLink %>>Kiểm tra thông tin</a></li>
				<li><a href="/BanVeXe/jsp/timve.jsp">Kiểm tra vé</a></li>
				<li><a href="/BanVeXe/jsp/tintuc.jsp">Tin tức</a></li>
				<li><a href="/BanVeXe/jsp/lienhe.jsp">Liên hệ</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>