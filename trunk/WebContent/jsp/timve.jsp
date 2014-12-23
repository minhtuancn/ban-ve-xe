<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script type="text/javascript">
	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
		}
	};
	function al(mes, type) {
		swal({
			title : mes,
			type : type
		});
	}
	$(window).load(function() {
		checkEr();
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="contain">
		<div id="center">
			<%
				String mes = "";
				if ((String) request.getAttribute("mes") != null)
					mes = (String) request.getAttribute("mes");
			%>
			<input type="hidden" value="<%=mes%>" id="error" />
			<form action="/BanVeXe/TimVe">
				<p id="h3">Bạn vui lòng nhập thông tin để tìm vé!</p>
				<div id="divtrai">
					<input type="text" class="text"
						style="width: 400px; margin-bottom: 20px;" name="maVe" />
					<div style="margin-left: 140px;">
						<input type="submit" id="button_s" value="Tìm vé " />
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>