<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.KhachHangThuongXuyen"%>
<%@page import="model.Ve"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kiểm tra vé</title>
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/kiemtrave.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/util.css">
<script src="/BanVeXe/js/jquery-1.11.1.min.js"></script>
<script src="/BanVeXe/js/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/BanVeXe/css/sweet-alert.css">
<link rel="stylesheet" type="text/css" href="/BanVeXe/css/popup.css">
<script>
	function removeReadonly() {
		$('.editable').removeAttr('readonly');
		$(".tv").css("visibility", "visible");
	}
	function addReadonly() {
		$('.editable').attr("readonly", "readonly");
		$(".tv").css("visibility", "hidden");
		$("#form-thongtin").submit();
	}

	function checkEr() {
		if ($("#error").val().length != 0) {
			al($("#error").val(), "error");
		}
		if ($("#success").val().length != 0) {
			al($("#success").val(), "success");
		}
	};
	function al(mes, type) {
		swal({
			title : mes,
			type : type
		});
	}
	$(window).load(function() {
		checkEr();
	});
	function huyVe(mave) {
		swal({
			title : "Bạn có chắc chắn hủy vé?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "Ok",
			cancelButtonText : "Cancel",
			closeOnConfirm : true,
		}, function(isConfirm) {
			if (isConfirm) {
				
				$.get("<%=DuongDan.CHECK_OTP%>", function(data, status) {
					if (status == "success") {
						if (data == "ok") {
							var loginBox = $("#login-box");

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

							$("#mave").val(mave);

							$('a.close').click(
									function() {
										$('#mask , .login-popup').fadeOut(300,
												function() {
													$('#mask').remove();
												});
										return false;
									});
							$('#mask').click(
									function() {
										$('#mask , .login-popup').fadeOut(300,
												function() {
													$('#mask').remove();
												});
										return false;
									});
						}
					}
				});

			}
		});
	};
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 200) {
				$(".autoScroll").animate({
					top :10
				},0, function() {
					
				});
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
	<div style="width: 100%; height: 1000px;">
		<div class="bg title">
			<marquee behavior="alternate" width="10%">>></marquee>
			Kiểm tra vé
			<marquee behavior="alternate" width="10%"> << </marquee>
		</div>
		<div class="center">
			<div id="left">
				<img id="imgleft" class="autoScroll" alt="left"
					src="/BanVeXe/image/cau-doi-l.png" />
			</div>
			<div id="bodys">
				<div class="kiemtrave kt-ve">
					<div class="kt-ve pd mg" id="ktve">
						<%
							KhachHang kh = (KhachHang) session.getAttribute("khachHang");
							String user = "";
							String sdt = kh.getSdt();
							String tenDangKi = kh.getTenKhachHang();
							String email = kh.getEmail();
							String cmnd = kh.getCmnd();
							String diaChi = kh.getDiaChi();
							long soTien = ((KhachHangThuongXuyen) kh).getSoTien();
							List<Ve> listVe = kh.getDanhSachVeDaDat();
							//
							Locale here = request.getLocale();
							NumberFormat cf = NumberFormat.getCurrencyInstance(here);
							cf.setMaximumFractionDigits(0);
							cf.setMinimumFractionDigits(0);
						%>

						<%
							String mes = "";
							if ((String) request.getAttribute("mes") != null)
								mes = (String) request.getAttribute("mes");
							String mesSuccess = "";
							if ((String) request.getAttribute("mesSuccess") != null)
								mesSuccess = (String) request.getAttribute("mesSuccess");
						%>
						<input type="hidden" value="<%=mes%>" id="error" /> <input
							type="hidden" value="<%=mesSuccess%>" id="success" />

						<form action="/BanVeXe/SuaThongTin" id="form-thongtin"
							method="post" accept-charset="UTF-8">
							<fieldset>
								<div class="kt-ve">
									<div class="ktve-p pd mg kt-ve">
										<p>Thông tin cá nhân</p>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Tên Khách hàng:</label>
											<%-- 									<textarea rows="10" cols="100"><%=tenDangKi %></textarea> --%>
											<input class="input-txt editable wd-240" name="name"
												type="text" readonly value="<%=tenDangKi%>">
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Địa chỉ Email:</label> <input
												class="input-txt editable wd-240" readonly name="email"
												type="text" value=<%=email%>>
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Số điện thoại:</label> <input
												class="input-txt editable wd-240" readonly name="sdt"
												type="text" value=<%=sdt%>>
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Số dư trong tài khoản:</label> <input
												class="input-txt wd-240" readonly name="sdt" type="text"
												value="<%=cf.format(soTien)%>">
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Số Cmnd:</label> <input
												class="input-txt editable wd-240" name="cmnd" type="text"
												readonly value=<%=cmnd%>>
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">Địa chỉ:</label> <input
												class="input-txt editable wd-240" readonly name="diachi"
												type="text" value="<%=diaChi%>">
										</div>
										<div class="ktve-dong kt-ve">
											<label class="wd-110 fl-l">&nbsp;</label> <input
												class="timve fl-l" type="button" value="Sửa thông tin"
												onclick="removeReadonly()"> <input
												class="timve tv fl-l" type="button" value="Cập nhật"
												style="visibility: hidden" onclick="addReadonly()">
										</div>
										<a href="/BanVeXe/jsp/DoiMatKhau.jsp">Đổi mật khẩu</a>

									</div>

								</div>
								<hr />
								<div class="kt-ve">
									<div class="ktve-p pd mg kt-ve">
										<div id="thongtinve">
											<p>Thông tin vé đã đặt</p>
										</div>
										<div id="timkiem">
											<input type="text" id="text_timkiem" /> &nbsp; <input
												type="image" src="/BanVeXe/image/search1.png"
												style="margin-top: 5px; margin-left: 5px;">
										</div>
										<div></div>
										<table id="ktv">

											<tr id="dong1" class="bg">
												<td class="tr1" align="center">Chuyến xe</td>
												<td class="tr1" align="center">Giờ xuất phát</td>
												<td class="tr1" align="center">Giá vé</td>
												<td class="tr1" align="center">Loại ghế</td>
												<td class="tr1" align="center">Loại xe</td>
												<td class="tr1" align="center">Mã ghế</td>
												<td class="tr1" align="center">Thanh toán</td>
												<td class="tr1" align="center">Khởi hành</td>
											</tr>

										</table>
										<div id="divroll">
											<table id="ktv">

												<%
													for (Ve v : listVe) {
												%>
												<tr id="dong2">
													<td class="tr1" align="center"><%=v.getTuyenXe()%></td>
													<td class="tr1" align="center"><%=v.getNgayKhoiHanh()%></td>
													<td class="tr1" align="center"><%=cf.format(v.getTongTien())%></td>
													<td class="tr1" align="center"><%=v.getLoaiGhe()%></td>
													<td class="tr1" align="center"><%=v.getLoaiXe()%></td>
													<td class="tr1" align="center"><%=v.getTenGhe()%></td>
													<td class="tr1" align="center">
														<%
															if (!v.isTrangThaiThanhToan()) {
														%> <a
														href="/BanVeXe/ThanhToan?mave=<%=v.getMaVe()%>&pageFoward=KiemTraVe"><%=v.getTrangThaiThanhToan()%></a>
														<%
															} else {
														%> <%=v.getTrangThaiThanhToan()%> <%
 	}
 %>
													</td>
													<td class="tr1" align="center"><%=v.getTrangThaiKhoiHanh()%>
														<%
															if (v.isTrangThaiThanhToan() && !v.isDaKhoiHanh()) {
														%> <a href="#" style="font-size: 9px;"
														onclick="huyVe('<%=v.getMaVe()%>')">Hủy vé</a> <%
 	}
 %></td>

												</tr>
												<%
													}
												%>
											</table>
										</div>
									</div>
								</div>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="right">
			<img id="imgright" class="autoScroll" alt="right"
				src="/BanVeXe/image/cau-doi-r.png" />
		</div>
	</div>


	<div id="login-box" class="login-popup">
		<a href="#" class="close"><img src="/BanVeXe/image/close.jpg"
			class="btn_close" title="Close Window" alt="Close" /></a>
		<form id="formhuyve" method="post" class="signin"
			action='<%=DuongDan.HUYVE%>'>
			<fieldset class="textbox">
				<input type="hidden" id="mave" value="" name="mave" /> <label>
					<span id="lb-otp">Nhập mã OTP</span> <input id="otp" name="otp"
					value="" type="text">
				</label> <input type="submit" value="Xác nhận" id="xn-otp" />
				<p>
					<a class="forgot" href="#">Gửi lại mã OTP</a>
				</p>
			</fieldset>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>