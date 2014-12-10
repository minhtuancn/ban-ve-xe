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
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/xe.js"></script>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/xe45.css">
<script>
</script>
</head>
<body>
	<%
	int idChuyens = (Integer) session.getAttribute("chuyen");
	Chuyen chuyens = null;
	if (idChuyens == 1) {
		chuyens = (Chuyen) session.getAttribute("chuyenDi");
	} else {
		chuyens = (Chuyen) session.getAttribute("chuyenVe");
	}
	List<Ghe> danhSachghes = chuyens.getDanhSachGheNgoi();
	%>
	<input type="hidden" value="<%= idChuyens%>" id="idChuyen" />
	<div id="xe45cho" >
		<img alt="dauxe" src="/BanVeXe/image/p.png" width="310px"
			height="100px">
		<%
			for (int i = 0; i < 40; i++) {
				int hang = i / 4;
				int cot = i % 4;
				if (danhSachghes.get(i).getTrangThai() == Ghe.DA_DAT) {
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
			for (int i = 40; i < 45; i++) {
				int hang = 10;
				int cot = i % 5;
				if (danhSachghes.get(i).getTrangThai() == Ghe.DA_DAT) {
		%>
		<img alt="ghe<%=i%>" src="/BanVeXe/image/ghe3.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot<%=cot%>" />
		<%
			} else {
		%>
		<img alt="ghe<%=i%>" src="/BanVeXe/image/ghe1.png" id="<%=i%>"
			class="ghe chuadat hang<%=hang%> cot1-<%=cot%>" />
		<%
			}
			}
		%>
	</div>
		
</body>
</html>