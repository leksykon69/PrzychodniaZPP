(function($){
	if(typeof $ === "undefined"){
		require(['lib/jquery.min'],function($){
			return $;
		});
	} else {
		return $;
	}
})(window.jQuery);