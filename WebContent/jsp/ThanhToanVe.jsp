<%@page import="model.KhachHangThuongXuyen"%>
<%@page import="model.Ve"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh Toán Vé</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/kiemtrave.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/timve.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/lienhe.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
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
</script>
</head>
<body style="color: blue;">
	<%@ include file="header.jsp"%>
	<div id=contain>
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Thanh toán
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<%
		 
	
			Ve ve = (Ve) request.getAttribute("veThanhToan");
			KhachHang khachHangTT = ve.getKhachHang();
		
		
		%>

		<div id="center"
			style="width: 1000px; margin-left: 150px; padding: 50px;">
			<h2>Chào mừng quý khách đến với trang thanh toán của công ty
				chúng tôi!</h2>
			<p>
				Quý khách vui lòng kiểm tra thông tin vé trước khi thanh toán <br>
				Mọi thắc mắc quý khách vui lòng liên hệ công ty để biết thêm chi
				tiết!
			</p>
			<fieldset>
				<legend>Thanh toán vé</legend>

				<div
					style="width: 100%; height: auto; float: left; clear: none; margin-bottom: 20px;">
					<div style="float: left; clear: right;">
						<div class="ktve-dong kt-ve">
							<label class="wd-110 ">Mã vé:</label> <input
								value="<%=ve.getMaVe()%>" class="input-txt wd-240" name="name"
								type="text" readonly>
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110 ">Tuyến:</label> <input
								value="<%=ve.getTuyenXe()%>" class="input-txt wd-240" readonly
								name="email" type="text">
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110 ">Ngày khởi hành</label> <input
								value="<%=ve.getNgayKhoiHanh()%>" class="input-txt wd-240"
								readonly name="sdt" type="text">
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110 ">Bến xuất phát:</label> <input
								value="<%=ve.getBenXuatPhat()%>" class="input-txt wd-240"
								name="cmnd" type="text" readonly>
						</div>


					</div>
					<div style="float: left; clear: none; margin-left: 200px;">
						<div class="ktve-dong kt-ve">
							<label class="wd-110 fl-l">Mã ghế:</label> <input
								value="<%=ve.getTenGhe()%>" class="input-txt wd-240" readonly
								name="email" type="text">
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110">Số lượng ghế:</label> <input
								value="<%=ve.getSoLuongGhe()%>" class="input-txt wd-240"
								name="name" type="text" readonly>
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110 fl-l">Giá vé:</label> <input
								value="<%=ve.getGia()%>" class="input-txt wd-240" readonly
								name="sdt" type="text">
						</div>
						<div class="ktve-dong kt-ve">
							<label class="wd-110 fl-l">Tổng tiền:</label> <input
								value="<%=ve.getTongTien()%>" class="input-txt wd-240"
								name="cmnd" type="text" readonly>
						</div>
					</div>
				</div>
				<hr />
				<form action="/BanVeXe/ThanhToanTien" method="post">
					<input type="hidden" name="maVeThanhToan" value="<%=ve.getMaVe()%>">
					<div style="margin-top: 20px;">
						<div style="float: left; clear: right;">
							<div class="ktve-dong kt-ve">
								<label class="wd-110 fl-l">Số dư tài khoản:</label> <input
									value="<%=((KhachHangThuongXuyen) khachHangTT).getSoTien()%>"
									class="input-txt wd-240" name="cmnd" type="text"
									readonly="readonly">
							</div>
							<div class="ktve-dong kt-ve">
								<label class="wd-110 fl-l">Mã OTP:</label> <input required="required"
									class="input-txt wd-240" name="maOTP" type="text">

							</div>
							<label class="wd-110 fl-l">&nbsp;</label> 
<!-- 							<input type="button" -->
<!-- 								class="chon" value="Gửi lại mã OTP" onclick="sendOTP()"> -->
							<a onclick="sendOTP()" id="a-otp">Gửi lại mã OTP</a>
						</div>
						<div style="float: left; margin-left: 200px;">
							<div class="ktve-dong kt-ve">
								<label class="wd-110 fl-l">Số tiền chi trả:</label> <input
									value="<%=ve.getTongTien()%>" readonly="readonly"
									class="input-txt wd-240" name="diachi" type="text">
							</div>
							<br>
							<div style="float: right; margin-bottom: 20px;">
								<input type="submit" class="chon" value="THANH TOÁN VÉ" />
							</div>
						</div>
					</div>

				</form>
			</fieldset>
		</div>

	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>