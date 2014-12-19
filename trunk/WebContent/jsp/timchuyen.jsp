<%@page import="util.DuongDan"%>
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
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/util.js"></script>
<script type="text/javascript">
	function chonXe(scrollid,time, chuyenDiOrVe, chuyen, id) {
// 		setDefaut(chuyenDiOrVe);
		setDefaut('chuyendi');
		setDefaut('chuyenve');
		$("#"+chuyen+"-"+id).load("/BanVeXe/TimGhe?chuyen="+chuyen+"&id="+id, function() {
		});
			$("#"+chuyen+"-"+id).slideDown();
			scroll(scrollid,time);
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div></div>
	<div id="tc-container">
		<div id="timvedi" class="title bg">
			<marquee behavior="alternate" width="10%">>></marquee>
			Tìm vé đi
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div>
			<%
				Tuyen tuyen = (Tuyen) session.getAttribute("tuyenDi");
			%>

			<table class="">
				<thead>
					<tr class="dong1 bg">
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
					<tr id="scroll1<%=i%>" class="dong2">
						<td class="tr1" align="center"><%=tuyen.getTuyenXe()%></td>
						<td class="tr1" align="center"><%=c.getGioKhoiHanh()%></td>
						<td class="tr1" align="center"><%=c.getGia()%></td>
						<td class="tr1" align="center"><%=c.getLoaiGhe()%></td>
						<td class="tr1" align="center"><%=c.getLoaiXe() + " chổ"%></td>
						<td class="tr1" align="center"><%=c.getSLGheChuaDat()%></td>
						<td class="tr1" align="center"><input type="button"
							value="chọn" class="chon"
							onclick="chonXe('#scroll1<%=i%>',800,'chuyendi',1,<%=i%>)" /></td>
					</tr>
					<tr>
						<td colspan="7"><div id="1-<%=i++%>" class="chuyendi"
								style="margin-left: 200px;"></div></td>
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

		<div id="timveve" class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Tìm vé về
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div>
			<%
				tuyen = (Tuyen) session.getAttribute("tuyenVe");
			%>

			<table class="">
				<thead>
					<tr class="dong1 bg">
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
					<tr id="scroll2<%=i%>" class="dong2">
						<td class="tr1" align="center"><%=tuyen.getTuyenXe()%></td>
						<td class="tr1" align="center"><%=c.getGioKhoiHanh()%></td>
						<td class="tr1" align="center"><%=c.getGia()%></td>
						<td class="tr1" align="center"><%=c.getLoaiGhe()%></td>
						<td class="tr1" align="center"><%=c.getLoaiXe() + " chổ"%></td>
						<td class="tr1" align="center"><%=c.getSLGheChuaDat()%></td>
						<td class="tr1" align="center"><input type="button"
							value="chọn" class="chon"
							onclick="chonXe('#scroll2<%=i%>',1000,'chuyenve', 2,<%=i%>)" />
						</td>
					</tr>
					<tr>
						<td colspan="7"><div id="2-<%=i++%>" class="chuyenve"
								style="margin-left: 200px;"></div></td>
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