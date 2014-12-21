<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
	<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="contain">
		<div id="center">
		<form action="">
			<p id="h3">Bạn vui lòng nhập thông tin để kiểm tra vé!</p>
			<div id="divtrai">
				<label id="lsdt">Nhập số điện thoại:</label><br> <input
				type="text" class="text" />
			</div>
			<div id="divphai">
				<label id="lcmnd">Nhập số CMND:</label><br>
				<input type="text" class="text" />
			</div>
			<div id="bt"><input type="button" value=" Xem " id="button_s" /></div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>