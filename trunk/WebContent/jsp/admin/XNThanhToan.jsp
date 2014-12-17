<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/BanVeXe/css/datatable/XacNhanThanhToan.css" rel="stylesheet"
	type="text/css" media="all" />
<title>Insert title here</title>
</head>
<body>
<div id="container">
<div>
<fieldset>
<legend>Thông tin khách hàng</legend>
<%@ include file="/ListKhachHang"%>
</fieldset>
</div>
<div>
<fieldset>
<legend>Thông tin vé</legend>
<%@ include file="/ListVe"%>
</fieldset>
</div>
</div>
</body>
</html>