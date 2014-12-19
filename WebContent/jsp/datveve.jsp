<%@page import="model.Chuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/xe.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	set($("div#chuyenve img.chuadat"),$('#idChuyenVe'), ".chitietve");
});
</script>
</head>
<body>
	<%
		Chuyen c = (Chuyen) session.getAttribute("chuyenVe");
		int loaiXe = c.getLoaiXe();
	%>
	<input type="hidden" value="2" id="idChuyenVe" />
	<div id="chuyenve"
		<%-- 		style="width: 100%; <%if (loaiXe == 15) {%> height:530px; <%} else {%> height:720px; <%}%>"> --%>
		style="width: 100%; height: 730px;">
		<%
			switch (loaiXe) {
			case 15:
		%>
		<div style="position: absolute;">
			<%@ include file="xe16.jsp"%></div>
		<%
			break;
			case 45:
		%>
		<div style="position: absolute;">
			<%@ include file="xe45.jsp"%></div>
		<%
			break;
			default:
				break;
			}
		%>
		<div style="margin-top: 10px; margin-left: 500px" class="chitietve"><%@ include
				file="chitietvexe.jsp"%></div>
	</div>
</body>
</html>