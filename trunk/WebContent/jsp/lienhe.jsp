<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/lienhe.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="width: 100%; height: 600px;">
		<div
			style="width: 100%; height: 40px; background: #145CA1; font-size: 30px; color: white; margin-top: 10px;">Liên
			hệ</div>
		<div id="dangki">
			<form id="contactform" name="contact" method="post" action="#">
				<p class="note">
					<img alt="icon"
						src="../image/con_info.png"> Mọi thông tin thắc mắc khách
					hàng hãy gọi điện hoặc gửi thông tin cho chúng tôi, chúng tôi sẽ
					trả lời trong thời gian sớm nhất. Xin cảm ơn!
				</p>
				<div class="row">
					<label for="name">Tên bạn</label>
					 <input type="text" name="name" id="name" class="txt" tabindex="1">
				</div>

				<div class="row">
					<label for="email">Địa chỉ email <span class="req">*</span></label>
					<input type="email" name="email" id="email" class="txt"
						tabindex="2" required>
				</div>

				<div class="row">
					<label for="subject">Tiêu đề thông điệp</label>
					 <input	type="text" name="subject" id="subject" class="txt" tabindex="3">
				</div>

				<div class="row">
					<label for="message">Message <span class="req">*</span></label>
					<textarea name="message" id="message" class="txtarea" tabindex="4" required></textarea>
				</div>

				<div class="center">
					<input type="button" id="submitbtn" name="submitbtn" tabindex="5"
						value="Gởi">
				</div>
			</form>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>