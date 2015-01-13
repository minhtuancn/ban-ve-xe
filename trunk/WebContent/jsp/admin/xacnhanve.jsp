<%@page import="model.Ve"%>
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
<title>Xác nhận thanh toán vé</title>
<!-- <link href="/BanVeXe/css/datatable/ThemTuyen.css" rel="stylesheet" -->
<!-- 	type="text/css" media="all" /> -->
<!-- <link href="/BanVeXe/css/datatable/media/dataTables/demo_table.css" -->
<!-- 	rel="stylesheet" type="text/css" /> -->
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
						var table = $("#KhachHangTable").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true
						});
						
					});

</script>
</head>
<body id="dt_example">
<%@ include file="headeradmin.jsp" %>
	<div id="container">
		<div id="demo_jui">
			<table id="KhachHangTable" class="display dataTable">
				<%
					List<Ve> listVe;
					if (request.getAttribute("listVe") != null)
						listVe = (List<Ve>) request.getAttribute("listVe");
					else
						listVe = new ArrayList();
				%>
				<thead>
					<tr>
						<th>Mã vé</th>
						<th>Chuyến</th>
						<th>Ngày đặt vé</th>
						<th>Danh sách ghế</th>
						<th>Trạng thái thanh toán</th>
						<th>Xác nhận thanh toán</th>
					</tr>
				</thead>
				<tbody>
					<%
						int h = 0;
						for (Ve kh : listVe) {
					%>
					<tr id="<%=h++%>">
						<td><%=kh.getMaVe()%></td>
						<td><%=kh.getTuyenXe()%></td>
						<td><%=kh.getNgayDatVe()%></td>
						<td><%=kh.getTenGhe()%></td>
						<td><%=(!kh.isTrangThaiThanhToan() ? "Chưa thanh toán"
						: "Đã thanh toán")%>
								<%
									if (!kh.isTrangThaiThanhToan()) {
								%></td>
						<td><input type="button" value="xác nhận"
								onclick="xacnhan()" /></td>
					<%
						}
					%>
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