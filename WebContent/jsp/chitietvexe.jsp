<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.DatVe"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Chuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/chitietve.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/util.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#xacnhan").click(function() {
			$.get('/BanVeXe/kiemtrasoluongghe', {}, function(responseText) {
				if (responseText.indexOf("0") != -1) {
					window.location = '/BanVeXe/jsp/thanhtoan.jsp';
				} else {
					if (responseText.indexOf("1") != -1) {
						alert("Bạn chưa chọn vé cho chuyến đi!");
						setDefaut("chuyenve");
						scroll("#timvedi", 800);
					} else {
						alert("Bạn chưa chọn vé cho chuyến về!");
						setDefaut("chuyendi");
						scroll("#timveve", 800);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<%
		// 		int idChuyen = Integer.parseInt(request.getParameter("chuyen"));
		DatVe datVeDi = (DatVe) session.getAttribute("datVeDi");
		DatVe datVeVe = null;
		boolean laKhuHoi = (Boolean) session.getAttribute("laKhuHoi");
		if (laKhuHoi)
			datVeVe = (DatVe) session.getAttribute("datVeVe");
	%>
	<%
		Locale here = request.getLocale();
		NumberFormat cf = NumberFormat.getCurrencyInstance(here);
		cf.setMaximumFractionDigits(0);
		cf.setMinimumFractionDigits(0);
	%>
	<div id="chitietve" class="bg">
		<h1 align="center">Chi tiết đặt chỗ</h1>
		<hr />
		<table>
			<!-- 			<tr> -->
			<!-- 				<td id="td1">Công ty:</td> -->
			<!-- 				<td id="td2">Đồng Phước</td> -->
			<!-- 			</tr> -->
			<tr>
				<td colspan="2"><h1>Tuyến đi</h1></td>
			</tr>
			<tr>
				<td id="td1">Tuyến xe:</td>
				<td id="td2"><%=datVeDi.getTuyenXe()%></td>
			</tr>
			<tr>
				<td id="td1">Ngày đi:</td>
				<td id="td2"><%=new SimpleDateFormat("dd/MM/yyyy").format(datVeDi
					.getNgayKhoiHanh())%></td>
			</tr>
			<tr>
				<td id="td1">Giờ khởi hành:</td>
				<td id="td2"><%=datVeDi.getGioKhoiHanh()%></td>
			</tr>
			<tr>
				<td id="td1">Nơi khởi hành:</td>
				<td id="td2"><%=datVeDi.getBenXuatPhat()%></td>
			</tr>
			<tr>
				<td id="td1">Giá vé:</td>
				<td id="td2"><%=cf.format(datVeDi.getGia())%></td>
			</tr>
			<tr>
				<td id="td1" width="150px">Số lượng:</td>
				<td id="td2"><%=datVeDi.getSoLuongGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Mã ghế:</td>
				<td id="td2"><%=datVeDi.getTenGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Thành tiền:</td>
				<td id="td2"><%=cf.format( datVeDi.getTongTien())%></td>
			</tr>
		</table>
		<hr />
		<%
			if (laKhuHoi && datVeVe != null) {
		%>
		<table>
			<tr>
				<td colspan="2"><h1>Tuyến về</h1></td>
			</tr>
			<tr>
				<td id="td1">Tuyến xe:</td>
				<td id="td2"><%=datVeVe.getTuyenXe()%></td>
			</tr>
			<tr>
				<td id="td1">Ngày đi:</td>
				<td id="td2"><%=new SimpleDateFormat("dd/MM/yyyy  HH:mm")
						.format(datVeVe.getNgayKhoiHanh())%></td>
			</tr>
			<tr>
				<td id="td1">Giờ khởi hành:</td>
				<td id="td2"><%=datVeVe.getGioKhoiHanh()%></td>
			</tr>
			<tr>
				<td id="td1">Nơi khởi hành:</td>
				<td id="td2"><%=datVeVe.getBenXuatPhat()%></td>
			</tr>
			<tr>
				<td id="td1">Giá vé:</td>
				<td id="td2"><%=cf.format( datVeVe.getGia())%></td>
			</tr>
			<tr>
				<td id="td1">Số lượng:</td>
				<td id="td2"><%=datVeVe.getSoLuongGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Mã ghế:</td>
				<td id="td2"><%=datVeVe.getTenGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Thành tiền:</td>
				<td id="td2"><%=cf.format( datVeVe.getTongTien())%></td>
			</tr>

		</table>
		<hr />
		<table>
			<tr>
				<td id="td1">Tổng tiền:</td>
				<td id="td2"><%=datVeVe.getTongTien() + datVeDi.getTongTien()%></td>
			</tr>
		</table>
		<%
			}
		%>
		<input type="image" id="xacnhan" src="/BanVeXe/image/xacnhan.png"
			width="80px"
			style="margin-left: 100px; margin-top: 5px; float: left; clear: right;">
		<a href="/BanVeXe/jsp/datve.jsp"><input type="image"
			src="/BanVeXe/image/huyve.png" width="80px"
			style="margin-left: 10px; margin-top: 5px;"></a>
	</div>
</body>
</html>