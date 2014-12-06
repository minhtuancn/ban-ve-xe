<%@page import="model.Chuyen"%>
<%@page import="model.Tuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/timve.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btnPrint").click(function() {
		var divContents = $("#tc-container").html();
		var css = '<link rel="stylesheet" type="text/css" href="/BanVeXe/css/timve.css">';
		var printWindow = window.open('', '', 'height=400,width=800');
		printWindow.document.write('<html><head><title>DIV Contents</title>');
		printWindow.document.write(css);
		printWindow.document.write('</head><body >');
		printWindow.document.write(divContents);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		printWindow.print();
	});
});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div>
		<input type="button" value="Print Div Contents" id="btnPrint" />
	</div>
	<div id="tc-container">
		<div id="timve">Tìm vé đi</div>
		<div>
			<%
				Tuyen tuyen = (Tuyen) session.getAttribute("tuyenDi");
			%>

			<table class="">
				<thead>
					<tr id="dong1">
						<td class="tr1" align="center">Chuyến xe</td>
						<td class="tr1" align="center">Giờ xuất phát</td>
						<td class="tr1" align="center">Giá vé</td>
						<td class="tr1" align="center">Loại ghế</td>
						<td class="tr1" align="center">Loại xe</td>
						<td class="tr1" align="center">Chỗ trống</td>
						<td class="tr1" align="center">chọn</td>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 0;
						for (Chuyen c : tuyen.getDanhSachChuyen()) {
					%>
					<tr id="dong2">
						<form action="TimGhe">
							<td class="tr1" align="center"><%=tuyen.getTuyenXe()%></td>
							<td class="tr1" align="center"><%=c.getGioKhoiHanh()%></td>
							<td class="tr1" align="center"><%=c.getGia()%></td>
							<td class="tr1" align="center"><%=c.getLoaiGhe()%></td>
							<td class="tr1" align="center"><%=c.getLoaiXe() + " chổ"%></td>
							<td class="tr1" align="center"><%=c.getSLGheChuaDat()%></td>
							<td class="tr1" align="center"><input type="hidden"
								value="<%=i++%>" name="id" /><input type="hidden"
								value="<%=1%>" name="chuyen" /> <input type="submit"
								value="chọn" class="chon" /></td>
						</form>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>


		<!-- tim vé về -->
		<%
			boolean laKhuHoi = (Boolean) session.getAttribute("laKhuHoi");
			if (laKhuHoi) {
		%>

		<div id="timve">Tìm vé về</div>
		<div>
			<%
				tuyen = (Tuyen) session.getAttribute("tuyenVe");
			%>

			<table class="">
				<thead>
					<tr id="dong1">
						<td class="tr1" align="center">Chuyến xe</td>
						<td class="tr1" align="center">Giờ xuất phát</td>
						<td class="tr1" align="center">Giá vé</td>
						<td class="tr1" align="center">Loại ghế</td>
						<td class="tr1" align="center">Loại xe</td>
						<td class="tr1" align="center">Chỗ trống</td>
						<td class="tr1" align="center">chọn</td>
					</tr>
				</thead>
				<tbody>
					<%
						i = 0;
							for (Chuyen c : tuyen.getDanhSachChuyen()) {
					%>
					<tr id="dong2">
						<form action="TimGhe">
							<td class="tr1" align="center"><%=tuyen.getTuyenXe()%></td>
							<td class="tr1" align="center"><%=c.getGioKhoiHanh()%></td>
							<td class="tr1" align="center"><%=c.getGia()%></td>
							<td class="tr1" align="center"><%=c.getLoaiGhe()%></td>
							<td class="tr1" align="center"><%=c.getLoaiXe() + " chổ"%></td>
							<td class="tr1" align="center"><%=c.getSLGheChuaDat()%></td>
							<td class="tr1" align="center"><input type="hidden"
								value="<%=i++%>" name="id" /> <input type="hidden"
								value="<%=2%>" name="chuyen" /> <input type="submit"
								value="chọn" class="chon" /></td>
						</form>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<%
			}
		%>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>