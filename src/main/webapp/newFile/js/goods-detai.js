$(function(){
    $(".goods-img").on({
        "mousemove" : function(e){
            //console.log($(this).offset().left,$(this).offset().top,e.pageX,e.pageY)
            var e = e || window.event;
            var ex = e.pageX - $(this).offset().left - 50;
            var ey = e.pageY - $(this).offset().top  - 50;
            var img_src = $(".goods-img img").attr("src");
            //console.log(ex,ey)
            $(".scope").show().css({
                "left" : Math.max(0,Math.min(200,ex)),
                "top" : Math.max(0,Math.min(200,ey))
            });
            $(".goods-img-detail").show();
            $(".goods-img-detail img").attr("src",img_src).css({
                "left" : -Math.max(0,Math.min(200,ex)) * 3,
                "top" : -Math.max(0,Math.min(200,ey)) * 3
            })
        },
        "mouseleave" : function(e){
            $(".scope").hide();
            $(".goods-img-detail").hide();
        }
    });
    $("#main .all-img ul").css({
    	"width" : $("#main .all-img ul li").length * 92
    });
    $("#main .all-img li").on({
        "click" : function(){
          $("#main .goods-img img").attr("src",$(this).children("img").attr("src"));  
        }
    });
    $("#main .img-list span:eq(0)").on({
        "click" : function(e){
            var e = e || window.event;
            var i = $("#main .all-img li").length;
            var left_now = parseInt($("#main .all-img ul").css("left"));
            if( left_now < 0){
                $("#main .all-img ul").animate({"left" : left_now + 92},200);
            }
        }
    });
    $("#main .img-list span:eq(1)").on({
        "click" : function(e){
            var e = e || window.event;
            var i = $("#main .all-img li").length;
            var left_now = parseInt($("#main .all-img ul").css("left"));
            if(left_now >= 112 * (4 - i)){
                $("#main .all-img ul").animate({"left" : left_now - 92},200);
            }
        }
    });
});