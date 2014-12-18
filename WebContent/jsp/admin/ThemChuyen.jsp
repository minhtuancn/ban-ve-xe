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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/BanVeXe/css/datatable/ThemChuyen.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/BanVeXe/media/dataTables/demo_page.css" rel="stylesheet"
	type="text/css" />
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
<script type="text/javascript">

</script>
</head>
<body id="dt_example">
	<fieldset>
		<legend>Danh sách chuyến</legend>
		<%
			String dates = "";
		if(request.getParameter("date")!= null)
			dates = request.getParameter("date")	;
			Tuyen tuyen = null;
			if (request.getAttribute("tuyen") != null) {
				tuyen = (Tuyen) request.getAttribute("tuyen");
		%>
		<div id="ngay">
			<span >Ngày: <%=dates%></span>&nbsp;&nbsp;<span>Tuyến:<%=tuyen.getTuyenXe()%></span>
		</div>
		<%
			}
		%>
		<div id="container">
			<div id="demo_jui">
				<button id="btThemChuyen" value="Ok">Thêm chuyến xe</button>
				<button id="btXoaChuyen" value="cancel">Xóa chuyến xe</button>
				<table class="myDataTable" class="display dataTable">
					<%
						List<Chuyen> listChuyen;
// 						if (request.getAttribute("listChuyen") != null)
// 							listChuyen = (List<Chuyen>) request.getAttribute("listChuyen");
// 						else
// 							listChuyen = new ArrayList();
						listChuyen = new ChuyenDAOImpl().getAllChuyen(tuyen);
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
<%-- 						<% --%>
<!-- // 							int k = 0; -->
<!-- // 							for (Chuyen chuyen : listChuyen) { -->
<%-- 						%> --%>
<%-- 						<tr id="<%=k++%>"> --%>
<%-- 							<td><%=chuyen.getGioKhoiHanh()%></td> --%>
<%-- 							<td><%=chuyen.getLoaiXe()%></td> --%>
<%-- 							<td><%=chuyen.getBenXuatPhat()%></td> --%>
<%-- 							<td><%=chuyen.getGia()%></td> --%>
<%-- 							<td><%=chuyen.isChuaKhoiHanh()%> <% --%>
<!-- //  	if (!chuyen.isChuaKhoiHanh()) -->
<%--  %> <input type="button" value="cập nhật" /></td> --%>
<!-- 						</tr> -->
<%-- 						<% --%>
<!-- // 							} -->
<%-- 						%> --%>
					</tbody>
				</table>
			</div>
			
		</div>
	</fieldset>
</body>
</html>