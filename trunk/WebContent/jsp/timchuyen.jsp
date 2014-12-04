<%@page import="model.Chuyen"%>
<%@page import="model.Tuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/timve.css">

</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="width: 100%; height: 600px;">
		<div
			style="width: 100%; height: 40px; background: #145CA1; font-size: 30px; color: white; margin-top: 10px;">Tìm
			vé</div>
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
				<!-- 					<tr id="dong2"> -->
				<!-- 						<td class="tr1" align="center">HCM - Nha Trang</td> -->
				<!-- 						<td class="tr1" align="center">7:00 am</td> -->
				<!-- 						<td class="tr1" align="center">220,000đ</td> -->
				<!-- 						<td class="tr1" align="center">Giường nằm</td> -->
				<!-- 						<td class="tr1" align="center">45 chỗ</td> -->
				<!-- 						<td class="tr1" align="center">20</td> -->
				<!-- 						<td class="tr1" align="center"><input type="submit" -->
				<!-- 							value="chọn" class="chon" /></td> -->
				<!-- 					</tr> -->
				<!-- 					<tr id="dong2"> -->
				<!-- 						<td class="tr1" align="center">HCM - Nha Trang</td> -->
				<!-- 						<td class="tr1" align="center">5:00 pm</td> -->
				<!-- 						<td class="tr1" align="center">120,000đ</td> -->
				<!-- 						<td class="tr1" align="center">Giường nằm</td> -->
				<!-- 						<td class="tr1" align="center">45 chỗ</td> -->
				<!-- 						<td class="tr1" align="center">30</td> -->
				<!-- 						<td class="tr1" align="center"><input type="submit" -->
				<!-- 							value="chọn" class="chon" /></td> -->
				<!-- 					</tr> -->
				<tbody>
					<%
						int i = 0;
						for (Chuyen c : tuyen.getDanhSachChuyen()) {
					%>
					<tr id="dong2">
					<form action="../TimGhe">
						<td class="tr1" align="center"><%=tuyen.getTuyenXe()%></td>
						<td class="tr1" align="center"><%=c.getGioKhoiHanh()%></td>
						<td class="tr1" align="center"><%=c.getGia()%></td>
						<td class="tr1" align="center"><%=c.getLoaiGhe()%></td>
						<td class="tr1" align="center"><%=c.getLoaiXe() + " chổ"%></td>
						<td class="tr1" align="center"><%=c.getSLGheChuaDat()%></td>
						<td class="tr1" align="center"><input type="hidden"
							value="<%=i++%>" name="id" /> <input type="submit" value="chọn"
							class="chon" /></td>
					</form>
					</tr>

					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>