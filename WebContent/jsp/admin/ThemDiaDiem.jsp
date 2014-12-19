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
<link href="/BanVeXe/css/datatable/ThemDiaDiem.css" rel="stylesheet"
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
	$(document).ready(
			function() {
				$("#myDataTable").dataTable({
					"sPaginationType" : "full_numbers",
					"bJQueryUI" : true
				});
				$("#myDataTable").dataTable().makeEditable({
					
					sUpdateURL :
<%="'" + DuongDan.SUA_DIADIEM_SV + "'"%>
	,
					sAddURL :
<%="'" + DuongDan.THEM_DIADIEM_SV + "'"%>
	,
					sDeleteURL :
<%="'" + DuongDan.XOA_DIADIEM_SV + "'"%>
	,
					"aoColumns" : [ 
					//Empty object is used for the default editable settings
					{
						
					}],
					sAddNewRowFormId : "formThemTuyen",
					sAddNewRowButtonId : "btThemTuyen",
					sAddNewRowOkButtonId : "btOk",
					sAddNewRowCancelButtonId : "btCancel",
					sDeleteHttpMethod : "POST",
					sDeleteRowButtonId : "btXoaTuyen",
		
	oAddNewRowButtonOptions : {
		icons : {
			primary : 'ui-icon-plus'
		}
	},
	fnOnDeleted : function(status) {
		if (status.indexOf("success") != -1) {
			swal({
				title : "Xóa địa điểm thành công!",
				timer : 2000,
				type : "success"
			});
		}else{
			swal({
				title : "Xóa địa điểm không thành công!",
				type : "warning"
			});
		}
	},
	fnOnAdded : function(status) {
		if (status.indexOf("success") != -1) {
			swal({
				title : "Thêm địa điểm thành công!",
				timer : 2000,
				type : "success"
			});
		}else{
			swal({
				title : "Thêm địa điểm không thành công!",
				type : "warning"
			});
		}
	},
	fnOnEditing : function(jInput,
			oEditableSettings, sOriginalText,
			id) {
		// 					  alert("Updating cell with value " + input.val() + ". Sending request to " + oEditableSettings.target);
		idTrEdit = jInput.parent().parent()
				.parent().attr("id");
		return true;
	},
	fnOnEdited : function(status) {
		if (status.indexOf("success") != 1) {
			$('tr#' + idTrEdit)
					.each(
							function() {
								var tenDiaDiem = $(
										this)
										.find(
												"#tenDD")
										.html();
							});
			$('tr#' + idTrEdit).addClass(
					"row_selected");
			swal({
				title : "Sửa địa điểm thành công!",
				timer : 2000,
				type : "success"
			});
		}else{
			swal({
				title : "Sửa địa điểm không thành công!",
				type : "warning"
			});
		}
	}
});
});
			
</script>
</head>
<body id="dt_example">
	<div>
		<fieldset>
			<legend>Thêm địa điểm</legend>
			<div id="container">
				<div id="demo_jui">
					<button id="btThemTuyen" value="Ok">Thêm địa điểm</button>
					<button id="btXoaTuyen" value="cancel">Xóa địa điểm</button>
					<table id="myDataTable" class="display dataTable">
						<%
							List<DiaDiem> listDiaDiem;
							if (request.getAttribute("listDiaDiem") != null)
								listDiaDiem = (List<DiaDiem>) request.getAttribute("listDiaDiem");
							else
								listDiaDiem = new ArrayList();
						%>

						<thead>
							<tr>
								<th>Tên địa điểm</th>
							</tr>
						</thead>
						<tbody>
							<%
								int k = 0;
								for (DiaDiem d : listDiaDiem) {
							%>
							<tr id="<%=k++%>">
								<td id="tenDD"><%=d.getTenDiaDiem()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<form id="formThemTuyen" action="#" title="Thêm chuyến xe">
					<input type="hidden" id="id" name="id" value="-1" /> <label
						for="name">Tên địa điểm:</label><br /> <input type="text"
						name="tendiadiem" id="tendiadiem" rel="0" />
					<button id="btOk">Add</button>
					<button id="btCancel">Cancel</button>
				</form>
			</div>
		</fieldset>
	</div>
</body>
</html>