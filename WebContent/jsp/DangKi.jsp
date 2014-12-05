<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng Kí</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/dangki.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('#refresh').click(function() {
			var d = new Date();
			var newSrc = "/BanVeXe/GenerateCaptcha?"+d.getTime();
			$('#captcha').attr("src", newSrc);
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="dk-contain">
		<div id="dangki">
			<h1>Đăng Kí!</h1>
			<form id="contactform" name="contact" method="post" action="#">
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="name" id="name" class="txt" tabindex="1"
						placeholder="Tên đăng nhập" required>
				</div>

				<div class="row">
					<label for="email">Địa chỉ email: <span class="req">*</span></label>
					<input type="email" name="email" id="email" class="txt"
						tabindex="2" placeholder="address@gmail.com" required>
				</div>

				<div class="row">
					<label for="subject">Số Điện Thoại: <span class="req">*</span></label>
					<input type="text" name="subject" id="subject" class="txt"
						tabindex="3" placeholder="Số điện thoại" required>
				</div>
				<div class="row">
					<label for="subject">Địa chỉ:</label> <input type="text"
						name="subject" id="subject" class="txt" tabindex="3"
						placeholder="Địa chỉ" required>
				</div>
				<div class="captcha">
					<img id="captcha" src="/BanVeXe/GenerateCaptcha"
						title="Mã xác thực" width="100px" height="30px">
						<img id="refresh"
								src="/BanVeXe/image/refresh.png" title="Tải lại mã xác thực khác"  >
				</div>
				<div class="row">
					<label for="subject">Mã xác nhận: <span class="req">*</span></label>
					<input type="text" id="subject" class="txt" required="required" placeholder="Mã xác nhận">
				</div>
				<div class="center">
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Kí">
				</div>
			</form>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>