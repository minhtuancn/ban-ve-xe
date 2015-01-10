<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tin tức</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/tintuc.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/until.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="tt-container">
		<div class="title bg">
			<marquee behavior="alternate" width="10%">>></marquee>
			Tin tức
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div id="center" class="bg"></div>
		<div id="ds-top">Tin mới:</div>
		<div id="center-top">
		<div id="tt-01"><span class="tieu-de">Chuyến đi Tây Ninh - Cà Mau mới đươc thêm vào..</span></div>	
		
		<div id="tt-02"></div>	
		</div>
			<div id="ds-bottom">Thông tin khác:</div>
		<div id="tt-03"></div>	
		<div id="center-bottom">
			
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>