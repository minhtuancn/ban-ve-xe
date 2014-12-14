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
	function getParent(el) {
		alert($(el).parent().attr("id"));
	}
</script>
</head>
<body>
	<div id="container">
		<div id="1">
			<div id="2">
				<button onclick="getParent(this)">button 1</button>
			</div>
			<div id="3">
				<button onclick="getParent(this)">button 2</button>
			</div>
		</div>
	</div>
</body>
</html>