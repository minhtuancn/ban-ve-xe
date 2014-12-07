<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kiểm tra vé</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/kiemtrave.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script>
	function removeReadonly() {
		$('.input-txt').removeAttr('readonly');
		$(".tv").css("visibility", "visible");
	}
	function addReadonly() {
		$('.input-txt').attr("readonly", "readonly");
		$(".tv").css("visibility", "hidden");
	}
</script>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div style="width: 100%; height: 800px;">
		<div class="bg title"><marquee behavior="alternate" width="10%">>></marquee>Kiểm tra vé<marquee behavior="alternate" width="10%"> << </marquee></div>
		<div class="kiemtrave kt-ve">
			<div class="kt-ve pd mg" id="ktve">
				<form action="#">
					<fieldset>
						<div class="kt-ve">
							<div class="ktve-p pd mg kt-ve">
								<p>Thông tin cá nhân</p>
								<div class="ktve-dong kt-ve">
									<label class="wd-110 fl-l">Tên đăng nhập:</label> <input
										class="input-txt wd-240" name="user" type="text" readonly
										value="">
								</div>
								<div class="ktve-dong kt-ve">
									<label class="wd-110 fl-l">Địa chỉ Email:</label> <input
										class="input-txt wd-240" readonly name="email" type="text"
										value="">
								</div>
								<div class="ktve-dong kt-ve">
									<label class="wd-110 fl-l">Số điện thoại:</label> <input
										class="input-txt wd-240" readonly name="sdt" type="text"
										value="">
								</div>
								<div class="ktve-dong kt-ve">
									<label class="wd-110 fl-l">Địa chỉ:</label> <input
										class="input-txt wd-240" readonly name="diachi" type="text"
										value="">
								</div>
								<div class="ktve-dong kt-ve">
									<label class="wd-110 fl-l">&nbsp;</label> <input
										class="timve fl-l" type="button" value="Sửa thông tin"
										onclick="removeReadonly()"> <input
										class="timve tv fl-l" type="button" value="Cập nhật"
										style="visibility: hidden" onclick="addReadonly()">
								</div>
								<a href="#">Đổi mật khẩu</a>

							</div>

						</div>
						<hr />
						<div class="kt-ve">
							<div class="ktve-p pd mg kt-ve">
								<p>Thông tin vé đã đặt</p>
								<table id="ktv">
									<tr id="dong1" class="bg">
										<td class="tr1" align="center">Chuyến xe</td>
										<td class="tr1" align="center">Giờ xuất phát</td>
										<td class="tr1" align="center">Giá vé</td>
										<td class="tr1" align="center">Loại ghế</td>
										<td class="tr1" align="center">Loại xe</td>
										<td class="tr1" align="center">Mã ghế</td>
										<td class="tr1" align="center">Thanh toán</td>
										<td class="tr1" align="center">Xóa</td>
									</tr>
									<tr id="dong2">
										<td class="tr1" align="center">HCM - Nha Trang</td>
										<td class="tr1" align="center">7:00 am</td>
										<td class="tr1" align="center">220,000đ</td>
										<td class="tr1" align="center">Giường nằm</td>
										<td class="tr1" align="center">45 chỗ</td>
										<td class="tr1" align="center">A1</td>
										<td class="tr1" align="center">Chưa thanh toán<br /> <a
											href="DangNhap.jsp" class="ttoan">thanh toán</a></td>
										<td align="center" class="tr1"><button class="chon">Xóa</button></td>
									</tr>
									<tr id="dong2">
										<td class="tr1" align="center">HCM - Nha Trang</td>
										<td class="tr1" align="center">5:00 pm</td>
										<td class="tr1" align="center">120,000đ</td>
										<td class="tr1" align="center">Giường nằm</td>
										<td class="tr1" align="center">45 chỗ</td>
										<td class="tr1" align="center">A2</td>
										<td class="tr1" align="center">Đã thanh toán</td>
										<td class="tr1" align="center"><button class="chon">Xóa</button></td>
									</tr>

								</table>
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
	</div>



	<%@ include file="footer.jsp"%>
</body>
</html>