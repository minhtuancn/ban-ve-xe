<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/quenmatkhau.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="qmk-contain">
		<div class="quenmatkhau">Quên mật khẩu</div>
		<div class="quenmk">
			<p class="ghichu-qmk">
				Thông tin chi tiết của Quý khách sẽ giúp chúng tôi xác nhận lại tài
				khoản của mình một cách chính xác <br> - Quý khách vui lòng
				nhập chính xác các thông tin bên dưới<br>
			</p>
			<form action="#" class="quenmatkhau-form">
				<table>
					<tr>
						<td><span>Quên mật khẩu</span></td>
					</tr>
					<tr>
						<td><span>Nhập email:</span><span class="req">*</span></td>
						<td><input type="text" name="hoten" required="required"
							size="40" placeholder="Họ tên" /></td>
					</tr>
					<tr>
						<td><span>Nhập mã xác nhận:</span><span class="req">*</span></td>
						<td><input type="text" name="maXN" size="40"
							placeholder=" Nhập mã xác nhận" required="required"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td id="xacnhan"><input type="submit" name="xacnhan"
							value="Xác nhận" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%></body>
</html>