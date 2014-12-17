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
		$(".myDataTable").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true
		});
		$(".myDataTable").dataTable().makeEditable({

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

			{}, {
				indicator : 'Saving...',
				tooltip : 'Click to select town',
				loadtext : 'loading...',
				type : 'select',
				onblur : 'submit',
				data : "{'45':'45','16':'16'}"
			}, {
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

	function timchuyen() {
		if ($('#date').val().length == 0) {
			swal({
				title : "Bạn chưa nhập ngày!",
				type : "warning"
			});
		} else {
			var tuyen = $('#tuyen option:selected').val();
			while (tuyen.indexOf(" ") != -1) {
				tuyen = tuyen.replace(" ", "+");
			}
			// 			$("#themchuyen").load("/BanVeXe/ListChuyen", {tuyen: tuyen,date : + $('#date').val()+""}, function() {
			$("#themchuyen").html("AAAAA");
			// 				$("#themchuyen").html("aaaaaaaaaaaaaaa");
			$("#themchuyen").load(
					"/BanVeXe/ListChuyen?tuyen=" + tuyen + "&date="
							+ $('#date').val().replace(" ", "+"), function() {
					});
		}
	};
</script>
</head>
<body>
	<%	
		
		List<Tuyen> listTuyen;
		if (session.getAttribute("listTuyen") != null) {
			listTuyen = (List<Tuyen>) session.getAttribute("listTuyen");
			session.setAttribute("listTuyen", listTuyen);
		} else
			listTuyen = new ArrayList<Tuyen>();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		String date = "";
		if(request.getParameter("date") != null)
			date = request.getParameter("date");
		Date selectedDate ;
		if(date.equals(""))
			selectedDate = new Date();
		else
			selectedDate = f.parse(date);
	%>
	<div id="containers">
		<div id="tt-chuyen">
			<fieldset>
				<legend>Thông tin chuyến</legend>
				<div>
									<form action="Kiemtrachuyen" id="form">

					<label for="name">Tuyến Xe</label><br /> <select name="tuyen"
						id="tuyen">
						<%
							for (Tuyen d : listTuyen) {
						%>
						<option value="<%=d.getTuyenXe()%>">
							<%=d.getTuyenXe()%></option>
						<%
							}
						%>
					</select> <br /> <label for="name">Date</label><br /> <input type="date"
						id="date" name="date" min="<%= f.format(today) %>" value="2014-12-18"/> <br />
					<button onclick="timchuyen()">click</button>
					<br />
									</form>
				</div>
			</fieldset>
		</div>

		<div id="themchuyen">
			<%@ include file="ThemChuyen.jsp" %>
		</div>
		<form id="formThemChuyen" action="#" title="Thêm chuyến xe">
			<input type="hidden" id="id" name="id" value="1" /> <label
				for="name">Giờ khởi hành:</label><br /> <input type="text"
				name="giokhoihanh" id="giokhoihanh" rel="0" /><br> <label
				for="name">Xe</label><br /> <select name="xe" id="xe" rel="1">
				<option value="xe45">xe 45</option>
				<option value="xe16">xe 16</option>
			</select> <br /> <label for="name">Giá:</label><br /> <input type="number"
				name="gia" id="gia" rel="3" value="1222221"/> <input type="hidden" value="false"
				rel="4" /> <br /> <input type="hidden" value="" rel="2" /> <br />
			<button id="btOk">Add</button>
			<button id="btCancel">Cancel</button>
		</form>
	</div>
</body>
</html>