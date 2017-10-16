(function($){
	var ajax={
			//get请求
			get:function(url,data,callback){
				$.ajax({
					url : url,
					type : "get",
					data : data,
		  			crossDomain:true,
		  			dataType : "json",
		  			xhrFields: {withCredentials: true},
		  			success:callback
				});
			},
			
			//post请求
			post:function(url,data,callback){
				var $loading = $("#loading");
				$.ajax({
					url : url,
					type : "post",
					data : data,
		  			crossDomain:true,
		  			dataType : "json",
		  			xhrFields: {withCredentials: true},
                    beforeSend: function(){
						if(parent.showMask){
                            parent.showMask('mask');
						}
						
						if($loading.length>0){
							$loading.show();
						}

					},
                    complete:function(){
                    	if(parent.hideMask){
                            setTimeout("parent.hideMask('mask')",300);
						}
                    	if($loading.length>0){
							$loading.hide();
						}
					},
		  			success:callback
				}); 
			},


			postAsync:function(url,async,data,callback){
				$.ajax({
					url : url,
					type : "post",
					data : data,
                    async:async,
					crossDomain:true,
					dataType : "json",
					xhrFields: {withCredentials: true},
					success:callback
				});
			}
	};
	window.ajax=ajax;
})(jQuery);