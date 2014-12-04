<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/DangNhap.css">


</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="containerdn">

		<div id="dangki">
			<h1>Đăng Nhập</h1>
			<form id="contactform" name="contact" method="post" action="#">
				<div class="row">
					<label for="name">Tên Đăng Nhập: <span class="req">*</span></label>
					<input type="text" name="name" id="name" class="txt" tabindex="1"
						placeholder="Tên đăng nhập" required>
				</div>

				<div class="row">
					<label for="password">Mật khẩu: <span class="req">*</span></label>
					<input type="password" name="password" id="password" class="txt"
						tabindex="2" placeholder="********" required>
				</div>
				<div class="center">
					<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
						value="Đăng Nhập">
				</div>
				<div class="dong">
					<a class="dangki" href="DangKi.jsp">Đăng kí</a>
				</div>
				<div class="dong">
					<a class="quenmk" href="quenmk.jsp">Quên mật khẩu</a>
				</div>
			</form>
		</div>

		<!-- 		<div class="ttoan">Thanh toán</div> -->
		<!-- 		<div class="lable">Vui lòng đăng nhập</div> -->
		<!-- 		<div class="login-form-dangnhap"> -->

		<!-- 			<form action="#"> -->
		<!-- 				<table> -->
		<!-- 					<tr> -->
		<!-- 						<td colspan="2"><h1>ĐĂNG NHẬP</h1> -->
		<!-- 						</td> -->
		<!-- 					</tr> -->
		<!-- 					<tr class="tr-dangnhap"> -->
		<!-- 						<td><label for="name">Tên Đăng Nhập: <span -->
		<!-- 								class="req">*</span></label></td> -->
		<!-- 						<td><input type="text" name="username" -->
		<!-- 							placeholder="Tên đăng nhập" required="required"></td> -->
		<!-- 					</tr> -->

		<!-- 					<tr> -->
		<!-- 						<td><label for="name">Mật Khẩu: <span class="req">*</span></label> -->
		<!-- 						</td> -->
		<!-- 						<td><input type="password" name="password" -->
		<!-- 							placeholder="*****" required="required"></td> -->
		<!-- 					</tr> -->
		<!-- 					<tr align="center"> -->

		<!-- 						<td colspan="2"><input type="submit" value="Đăng nhập"> -->
		<!-- 						</td> -->
		<!-- 					</tr> -->
		<!-- 					<tr> -->
		<!-- 						<td><a class="quenmk" href="quenmk.jsp">Quên mật khẩu</a></td> -->
		<!-- 						<td><a class="dangki" href="DangKi.jsp">Đăng kí</a></td> -->
		<!-- 					</tr> -->
		<!-- 				</table> -->
		<!-- 			</form> -->

		<div class="ctv"><%@ include file="chitietvexe.jsp"%></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>