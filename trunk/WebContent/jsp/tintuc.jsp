<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tin tức</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/tintuc.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/until.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 200) {
			$(".autoScroll").animate({
				top :10
			},0, function() {
				
			});
			// 				$("#imgleft").attr("top", offset.top + "px");
		} else {
			$(".autoScroll").animate({
				top : 200 - $(this).scrollTop()
			},0, function() {
				
			});
		}
	});
});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="title bg">
		<marquee behavior="alternate" width="10%">>></marquee>
		Tin tức
		<marquee behavior="alternate" width="10%"> << </marquee>
	</div>
	<div id="tt-container">
		<div id="left">
			<img id="imgleft" class="autoScroll"  alt="left" src="/BanVeXe/image/cau-doi-l.png" />
		</div>
		<div id="center">
			<fieldset>
				<legend>Tin tức mới:</legend>
				<div id="center-top">
					<div id="tt-01">
						<span class="tt-img"><img alt="tt-01" src="/BanVeXe/image/nx-001.jpg"></span>
						<a class="tt-a" href="#">Vé xe tết 2015 - Sài Gòn</a><br>
						<br>
						<p>Kế hoạch bán vé xe tết cho các chuyến đi từ TP. Hồ Chí Minh</p>
					</div>
					<div id="tt-02">
						<span class="tt-img"><img alt="tt-01" src="/BanVeXe/image/nx-002.jpg"></span>
					<a class="tt-a" href="#">Tuyến xe TP. Hồ Chí Minh - Đà Nẵng đã được mở</a><br><br>
					<p>Kể từ ngày 16/01/ 2015 các chuyến xe thuộc tuyến đi từ TP. Hồ Chí Minh đến Đà Nẵng đã được mở thuận tiện việc đi lại cũng như thăm thú phong cảnh Bà Nà Hiu mộng mơ nhân dịp lễ tết này.</p> 
</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>tin tức khác:</legend>
				<div id="center-bottom">
				<div id="tt-03">
				<span class="tt-img"><img alt="tt-01" src="/BanVeXe/image/nx-003.jpg"></span>
					<a class="tt-a" href="#">Ngắm Vinpearl Land và đặt vé đi du lịch tại VeXeOnline nào!</a><br><br>
					<p>Hệ thống đặt vé xe trực tuyến xin giới thiệu tới quý khách hàng những nơi vui chơi giải trí hiện đại vào bậc nhất Việt Nam. Nha Trang được biết đến với khu nghỉ dưỡng, vui chơi nổi tiếng Vinpearl Land. Hãy cùng hệ thống đặt vé xe trực tuyến khám phá nơi đây nhé.</p> 
				</div>
				</div>
			</fieldset>
		</div>
		<div id="right">
			<img id="imgright" class="autoScroll"  alt="right" src="/BanVeXe/image/cau-doi-r.png" />
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>