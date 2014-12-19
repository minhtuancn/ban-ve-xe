<%@page import="util.DuongDan"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/DangNhap.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="containerdn">
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Đăng nhập
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div id="dangki">
			<% String pageForward = DuongDan.TRANG_CHU ;
			if(request.getParameter("pageForward") != null)
				pageForward = request.getParameter("pageForward");
		%>
			<h1>Đăng Nhập</h1>
			<form id="contactform" name="contact" method="post"
				action="/BanVeXe/DangNhap">
				<input type="hidden" name="pageForward" value="<%= pageForward%>" />
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="user" id="name" class="txt" tabindex="1"
						placeholder="Tên đăng nhập" required />
				</div>

				<div class="row">
					<label for="password">Mật khẩu: <span class="req">*</span></label>
					<input type="password" name="password" id="password" class="txt"
						tabindex="2" placeholder="********" required />
				</div>
				<div class="center">
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Nhập" />
				</div>
				<div class="dong">
					<a class="dangki" href="DangKi.jsp">Đăng kí</a>
				</div>
				<div class="dong">
					<a class="quenmk" href="quenmk.jsp">Quên mật khẩu</a>
				</div>
			</form>
		</div>

		<%-- 		<div class="ctv"><%@ include file="chitietvexe.jsp"%></div> --%>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>