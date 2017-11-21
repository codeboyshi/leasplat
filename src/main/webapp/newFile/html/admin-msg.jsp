<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>留言板管理</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont2/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont3/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/kkpager_blue.css" />
	<style type="text/css">
		html,body,div,ul,li,p,input,button,img,ol,dl,dt,dd,h1,h2,h3,h4,h5,h6,section{
			margin:0;
			padding:0;
		}
		li{
			list-style:none;
		}
		a{
			text-decoration:none;
		}
		img{
			border:0;
		}

		html{
			width:100%;
			height:100%;
		}
		body{
			background:#E1DFDD;
			height:100%;
			width:100%;
		}
		#box{
			width:100%;
			height:100%;
		}

		#nav{
			width:200px;
			position:absolute;
			background:#E1DFDD;
			height:100%;
		}
		#nav li{
			height:65px;
			width:150px;
			padding:0 20px 0 30px;
			text-align:left;
		}
		#nav li a{
			color:#666;
			line-height:60px;
			vertical-align:top;
		}
		#nav li a i{
			width:45px;
			float:left;
		}
		#nav .open{
			background:#FFF;
		}
		#nav .open a{
			color:#C71220;
		}
		#box .leave{
			color:#FFF;
			margin-left:20px;
		}
		#box .leave:hover{
			color:#C71220;
		}

		#main{
			height:100%;
			width:100%;
			margin-top:30px;
		}
		#box #container{
			height:100%;
			width:100%;
			background:#FFF;
		}
		#container .ctx{
			margin:0 50px 0 250px;
			padding-top:65px;
		}
		#container .search{
			padding:10px;
			float:left;
			box-shadow:0px 0px 3px 3px #ccc;
			width:100%;
		}
		#container .search .group{
			margin:10px 0;
			float:left;
			width:50%;
		}
		#container .search .group label{
			width:30%;
			text-align:right;
			display:inline-block;
		}
		#container .search .group input{
			width:60%;
			height:35px;
			border:0;
			outline:0;
			border:1px solid #ccc;
			border-radius:5px;
		}
		#container .search .btn-group{
			width:100%;
			text-align:center;
			float:left;
			padding-top:10px;
		}
		#container .search .btn-group div{
			display:inline-block;
			width:80px;
			height:40px;
			outline:0;
			cursor:pointer;
			line-height:40px;
			text-align:center;
			font-weight:900;
			border-radius:5px;
		}
		#container .search .btn-group .search-btn:active{
			box-shadow:0px 0px 1px 1px blue;
		}
		#container .search .btn-group .reset-btn:active{
			box-shadow:0px 0px 1px 1px gray;
		}
		#container .result{
			float:left;
			width:100%;
			padding:10px;
			box-shadow:0px 0px 3px 3px #ccc;
			margin-top:30px;
		}
		#container .result table{
			border-collapse:collapse;
			min-width:100%;
			background:#D6E9F0;
		}
		#container .result table tr td,#container .result table tr th{
			height:30px;
			border:1px solid #FFF;
			padding:5px 8px;
			border-radius:3px;
			width:700px;
		}
		#container .result table tr th{
			background:#67AAED;
		}
		#container .result table .btn{
			height:40px;
			width:80px;
			cursor:pointer;
			display:inline-block;
			line-height:40px;
			text-align:center;
			border-radius:5px;
			color:#FFF;
		}
	</style>
</head>
<body>
	<div id="box">
		<!--
		<div style="height:130px;background:url(../images/x3.jpg) no-repeat 0 0;
			background-size:cover;">
			<img src="../images/1.png" style="height:100px;margin-top:15px;padding-left:30px;"/>
			<div style="float:right;margin-right:100px;line-height:45px;font-size:14px;">
				<p style="display:inline-block;color:#FFF;">欢迎您， <span style="color:#C71220;">admin</span>。</p>
				<a class="leave" href="javascript:;"><i class="iconfont">&#xe67d;</i> 退出</a>
			</div>	
		</div>
		  -->
		<div id="main">
			<%@include file="/newFile/html/adminMenu.jsp" %>
			<!-- <ul id="nav">
				<li class="open"><a href=""><i class="iconfont" style="font-size:25px;">&#xe62e;</i> 用户管理</a></li>
				<li class=""><a href=""><i class="iconfont" style="font-size:25px;">&#xe61f;</i> 商品类别管理</a></li>
				<li class=""><a href=""><i class="iconfont" style="font-size:30px;">&#xe60d;</i> 通知管理</a></li>
				<li class=""><a href=""><i class="iconfont" style="font-size:40px;">&#xe66f;</i> 留言板管理</a></li>
			</ul> -->
			<div id="container" style="overflow:auto;">
				<div class="ctx">
					<div class="result" style="overflow-y:scroll;height:380px;">
						<div style="width:100%;overflow-x:auto;">
							<table>
								<tr>
									<th>名称</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
								<tbody id="bodyMsg">
									
								</tbody>
							</table>
							<ul id="kkpager">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../newFile/js/kkpager.min.js"></script>
 <script type="text/javascript" src="../newFile/js/admin.js"></script>
<script type="text/javascript">
var pageBean;
$(function(){
	serchList();
	
});
function serchList()
{
	$.post("../message/select.do",{pageNo:1,pageSize:5},function(data){
		console.log(data)
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
}
function forEach(data){
	console.log(data.data[0].result.length)
	var html = '';
	for(var i = 0;i < data.data[0].result.length;i++)
	{
		html += '<tr>';
		html += '<td nowrap="">' + data.data[0].result[i].message + '</td>';
		var date = (new Date(data.data[0].result[i].createTime));
		
		html +=	'<td>' + (1900+date.getYear()) + '年' + (date.getMonth() + 1) + '月' + date.getDate() + '日' + '' + '</td>';
		html += '<td>';	
		html += '<div class="btn" style="background:#E10000;" onclick = "deleteG(' + data.data[0].result[i].id + ')"><i class="iconfont"></i>删除</div>';	
		html += '</td>';
		html += '</tr>';
	}
	$("#bodyMsg").html(html);
}

function deleteG(id)
{
	$.post("../message/delete.do",{id:id},function(data){
		if(data.error.code == 1)
		{
			alert("删除成功");
			return window.location.reload();
		}
		else
		{
			alert(data.error.reason);
		}
	});
}
</script>
</html>
