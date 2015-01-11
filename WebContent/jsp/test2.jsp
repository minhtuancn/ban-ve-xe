<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/popup.css">
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
			closeOnCancel : false
		}, function(isConfirm) {
			if (isConfirm) {
				swal("Deleted!", "Your imaginary file has been deleted.",
						"success");
			} else {
				swal("Cancelled", "Your imaginary file is safe :)", "error");
			}
		});
	}

	$(document).ready(function() {
		$('a.login-window').click(function() {

			//Getting the variable's value from a link 
			var loginBox = $(this).attr('href');

			//Fade in the Popup
			$(loginBox).fadeIn(300);

			//Set the center alignment padding + border see css style
			var popMargTop = ($(loginBox).height() + 24) / 2;
			var popMargLeft = ($(loginBox).width() + 24) / 2;

			$(loginBox).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="mask"></div>');
			$('#mask').fadeIn(300);
			return false;
		});

		// When clicking on the button close or the mask layer the popup closed
		$('a.close').click(function() {
			$('#mask , .login-popup').fadeOut(300, function() {
				$('#mask').remove();
			});
			return false;
		});
		
	});
</script>
</head>
<body>
	<a href="#login-box" class="login-window">Login / Sign In</a>
	<div id="login-box" class="login-popup">
				<form method="post" class="signin" action="#">
			<fieldset class="textbox">
				<label class="username"> <span>Username or email</span> <input
					id="otp" name="otp" value="" type="text"
					autocomplete="on" placeholder="mã OTP">
<!-- 				</label> <label class="password"> <span>Password</span> <input -->
<!-- 					id="password" name="password" value="" type="password" -->
<!-- 					placeholder="Password"> -->
<!-- 				</label> -->
				<button class="submit button" type="button">Sign in</button>
<!-- 				<p> -->
<!-- 					<a class="forgot" href="#">Forgot your password?</a> -->
<!-- 				</p> -->
			</fieldset>
		</form>
	</div>
</body>
</html>