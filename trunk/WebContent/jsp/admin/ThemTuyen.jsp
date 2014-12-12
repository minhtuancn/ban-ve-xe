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
<link href="/BanVeXe/css/datatable/ThemTuyen.css" rel="stylesheet"
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
	rel="stylesheet" type="text/css" media="screen"/>
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
	$(document).ready(
			function() {
				$("#myDataTable").dataTable({
					"sPaginationType" : "full_numbers",
					"bJQueryUI" : true
				});
				$("#myDataTable").dataTable().makeEditable({
					sUpdateURL :
<%="'" + DuongDan.SUA_TUYEN_SV + "'"%>
	,
					AddURL :
<%="'" + DuongDan.THEM_TUYEN_SV + "'"%>
	,
					sDeleteURL :
<%="'" + DuongDan.XOA_TUYEN_SV + "'"%>
	,
					"aoColumns" : [ {
					//Empty object is used for the default editable settings
					}, null,//null for read-only columns
					{
						indicator : 'Saving...',
						tooltip : 'Click to select town',
						loadtext : 'loading...',
						type : 'select',
						onblur : 'submit',
						data : "{'London':'London','Liverpool':'Liverpool'}"
					} ],
					sAddNewRowFormId : "formThemTuyen",
					sAddNewRowButtonId : "btThemTuyen",
					sAddNewRowOkButtonId : "btOk",
					sAddNewRowCancelButtonId : "btCancel",
					sDeleteHttpMethod : "POST",
					sDeleteRowButtonId : "btXoaTuyen",
				});
				
				//////////////
// 				$("#myDataTable").dataTable().makeEditable({
// 					sUpdateURL :
<%-- <%="'" + DuongDan.SUA_TUYEN_SV + "'"%> --%>
// 	,
// 					"aoColumns" : [ {
// 					//Empty object is used for the default editable settings
// 					}, null,//null for read-only columns
// 					{
// 						indicator : 'Saving...',
// 						tooltip : 'Click to select town',
// 						loadtext : 'loading...',
// 						type : 'select',
// 						onblur : 'submit',
// 						data : "{'London':'London','Liverpool':'Liverpool'}"
// 					} ]
// 				});

// 				$("#myDataTable").dataTable().makeEditable({
// 					sAddNewRowFormId : "formThemTuyen",
// 					sAddNewRowButtonId : "btThemTuyen",
// 					sAddNewRowOkButtonId : "btOk",
// 					sAddNewRowCancelButtonId : "btCancel",
// 					sAddURL :
<%-- <%="'" + DuongDan.THEM_TUYEN_SV + "'"%> --%>
// 	,
// 					sAddHttpMethod : "POST",
// 				});
// 				$('#myDataTable').dataTable().makeEditable({
// 					sDeleteURL :
<%-- <%="'" + DuongDan.XOA_TUYEN_SV + "'"%> --%>
// 	,
// 					sDeleteHttpMethod : "POST",
// 					sDeleteRowButtonId : "btXoaTuyen"
// 				});
// 				$('#myDataTable').dataTable().makeEditable(
// 						{
// 							fnOnDeleting : function(tr, id, fnDeleteRow) {
// 								jConfirm(
// 										'Please confirm that you want to delete row with id '
// 												+ id, 'Confirm Delete',
// 										function(confirmed) {
// 											if (confirmed) {
// 												fnDeleteRow(id);
// 											}
// 										});
// 								return false;
// 							}
// 						});
			});
</script>
</head>
<body id="dt_example">
	<div id="container">
		<div id="demo_jui">
			<button id="btThemTuyen" value="Ok">Thêm tuyến xe</button>
			<button id="btXoaTuyen" value="cancel">Xóa tuyến xe</button>
			<table id="myDataTable" class="display dataTable">
				<%
					List<Tuyen> listTuyen;
					if (request.getAttribute("listTuyen") != null)
						listTuyen = (List<Tuyen>) request.getAttribute("listTuyen");
					else
						listTuyen = new ArrayList();
				%>
				<%
					List<DiaDiem> listDiaDiem;
					if (request.getAttribute("listDiaDiem") != null)
						listDiaDiem = (List<DiaDiem>) request
								.getAttribute("listDiaDiem");
					else
						listDiaDiem = new ArrayList();
				%>
				<thead>
					<tr>
						<th>Điểm đi</th>
						<th>Điểm đến</th>
						<th>Tên tuyến</th>
					</tr>
				</thead>
				<tbody>
					<%
						int k = 0;
						for (Tuyen tuyen : listTuyen) {
					%>
					<tr id="<%=k++%>">
						<td><%=tuyen.getDiemDi()%></td>
						<td><%=tuyen.getDiemDen()%></td>
						<td><%=tuyen.getTuyenXe()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<form id="formThemTuyen" action="#" title="Thêm tuyến xe">
			<input type="hidden" id="id" name="id" value="-1" /> <label
				for="name">Điểm đi</label><br /> <select name="diemDi" id="diemDi"
				rel="0">
				<%
					for (DiaDiem d : listDiaDiem) {
				%>
				<option value="<%=d.getIdDiaDiem()%>">
					<%=d.getTenDiaDiem()%></option>
				<%
					}
				%>
			</select> <br /> <label for="name">Điểm đến</label> <select name="diemDen"
				id="diemDen" rel="1">
				<%
					for (DiaDiem d : listDiaDiem) {
				%>
				<option value="<%=d.getIdDiaDiem()%>">
					<%=d.getTenDiaDiem()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value="aaaaaaaaa" ref="2" /> <br />
			<button id="btOk">Add</button>
			<button id="btCancel">Cancel</button>
		</form>
		<!-- <input type="text" name="diemDi" id="diemDi" -->
		<!-- 				class="required" rel="1" />  -->
	</div>
</body>
</html>