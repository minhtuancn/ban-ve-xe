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
	$(document)
			.ready(
					function() {
						$("#myDataTable").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true
						});
						$("#myDataTable")
								.dataTable()
								.makeEditable(
										{

											sUpdateURL :
<%="'" + DuongDan.SUA_CHUYEN_SV + "'"%>
	,
											sAddURL :
<%="'" + DuongDan.THEM_CHUYEN_SV + "'"%>
	,
											sDeleteURL :
<%="'" + DuongDan.XOA_CHUYEN_SV + "'"%>
	,
											"aoColumns" : [
													//Empty object is used for the default editable settings

													{},
													{
														indicator : 'Saving...',
														tooltip : 'Click to select town',
														loadtext : 'loading...',
														type : 'select',
														onblur : 'submit',
														data : "{'45':'45','16':'16'}"
													},
													{
														indicator : 'Saving...',
														tooltip : 'Click to select town',
														loadtext : 'loading...',
														type : 'select',
														onblur : 'submit',
														data : "{'London':'London','Liverpool':'Liverpool'}"
													},

													{
														indicator : 'Saving...',
														tooltip : 'Click to select town',
														loadtext : 'loading...',
														type : 'select',
														onblur : 'submit',
														data : "{'London':'London','Liverpool':'Liverpool'}"
													}, null ],
											sAddNewRowFormId : "formThemChuyen",
											sAddNewRowButtonId : "btThemChuyen",
											sAddNewRowOkButtonId : "btOk",
											sAddNewRowCancelButtonId : "btCancel",
											sDeleteHttpMethod : "POST",
											sDeleteRowButtonId : "btXoaChuyen",
// 											fnOnDeleted : function(status) {
// 												if (status.indexOf("success") != -1) {
// 													swal({
// 														title : "Xóa tuyến thành công!",
// 														timer : 2000,
// 														type : "success"
// 													});
// 												}
// 											},
// 											fnOnAdded : function(status) {
// 												if (status.indexOf("success") != -1) {
// 													swal({
// 														title : "Thêm tuyến thành công!",
// 														timer : 2000,
// 														type : "success"
// 													});
// 												}
// 											},
// 											fnOnEditing : function(jInput,
// 													oEditableSettings,
// 													sOriginalText, id) {

// 												return true;
// 											},
// 											fnOnEdited : function(status) {
// 												if (status.indexOf("success") != 1) {

// 												}
// 											}
										});
					});
</script>
</head>
<body id="dt_example">
	<fieldset>
		<legend>Danh sách chuyến</legend>
		<%
			String date = "";
			Tuyen tuyen = null;
			if (request.getAttribute("date") != null
					&& session.getAttribute("tuyen") != null) {
				date = (String) request.getAttribute("date");
				tuyen = (Tuyen) session.getAttribute("tuyen");
		%>
		<div id="ngay">
			<span >Ngày: <%=date%></span>&nbsp;&nbsp;<span>Tuyến:<%=tuyen.getTuyenXe()%></span>
		</div>
		<%
			}
		%>
		<div id="container">
			<div id="demo_jui">
				<button id="btThemTuyen" value="Ok">Thêm chuyến xe</button>
				<button id="btXoaTuyen" value="cancel">Xóa chuyến xe</button>
				<table id="myDataTable" class="display dataTable">
					<%
						List<Chuyen> listChuyen;
						if (request.getAttribute("listChuyen") != null)
							listChuyen = (List<Chuyen>) request.getAttribute("listChuyen");
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
							int k = 0;
							for (Chuyen chuyen : listChuyen) {
						%>
						<tr id="<%=k++%>">
							<td><%=chuyen.getGioKhoiHanh()%></td>
							<td><%=chuyen.getLoaiXe()%></td>
							<td><%=chuyen.getBenXuatPhat()%></td>
							<td><%=chuyen.getGia()%></td>
							<td><%=chuyen.isChuaKhoiHanh()%> <%
 	if (!chuyen.isChuaKhoiHanh())
 %> <input type="button" value="cập nhật" /></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<form id="formThemChuyen" action="#" title="Thêm chuyến xe">
				<input type="hidden" id="id" name="id" value="1" /> <label
					for="name">Giờ khởi hành:</label><br /> <input type="text"
					name="giokhoihanh" id="giokhoihanh" rel="1" /> <label for="name">Xe</label><br />
				<select name="xe" id="xe" rel="2">
					<option value="xe45">xe 45</option>
					<option value="xe16">xe 16</option>
				</select> <br /> <label for="name">Giá:</label><br /> <input type="number"
					name="gia" id="gia" rel="3" /> <input type="hidden"
					value="aaaaaaaaa" rel="4" /> <br /> <input type="hidden"
					value="aaaaaaaaaaa" rel="0" /> <br />
				<button id="btOk">Add</button>
				<button id="btCancel">Cancel</button>
			</form>
		</div>
	</fieldset>
</body>
</html>