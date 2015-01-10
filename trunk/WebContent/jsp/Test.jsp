<%@page import="util.DuongDan"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/jquery.md5.js"></script>
<script type="text/javascript">
	function check() {
		var md5 = $.md5('123456`');
		alert(md5);
	}
	function eq() {
		if ("abc" == "abc")
			alert("abs");
		else
			alert("ass");
	}
	function change() {
		$("#passmd5").val($.md5($("#pass").val()));
	}
	function print() {
		var divContents = $("div#content").html();
		var printWindow = window.open('', '', 'height=600,width=500');
		printWindow.document.write('<html><head><title>DIV Contents</title>');
		printWindow.document.write('<style type="text/css"> body { width: 300px; height: auto;} table#example td, table#example th { 	border: outset; 	}</style>');
		printWindow.document.write('</head><body >');
		printWindow.document.write(divContents);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		printWindow.print();
	};
</script>
<style type="text/css">
div#content {
	width: 500px;
	height: auto;
}
table#example td,table#example th {
	border: outset;
}
</style>
</head>
<body>
	<button onclick="print()">click</button>
	<div id="content">
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Position</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>Tiger</td>
					<td>Nixon</td>
					<td>System Architect</td>
				</tr>
				<tr>
					<td>Garrett</td>
					<td>Winters</td>
					<td>Accountant</td>
				</tr>
				<tr>
					<td>Ashton</td>
					<td>Cox</td>
					<td>Junior Technical Author</td>
				</tr>
				<tr>
					<td>Cedric</td>
					<td>Kelly</td>
					<td>Senior Javascript Developer</td>
				</tr>
				<tr>
					<td>Airi</td>
					<td>Satou</td>
					<td>Accountant</td>
				</tr>
				<tr>
					<td>Brielle</td>
					<td>Williamson</td>
					<td>Integration Specialist</td>
				</tr>
				<tr>
					<td>Herrod</td>
					<td>Chandler</td>
					<td>Sales Assistant</td>
				</tr>
				<tr>
					<td>Rhona</td>
					<td>Davidson</td>
					<td>Integration Specialist</td>
				</tr>
				<tr>
					<td>Colleen</td>
					<td>Hurst</td>
					<td>Javascript Developer</td>
				</tr>
				<tr>
					<td>Sonya</td>
					<td>Frost</td>
					<td>Software Engineer</td>
				</tr>
				<tr>
					<td>Jena</td>
					<td>Gaines</td>
					<td>Office Manager</td>
				</tr>
				<tr>
					<td>Quinn</td>
					<td>Flynn</td>
					<td>Support Lead</td>
				</tr>
				<tr>
					<td>Charde</td>
					<td>Marshall</td>
					<td>Regional Director</td>
				</tr>
				<tr>
					<td>Haley</td>
					<td>Kennedy</td>
					<td>Senior Marketing Designer</td>
				</tr>
				<tr>
					<td>Tatyana</td>
					<td>Fitzpatrick</td>
					<td>Regional Director</td>
				</tr>
				
			</tbody>
		</table>
	</div>

</body>
</html>