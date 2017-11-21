<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>租赁网首页</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/index.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/animate.min.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/swiper-3.3.1.min.css" />
	<style type="text/css">
		html,body,div,ul,li,p,input,button,img,ol,dl,dt,dd,h1,h2,h3,h4,h5,h6,section{
			margin:0;
			padding:0;
			list-style: none;
		}
		.myGoodsList{
			margin-left: 10%;
		}
		.myGoodsList li{
			float: left;
			width: 80%;
			margin: 0 auto;
			border-bottom: 1px solid #454545;
			position: relative;
			background: #a1a1a1;
		}
		.myGoodsList li:nth-child(odd){
			background: #f2f2f2;
		}
		.myGoodsList li>img{
			width: 100px;
			height: 100px;
			float: left;
		}
		.myGoodsList li>p{
			line-height: 50px;
		}
		.myGoodsList li>span{
			position: absolute;
			right: 100px;
			top: 45px;
			font-size: 20px;
			color: #f00;
		}
		.myGoodsList li>a{
			position: absolute;
			right: 0;
			top: 40px;
			color: #fff;
    		background-color: #337ab7;
    		border-color: #2e6da4;
    		padding:5px;
    		cursor: pointer;
		}
		.myGoodsList li>a.xg{
			right: 50px;
		}
	</style>
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
		</div>
		
		<%-- <div id="nav">
			<ul>
				<li><a href="javascript:;">首页</a></li>
				<li><a href="javascript:;">我要求租</a></li>
				<li><a href="javascript:;">我要出租</a></li>
				<li>
					<a href="javascript:;"><span class="iconfont">&#xe672;</span> 购物车</a>
				</li>
				<li><a href="../message/about.do">关于我们</a></li>
			</ul>
		</div>--%>
		<%@ include file = "/newFile/html/menu.jsp"%>
	<ul  class="myGoodsList">
		<c:forEach var="myGoods" items="${myGoodsList }">
			<li>
				<img src="/leasplat/file/readImgTwo.do?imageId=${myGoods.imageId}">
				<p>${myGoods.name }</p>
				<p>${myGoods.goodsMessage }</p>
				<c:if test="${myGoods.basicUnit == 0 }">
					<span class="rt">${myGoods.price }元/日</span>
				</c:if>
				<c:if test="${myGoods.basicUnit == 1 }">
					<span class="rt">${myGoods.price }元/日</span>
				</c:if>
				<c:if test="${myGoods.basicUnit == 2 }">
					<span class="rt">${myGoods.price }元/日</span>
				</c:if>
				<a class="xg" href="/leasplat/goods/edit.do?id=${myGoods.id }">修改</a>
				<a class="private-delete" onclick="deleteGoods(${myGoods.id })">删除</a>
			</li>
		</c:forEach>	
	</ul>
	<div class="return-top">
		<img src="../newFile/images/arr.png" />
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
<script type="text/javascript">
// /leasplat/goods/delete.do?id=${myGoods.id }
	function deleteGoods(id)
	{
		$.post("./delete.do", {id,id}, function(data){
			if(data.error.code == 1)
			{
				alert("删除成功");
				return window.location.href = "../goods/myList.do";
			}
			else
			{
				alert(data.error.reason);
			}
		});
	}
</script>
</html>