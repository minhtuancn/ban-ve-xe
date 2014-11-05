<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/xe16.css">
</head>
<body>

	<div id="xe">
	<img alt="dauxe" src="../image/p.png" width="260px" height="150px">
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
		%>

		<img alt="ghe<%=i%>" src="../image/ghe1.png"
			class="ghe<%=i%> ghe hang<%=hang%> cot<%=cot%>" />
		<%
			}
		%>
	</div>


</body>
</html>