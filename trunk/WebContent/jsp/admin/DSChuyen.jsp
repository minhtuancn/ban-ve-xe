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
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/datatable/DSChuyen.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/sweet-alert.css">
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<script src="/BanVeXe/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
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
			$("#themchuyen").load(
					"/BanVeXe/ListChuyen?tuyen=" + tuyen + "&date="
							+ $('#date').val().replace(" ", "+"), function() {
					});
			// 			});
			// 			alert($('#tuyen option:selected').val()+"&date="+$('#date').val());
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
	%>
	<div id="containers">
		<div id="tt-chuyen">
			<fieldset>
				<legend>Thông tin chuyến</legend>
				<div>
					<!-- 				<form action="ListChuyen" id="form"> -->

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
						id="date" name="date" /> <br />
					<button onclick="timchuyen()">click</button>
					<br />
					<!-- 				</form> -->
				</div>
			</fieldset>
		</div>

		<div id="themchuyen">
					<%@ include file="ThemChuyen.jsp"%>
		</div>
	</div>
</body>
</html>