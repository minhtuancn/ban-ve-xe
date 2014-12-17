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
					
					 
					{
// 						indicator : 'Saving...',
// 						tooltip : 'Click to select town',
// 						loadtext : 'loading...',
// 						type : 'select',
// 						onblur : 'submit',
// 						data : "{'London':'London','Liverpool':'Liverpool'}"
					},
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
					}, null],
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
	<%
							List<Tuyen> listTuyen;
							if (session.getAttribute("listTuyen") != null){
								listTuyen = (List<Tuyen>) session.getAttribute("listTuyen");
								session.setAttribute("listTuyen", listTuyen);
							}
							else
								listTuyen = new ArrayList();
						%>
	<div>
		<fieldset>
			<legend>Thông tin chuyến</legend>
			<div >
			<form action="ListChuyen" id="form">
			
				<label for="name">Tuyến Xe</label><br /> 
						<select name="tuyen" id="tuyen"
						>
						<%
							for (Tuyen d : listTuyen) {
						%>
						<option value="<%=d.getTuyenXe()%>">
							<%=d.getTuyenXe()%></option>
						<%
							}
						%>
					</select> <br /> 
					
					<label for="name">Date</label><br /> 
						<input type="date" id="date" name="date" />
						 <br /> 
						 
						
						<input type="submit" id="submit" name="submit" />
						 <br /> 
			</form>
			</div>
			</fieldset>
			
		<fieldset>
			<legend>Thêm chuyến</legend>
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
								<td><%=chuyen.isChuaKhoiHanh()%>
								<% if(!chuyen.isChuaKhoiHanh()) 
								%>
								<input type="button" value="cập nhật"/>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<form id="formThemTuyen" action="#" title="Thêm chuyến xe">
					<input type="hidden" id="id" name="id" value="1" />
					<label for="name">Giờ khởi hành:</label><br/> <input type="text" name="giokhoihanh" id="giokhoihanh" rel="1" />
					 <label
						for="name">Xe</label><br /> <select name="xe" id="xe"
						rel="2">
						<option value="xe45">xe 45</option>
						<option value="xe16">xe 16</option>
					</select> <br /> 
					<label for="name">Giá:</label><br/> <input type="number" name="gia" id="gia" rel="3" />
					<input type="hidden" value="aaaaaaaaa" rel="4" /> <br />
					<input type="hidden" value="aaaaaaaaaaa" rel="0" /> <br />
					<button id="btOk">Add</button>
					<button id="btCancel">Cancel</button>
				</form>
			</div>
		</fieldset>
	</div>
</body>
</html>