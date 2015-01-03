<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/quenmatkhau.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('#refresh').click(function() {
			var d = new Date();
			var newSrc = "/BanVeXe/GenerateCaptcha?" + d.getTime();
			$('#captcha').attr("src", newSrc);
		});
	});
	function layMatKhau() {
		$.post("<%= DuongDan.LAY_MAT_KHAU%>", 
				{
			tentk : $("#tentk").val(),
			captcha : $("#icaptcha").val()
		}, function(data, status) {
			if(status== "success"){
				if(data == "ok"){
					alert("ok");
				}else{
					alert(data);
				}
			}
		});
	};
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="qmk-contain">
		<div class="title bg">
			<marquee behavior="alternate" width="10%">>></marquee>
			Quên mật khẩu
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div class="quenmk">
			<p class="ghichu-qmk">
				Thông tin chi tiết của Quý khách sẽ giúp chúng tôi xác nhận lại tài
				khoản của mình một cách chính xác <br> - Quý khách vui lòng
				nhập chính xác các thông tin bên dưới<br>
			</p>
			<form action="#" class="quenmatkhau-form bg">
				<table>
					<tr>
						<td><span>Quên mật khẩu</span></td>
					</tr>
					<tr>
						<td><span>Tên tài khoản:</span><span class="req">*</span></td>
						<td><input type="text" name="tentk" id="tentk" required="required"
							style="width: 310px;" placeholder="Tên tài khoản" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><img id="captcha" src="/BanVeXe/GenerateCaptcha"
							title="Mã xác thực" width="100px" height="30px" />&nbsp;<img
							id="refresh" title="Tải lại mã xác thực khác"
							src="/BanVeXe/image/refresh.png" /></td>
					</tr>
					<tr>
						<td><span>Nhập mã xác nhận:</span><span class="req">*</span></td>
						<td><input type="text" name="icaptcha" id="icaptcha" size="40"
							placeholder=" Nhập mã xác nhận" required="required"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td id="xacnhan"><input type="button" name="xacnhan"
							value="Xác nhận" onclick="layMatKhau()" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%></body>
</html>