function set(item) {
	item.mouseleave(function() {
		unselected($(this));
	});
	item.mouseenter(function() {
		selected($(this))
	});
	item.click(function() {
		checkGhe($(this));
	});
}

function selected(el) {
		var newSrc = "../image/ghe2.png";
		$(el).attr("src", newSrc);
	}
	function unselected(el) {
		var newSrc = "../image/ghe1.png";
		$(el).attr("src", newSrc);
	}
	function choose(el) {
		$(el).unbind("mouseenter");
		$(el).unbind("mouseleave");
		$(el).unbind("click");
		$(el).click(function() {
			unchoose($(el));
		});
	}
	function unchoose(el) {
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
	}
	function checkGhe(el) {
		$.post('../checkGhe', {
			id : $(el).attr('id')
		}, function(data) {
			if (data.indexOf("1") != -1) {
				choose(el);
			} else {
				alert("Ghe da dc dat");
				setSeatOdered(el);
			}
		});
	}
	function setSeatOdered(el) {
		var newSrc = "../image/ghe3.png";
		$(el).attr("src", newSrc);
		$(el).unbind("mouseenter");
		$(el).unbind("mouseleave");
		$(el).unbind("click");
	}