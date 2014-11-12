<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/DangNhap.css">

</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="containerdn">
		<div class="ttoan">Thanh toán</div>
		<div class="lable">Vui lòng đăng nhập</div>
		<div class="login-form">
			<h1>ĐĂNG NHẬP</h1>
			<form action="#">
				<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
				<input type="text" name="username" placeholder="Tên đăng nhập"
					required="required"> <label for="name">Mật Khẩu: <span
					class="req">*</span></label> <input type="password" name="password"
					placeholder="Mật khẩu" required="required"> <input
					type="submit" value="Đăng nhập">
					
			</form>

		</div>
		<div class="ctv"><%@ include file="chitietvexe.jsp"%></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>