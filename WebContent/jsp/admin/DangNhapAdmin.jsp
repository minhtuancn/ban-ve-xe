<%@page import="util.DuongDan"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/DangNhap.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">

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
	function convertMD5() {
				$("#md5password").val($.md5($("#password").val()));
	}
</script>
</head>

<body>
	<%@ include file="HeaderAdmin.jsp"%>
	<div class="containerdn">
		<div id="dangki">
			<% String pageFoward = DuongDan.LIST_TUYEN_SV ;
			if(request.getAttribute("pageFoward") != null)
				pageFoward = (String)request.getAttribute("pageFoward");
		%>
		
		<%
			String mes = "";
			if ((String) request.getAttribute("mes") != null)
				mes = (String) request.getAttribute("mes");
		%>
		<input type="hidden" value="<%=mes%>" id="error" />
			<h1>Đăng Nhập</h1>
			<form id="contactform" name="contact" method="post"
				action="<%=DuongDan.DANG_NHAP_ADMIN_SV %>">
				<input type="hidden" name="pageFoward" value="<%= pageFoward%>" />
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="user" id="name" class="txt" tabindex="1"
						placeholder="Tên đăng nhập" required />
				</div>

				<div class="row">
					<label for="password">Mật khẩu: <span class="req">*</span></label>
					<input type="password" name="password" id="password" class="txt"
						tabindex="2" placeholder="********" required />
				</div>
				<div class="center">
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Nhập" />
				</div>
			</form>
		</div>

	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>