<%@page import="model.Ghe"%>
<%@page import="java.util.List"%>
<%@page import="model.Chuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/xe16.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/xe.js"></script>
<script>
	$(document).ready(function() {
		set($(".chuadat"));
		$("#btnPrint").click( function () {
	        var divContents = $("body").html();
	        var printWindow = window.open('', '', 'height=400,width=800');
	        printWindow.document.write('<html><head><title>DIV Contents</title>');
	        printWindow.document.write('</head><body >');
	        printWindow.document.write(divContents);
	        printWindow.document.write('</body></html>');
	        printWindow.document.close();
	        printWindow.print();
	    });
	});
	
</script>
</head>
<body>
<input type="button" value="Print Div Contents" id="btnPrint" />
	<div id="xe">
		<%
			int idChuyen = (Integer) session.getAttribute("chuyen");
			Chuyen chuyen = null;
			if (idChuyen == 1) {
				chuyen = (Chuyen) session.getAttribute("chuyenDi");
			} else {
				chuyen = (Chuyen) session.getAttribute("chuyenVe");
			}
			List<Ghe> danhSachghe = chuyen.getDanhSachGheNgoi();
		%>
		<input type="hidden" value="<%=idChuyen%>" id="idChuyen" /> <img
			alt="dauxe" src="/BanVeXe/image/p.png" width="260px" height="150px">
		<%
			for (int i = 0; i < 15; i++) {
				int hang = 0;
				int cot = 0;

				switch (i) {
				case 0:
				case 1:
					hang = 0;
					break;
				case 2:
				case 3:
				case 4:
					hang = 1;
					break;
				case 5:
				case 6:
				case 7:
					hang = 2;
					break;
				case 8:
				case 9:
				case 10:
					hang = 3;
					break;
				case 11:
				case 12:
				case 13:
				case 14:
					hang = 4;
					break;
				default:
					break;
				}
				switch (i) {
				case 2:
				case 5:
				case 8:
				case 11:

					cot = 0;
					break;
				case 0:
				case 3:
				case 6:
				case 9:
				case 12:
					cot = 1;
					break;
				case 1:
				case 4:
				case 7:
				case 10:
				case 13:
					cot = 2;
					break;
				default:
					cot = 3;
					break;
				}
				if (danhSachghe.get(i).getTrangThai() == Ghe.DA_DAT) {
		%>
		<img alt="ghe<%=i%>" src="/BanVeXe/image/ghe3.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot<%=cot%>" />

		<%
			} else {
		%>
		<img alt="ghe<%=i%>" src="/BanVeXe/image/ghe1.png" id="<%=i%>"
			class="ghe chuadat hang<%=hang%> cot<%=cot%>" />
		<%
			}
			}
		%>
	</div>
	
</body>
</html>