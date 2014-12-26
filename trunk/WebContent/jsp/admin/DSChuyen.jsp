<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/datatable/DSChuyen.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<script src="/BanVeXe/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
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
			               null, null, null, null, null
			 ],
			sAddNewRowFormId : "formThemChuyen",
			sAddNewRowButtonId : "btThemChuyen",
			sAddNewRowOkButtonId : "btOk",
			sAddNewRowCancelButtonId : "btCancel",
			sDeleteHttpMethod : "POST",
			sDeleteRowButtonId : "btXoaChuyen",
		//									fnOnDeleted : function(status) {
		//										if (status.indexOf("success") != -1) {
		//											swal({
		//												title : "Xóa tuyến thành công!",
		//												timer : 2000,
		//												type : "success"
		//											});
		//										}
		//									},
		//									fnOnAdded : function(status) {
		//										if (status.indexOf("success") != -1) {
		//											swal({
		//												title : "Thêm tuyến thành công!",
		//												timer : 2000,
		//												type : "success"
		//											});
		//										}
		//									},
		//									fnOnEditing : function(jInput,
		//											oEditableSettings,
		//											sOriginalText, id) {

		//										return true;
		//									},
		//									fnOnEdited : function(status) {
		//										if (status.indexOf("success") != 1) {

		//										}
		//									}
		});
	});

// 	function timchuyen() {
// 		if ($('#date').val().length == 0) {
// 			swal({
// 				title : "Bạn chưa nhập ngày!",
// 				type : "warning"
// 			});
// 		} else {
// 			var tuyen = $('#tuyen option:selected').val();
// 			while (tuyen.indexOf(" ") != -1) {
// 				tuyen = tuyen.replace(" ", "+");
// 			}
// 			// 			$("#themchuyen").load("/BanVeXe/ListChuyen", {tuyen: tuyen,date : + $('#date').val()+""}, function() {
// 			$("#themchuyen").html("AAAAA");
// 			// 				$("#themchuyen").html("aaaaaaaaaaaaaaa");
// 			$("#themchuyen").load(
// 					"/BanVeXe/ListChuyen?tuyen=" + tuyen + "&date="
// 							+ $('#date').val().replace(" ", "+"), function() {
// 					});
// 		}
// 	};
</script>
</head>
<body>
	<%
		List<Tuyen> listTuyen;
		if (session.getAttribute("listTuyen") != null) {
			listTuyen = (List<Tuyen>) session.getAttribute("listTuyen");
		} else
			listTuyen = new ArrayList<Tuyen>();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String date = "";
		Date selectDate;
		long idSelected = 2;
		if(request.getParameter("tuyen") != null)
			idSelected = Long.parseLong(request.getParameter("tuyen"));
		if (request.getParameter("date") != null)
			date = request.getParameter("date");
		if (date.equals("")) {
			selectDate = new Date();
		} else {
			selectDate = f2.parse(date);
		}
	%>
	<div id="containers">
		<div id="tt-chuyen">
			<fieldset>
				<legend>Thông tin chuyến</legend>
				<div>
					<form action="ListChuyen" id="form">

						<label for="name">Tuyến Xe</label><br /> <select name="tuyen"
							id="tuyen">
							<%
								for (Tuyen t : listTuyen) {
							%>
							<option value="<%=t.getIdTuyen()%>" <%= t.getIdTuyen() == idSelected ? "selected" : ""%>>
								<%=t.getTuyenXe()%></option>
							<%
								}
							%>
						</select> <br /> <label for="name">Date</label><br /> <input type="date"
							id="date" name="date" min="<%=f2.format(today)%>"
							value="<%=f2.format(selectDate)%>" /> <br />
						<button style="width: 100px;">Tìm Tuyến</button>
						<br />
					</form>
				</div>
			</fieldset>
		</div>

		<div id="themchuyen">
			<%@ include file="ThemChuyen.jsp"%>
		</div>
		<form id="formThemChuyen" action="#" title="Thêm chuyến xe">
			<input type="hidden" id="id" name="id" value="1" /> <label
				for="name">Giờ khởi hành:</label><br /> <input type="text"
				name="giokhoihanh" id="giokhoihanh" rel="0" /><br> <label
				for="name">Xe</label><br /> <select name="xe" id="xe" rel="1">
				<option value="2">xe 45</option>
				<option value="1">xe 16</option>
			</select> <br /> <label for="name"/label><br /> <input type="number"
				name="gia" id="gia" rel="3" value="" /> <input type="hidden"
				value="false" rel="4" /> <br /> <input type="hidden" value=""
				rel="2" /> <br />
			<button id="btOk">Thêm</button>
			<button id="btCancel">Hủy</button>
		</form>
	</div>
</body>
</html>