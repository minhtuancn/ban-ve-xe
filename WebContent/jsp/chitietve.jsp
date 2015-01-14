<%@page import="model.Ve"%>
<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vé xe online</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/thongtinve.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/popup.css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#thanhtoan").click(function() {
			var loginBox = $("#login-box");

			//Fade in the Popup
			$(loginBox).fadeIn(300);

			//Set the center alignment padding + border see css style
			var popMargTop = ($(loginBox).height()) / 2;
			var popMargLeft = ($(loginBox).width()) / 2;

			$(loginBox).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="mask"></div>');
			$('#mask').fadeIn(300);
			$('#mask').click(
					function() {
						alert("aaaaaaa");
						$('#mask , .login-popup-thanhtoan').fadeOut(300,
								function() {
									$('#mask').remove();
								});
						return false;
					});
		});
	});
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
	function print() {
		var divContents = $("div.thongtinve").html();
		var divContents = $("fieldset").html();
		var printWindow = window.open('', '', 'height=600,width=900');
		printWindow.document.write('<html><head><title>DIV Contents</title>');
		printWindow.document
				.write('<link rel="stylesheet" type="text/css" href="/BanVeXe/css/thongtinve.css">');
		printWindow.document.write('</head><body >');
		printWindow.document.write(divContents);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		printWindow.print();
	};
</script>
</head>
<body>
	<%
		Ve veDi = (Ve) session.getAttribute("veDi");
		KhachHang kh = veDi.getKhachHang();
	%>
	<%
		String mes = "";
		if ((String) request.getAttribute("mes") != null)
			mes = (String) request.getAttribute("mes");
	%>
	<input type="hidden" value="<%=mes%>" id="error" />
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
					<tr>
						<td colspan="2">Tổng tiền:</td>
						<td colspan="4" align="center"><%=veDi.getTongTien()%></td>
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
					<tr>
						<td colspan="2">Tổng tiền:</td>
						<td colspan="4" align="center"><%=veVe.getTongTien()%></td>
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
					vui lòng thanh toán vé ở link bên dưới đây.<br> Quý khách vui
					lòng thanh toán cho vé trước Thời hạn thanh toán, sau thời gian này
					vé giữ chỗ của Quý khách sẽ bị hủy tự động.<br> Quý khách có
					thể thanh toán qua các hình thức:<br> 1/ Thanh toán trực tuyến
					trên VeXeOnline qua thẻ ATM ngân hàng. Quý khách có thể tham khảo
					thêm hướng dẫn phương thức thanh toán trực tuyến tại đây<br>
					2/ Thanh toán bằng tiền mặt tại văn phòng Công ty đặt tại văn phòng
					Cẩm Tú, đại học Nông Lâm, khu phố 6, phường Linh Trung, quận Thủ
					Đức.<br> 3/ Thanh toán bằng tiền mặt tại phòng vé chính thức
					của Hãng xe.<br> 4/ Chuyển khoản ngân hàng.<br>

					<%
						if (!veDi.isTrangThaiThanhToan()) {
					%>
				
				<p>Quý khách vui lòng nhắn tin với cú pháp "VE &ltmave&gt" gửi
					0169xxxxx để gia hạn thời gian thanh toán</p>

				<a id="thanhtoan" href="#"
					style="color: red;">Quý khách nhấp link để thanh toán vé đi</a><br>
				<%
					}

					if (veVe != null && !veVe.isTrangThaiThanhToan()) {
				%>

				<a id="thanhtoan" href="#" style="color: red;">Quý khách nhấp link để thanh
					toán vé về</a><br>
				<%
					}
				%>
				<div id="login-box" class="login-popup-thanhtoan">
					<fieldset class="textbox">
						
							<div class="row-thanhtoan"><p class="thanhtoan-p">Thanh toán bằng tài khoản trên website: chọn vào &nbsp</p> <a class="thanhtoan-a"
								href="<%=DuongDan.THANH_TOAN_SV + "?mave=" + veDi.getMaVe()%>">ĐÂY</a></div>
							<div class="row-thanhtoan"><p class="thanhtoan-p">Thanh toán trực tiếp tại đại lý: chọn vào &nbsp</p><a class="thanhtoan-a"
								href="/BanVeXe/jsp/chiduong.jsp">ĐÂY</a> <p class="thanhtoan-p">&nbsp để tìm đại lý gần nhất</p>
							</div>
							<div class="row-thanhtoan"> Thanh toán băng cách chuyển khoản ATM: Quí khách chuyển
								vào tài khoản Hoàng Nhược Quỳ, số tài khoản 123456789, BIDV chi
								nhánh Đông Sài Gòn.</div>
					</fieldset>
				</div>

			</div>
			<button onclick="print()" id="button_s">In vé</button>
		</fieldset>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>