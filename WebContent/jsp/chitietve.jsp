<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vé xe online</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/thongtinve.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<h1>Chúc mừng quý khách đã giữ chỗ thành công!</h1>
		<fieldset>
			<legend>Thông tin vé</legend>
			<div class="thongtinve">
				<div class="td"><div class="thoidiem">Thời điểm đặt vé :&nbsp;3/12/2012&nbsp; 14:00</div><div class="mave">Mã vé: IU000012</div></div>
				<table border="1">
					<tr>
						<td>Tuyến:</td>
						<td colspan="5"><h3>Thành phố hồ chí minh---> đà nẵng</h3> <img alt="chuathanhtoan" src="/BanVeXe/image/iconchuathanhtoan.png"></td>
					</tr>
					<tr>
						<td>Ngày đi:</td>
						<td>12/12/2012 &nbsp;12:00</td>
						<td>Hành khách:</td>
						<td align="center">Nguyễn văn a</td>
						<td>Điện thoại:</td>
						<td align="center">0933323400</td>
						</tr>
					<tr>
					<td>Số lượng ghế:</td>
					<td align="center">2</td>
						<td>Vị trí ghế:</td>
						<td colspan="3" align="center">A1, A2</td>
</tr>
				</table>
				<div class="thoihan">(Thời hạn thanh toán: 30/12/2012 12:00)</div>
				<p>
					Vé của Quý khách được giữ chỗ đến Thời hạn thanh toán được ghi chú
					trên thông tin vé.<br> Để tăng thời gian giữ chỗ, Quý khách
					hãy kích hoạt link xác nhận thông tin đặt vé nhận được trong email.<br>
					Để mua được vé thành công, Quý khách vui lòng thanh toán theo hình
					thức phù hợp trước Thời hạn thanh toán, sau thời gian này vé giữ
					chỗ của Quý khách sẽ bị hủy tự động.<br> Quý khách có thể
					thanh toán qua các hình thức:<br> 1/ Thanh toán trực tuyến
					trên click1BUS qua thẻ ATM ngân hàng. Quý khách có thể tham khảo
					thêm hướng dẫn phương thức thanh toán trực tuyến tại đây<br>
					2/ Thanh toán bằng tiền mặt tại văn phòng Công ty TNHH SiGlaz Việt
					Nam.<br> 3/ Thanh toán bằng tiền mặt tại phòng vé chính thức
					của Hãng xe.<br> 4/ Chuyển khoản ngân hàng.<br>
				<p>
					Quý khách nhấp link xác nhận đặt vé trong Email Thông tin vé để
					tăng Thời hạn thanh toán<br>
				</p>
			</div>
		</fieldset>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>