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
</script>
</head>
<body>
	<input type="text" id="pass" onblur="change()" />
	<input type="hidden" id="passmd5" />
	<button onclick="check()">click</button>
</body>
</html>