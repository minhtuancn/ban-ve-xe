<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="DAO.ChuyenDAOImpl"%>
<%@page import="model.Chuyen"%>
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
<meta charset="UTF-8">
<title>Thêm Chuyến</title>
<link href="/BanVeXe/css/datatable/ThemChuyen.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- <link href="/BanVeXe/css/datatable/media/dataTables/demo_page.css" -->
<!-- 	rel="stylesheet" type="text/css" /> -->
<!-- <link href="/BanVeXe/css/datatable/media/dataTables/demo_table.css" -->
<!-- 	rel="stylesheet" type="text/css" /> -->
<link href="/BanVeXe/css/datatable/media/dataTables/demo_table_jui.css"
	rel="stylesheet" type="text/css" />
<link href="/BanVeXe/css/datatable/media/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href="/BanVeXe/css/datatable/media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" media="all" />
<!-- 	sweet alert -->
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<!-- ... -->
<script src="/BanVeXe/js/scripts/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<!--  -->
<script src="/BanVeXe/js/scripts/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.dataTables.editable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.jeditable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery.validate.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/scripts/jquery-ui.js" type="text/javascript"></script>
</script>
</head>
<body id="dt_example">
	<fieldset>
		<legend>Danh sách chuyến</legend>
		<div id="ngay">
			<%-- 			<span>Ngày: <%=dates%></span>&nbsp;&nbsp;<span>Tuyến:<%=tuyen.getTuyenXe()%></span> --%>
		</div>
		<div id="container">
			<div id="demo_jui">
				<button id="btThemChuyen" value="Ok">Thêm chuyến xe</button>
				<button id="btXoaChuyen" value="cancel">Xóa chuyến xe</button>
				<table id="myDataTable" class="display dataTable">
					<%
					Locale here = request.getLocale();
					NumberFormat cf = NumberFormat.getCurrencyInstance(here);
					cf.setMaximumFractionDigits(0);
					cf.setMinimumFractionDigits(0);
						List<Chuyen> listChuyen;
						if (session.getAttribute("listChuyen") != null)
							listChuyen = (List<Chuyen>) session.getAttribute("listChuyen");
						else
							listChuyen = new ArrayList();
					%>

					<thead>
						<tr>
							<th>Giờ khỏi hành</th>
							<th>Loại xe</th>
							<th>Bến xuất phát</th>
							<th>Giá</th>
							<th>Trạng thái khởi hành</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Chuyen chuyen : listChuyen) {
						%>
						<tr id="<%=chuyen.getIdChuyen()%>">
							<td><%=chuyen.getGioKhoiHanh()%></td>
							<td><%=chuyen.getLoaiXe()%></td>
							<td><%=chuyen.getBenXuatPhat()%></td>
							<td><%=cf.format(chuyen.getGia())%></td>
							<td><%=(!chuyen.isChuaKhoiHanh() ? "Chưa khởi hành"
						: "Đã khởi hành")%>
								<%
									if (!chuyen.isChuaKhoiHanh()) {
								%> <input type="button" value="cập nhật"
								onclick="capnhat(<%=chuyen.getIdChuyen()%>)" /></td>
							<%
								}
								}
							%>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</fieldset>
</body>
</html>