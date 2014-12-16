<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<script type="text/javascript">
	function mes() {
		swal({
			title : "Are you sure?",
			text : "You will not be able to recover this imaginary file!",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "Yes, delete it!",
			closeOnConfirm : false,
			closeOnCancel: false
		}, function(isConfirm) {
			if (isConfirm) {
				swal("Deleted!", "Your imaginary file has been deleted.",
						"success");
			} else {
				swal("Cancelled", "Your imaginary file is safe :)", "error");
			}
		});
	}
</script>
</head>
<body>
	<button onclick="mes()">abc</button>
</body>
</html>