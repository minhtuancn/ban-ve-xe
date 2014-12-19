<%@page import="model.ThongTinVe"%>
<%@page import="model.KhachHang"%>
<%@page import="util.DuongDan"%>
<%@page import="model.DiaDiem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Tuyen"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/BanVeXe/css/datatable/ThemVe.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/BanVeXe/css/datatable/media/dataTables/demo_table.css"
	rel="stylesheet" type="text/css" />
<link href="/BanVeXe/css/datatable/media/dataTables/demo_table_jui.css"
	rel="stylesheet" type="text/css" />
<link href="/BanVeXe/css/datatable/media/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="/BanVeXe/css/datatable/media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/BanVeXe/js/jquery.alerts-1.1/jquery.alerts.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- 	sweet alert -->
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<!-- ... -->
<script type="text/javascript"
	src="http://www.google-analytics.com/ga.js"></script>
<script src="/BanVeXe/js/jquery.alerts-1.1/jquery.alerts.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<!-- <script src="/BanVeXe/js/jquery-1.11.1.min.js" type="text/javascript"></script> -->
<script src="/BanVeXe/js/scripts/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.dataTables.editable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.jeditable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.validate.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						// edit var
						var idTrEdit;
						//
						var table = $("#VeTable").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true
						});
						
					});

</script>
</head>
<body id="dt_example">
	<div id="container">
		<div id="demo_jui">
			<table id="VeTable" class="display dataTable">
				<%
					List<ThongTinVe> listVe;
					if (request.getAttribute("listVe") != null)
						listVe = (List<ThongTinVe>) request.getAttribute("listVe");
					else
						listVe = new ArrayList();
				%>
				<thead>
					<tr>
						<th>Mã vé</th>
						<th>Chuyến</th>
						<th>Ghi chú</th>
						<th>Ngày đặt vé</th>
						<th>Danh sách ghế</th>
						<th>Trạng thái khởi hành</th>
						<th>Trạng thái thanh toán</th>
						<th>Thời hạn thanh toán</th>
					</tr>
				</thead>
				<tbody>
					<%
						int k = 0;
						for (ThongTinVe ve : listVe) {
					%>
					<tr id="<%=k++%>">
						<td><%=ve.getMaVe()%></td>
						<td><%=ve.getChuyen()%></td>
						<td><%=ve.getGhiChu()%></td>
						<td><%=ve.getNgayDatVe()%></td>
						<td><%=ve.getDanhSachGhe()%></td>
						<td><%=ve.isDaKhoiHanh()%> <% if(!ve.isDaKhoiHanh()) {
								%> <input type="button" value="cập nhật" /> <%} %></td>

						<td><%=ve.isTrangThaiThanhToan()%> <% if(!ve.isTrangThaiThanhToan()) {
								%> <input type="button" value="cập nhật" /> <%} %></td>

						<td><%=ve.getThoiHanThanhToan()%></td>
					</tr>
					<%
								}
							%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>