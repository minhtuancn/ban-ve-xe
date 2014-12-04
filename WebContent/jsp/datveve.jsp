<%@page import="model.Chuyen"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="width: 100%; height: 700px; margin-top: 20px;">
		<%
			Chuyen c = (Chuyen) session.getAttribute("chuyenVe");
			int loaiXe = c.getLoaiXe();
			switch (loaiXe) {
			case 15:
		%>
		<div style="left: 100px; position: absolute;">
			<%@ include file="xe16.jsp"%></div>
		<%
			break;
			case 45:
		%>
		<div style="left: 100px; position: absolute;">
			<%@ include file="xe45.jsp"%></div>
		<%
			break;
			default:
				break;
			}
		%>
		<div style="margin-left: 800px;"><%@ include
				file="chitietvexe.jsp"%></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>