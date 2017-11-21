$(function(){
    $("#login .register").on({
        "click" : function(){
            console.log($("#login .reg").css("display"));
            if($("#login .reg").css("display") == "list-item"){
                $("#login .reg").hide();
                $("#login .sanjiao").hide();
                return;
            }
            $("#login .log").hide();
            $("#login .reg").show();
            $("#login .sanjiao").show().css("left","94px");
        }
    });
    $("#login .login").on({
        "click" : function(){
            if($("#login .log").css("display") == "list-item"){
                $("#login .log").hide();
                $("#login .sanjiao").hide();
                return;
            }
            $("#login .reg").hide();
            $("#login .log").show();
            $("#login .sanjiao").show().css("left","162px");
        }
    });
   
    var pageBean;

    $.post("./select.do",{pageNo:1,pageSize:5},function(data){
    	if(data.error.code == 0) return alert("系统出现了未知错误，请联系管理员！！！");
    	if(data.error.code == 1){
    		console.log(data);
    		forEach(data);
    		pageBean = {"total":data.data[0].pa,"totalRecords":data.data[0].totalCount};
    		 kkpager.generPageHtml({
    		        pno : 1,
    		        //总页码
    		        total : pageBean["total"],
    		        //总数据条数
    		        totalRecords :pageBean["totalRecords"],
    		        //链接前部
    		        //hrefFormer : 'demo',
    		        //链接尾部
    		        //hrefLatter : '.html',
    		        //getLink : function(n){
    		          //  return this.hrefFormer + this.hrefLatter + "?pno="+n;
    		        //}
    		        
    		        lang : {
    		            firstPageText           : '首页',
    		            firstPageTipText        : '首页',
    		            lastPageText            : '尾页',
    		            lastPageTipText         : '尾页',
    		            prePageText             : '上一页',
    		            prePageTipText          : '上一页',
    		            nextPageText            : '下一页',
    		            nextPageTipText         : '下一页',
    		            totalPageBeforeText     : '共',
    		            totalPageAfterText      : '页',
    		            currPageBeforeText      : '当前第',
    		            currPageAfterText       : '页',
    		            totalInfoSplitStr       : '/',
    		            totalRecordsBeforeText  : '共',
    		            totalRecordsAfterText   : '条数据',
    		            gopageBeforeText        : ' 转到',
    		            gopageButtonOkText      : '确定',
    		            gopageAfterText         : '页',
    		            buttonTipBeforeText     : '第',
    		            buttonTipAfterText      : '页'
    		        },
    		        mode : 'click',//默认值是link，可选link或者click
    		        click : function(n){
    		        	$.post("../message/select.do",{pageNo:n,pageSize:5},function(data){
    		        		console.log(data);
    		        		forEach(data);
    		            })
    		            this.selectPage(n);
    		            return false;
    		        }
    		    });
    	}
    });

    function forEach(data){
    	var htm = "";
    	for(var i=0;i<data.data[0].result.length;i++){
    		htm += '<li style="overflow:hidden; border-bottom:1px solid #ddd;padding-bottom:10px;">';
    		htm += '<div class="user-about" style="float:left;height:100px;width:100px;line-height:100px;text-align:center;margin-right:10px;">';
    		htm += '<div class="user-head" style="display:none;"> </div>';
    		htm += '<div class="user-name" >';
    		htm += data.data[1][i] + '</div></div>';
    		htm += '<div class="message" style="float:left;position:relative;width:1065px;height:80px;padding:10px;">' ;
    		htm += '<div class="message-details" style="position:relative;float:left;width:1065px;height:80px;overflow:auto;">';
    		htm += data.data[0].result[i].message + '</div>';
    		htm += '<div class="message-time" style="position:absolute;right:10px;bottom:0px;">';
    		var date = (new Date(data.data[0].result[i].createTime));
    		
    		htm +=	1900+date.getYear()+'年'+(date.getMonth()+1) +'月'+date.getDate()+'日'+'' + '</div></div></li>';
    		
    	}
    	$("#private-message").html(htm);
    	format();
    }
    
    
    function format(){
   		var message = $(".message .message-details").text().length;
      	 if(message<=147){
      		 $(".message .message-details").css({
      			 "line-height":"80px",
      		 });
      	 }
    }
   
});