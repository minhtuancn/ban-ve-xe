<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/thanhtoan.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="contain">
		<div class="thongtinKH">Thanh toán</div>
		<div>
			<p class="p-thongtin">Thông tin khách hàng:</p>
			<hr />
			<div class="login">
			<div class="dangnhap"><p class="p-dangnhap"> - Bạn nên đăng nhập để có thể tích điểm tích lũy, nhấp vào&nbsp;</p>
			<a href="/BanVeXe/jsp/DangNhap.jsp" class="dn">ĐÂY</a>
			<p class="p-dangnhap">. Hoặc nhấp vào&nbsp;</p><a href="/BanVeXe/jsp/DangKi.jsp" class="dn">ĐÂY</a>
			<p class="p-dangnhap">để đăng kí.</p>
			</div>
			<p class="p-KCdangnhap">Thông tin chi tiết của Quý khách sẽ giúp chúng tôi và công ty vận chuyển phục vụ một cách tốt nhất.<br>
				- Xin vui lòng kiểm tra lại thông tin mà Quý khách đã khai báo với ở phần dưới đây một cách chính xác (bao gồm tên và số điện thoại).<br>
				- Nếu Quý khách là người mua hộ vé này cho người khác. Vui lòng điền thông tin đầy đủ và chính xác (bao gồm tên và số điện thoại của người đi).<br>
				- Chúng tôi và Công ty vận chuyển không chịu trách nhiệm và từ chối phục vụ Quý khách nếu thông tin của Quý khách không đúng theo Mục 6.2, Điều 6, của Quy Định Vận Chuyển.</p>
				<form action="#" class="login-form">
					<table>
						<tr>
							<td><span>Thông tin người đi:</span></td>
						</tr>
						<tr>
							<td><span>Họ tên:</span><span class="req">*</span></td>
							<td><input type="text" name="hoten" size="30"
								placeholder="Họ tên" /></td>
						</tr>
						<tr>
							<td><span>Di động:</span><span class="req">*</span></td>
							<td><input type="tel" name="didong" size="30"
								placeholder="Di động" /></td>
						</tr>
						<tr>
							<td><span>Ghi chú:</span></td>
							<td><textarea rows="5" cols="60" autofocus
									placeholder="Ghi chú"></textarea></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td id="xacnhan"><input type="submit" name="xacnhan" value="Xác nhận" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>