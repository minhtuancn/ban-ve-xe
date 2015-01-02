<%@page import="util.DuongDan"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/DangNhap.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/jquery.md5.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script type="text/javascript">
	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
		}
		if ($("#success").val().length != 0) {
			al($("#success").val(), "success");
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
	function convertMD5() {
				$("#md5password").val($.md5($("#password").val()));
	}
</script>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="containerdn">

		<%
			String mes = "";
			if ((String) request.getAttribute("mes") != null)
				mes = (String) request.getAttribute("mes");
			String mesSuccess = "";
			if ((String) request.getAttribute("mesSuccess") != null)
				mesSuccess = (String) request.getAttribute("mesSuccess");
		%>
		<input type="hidden" value="<%=mes%>" id="error" />

		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Đăng nhập
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div id="dangki">
			<%
				String pageFoward = DuongDan.TRANG_CHU;
				if (request.getParameter("pageFoward") != null)
					pageFoward = request.getParameter("pageFoward");
			%>
			<h1>Đăng Nhập</h1>
			<form id="contactform" name="contact" method="post"
				action="<%=DuongDan.DANG_NHAP_SV%>">
				<input type="hidden" name="pageFoward" value="<%=pageFoward%>" />
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="user" id="name" class="txt" tabindex="1"
						placeholder="Tên đăng nhập" required />
				</div>

				<div class="row">
					<label for="password">Mật khẩu: <span class="req">*</span></label>
					<input type="password" id="password" class="txt" tabindex="2"
						placeholder="********" required onkeyup="convertMD5()" /> <input
						type="hidden" name="password" id="md5password" />
				</div>
				<div class="center">
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Nhập" />
				</div>
				<div class="dong">
					<a class="dangki" href="DangKi.jsp">Đăng kí</a>
				</div>
				<div class="dong">
					<a class="quenmk" href="quenmk.jsp">Quên mật khẩu</a>
				</div>
			</form>
		</div>

		<%-- 		<div class="ctv"><%@ include file="chitietvexe.jsp"%></div> --%>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>