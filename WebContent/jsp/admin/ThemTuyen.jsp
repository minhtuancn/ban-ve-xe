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
<link href="media/dataTables/demo_page.css" rel="stylesheet"
	type="text/css" />
<link href="media/dataTables/demo_table.css" rel="stylesheet"
	type="text/css" />
<link href="media/dataTables/demo_table_jui.css" rel="stylesheet"
	type="text/css" />
<link href="media/themes/base/jquery-ui.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/BanVeXe/css/datatable/ThemTuyen.css" rel="stylesheet"
	type="text/css" media="all" />
<script src="/BanVeXe/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="/BanVeXe/js/datatable/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/datatable/jquery.dataTables.editable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/datatable/jquery.jeditable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/datatable/jquery.validate.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/datatable/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myDataTable").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true
		}).

		makeEditable({
			"sUpdateURL" : "/Company/UpdateCompanyData",
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
			} ]
		});

		$("#myDataTable").dataTable().makeEditable({
			sAddNewRowFormId : "formThemTuyen",
			sAddNewRowButtonId : "btThemtuyen",
			sAddNewRowOkButtonId : "btOk",
			sAddNewRowCancelButtonId : "btCancel",
			sAddURL :
<%="'" + DuongDan.THEM_TUYEN_SV + "'"%>
	,
			sAddHttpMethod : "POST",
		});
	});
</script>
</head>
<body>
	<div id="container">
		<button id="btThemtuyen" value="Ok">Thêm tuyến xe</button>
		<button id="btXoaTuyen" value="cancel">Xóa tuyến xe</button>
		<table id="myDataTable">
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
					int k = 100;
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
			</select> <br />
			<button id="btOk">Add</button>
			<button id="btCancel">Cancel</button>
		</form>
		<!-- <input type="text" name="diemDi" id="diemDi" -->
		<!-- 				class="required" rel="1" />  -->
	</div>
</body>
</html>