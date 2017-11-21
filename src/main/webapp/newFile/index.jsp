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
	<link rel="stylesheet" href="../newFile/css/sweetalert2.min.css">
	<link rel="stylesheet" type="text/css" href="../newFile/css/swiper-3.3.1.min.css" />
	
</head>
<body>
	<div id="box">
		<header style="position: relative;">
		<a href="javascript:;"></a>
			<div id="swiper-container" style="padding:10px; width: 600px;height: 50px; position: absolute; left: 50%; top: 50%; margin-left: -310px; margin-top: -35px;  overflow: hidden; line-height: 30px;">
			  	<div class="swiper-wrapper private-msg">
			    	
			  	</div>
			</div>
		</header>
		<div id="login">
			<div>
				<p>
					<span>${sessionScope.userAccount }</span>
					<a class="register" href="javascript:;">注册</a>
					<span>|</span>
					<a class="login" href="javascript:;">登录</a>
					<a href="../goods/myList.do">我的出租单</a>
					<a id="con" href="javascript:;">业务咨询</a>
					<span id="out" style="color: #A8A8A8;cursor:pointer;">退出登录</span>
				</p>
				<form onsubmit="return false;"> 
					<span class="iconfont sanjiao">&#xe62d;</span>
					<ol>
						<li class="reg"> 
                            <h3>新用户注册 <i class="iconfont">&#xe697;</i></h3>
                            <div class="form-group">
                                <label>用户账号：</label>
                                <input type="text" id="userName" placeholder="5-16位字母数字下划线"/>
                                <span id="isOccupy" ></span>
                            </div>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password" id="password" placeholder="5-16位字母数字下划线"/>
                            </div>
                            <div class="form-group">
                                <label>确认密码：</label>
                                <input type="password" id="repassword"/>
                            </div>
                            <button id = "private-save">注册</button>
						</li>
						<li class="log"> 
                            <h3>登录 <i class="iconfont" style="font-size:20px;">&#xe600;</i></h3>
                            <div class="form-group">
                                <label>用户账号：</label>
                                <input type="text" id="uname" name="name"/>
                            </div>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password" id="pwd" name="password"/>
                            </div>
                            <div class="form-group check-code">
                                <label>验证码：</label>
                                <input type="text" id="yz" name = "checkCode"/>
                                <img src="./checkCode.do" onclick="src='./checkCode.do?'+Math.random()" />
                            </div>
                            <div class="form-group">
                            <a href="../newFile/html/change-password.jsp">忘记密码请点我</a>
                            </div>
                            <p><input type="checkbox" checked name=""> 您登录表示您同意我们的服务条款</p>
                            <button id="private-login">登录</button>
						</li>
					</ol>
				</form>
			</div>
		</div>
		
		<div id="search">
			<div>
				<img src="../newFile/images/logo.png" />
				<div>
					<input type="text" id="serchTerm" placeholder="请输入想要搜索的商品名/类别名" />
					<button id="serch">搜索</button>
				</div>
			</div>
		</div>
		<%--
		 <div id="nav">
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
		<div id="banner">
			<div class="swiper-container">
				<div class="swiper-wrapper">
      				<div class="swiper-slide">
						<a href="javascript:;">
							<img src="../newFile/images/s6.jpg" />
						</a>
					</div>
					<div class="swiper-slide">
						<a href="javascript:;">
							<img src="../newFile/images/s7.jpg" />
						</a>
					</div>
					<div class="swiper-slide">
						<a href="javascript:;">
							<img src="../newFile/images/s8.jpg" />
						</a>
					</div>
					<div class="swiper-slide">
						<a href="javascript:;">
							<img src="../newFile/images/s5.jpg" />
						</a>
					</div>
				</div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-button-next"></div>
				<div class="swiper-pagination"></div>
			</div>
		</div>
		<div id="main">
			<h4><i class="iconfont">&#xe616;</i> 最新商品<a href="/leasplat/goods/list.do">查看更多</a></h4>
			<ul id="newGoods">
				
			</ul>
		</div>
	</div>
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
<script type="text/javascript" src="../newFile/js/swiper-3.3.1.min.js"></script>
<script type="text/javascript" src="../newFile/js/swiper.animate1.0.2.min.js"></script>
<script type="text/javascript" src="../newFile/js/index.js"></script>
<script type="text/javascript" src="../newFile/js/sweetalert2.js"></script>
<script type="text/javascript">
// 退出登录
$("#out").click(function(){
	$.post("../user/out.do",null,function(data){
		if (data.error.code == 1)
		{
			window.location.reload();
		}
	});
});
$.post("../notice/list.do",null,function(data){
	var ht = '';
	for(var i = 0;i < data.data.length;i++)
	{
		ht += '<div class="swiper-slide">' + data.data[i].noticeMessage + '</div>';
	}
	$(".private-msg").html(ht);
	index();
});
function index()
{
		var mySwiper = new Swiper('#swiper-container', {
			autoplay : 5000,//可选选项，自动滑动
			direction : 'vertical',
			width : 620,
			effect :  'cube',
			loop : true,
			loopAdditionalSlides : 1
		});
		
		
		$("#serch").click(function(){
			var serchTerm = $("#serchTerm").val();
			if (!serchTerm) return alert("请填写检索条件！");
			window.location.href = "../goods/serch.do?serchName=" + serchTerm;
		});
		$("#con").click(function(){
			alert("请打此电话联系管理员：13091450766");
		});
		$("#userName").blur(function () {
			if(!$("#userName").val()) return;
			var account = $("#userName").val();
			$.post("isOccupy.do",{account : account}, function(data){
				if(data.error.code == 0) 
				{
					$("#isOccupy").attr("style","color:red");
					return $("#isOccupy").text(data.error.reason);
				}
				if(data.error.code == 1){
					$("#isOccupy").attr("style","color:green");
					return $("#isOccupy").text(data.data);
				}
			});
		});
		
		$("#private-save").click(function(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			var repassword = $("#repassword").val();
			if(!userName){
				alert("请输入账号");
				return false;
			}
			
			if(!password){
				alert("请输入密码");
				return false;
			}
			if(!repassword){
				alert("请输入确认密码");
				return false;
			}
			if(password != repassword){
				alert("密码与确认密码不同，请正确填写");
				return false;
			}
			$.post("./save.do",{userName:userName,password:password,repassword:repassword},function(data){
				alert(userName+","+password);
				if(data.error.code == 1){
					swal('注册成功', '', 'success').catch(swal.noop);
					//alert("注册成功");
					setTimeout(function(){
						window.location.reload();
					},3000);
				}
			})
		});
		
		$("#private-login").click(function(){
			var name = $("#uname").val();
			var password = $("#pwd").val();
			var checkCode = $("#yz").val();
			if(!name){
				alert("请输入账号");
				return false;
			}
			
			if(!password){
				alert("请输入密码");
				return false;
			}
			if(!checkCode){
				alert("请输入验证码");
				return false;
			}
			$.post("./login.do",{name:name,password:password,checkCode:checkCode},function(data){
				if(data.error.code == 1){
					console.log("admin",data)
					if (data.data.isAdmin == 1)
					{
						// 做成是否跳转到管理界面
						if(confirm("你的身份为管理员，你确定跳转管理页面么？"))
						{
							return window.location.href = "../user/admin.do";
						}
						return window.location.reload();
					}
					swal('登录成功', '', 'success').catch(swal.noop);
					setTimeout(function(){
						window.location.reload();
					},2000);
					//alert("登录成功");
					//window.location.reload();
				}else{
					alert(data.error.reason);
				}
			});
		});
		
		$.post("../goods/newest.do",null,function(data){
			console.log(data)
			var html = '';
			for(var i = 0;i < data.data.length;i++)
			{

				var url = "../file/readImgTwo.do?imageId=" + data.data[i].imageId;
				    html += '<li>';
					html += '<a href="../goods/detail.do?id=' + data.data[i].id + '">' ;
					html += '<dl>';
					html += '<dt><img src="' + url + '" style = "width:400px;height:388px"></dt>';
							
				if(data.data[i].basicUnit == 0)
				{
					html += '<dd><span>￥' + data.data[i].price + '/天' + '</span></dd>';
				}
				
				if(data.data[i].basicUnit == 1)
				{
					html += '<dd><span>￥' + data.data[i].price + '/月' + '</span></dd>';
				}
				if(data.data[i].basicUnit == 2)
				{
					html += '<dd><span>￥' + data.data[i].price + '/年' + '</span></dd>';
				}
				html +=   '<dd>' + data.data[i].user.userName + '</dd>'
						+ '<dd>' + data.data[i].name + '</dd>'
						+ '</dl>'
					    + '</a>';
					    + '</li>';
				
				// $("#main ul li").eq(i).html(html);
			}
			console.log(html)
			$("#newGoods").html(html);
		});
}

</script>
</html>