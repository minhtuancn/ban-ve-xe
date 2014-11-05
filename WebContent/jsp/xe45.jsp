<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/xe45.css">
</head>
<body>
	<div id="xe">
		<img alt="dauxe" src="../image/p.png" width="310px" height="100px">
		<%
			for (int i = 0; i < 40; i++) {
				int hang = i / 4;
				int cot = i % 4;
		%>
		<img alt="ghe<%=i%>" src="../image/ghe1.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot<%=cot%>" />
		<%
			}
		for(int i = 40; i<45; i++){
			int hang = 10;
			int cot = i % 5;
			%>
			<img alt="ghe<%=i%>" src="../image/ghe1.png" id="<%=i%>"
			class="ghe hang<%=hang%> cot1-<%=cot%>" />
		<%}
		%>
	</div>
</body>
</html>