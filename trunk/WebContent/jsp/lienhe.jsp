<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liên hệ</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/lienhe.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="container">
		<div id="contain">Liên hệ</div>
		<div id="lienhe">
			<p class="note">
					<img alt="icon"
						src="/BanVeXe/image/con_address.png">Văn phòng chính: VP Cẩm Tú, khu phố 6, phường Linh Trung, Q.Thủ Đức, TP. Hồ Chí Minh, Việt Nam 
				</p>
				<p class="note">
					<img alt="icon"
						src="/BanVeXe/image/emailButton.png"> vexeonline@hcmuaf.edu.vn 
				</p>
				<p class="note">
					<img alt="icon"
						src="/BanVeXe/image/con_tel.png"> Tổng đài đặt vé: 08.29 29 29 29
				</p>
				<p class="note">
					<img alt="icon"
						src="/BanVeXe/image/con_mobile.png"> Đường dây nóng: 01234567890;
				</p>
				<p class="note">
					<img alt="icon"
						src="/BanVeXe/image/con_info.png"> Mọi thông tin thắc mắc khách
					hàng hãy gọi điện hoặc gửi thông tin cho chúng tôi, chúng tôi sẽ
					trả lời trong thời gian sớm nhất. Xin cảm ơn!
				</p>
				
			<form id="contactform" name="contact" method="post" action="#">
				<div class="row">
					<label for="name">Tên bạn:</label>
					 <input type="text" name="name" id="name" class="txt" tabindex="1">
				</div>

				<div class="row">
					<label for="email">Địa chỉ email: <span class="req">*</span></label>
					<input type="email" name="email" id="email" class="txt"
						tabindex="2" required>
				</div>

				<div class="row">
					<label for="subject">Tiêu đề:</label>
					 <input	type="text" name="subject" id="subject" class="txt" tabindex="3">
				</div>

				<div class="row">
					<label for="message">Nội dung: <span class="req">*</span></label>
					<textarea name="message" id="message" class="txtarea" tabindex="4" required></textarea>
				</div>
				<div class="cb"> <input type="checkbox" name="checkbox" value="a">Gởi một bản copy thông điệp này đến hộp email của bạn
				</div>
				<div>
					<input type="button" id="submitbtn" name="submitbtn" tabindex="5"
						value="Gởi">
				</div>
			</form>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>