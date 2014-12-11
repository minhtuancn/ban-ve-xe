<%@page import="util.DuongDan"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/thanhtoan.css">
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
</script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%
		String shoten = "a";
		String sdidong = "1";
		String scmnd = "1";
		String semail = "a";
		KhachHang kh = (KhachHang ) session.getAttribute("khachHang");
		if (kh == null) {
			if (request.getParameter("hoten") != null)
				shoten = request.getParameter("hoten");
			if (request.getParameter("didong") != null)
				sdidong = request.getParameter("didong");
			if (request.getParameter("cmnd") != null)
				scmnd = request.getParameter("cmnd");
			if (request.getParameter("email") != null)
				semail = request.getParameter("email");
		}else{
			shoten = kh.getTenKhachHang();
			sdidong = kh.getSdt();
			scmnd = kh.getCmnd();
			semail = kh.getEmail();
		}
	%>
	<div class="contain">
		<div class="thongtinKH bg">
			<marquee behavior="alternate" width="10%">>></marquee>
			Thanh toán
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div>
			<p class="p-thongtin">Thông tin khách hàng:</p>
			<hr />
			<div class="login">
				<div class="dangnhap">
					<p class="p-dangnhap">- Bạn nên đăng nhập để có thể tích điểm
						tích lũy, nhấp vào&nbsp;</p>
					<a href="/BanVeXe/jsp/DangNhap.jsp?pageForward=<%=DuongDan.THANH_TOAN%>" class="dn">ĐÂY</a>
					<p class="p-dangnhap">. Hoặc nhấp vào&nbsp;</p>
					<a href="/BanVeXe/jsp/DangKi.jsp" class="dn">ĐÂY</a>
					<p class="p-dangnhap">để đăng kí.</p>
				</div>
				<p class="p-KCdangnhap">
					Thông tin chi tiết của Quý khách sẽ giúp chúng tôi và công ty vận
					chuyển phục vụ một cách tốt nhất.<br> - Xin vui lòng kiểm tra
					lại thông tin mà Quý khách đã khai báo với ở phần dưới đây một cách
					chính xác (bao gồm tên và số điện thoại).<br> - Nếu Quý khách
					là người mua hộ vé này cho người khác. Vui lòng điền thông tin đầy
					đủ và chính xác (bao gồm tên và số điện thoại của người đi).<br>
					- Chúng tôi và Công ty vận chuyển không chịu trách nhiệm và từ chối
					phục vụ Quý khách nếu thông tin của Quý khách không đúng theo Mục
					6.2, Điều 6, của Quy Định Vận Chuyển.
				</p>
				<form action="/BanVeXe/ThongTin" class="login-form bg">
					<table>
						<tr>
							<td><span>Thông tin người đi:</span></td>
						</tr>
						<tr>
							<td><span>Họ tên:</span><span class="req">*</span></td>
							<td><input type="text" name="hoten" size="58"
								required="required" placeholder="Họ tên" value="<%= shoten%>"/></td>
						</tr>
						<tr>
							<td><span>Di động:</span><span class="req">*</span></td>
							<td><input type="number" name="didong" size="100"
								required="required" placeholder="Di động" value="<%= sdidong%>" /></td>
						</tr>
						<tr>
							<td><span>Số CMND:</span><span class="req">*</span></td>
							<td><input type="number" name="cmnd" size="80"
								required="required" placeholder="Số CMND" value="<%= scmnd%>" /></td>
						</tr>
						<tr>
							<td><span>Email:</span><span class="req">*</span></td>
							<td><input type="email" name="email" size="50"
								required="required" placeholder="abc@gmail.com" value="<%= semail%>"/></td>
						</tr>
						<tr>
							<td><span>Ghi chú:</span></td>
							<td><textarea rows="5" cols="60" autofocus
									placeholder="Ghi chú" name="ghichu"></textarea></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><img id="captcha" src="/BanVeXe/GenerateCaptcha"
								title="Mã xác thực" width="100px" height="30px" />&nbsp;<img
								id="refresh" src="/BanVeXe/image/refresh.png"
								title="Tải lại mã xác thực khác" /></td>
						</tr>
						<tr>
							<td><span>Nhập mã xác nhập:</span><span class="req">*</span></td>
							<td><input type="text" required="required" name="captcha"
								placeholder="Mã xác nhận"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td id="xacnhan"><input type="submit"
							 /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>