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
		var md5 = $.md5('hoang nhuoc quy'); 
		alert(md5);
		alert($.md5(md5));
	}
</script>
</head>
<body>
	<%@ include file="test2.jsp"%>
</body>
</html>