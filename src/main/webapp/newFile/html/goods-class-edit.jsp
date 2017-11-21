<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>商品类别管理</title>
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
			text-align:center;
			border-radius:3px;
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
		<div id="main">
			<%@include file="/newFile/html/adminMenu.jsp" %>
			<div id="container">
				<div class="ctx">
					<div class="search">
						<div class="group">
							<label>名称：</label>
							<input type="text" name="" id="name" value="${goodsClass.name }"/>
							<input type="hidden" name="id" id="id" value="${goodsClass.id }">
						</div>
						<div class="btn-group">
							<div class="search-btn" id="update" style="background:blue;color:#FFF;"><i class="iconfont">&#xe61b;</i>修改</div>
							<div class="search-btn" id="private-return" style="background:blue;color:#FFF;"><i class="iconfont">&#xe601;</i>返回</div>
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
	$(".private-n1 li").eq(1).addClass('open');
	$(function(){
		$("#update").click(function () {
			var name = $("#name").val();
			var id = $("#id").val();
			if(!name) return alert("名称不能为空");
			$.post("../goodsclass/update.do",{id:id,name:name},function(data){
				console.log(data)
				if(data.error.code == 1)
				{
					alert("修改成功");
					return window.location.href = '../goodsclass/list.do';
				}
				else
				{
					alert(data.error.reason);
				}
			});
		});
		
		$("#private-return").click(function(){
			window.history.go(-1);
		});
	});
 </script>
</html>
