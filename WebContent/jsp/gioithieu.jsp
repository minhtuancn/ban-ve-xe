<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giới thiệu</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/gioithieu.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 200) {
				$(".autoScroll").animate({
					top : 10
				}, 0, function() {

				});
			} else {
				$(".autoScroll").animate({
					top : 200 - $(this).scrollTop()
				}, 0, function() {

				});
			}
		});
	});
	$(window).load(function() {
		setMenu();
	});
	function setMenu() {
		$("#" + $("#menuSelect").val()).addClass("select");
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<input type="hidden" value="gioithieu" id="menuSelect" />
	<div id="gt-container">
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Giới thiệu
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div id="left">
			<img id="imgleft" class="autoScroll" alt="left"
				src="/BanVeXe/image/cau-doi-l.png" />
		</div>
		<div id="bodys">
			<fieldset>
				<div id="gt">
					<p class="note">
						<img alt="icon" src="/BanVeXe/image/bus.jpg">Giới thiệu
					</p>
					<p>
						Hệ thống đặt vé xe khách của chúng tôi gồm có các chức năng:<br>
						- Nhắn tin thông báo SMS cho khách hàng khi vé đã được đặt. - Quản
						lý vé đặt trước qua điện thoại và vé bán tại đại lý. - Quản lý
						danh sách khách hàng. - Thống kê doanh thu đạt được trong ngày,
						tháng.... - Chức năng quản lý thu & chi. - Có thể tùy chỉnh phôi
						in ra phù hợp với phôi hiện tại của nhà xe.
					</p>
					<p class="note">
						<img alt="icon" src="/BanVeXe/image/bus.jpg">Tầm nhìn
					</p>
					<p>
						Vì hàng triệu người Việt Nam không ai phải xếp hàng mua vé<br>
						Hiện nay, thương mại điện tử, đặc biệt là đặt vé máy bay đã trở
						nên rất phổ biến ở Việt Nam. Tuy nhiên, lĩnh vực xe khách, phương
						tiện giao thông được sử dụng phổ biến nhất và đáp ứng được nhu cầu
						của đa số người dân, lại chưa có một kênh đặt vé trực tuyến đúng
						nghĩa.Hiểu được nhu cầu đi lại cấp thiết của người dân Việt nam,
						VeXeOnline.Com đã ra đời để cung cấp thông tin: bảng giá vé, lịch
						trình, địa chỉ, số điện thoại và đánh giá của trên 3000 tuyến
						đường cả nước.
					</p>
					<p class="note">
						<img alt="icon" src="/BanVeXe/image/bus.jpg">Sứ mệnh
					</p>
					<p>
						Trở thành công ty công nghệ hàng đầu Châu Á chuyên cung cấp các
						giải pháp nâng cao đời sống xã hội.<br> Trải qua hàng nghìn
						năm, lịch sử nhân loại đã có những bước tiến nhảy vọt, chủ yếu do
						cải thiện năng suất lao động. Tin tưởng vào điều này, VeXeOnline
						mong muốn có thể góp phần cải thiện đời sống người dân thông qua
						khả năng sáng tạo và ứng dụng công nghệ vào mọi mặt đời sống hàng
						ngày. VeXeOnline mong muốn được biết đến với tư cách là một công
						ty công nghệ hàng đầu Châu Á chuyên cung cấp các sản phẩm và dịch
						vụ giải quyết các vấn đề hiện tại của xã hội.

					</p>
					<p class="note">
						<img alt="icon" src="/BanVeXe/image/bus.jpg">Ghi chú
					</p>
					<p>
						Quý khách có thể trực tiếp đến các phòng vé để lấy vé hoặc yêu cầu
						dịch vụ giao vé tận nhà.<br> * Tổng đài đặt vé: 08.39 29 29
						29<br> * Bộ phận Chăm sóc khách hàng: 08.35 11 77 88<br>
						* Đường dây nóng: 0985 29 29 29<br> * Địa chỉ phòng vé:<br>
						VP Cẩm Tú, khu phố 6, phường Linh Trung, Q.Thủ Đức, TP. Hồ Chí
						Minh, Việt Nam<br>
					</p>
				</div>
			</fieldset>
		</div>
		<div id="right">
			<img id="imgright" class="autoScroll" alt="right"
				src="/BanVeXe/image/cau-doi-r.png" />
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>