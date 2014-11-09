<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/kiemtrave.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:100%;height:600px;">
<div style="width:100%;height:40px;background:#145CA1;font-size:30px;color:white;margin-top:10px;">Kiểm tra vé</div>
<div class="kiemtrave kt-ve">
    <div class="kt-ve pd mg" id="ktve">
    	
<form action="#" > 
       	<fieldset>
                <div class="kt-ve">
                	<div class="ktve-p pd mg kt-ve">
                        <p>Vui lòng nhập chính xác mã vé và số điện thoại quý khách dùng để mua vé.</p>
                        <div class="ktve-dong kt-ve">
                            <label class="wd-110 fl-l">Điện thoại <strong>*</strong></label>
                            <input class="input-txt wd-240" name="sodienthoai" type="text" value="">
                        </div>
                        <div class="ktve-dong kt-ve">
                            <label class="wd-110 fl-l">Mã vé <strong>*</strong></label>
                            <input class="input-txt wd-240" name="mave" type="text" value="">
                        </div>
                        <div class="ktve-dong kt-ve">
                            <label class="wd-110 fl-l">&nbsp;</label>
                            <input class="timve fl-l" type="submit" value="Kiểm tra" >
                        </div>
                        
                    </div>
                    
                </div>               

	        </fieldset>
</form>    </div>
</div>
        </div>
<%@ include file="footer.jsp" %>
</body>
</html>