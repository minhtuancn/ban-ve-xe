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
		var md5 = $.md5('hoang nhuoc quy');
		alert(md5);
		alert($.md5(md5));
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
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/kiemtrave.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/timve.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/lienhe.css">
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
<script type="text/javascript">
	function sendOTP() {
		$.get(
<%=DuongDan.CHECK_OTP%>
	, function(data, status) {
			alert(status + " : " + data);
			if (status == "success") {
				if (data == "ok") {
					swal({
						title : "Mã OTP đã được gửi cho quý khách",
						type : "success"
					});
				}
			}
		});
	}
</script>
</head>
<body>
	<input type="text" id="pass" onblur="change()" />
	<input type="hidden" id="passmd5" />
	<button onclick="sendOTP()">click</button>
</body>
</html>