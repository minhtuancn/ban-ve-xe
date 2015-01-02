<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script type="text/javascript">

function sendOTP() {
	$.get(
"<%=DuongDan.CHECK_OTP%>"
, function(data, status) {
		if (status == "success") {
			if (data == "ok") {
				swal({
					title : "Mã OTP đã được gửi cho quý khách",
					type : "success"
				});
			}
		}
	});
}

	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
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
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="contain">
		<div id="center">
			<%
				String mes = "";
				if ((String) request.getAttribute("mes") != null)
					mes = (String) request.getAttribute("mes");
			%>
			<input type="hidden" value="<%=mes%>" id="error" />
			<form action="/BanVeXe/KichHoatTaiKhoan">
				<p>Tài khoản quý khách chưa kích hoat!<br>
				Mã OTP đã được gửi cho quý khách qua tin nhắn!!<br>
 Quý khách vui lòng nhập mã OTP để kích hoạt tài khoản !!</p>
				<div id="divtrai">
					<input type="text" class="text"
						style="width: 400px; margin-bottom: 20px;" name="maOTP" />
						<div><input type="button"
								class="chon" value="Gửi lại mã OTP" onclick="sendOTP()"></div>
					<div style="margin-left: 250px;">
						<input type="submit" id="button_s" value="Xác nhận" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>