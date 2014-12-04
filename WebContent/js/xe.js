function set(item) {
	item.mouseleave(function() {
		unselected($(this));
	});
	item.mouseenter(function() {
		selected($(this));
	});
	item.click(function () {
		choose($(this));
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
	selected($(el));
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

function setSeatOdered(el) {
	var newSrc = "../image/ghe3.png";
	$(el).attr("src", newSrc);
	$(el).unbind("mouseenter");
	$(el).unbind("mouseleave");
	$(el).unbind("click");
}
function unsetSeatOdered(el) {
	var newSrc = "../image/ghe1.png";
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