<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liên hệ</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/lienhe.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script type="text/javascript">
	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "success");
		}
	};
	function al(mes, type) {
		swal({
			title : mes,
			type : type
		});
	}
	$(window).load(function() {
		checkEr();
	});
	
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 200) {
				$(".autoScroll").animate({
					top :10
				},0, function() {
					
				});
			} else {
				$(".autoScroll").animate({
					top : 200-$(this).scrollTop()
				},0, function() {
					
				});
			}
		});
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Liên hệ
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<%
			String mes = "";
			if ((String) request.getAttribute("mes") != null)
				mes = (String) request.getAttribute("mes");
		%>
		<input type="hidden" value="<%=mes%>" id="error" />
	<div id="containers">
		<div id="left">
			<img id="imgleft" class="autoScroll"  alt="left" src="/BanVeXe/image/cau-doi-l.png" />
		</div>
		<div id="lienhe">
			<fieldset>
				<legend>Liên hệ</legend>
			<p class="note">
				<img alt="icon" src="/BanVeXe/image/con_address.png">Văn phòng
				chính: VP Cẩm Tú, khu phố 6, phường Linh Trung, Q.Thủ Đức, TP. Hồ
				Chí Minh, Việt Nam
			</p>
			<p class="note">
				<img alt="icon" src="/BanVeXe/image/emailButton.png">
				vexeonline@hcmuaf.edu.vn
			</p>
			<p class="note">
				<img alt="icon" src="/BanVeXe/image/con_tel.png"> Tổng đài đặt
				vé: 08.29 29 29 29
			</p>
			<p class="note">
				<img alt="icon" src="/BanVeXe/image/con_mobile.png"> Đường dây
				nóng: 01234567890;
			</p>
			<p class="note">
				<img alt="icon" src="/BanVeXe/image/con_info.png"> Mọi thông
				tin thắc mắc khách hàng hãy gọi điện hoặc gửi thông tin cho chúng
				tôi, chúng tôi sẽ trả lời trong thời gian sớm nhất. Xin cảm ơn!
			</p>

			<form id="contactform" name="contact" method="post"
				action=<%=DuongDan.LIEN_HE_SV%>>
				<div class="row">
					<label for="name">Tên bạn:</label> <input type="text" name="name"
						id="name" class="txt" tabindex="1">
				</div>

				<div class="row">
					<label for="email">Địa chỉ email: <span class="req">*</span></label>
					<input type="email" name="email" id="email" class="txt"
						tabindex="2" required>
				</div>

				<div class="row">
					<label for="subject">Tiêu đề:</label> <input type="text"
						name="tieude" id="subject" class="txt" tabindex="3">
				</div>

				<div class="row">
					<label for="message">Nội dung: <span class="req">*</span></label>
					<textarea name="message" id="message" class="txtarea" tabindex="4"
						required></textarea>
				</div>
				<div class="cb">
					<input type="checkbox" name="checkbox">Gởi một bản copy
					thông điệp này đến hộp email của bạn
				</div>
				<div>
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Gởi">
				</div>
			</form>
			</fieldset>
		</div>
		<div id="right">
			<img id="imgright" class="autoScroll"  alt="right" src="/BanVeXe/image/cau-doi-r.png" />
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>