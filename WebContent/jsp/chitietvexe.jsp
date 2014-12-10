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
<script type="text/javascript">
	$(document).ready(function() {
		$("#xacnhan").click(function() {
			var idChuyen = $('#idChuyen').val();
			$.get('KiemTraSLGhe', {
				idChuyen : idChuyen,
			}, function(responseText) {
				if(responseText.indexOf("true") != -1){
					window.location = '/BanVeXe/jsp/thanhtoan.jsp';
				}else{
					alert("Bạn chưa chọn bất kỳ ghế nào!");
				}
			});
		});
	});
</script>
</head>
<body>
	<%
		int idChuyen = Integer.parseInt(request.getParameter("chuyen"));
		DatVe datVe = null;
		if (idChuyen == 1)
			datVe = (DatVe) session.getAttribute("datVeDi");
		else
			datVe = (DatVe) session.getAttribute("datVeVe");
	%>
	<div id="chitietve" class="bg">
		<h1 align="center">Chi tiết đặt chỗ</h1>
		<table>
			<tr>
				<td id="td1">Công ty:</td>
				<td id="td2">Đồng Phước</td>
			</tr>
			<tr>
				<td id="td1">Tuyến xe:</td>
				<td id="td2"><%=datVe.getTuyenXe()%></td>
			</tr>
			<tr>
				<td id="td1">Ngày đi:</td>
				<td id="td2"><%=new SimpleDateFormat("dd/MM/yyyy  HH:mm").format(datVe
					.getNgayKhoiHanh())%></td>
			</tr>
			<tr>
				<td id="td1">Giờ khởi hành:</td>
				<td id="td2"><%=datVe.getGioKhoiHanh()%></td>
			</tr>
			<tr>
				<td id="td1">Nơi khởi hành:</td>
				<td id="td2"><%=datVe.getBenXuatPhat()%></td>
			</tr>
			<tr>
				<td id="td1">Giá vé:</td>
				<td id="td2"><%=datVe.getGia()%></td>
			</tr>
			<tr>
				<td id="td1" width="150px">Số lượng:</td>
				<td id="td2"><%=datVe.getSoLuongGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Mã ghế:</td>
				<td id="td2"><%=datVe.getTenGhe()%></td>
			</tr>
			<tr>
				<td id="td1">Thành tiền:</td>
				<td id="td2"><%=datVe.getTongTien()%></td>
			</tr>
		</table>
		<hr />

		<input type="image" id="xacnhan" src="/BanVeXe/image/xacnhan.png"
			width="80px"
			style="margin-left: 100px; margin-top: 5px; float: left; clear: right;">
		<a href="/BanVeXe/jsp/datve.jsp"><input type="image"
			src="/BanVeXe/image/huyve.png" width="80px"
			style="margin-left: 10px; margin-top: 5px;"></a>
	</div>
</body>
</html>