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
	<script type="text/javascript">
	function checkPass() {
		alert("doimatkhau");
		if ($("#pass").val() == $("#re-pass").val())
			$("#contactform").submit();
		else
			$("#error-pass").text("Mật khẩu không trùng khớp!");

	}
	</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="contain">
		<div id="center">
		<form action="/BanVeXe/DoiMatKhau">
			<p id="h3">Bạn vui lòng nhập thông tin để kiểm tra vé!</p>
			<div id="divtrai">
				<label id="lsdt">Nhập mật khẩu hiện tại:</label><br> <input
				type="password" class="text" required="required" id="pass-old"/>
			</div>
			<div id="divphai">
				<label id="lcmnd">Nhập mật khẩu mới:</label><br>
				<input type="password" class="text" required="required" id="pass"/>
			</div>
			<div id="divphai">
				<label id="lcmnd">Nhập lại mật khẩu mới:</label><br>
			<span id ="error-pass" style="color: red;"></span>
				<input type="password" class="text" required="required" id="re-pass"/>
			</div>
			<div id="bt"><input type="button" value="Đổi mật khẩu" id="button_s" onclick="checkPass()"/></div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>