function set(item) {
	item.mouseleave(function() {
		unselected($(this));
	});
	item.mouseenter(function() {
		selected($(this));
	});
	item.click(function() {
		choose($(this));
	});
}

function selected(el) {
	var newSrc = "/BanVeXe/image/ghe2.png";
	$(el).attr("src", newSrc);
}
function unselected(el) {
	var newSrc = "/BanVeXe/image/ghe1.png";
	$(el).attr("src", newSrc);
}
function choose(el) {
	var idChuyen = $('#idChuyen').val();
	var idGhe = $(el).attr("id");
	$
			.get(
					'ThemGhe',
					{
						idChuyen : idChuyen,
						idGhe : idGhe
					},
					function(responseText) {
						if (responseText.indexOf("ok") != -1) {
							$("#chitietve")
									.load("/BanVeXe/jsp/chitietvexe.jsp");
							$(el).unbind("mouseenter");
							$(el).unbind("mouseleave");
							$(el).unbind("click");
							$(el).click(function() {
								unchoose($(el));
							});
							selected($(el));
							return;
						} else {
							if (responseText.indexOf("limited-notlogin") != -1) {
								alert("Quý khách chưa đăng nhập nên chỉ được chọn tối đa 2 vé! Vui lòng đăng nhập để được chon nhiều hơn!");
							} else {
								alert("Quý khách chỉ được chọn tối đa 5 ghế!");
							}
						}
						unselected($(el));
					});

}
function unchoose(el) {
	var idChuyen = $('#idChuyen').val();
	var idGhe = $(el).attr("id");
	$.get('HuyGhe', {
		idChuyen : idChuyen,
		idGhe : idGhe
	}, function(responseText) {
		if (responseText.indexOf("ok") != -1) {
			$("#chitietve").load("/BanVeXe/jsp/chitietvexe.jsp");
			$(el).mouseenter(function() {
				selected($(el));
			});
			$(el).mouseleave(function() {
				unchoose($(el));
			});
			$(el).unbind("click");
			$(el).click(function() {
				choose($(el));
			});
			unselected($(el));
		} else {
			selected($(el));
		}
	});

}

function setSeatOdered(el) {
	var newSrc = "/BanVeXe/image/ghe3.png";
	$(el).attr("src", newSrc);
	$(el).unbind("mouseenter");
	$(el).unbind("mouseleave");
	$(el).unbind("click");
}
function unsetSeatOdered(el) {
	var newSrc = "/BanVeXe/image/ghe1.png";
	$(el).attr("src", newSrc);
	$(el).mouseleave(function() {
		unselected($(this));
	});
	$(el).mouseenter(function() {
		selected($(this));
	});
	$(el).click(function() {
	});
}

