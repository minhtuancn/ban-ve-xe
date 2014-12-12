<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/BanVeXe/js/jquery.alerts-1.1/jquery.alerts.css"
	rel="stylesheet" type="text/css" media="screen" />
<script src="/BanVeXe/js/jquery.alerts-1.1/jquery.alerts.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/jquery.alerts-1.1/ui.draggable.js"
	type="text/javascript"></script>
<script src="/BanVeXe/js/jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript">
	function clickc() {
		jConfirm("aaaaa", "bbbbbb", function(confirm) {
			alert(confirm);
		});
	}
</script>
</head>
<body>
<button onclick="clickc()">click</button>
</body>
</html>