$(function(){
	var mySwiper = new Swiper('.swiper-container', {
        autoplay : 2000,//可选选项，自动滑动
        pagination : '.swiper-pagination',
        prevButton : '.swiper-button-prev',
        nextButton : '.swiper-button-next',
        autoplayDisableOnInteraction : false,
        effect : 'fade',
        paginationClickable :true,
        loop : true
    });

    $("#login .register").on({
    	"click" : function(){
    		if($("#login .reg").css("display") == "list-item"){
    			$("#login .reg").hide();
    			$("#login .sanjiao").hide();
    			return;
    		}
    		$("#login .log").hide();
    		$("#login .reg").show();
    		$("#login .sanjiao").show().css("left","94px");//94
    	}
    });
    $("#login .login").on({
    	"click" : function(){
    		console.log(213);
    		if($("#login .log").css("display") == "list-item"){
    			$("#login .log").hide();
    			$("#login .sanjiao").hide();
    			return;
    		}
    		$("#login .reg").hide();
    		$("#login .log").show();
    		$("#login .sanjiao").show().css("left","162px");//162
    	}
    });
    $(window).scroll(function(){
    	if($(this).scrollTop() > 200){
    		$(".return-top").show();
    	}else{
    		$(".return-top").hide();
    	}
    });
    $(".return-top").click(function(){
    	$("body,html").animate({"scrollTop":"0px"},600);
    });
});