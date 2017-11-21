<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>商品列表页</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/goods-list.css" />
		<link rel="stylesheet" type="text/css" href="../newFile/css/kkpager_blue.css" />
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
		</div>

		<div id="search">
			<div>
				<img src="../newFile/images/logo.png" />
				<div>
					<input type="text" id="name" name="" placeholder="请输入想要搜索的商品名/类别名" />
					<button id="select">搜索</button>
				</div>
			</div>
		</div>
		<%@ include file = "/newFile/html/menu.jsp"%>
		<div id="main">
			<ul id="private-msg">
			
			</ul>
			
			<ul id="kkpager">

			</ul>
		</div>
	</div>
	<footer>
		<div>
			<a href="javascript:;">法律声明及隐私权政策</a> | 
			<a href="javascript:;">知识产权</a>
	 		<p>© 2017 shiqiang.com 版权所有</p>
		</div>
	</footer>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../newFile/js/kkpager.min.js"></script>
<script type="text/javascript">
	// 分页查询
	var pageBean;
	$(function(){
		$("#select").click(function(){
			serchList($("#name").val());
		});
		if("${serchName}")
		{
			$("#name").val("${serchName}");
			$("#select").click();
		}
		else
		{
			$("#select").click();
		}
		
	});
	function serchList(value)
	{
		 $.post("./select.do",{pageNo:1,pageSize:9,selectName:value},function(data){
		    	if(data.error.code == 0) return alert("系统出现了未知错误，请联系管理员！！！");
		    	if(data.error.code == 1){
		    		console.log(data);
		    		forEach(data);
		    		pageBean = {"total":data.data.pa,"totalRecords":data.data.totalCount};
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
		    		        	$.post("./select.do",{pageNo:n,pageSize:5,selectName:value},function(data){
		    		        		console.log(data);
		    		        		forEach(data);
		    		            })
		    		            this.selectPage(n);
		    		            return false;
		    		        }
		    		    });
		    	}
		    	
		    	function forEach(data){
		    		var html = '';
		    		for(var i = 0;i < data.data.result.length;i++)
		    		{
		    			html += '<li>';
		    			html += '<a href="../goods/detail.do?id=' + data.data.result[i].id + '">';
						html += '<dl>';
						html += '<dt><img src="../file/readImgTwo.do?imageId=' + data.data.result[i].imagePath[0].id + '"></dt>'
						if(data.data.result[i].basicUnit == 0)
						{
							html += '<dd><span>￥' + data.data.result[i].price + '/天' + '</span></dd>';
						}
						
						if(data.data.result[i].basicUnit == 1)
						{
							html += '<dd><span>￥' + data.data.result[i].price + '/月' + '</span></dd>';
						}
						if(data.data.result[i].basicUnit == 2)
						{
							html += '<dd><span>￥' + data.data.result[i].price + '/年' + '</span></dd>';
						}
						html += '<dd>' + data.data.result[i].user.userName + '</dd>';
						html += '<dd>' + data.data.result[i].name + '</dd>';
						html += '</dl>';
						html += '</a>';
						html += '</li>';
		    		}
		    		$("#private-msg").html(html);
		    	}
		    });
	}
   

</script>
</html>