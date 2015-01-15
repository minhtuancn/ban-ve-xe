<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/NhapTTVangLai.css">
	<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/jquery.md5.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
	<script type="text/javascript">
	function checkPass() {
		if ($("#pass").val() == $("#re-pass").val()){
				if($("#pass").val().length >= 8){
					
				}else{
					$("#error-pass").text("Mật khẩu phải dài hơn 8 kí tự!");
					return false;
				}
			$("#contactform").submit();
		}
		else
			$("#error-repass").text("Mật khẩu không trùng khớp!");
	}
	function md5OldPass() {
		$("#md5pass-old").val($.md5($("#pass-old").val()));
	}
	function md5Pass() {
		$("#md5pass").val($.md5($("#pass").val()));
	}
	function md5Repass() {
		$("#md5re-pass").val($.md5($("#re-pass").val()));
	}
	function checkPass8() {
		if($("#pass").val().length >= 8){
			$("#error-pass").text("");
		}else{
			$("#error-pass").text("Mật khẩu phải dài hơn 8 kí tự!");
			return false;
		}
	}
	</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="contain">
	<%String mes = "";
		if(request.getAttribute("mes")!= null)
			mes = (String) request.getAttribute("mes");
	%>
		<div id="center">
		<form id="contactform" action="<%= DuongDan.DOI_MAT_KHAU_SV%>">
			<p id="h3">Đổi mật khẩu</p>
			<div id="divtrai">
				<label id="slable">Nhập mật khẩu hiện tại:</label><br> 
				<span id ="error-pass-old" style="color: red;" ><%=mes %></span>
				<input type="password" class="text" required="required" id="pass-old" onfocus="$('#error-pass-old').text(' ')" onkeyup="md5OldPass()"/>
				<input type="hidden" name="pass-old" id="md5pass-old" />
			</div>
			<div id="divphai">
				<label id="slable">Nhập mật khẩu mới:</label><br>
				<span id ="error-pass" style="color: red;"></span>
				<input type="password" class="text" required="required" id="pass" onblur="checkPass8()" onkeyup="md5Pass()"/>
				<input type="hidden" name="pass" id="md5pass" />
			</div>
			<div id="divphai">
				<label id="slable">Nhập lại mật khẩu mới:</label><br>
				<span id ="error-repass" style="color: red;"></span>
				<input type="password" class="text" required="required" id="re-pass" onfocus="$('#error-repass').text(' ')"  onkeyup="md5Repass()"/>
				<input type="hidden" name="re-pass" id="md5re-pass" />
			</div>
			<div id="bt"><input type="button" value="Đổi mật khẩu" id="button_s" onclick="checkPass()"/></div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>