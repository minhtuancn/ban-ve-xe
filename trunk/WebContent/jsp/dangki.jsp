<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng Kí</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/dangki.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/jquery.md5.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script>
	$(document).ready(function() {
		$('#refresh').click(function() {
			var d = new Date();
			var newSrc = "<%=DuongDan.CAPTCHA%>?" + d.getTime();
			$('#captcha').attr("src", newSrc);
		});
		$("#contactform").submit(function(e) {
			if($("#error-user").text().length == 0){
				if ($("#pass").val() == $("#re-pass").val()){
					if($("#pass").val().length >= 8){
						
					}else{
						$("#error-pass").text("Mật khẩu phải dài hơn 8 kí tự!");
						return false;
					}
				} else{
					$("#error-pass").text("Mật khẩu không trùng khớp!");
						return false;
				}
			}else{
				al("User đã tồn tại", "warning");
						return false;
			}
		});
	});

	function al(mes, type) {
		swal({
			title : mes,
			type : type
		});
	}

	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
		}
	};

	$(window).load(function() {
		checkEr();
	});

// 	function checkPass() {
// 		if($("#error-user").text().length == 0){
// 			if ($("#pass").val() == $("#re-pass").val()){
// 				if($("#pass").val().length >= 8){
// 					$("#contactform").submit();
// 				}else{
// 					$("#error-pass").text("Mật khẩu phải dài hơn 8 kí tự!");
// 				}
// 			} else
// 				$("#error-pass").text("Mật khẩu không trùng khớp!");
// 		}else{
// 			al("User đã tồn tại", "warning");
// 		}

// 	}
	
	
	
	function checkPass2() {
		if ($("#pass").val() != $("#re-pass").val())
			$("#error-pass").text("Mật khẩu không trùng khớp!");

	}
	function checkUser() {
		if ($("#name").val().length != 0) {
			$("#error-user").load("<%=DuongDan.KIEM_TRA_USER_SV%>?user=" + $("#name").val());
		}
	}
	function md5passs() {
		$("#md5pass").val($.md5($("#pass").val()));
	};
	function md5repasss() {
		$("#md5repass").val($.md5($("#re-pass").val()));
	};
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="dk-contain">
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Đăng kí
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<%
			String user = "";
			String pass = "";
			String re_pass = "";
			String sdt = "";
			String tenDangKi = "";
			String email = "";
			String cmnd = "";
			String diaChi = "";

			if (request.getParameter("user") != null) {
				user = request.getParameter("user");
			}
			if (request.getParameter("pass") != null) {
				pass = request.getParameter("pass");
			}
			if (request.getParameter("re-pass") != null) {
				re_pass = request.getParameter("re-pass");
			}
			if (request.getParameter("sdt") != null) {
				sdt = request.getParameter("sdt");
			}
			if (request.getParameter("name") != null) {
				tenDangKi = request.getParameter("name");
			}
			if (request.getParameter("email") != null) {
				email = request.getParameter("email");
			}
			if (request.getParameter("cmnd") != null) {
				cmnd = request.getParameter("cmnd");
			}
			if (request.getParameter("diachi") != null) {
				diaChi = request.getParameter("diachi");
			}
		%>

		<%
			String mes = "";
			if (request.getAttribute("mes") != null)
				mes = (String) request.getAttribute("mes");
		%>
		<input type="hidden" value="<%=mes%>" id="error" />
		<div id="dangki">
			<h1>Đăng Kí!</h1>
			<form id="contactform" name="contact" method="post"
				action="<%=DuongDan.DANG_KI_SV%>">
				<span id="error-user" style="color: red; margin-left: 180px;"></span>
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="user" id="name" class="txt" tabindex="1"
						value="<%=user%>" placeholder="Tên đăng nhập" required
						onblur="checkUser()" onfocus="$('#error-user').text(' ')">
				</div>

				<div class="row">
					<label for="name">Mật khẩu: <span class="req">*</span></label> <input
						type="password" id="pass" class="txt" tabindex="1"
						onkeyup="md5passs()" value="" placeholder="********" required>
					<input type="hidden" name="pass" id="md5pass" />
				</div>
				<span id="error-pass" style="color: red; margin-left: 180px;"></span>
				<div class="row">
					<label for="name">Nhập lại mật khẩu: <span class="req">*</span></label>
					<input type="password" id="re-pass" class="txt" value=""
						tabindex="1" placeholder="********" required onblur="checkPass2()"
						onkeyup="md5repasss()" onfocus="$('#error-pass').text(' ')">
					<input type="hidden" name="re-pass" id="md5repass" />
				</div>

				<div class="row">
					<label for="name">Tên Khách hàng: <span class="req">*</span></label>
					<input type="text" name="name" id="name" class="txt" tabindex="1"
						value="<%=tenDangKi%>" placeholder="Tên khách hàng" required>
				</div>

				<div class="row">
					<label for="email">Địa chỉ email: <span class="req">*</span></label>
					<input type="email" name="email" id="email" class="txt"
						value="<%=email%>" tabindex="2" placeholder="address@gmail.com"
						required>
				</div>

				<div class="row">
					<label for="subject">Số Điện Thoại: <span class="req">*</span></label>
					<input type="text" name="sdt" id="subject" class="txt" tabindex="3"
						value="<%=sdt%>" placeholder="Số điện thoại" required>
				</div>
				<div class="row">
					<label for="subject">Số CMND: <span class="req">*</span></label> <input
						type="text" name="cmnd" id="subject" class="txt" tabindex="3"
						value="<%=cmnd%>" placeholder="Số CMND" required>
				</div>
				<div class="row">
					<label for="subject">Địa chỉ:</label> <input type="text"
						name="diachi" id="subject" class="txt" tabindex="3"
						value="<%=diaChi%>" placeholder="Địa chỉ" >
				</div>
				<div class="captcha">
					<img id="captcha" src="<%=DuongDan.CAPTCHA%>" title="Mã xác thực"
						width="100px" height="30px"> <img id="refresh"
						src="/BanVeXe/image/refresh.png" title="Tải lại mã xác thực khác">
				</div>
				<div class="row">
					<label for="subject">Mã xác nhận: <span class="req">*</span></label>
					<input type="text" id="subject" class="txt" required="required"
						name="captcha" placeholder="Mã xác nhận">
				</div>
				<div class="center">
					<input type="button" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Kí" onclick="checkPass()">
						<input type="submit" value="ok"/>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>