<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>购物车</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/shopcart.css" />
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
		
		</div>
		<%@ include file = "/newFile/html/menu.jsp"%>
		<div id="main">
		<%--<li class="goods-incart">
					<p class="goods-name">
						无名超贵相机
					</p>
					<div class="goods-img">
						<img src="../images/s1.jpg" />
					</div>
					<p class="pay-day">
						200
					</p>
					<div class="add-sub">
						<i class="iconfont">&#xe643;</i>
						<input type="text" name="">
						<i class="iconfont">&#xe603;</i>
					</div>
					<div class="del">
						删除
					</div>
				</li>
				<li class="goods-incart">
					<p class="goods-name">
						无名超贵相机
					</p>
					<div class="goods-img">
						<img src="../images/s1.jpg" />
					</div>
					<p class="pay-day">
						200
					</p>
					<div class="add-sub">
						<i class="iconfont">&#xe643;</i>
						<input type="text" name="">
						<i class="iconfont">&#xe603;</i>
					</div>
					<div class="del">
						删除
					</div>
				</li>
				<li class="goods-incart">
					<p class="goods-name">
						无名超贵相机
					</p>
					<div class="goods-img">
						<img src="../images/s1.jpg" />
					</div>
					<p class="pay-day">
						200
					</p>
					<div class="add-sub">
						<i class="iconfont">&#xe643;</i>
						<input type="text" name="">
						<i class="iconfont">&#xe603;</i>
					</div>
					<div class="del">
						删除
					</div>
				</li>
				<li class="goods-incart">
					<p class="goods-name">
						无名超贵相机
					</p>
					<div class="goods-img">
						<img src="../images/s1.jpg" />
					</div>
					<p class="pay-day">
						200
					</p>
					<div class="add-sub">
						<i class="iconfont">&#xe643;</i>
						<input type="text" name="">
						<i class="iconfont">&#xe603;</i>
					</div>
					<div class="del">
						删除
					</div>
				</li>
				<li class="goods-incart">
					<p class="goods-name">
						无名超贵相机
					</p>
					<div class="goods-img">
						<img src="../images/s1.jpg" />
					</div>
					<p class="pay-day">
						200
					</p>
					<div class="add-sub">
						<i class="iconfont">&#xe643;</i>
						<input type="text" name="">
						<i class="iconfont">&#xe603;</i>
					</div>
					<div class="del">
						删除
					</div>
				</li> --%>
			<ul>
				<li>
					<p>商品</p>
					<p>租金（元）</p>
					<p>租借时长</p>
					<p>操作</p>
				</li>
				<c:forEach var="shopCar" items="${shopCarList }" varStatus="status">
					<li class="goods-incart private-li${status.index + 1 }">
						<p class="goods-name">
							${shopCar.goods.name }
						</p>
						<div class="goods-img">
							<img src="/leasplat/file/readImgTwo.do?imageId=${shopCar.goodsImageId }" />
						</div>
						<p class="pay-day">
							<c:if test="${shopCar.goods.basicUnit == 0 }">
								${shopCar.goods.price}/天
							</c:if>
							<c:if test="${shopCar.goods.basicUnit == 1 }">
								${shopCar.goods.price}/月
							</c:if>
							<c:if test="${shopCar.goods.basicUnit == 2 }">
								${shopCar.goods.price}/年
							</c:if>
						</p>
						<div class="add-sub">
						<input type="hidden" id="id${shopCar.id }" value="${shopCar.id }">
							<i class="iconfont private-add" onclick="add(${status.index + 1 })" style="cursor:pointer;">&#xe643;</i>
							<input type="text" name="" value="${shopCar.numberOfDays }">
							<i class="iconfont private-reduce" onclick="reduce(${status.index + 1 })" style="cursor:pointer;">&#xe603;</i>
						</div>
						<div class="del">
							<span id="delete" style="cursor:pointer;" onclick="deleteCar(${shopCar.id })">删除</span>
						</div>
					</li>
				</c:forEach>
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
	<!-- <input type="text" name="" style="width:30px;border:0;height:30px;border-radius:50%;text-align:center;line-height:30px;border:1px solid #000;"> -->
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript">

	function deleteCar(id) {
		$.post("../shop/delete.do",{id:id},function(data){
			if(data.error.code == 1)
			{
				alert("删除成功");
				window.location.reload();
			}
			else
			{
				alert(data.error.reason);
			}
		});
	}
	
	// 加
	function add(i)
	{
		var value = parseInt($(".private-li" + i+" input")[1].value);
		//console.log($(".private-li" + i).find("input").val());
		$(".private-li" + i+" input")[1].value=value+1;
		toPost(i)
		//console.log($(".private-li" + i+" input")[0].value);
	}
	
	//减
	function reduce(i)
	{
		var value = parseInt($(".private-li" + i+" input")[1].value);
		if(value <= 1) return;
		$(".private-li" + i+" input")[1].value=value-1;
		toPost(i)
	}
	
	function toPost(i)
	{
		var id = $(".private-li" + i+" input")[0].value;
		var day = $(".private-li" + i+" input")[1].value;
		$.post("../shop/update.do",{day:day,id:id},function(data){
			if(data.error.code == 1)
			{
				console.log(data);
				//window.location.reload();
			}
			else
			{
				alert("出错了，联系管理员吧");
			}
		});
	}
	
</script>
</html>