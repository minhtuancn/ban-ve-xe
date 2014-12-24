<%@page import="model.Ve"%>
<%@page import="model.KhachHang"%>
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
	<%
		Ve veDi = (Ve) session.getAttribute("veDi");
		KhachHang kh = veDi.getKhachHang();
		;
	%>

	<div class="container">
		<%@ include file="header.jsp"%>
		<h1>Chúc mừng quý khách đã đặt chỗ thành công!</h1>
		<fieldset>
			<legend>Thông tin vé</legend>
			<div class="thongtinve">
				<div class="td">
					<div class="thoidiem">
						Thời điểm đặt vé :&nbsp;
						<%=veDi.getNgayDatVe()%></div>
					<div class="mave">
						Mã vé:
						<%=veDi.getMaVe()%></div>
				</div>
				<table border="1">
					<tr>
						<td>Tuyến:</td>
						<td colspan="5"><h3><%=veDi.getTuyenXe()%></h3> <%
 	if (!veDi.isTrangThaiThanhToan()) {
 %> <img alt="chuathanhtoan" src="/BanVeXe/image/iconchuathanhtoan.png"></td>
						<%
							} else {
						%>
						<img alt="chuathanhtoan" src="/BanVeXe/image/icondathanhtoan.png">
						</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Ngày đi:</td>
						<td><%=veDi.getNgayKhoiHanh()%></td>
						<td>Hành khách:</td>
						<td align="center"><%=kh.getTenKhachHang()%></td>
						<td>Điện thoại:</td>
						<td align="center"><%=kh.getSdt()%></td>
					</tr>
					<tr>
						<td>Số lượng ghế:</td>
						<td align="center"><%=veDi.getSoLuongGhe()%></td>
						<td>Vị trí ghế:</td>
						<td colspan="3" align="center"><%=veDi.getTenGhe()%></td>
					</tr>
				</table>
				<%
					if (!veDi.isTrangThaiThanhToan()) {
				%>
				<div class="thoihan">
					(Thời hạn thanh toán:
					<%=veDi.getThoiHanThanhToan()%>)
				</div>
				<%
					}
				%>
				<!-- 				Vé về -->
				<%
					Ve veVe = (Ve) session.getAttribute("veVe");
					if (veVe != null) {
				%>
				<div class="td">
					<div class="thoidiem">
						Thời điểm đặt vé :&nbsp;
						<%=veVe.getNgayDatVe()%></div>
					<div class="mave">
						Mã vé:
						<%=veVe.getMaVe()%></div>
				</div>
				<table border="1">
					<tr>
						<td>Tuyến:</td>
						<td colspan="5"><h3><%=veVe.getTuyenXe()%></h3> <%
 	if (!veVe.isTrangThaiThanhToan()) {
 %> <img alt="chuathanhtoan" src="/BanVeXe/image/iconchuathanhtoan.png"></td>
						<%
							} else {
						%>
						<img alt="chuathanhtoan" src="/BanVeXe/image/icondathanhtoan.png">
						</td>
						<%
							}
						%>
					</tr>
					<tr>
						<td>Ngày đi:</td>
						<td><%=veVe.getNgayKhoiHanh()%></td>
						<td>Hành khách:</td>
						<td align="center"><%=kh.getTenKhachHang()%></td>
						<td>Điện thoại:</td>
						<td align="center"><%=kh.getSdt()%></td>
					</tr>
					<tr>
						<td>Số lượng ghế:</td>
						<td align="center"><%=veVe.getSoLuongGhe()%></td>
						<td>Vị trí ghế:</td>
						<td colspan="3" align="center"><%=veVe.getTenGhe()%></td>
					</tr>
				</table>
				<div class="thoihan">
					(Thời hạn thanh toán:
					<%=veVe.getThoiHanThanhToan()%>)
				</div>
				<%
					}
				%>
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
					Quý khách vui lòng nhắn tin với cú pháp "VE &ltmave&gt" gửi 0169xxxxx để gia hạn thời gian thanh toán <a href="<%=DuongDan.THANH_TOAN_SV + "?pageFoward="+DuongDan.CHI_TIET_VE_SVL+ "&mave=" + veDi.getMaVe()%>" style="color: red;">Quý khách nhấp link để thanh toán vé đi</a><br>
					<%if(veVe != null){%>
					
					<a href="<%=DuongDan.THANH_TOAN_SV + "?pageFoward="+DuongDan.CHI_TIET_VE_SVL+ "&mave=" + veVe.getMaVe()%>" style="color: red;">Quý khách nhấp link để thanh toán vé về</a><br>
					<%} %>
				</p>
			</div>
		</fieldset>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>