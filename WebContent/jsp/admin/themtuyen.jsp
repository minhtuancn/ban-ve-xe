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
						var table = $("#myDataTable").dataTable({
							"sPaginationType" : "full_numbers",
							"bJQueryUI" : true
						});
						table
								.makeEditable({
									sUpdateURL :
<%="'" + DuongDan.SUA_TUYEN_SV + "'"%>
	,
									sAddURL :
<%="'" + DuongDan.THEM_TUYEN_SV + "'"%>
	,
									sDeleteURL :
<%="'" + DuongDan.XOA_TUYEN_SV + "'"%>
	,
									"aoColumns" : [
											{
												ndicator : 'Saving...',
												tooltip : 'Click để chọn điểm đi',
												loadtext : 'loading...',
												type : 'select',
												onblur : 'cancel',
												submit : 'Ok',
												data :
<%=request.getAttribute("dataDiaDiem")%>
	// 						data : "{'London':'London','Liverpool':'Liverpool'}"
											},//null for read-only columns
											{
												indicator : 'Saving...',
												tooltip : 'Click để chọn điểm đến',
												loadtext : 'loading...',
												type : 'select',
												onblur : 'cancel',
												submit : 'Ok',
												// 						data : "{'London':'London','Liverpool':'Liverpool'}"
												data :
<%=request.getAttribute("dataDiaDiem")%>
	}, null ],
									sAddNewRowFormId : "formThemTuyen",
									sAddNewRowButtonId : "btThemTuyen",
									sAddNewRowOkButtonId : "btOk",
									sAddNewRowCancelButtonId : "btCancel",
									sDeleteHttpMethod : "POST",
									sDeleteRowButtonId : "btXoaTuyen",
									oAddNewRowButtonOptions : {
										// 				label : "Add...",
										icons : {
											primary : 'ui-icon-plus'
										}
									},
									fnOnDeleted : function(status) {
										if ("success" == status) {
											swal({
												title : "Xóa tuyến thành công!",
												timer : 2000,
												type : "success"
											});
										}else{
											swal({
												title : "Xóa tuyến không thành công!",
												type : "warning"
											});
										}
									},
									fnOnAdded : function(status) {
										if ("success" == status) {
											swal({
												title : "Thêm tuyến thành công!",
												timer : 2000,
												type : "success"
											});
										}else{
											swal({
												title : "Thêm tuyến không thành công!",
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
										if (status == "success") {
											$('tr#' + idTrEdit)
													.each(
															function() {
																var diemDi = $(
																		this)
																		.find(
																				"#diemDi")
																		.html();
																var diemDen = $(
																		this)
																		.find(
																				"#diemDen")
																		.html();
																$(this)
																		.find(
																				"#tuyen")
																		.html(
																				diemDi
																						+ " - "
																						+ diemDen);
															});
											$('tr#' + idTrEdit).addClass(
													"row_selected");
											swal({
												title : "Sữa tuyến thành công!",
												timer : 2000,
												type : "success"
											});
										}else{
// 											swal({
// 												title : "Sữa tuyến không thành công!",
// 												type : "warning"
// 											});
										}
									}
								});
					});

	function setTenTuyen() {
		$("#tenTuyen").val(
				$("#selectdiemDi option:selected").text() + " - "
						+ $("#selectdiemDen option:selected").text());
	}
	
	$(window).load(function() {
		setMenu();
		
	});
	function setMenu() {
		$("#" + $("#menuSelect").val()).addClass("select");
	}
</script>
</head>
<body id="dt_example">
<input type="hidden" value="themtuyen" id="menuSelect" />
<%@ include file="headeradmin.jsp" %>
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
					<tr id="<%=tuyen.getIdTuyen()%>">
						<td id="diemDi"><%=tuyen.getDiemDi()%></td>
						<td id="diemDen"><%=tuyen.getDiemDen()%></td>
						<td id="tuyen"><%=tuyen.getTuyenXe()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<form id="formThemTuyen" action="#" title="Thêm tuyến xe">
			<input type="hidden" id="id" name="id" value="-1" /> <label
				for="name">Điểm đi</label><br /> <select name="diemDi"
				id="selectdiemDi" rel="0" onchange="setTenTuyen()">
				<%
					for (DiaDiem d : listDiaDiem) {
				%>
				<option value="<%=d.getIdDiaDiem()%>">
					<%=d.getTenDiaDiem()%></option>
				<%
					}
				%>
			</select> <br /> <label for="name">Điểm đến</label> <select name="diemDen"
				id="selectdiemDen" rel="1" onchange="setTenTuyen()">
				<%
					for (DiaDiem d : listDiaDiem) {
				%>
				<option value="<%=d.getIdDiaDiem()%>">
					<%=d.getTenDiaDiem()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value="" rel="2" id="tenTuyen" /> <br />
			<button id="btOk">Thêm</button>
			<button id="btCancel">Hủy</button>
		</form>
	</div>
</body>
</html>