<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnJTp_L3nQyoa9MjQAeFXiKg6RxTH2aek">
</script>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//phuong vi 10.871898, 106.792770
		var fromLatitude = 10.871898;
		var fromLongitude = 106.792770;
		// suoi tien 10.866142, 106.802154
		var toLatitude = 10.866142;
		var toLongitude = 106.802154;
		if (navigator.geolocation){
			navigator.geolocation.getCurrentPosition(showPosition);
		}
		function showPosition(position) {
			fromLatitude = position.coords.latitude;
			fromLongitude = position.coords.longitude;
		var to = new google.maps.LatLng(toLatitude, toLongitude);
		var from = new google.maps.LatLng(fromLatitude, fromLongitude);
		
		//Khai bÃ¡o cÃ¡c biáº¿n vÃ  Äá»i tÆ°á»£ng cáº§n thiáº¿t
		
		var map;
		var directionsService = new google.maps.DirectionsService();
		var directionsDisplay;

		// Tháº» div chá»©a báº£n Äá»
		var map_canvas = document.getElementById("google-map");
		map_canvas.style.width = '100%';
		map_canvas.style.height = '500px';

		// Option map
		var map_options = {
			center : from,
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.HYBRID
		};

		// Äá»i tÆ°Æ¡ng map
		map = new google.maps.Map(map_canvas, map_options);

		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsDisplay.setMap(map);

		var request = {
			origin : from,
			destination : to,
			travelMode : google.maps.TravelMode.DRIVING
		};

		directionsService.route(request, function(result, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(result);
			}

		});
		var marker = new google.maps.Marker({
			position : from,
			icon : '/BanVeXe/image/user_icon.jpg'
		});
		marker.setMap(map);
		var infowindow = new google.maps.InfoWindow({
			  content:"Bạn đang ở đây!"
			  });
		infowindow.open(map,marker);
		marker = new google.maps.Marker({
			position : to,
			icon : '/BanVeXe/image/icon_nlu.png'
		});
		marker.setMap(map);
		infowindow = new google.maps.InfoWindow({
			  content:"Đại lý của chúng tôi ở đây!"
			  });
		infowindow.open(map,marker);
		};
	});
	
</script>
</head>
<body>
	<div id="google-map"></div>
</body>
</html>