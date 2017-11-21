<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>商品详情页</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/goods-detail.css" />
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
			
		</div>
		<%@ include file = "/newFile/html/menu.jsp"%>
		<!-- <div id="nav">
			<ul>
				<li><a href="javascript:;">首页</a></li>
				<li><a href="javascript:;">我要求租</a></li>
				<li><a href="javascript:;">我要出租</a></li>
				<li>
					<a href="javascript:;"><span class="iconfont">&#xe672;</span> 购物车</a>
				</li>
				<li><a href="javascript:;">关于我们</a></li>
			</ul>
		</div>
		 -->
		<div id="main">
			<div class="left-info">
				<div class="goods-img">
					<img id="imageMain" src="" />
					<div class="scope"></div>
				</div>
				<div class="goods-img-detail" style="z-index:200;">
					<img src="" />
				</div>
				<div class="img-list">
					<span><</span>
					<div class="all-img">
						<ul>
							<li>
								<img id="image1" src="">
							</li>
							<li>
								<img id="image2" src="">
							</li>
							<li>
								<img id="image3" src="">
							</li>
							<li>
								<img id="image4" src="">
							</li>
						</ul>
					</div>
					<span>></span>
				</div>
			</div>
			<div class="right-info">
				<ul>
					<li><h3 style="font-size:25px;font-family:'微软雅黑';">${goods.name }</h3></li>
					<c:if test="${goods.basicUnit == 0 }">
						<li style="text-indent:20px;"><span>￥${goods.price }元/天</span></li>
					</c:if>
					<c:if test="${goods.basicUnit == 1 }">
						<li style="text-indent:20px;"><span>￥${goods.price }元/月</span></li>
					</c:if>
					<c:if test="${goods.basicUnit == 2 }">
						<li style="text-indent:20px;"><span>￥${goods.price }元/年</span></li>
					</c:if>
					<li style="color:#090138;font-weight:600;text-indent:20px;">出租人姓名：${goods.user.userName }</li>
					<li style="color:#090138;font-weight:600;text-indent:20px;">出租人联系方式：${goods.user.phone }</li>
					<input type="hidden" id="goodsId" value="${goods.id }"/>
					<li><button id="private-save">加入购物车</button></li>
				</ul>
			</div>
			<div class="hot-goods" style="width:380px;float:left;margin-left:20px;">
				<%@include file="/newFile/html/img.jsp" %>
			<!-- 	<ul>
					<li>
						<img src="../images/pingban.jpg" />
					</li>
					<li style="margin-top:10px;">
						<img src="../images/zhaoxiangji.jpg" />
					</li>
				</ul>
				 -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../newFile/js/goods-detai.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#private-save").click(function(){
			var goodsId = $("#goodsId").val();
			$.post("../shop/save.do",{goodsId:goodsId},function(data){
				console.log(data)
				if (data.error.code == 1){
					alert("添加成功");
				}
				else
				{
					alert(data.error.reason);
				}
			});
		});
		
		var imgAttr = [];
		<c:forEach var="goodsImage" items="${goodsImageList}">
			imgAttr.push(${goodsImage.id});
		</c:forEach>
		for (var i = 1;i <= imgAttr.length;i++)
		{
			if (i == 1)
			{
				$("#imageMain").attr("src","../file/readImgTwo.do?imageId=" + imgAttr[0]);
			}
			$("#image" + i).attr("src","../file/readImgTwo.do?imageId=" + imgAttr[i - 1]);
		}
	});
</script>
</html>