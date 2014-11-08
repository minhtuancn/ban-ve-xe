<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="width: 100%; height: 600px;">
		<div
			style="width: 100%; height: 40px; background: #145CA1; font-size: 30px; color: white; margin-top: 10px;">Thanh
			toán</div>
		<div
			style="width: 50%; height: 300px; background: maroon; font-size: 20px; color: white; margin-top: 10px; float: left; clear: right;">
			<p>Thông tin khách hàng:</p>
			<hr />
			<form action="#">
				<table>
					<tr>
						<td><span>Thông tin người đi:</span></td>
					</tr>
					<tr>
						<td><span>Họ tên:</span></td>
						<td><input type="text" name="hoten" size="30" placeholder="Họ tên"/></td>
					</tr>
					<tr>
						<td><span>Di động:</span></td>
						<td><input type="tel" name="didong"size="30" placeholder="Di động"/></td>
					</tr>
					<tr>
						<td><span>Ghi chú:</span></td>
						<td><textarea rows="5" cols="60" autofocus placeholder="Ghi chú"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-left: 800px; margin-top: 10px;"><%@ include
				file="chitietvexe.jsp"%></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>