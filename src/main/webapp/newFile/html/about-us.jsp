<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>关于我们</title>
	<link  rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/about-us.css">
	<link rel="stylesheet" type="text/css" href="../newFile/css/kkpager_blue.css" />
	<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
	<style>
		<!--隔行变色 -->
	  	#private-message li:nth-of-type(odd){
	  		background : #E5EAEE;
	  		
	  	}
	  	
	  	#private-message li:nth-of-type(even){
	  		background : #ddd;
	  		
	  	}
	</style>
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
			<div>
				<p>
					<%--<a class="register" href="javascript:;">注册</a>--%>
					<span>${sessionScope.userAccount }</span>
					<%-- <a class="login" href="javascript:;">登录</a>
					<a href="javascript:;">我的出租单</a>
					<a href="javascript:;">业务咨询</a>--%>
				</p>
				<%--<form> 
					<span class="iconfont sanjiao">&#xe62d;</span>
					<ol>
						<li class="reg"> 
                            <h3>新用户注册 <i class="iconfont">&#xe697;</i></h3>
                            <div class="form-group">
                                <label>用户名：</label>
                                <input type="text" />
                            </div>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password"/>
                            </div>
                            <div class="form-group">
                                <label>确认密码：</label>
                                <input type="password"/>
                            </div>
                            <button>注册</button>
						</li>
						<li class="log"> 
                            <h3>登录 <i class="iconfont" style="font-size:20px;">&#xe600;</i></h3>
                            <div class="form-group">
                                <label>用户名：</label>
                                <input type="text" />
                            </div>
                            <div class="form-group">
                                <label>密码：</label>
                                <input type="password"/>
                            </div>
                            <div class="form-group check-code">
                                <label>验证码：</label>
                                <input type="text"/>
                                <img src="../images/yanzhengma.jpg" />
                            </div>
                            <p><input type="checkbox" checked name=""> 您登录表示您同意我们的服务条款</p>
                            <button>登录</button>
						</li>
					</ol>
				</form>--%>
			</div>
		</div>
		<%-- <div id="nav">
			<ul>
				<li><a href="javascript:;">首页</a></li>
				<li><a href="javascript:;">我要求租</a></li>
				<li><a href="javascript:;">我要出租</a></li>
				<li>
					<a href="javascript:;"><span class="iconfont">&#xe672;</span> 购物车</a>
				</li>
				<li><a href="javascript:;" style="float:left;">关于我们</a></li>
			</ul>
		</div>
		--%>
		<%@ include file = "menu.jsp"%>
		<div id="web-info">
			<h3>网站信息</h3>
			<section>
				我们是一个良心的第三方交易平台，不涉及任何金融交易环节，对线下同学的交易不负任何责任，所以正式达成租赁协议之前一定要谨慎决定。平台本着服务大家的精神，不收取任何费用，做到信息的无常共享。
			</section>
			<section>
			          我们是一个刚刚出生的平台，自身一定包含着很多的不足与缺点，所以还希望大家可以在下面的评论中指出，我们定当尽最大可能去完善平台。希望大家可以共同见证平台的成长！
			</section>  
		</div>
		<div id="leave-message" style="overflow:hidden">
			<h3>留言板</h3>
			<textarea style="width:1180px;height:60px;resize:none;margin-top:10px;" id = "message"></textarea>
			<button class = "btn btn-primary" style="float:right;margin:10px 0px; font-weight:bold;" id="private-save">发 表</button>
		</div>
		<div id="show-message">
		<div id="private-message">
		
		</div>
		 <%--   <li style="overflow:hidden; border-bottom:1px solid #ddd;padding-bottom:10px;">
	
			 <div class="user-about" style="float:left;height:100px;width:100px;line-height:100px;text-align:center;margin-right:10px;">
			   <div class="user-head" style="display:none;">
			     
			   </div>
			   <div class="user-name" >
			           蒋老大
			   </div>
			 </div>
			 <div class="message" style="float:left;position:relative;width:1065px;height:80px;padding:10px;">
			   <div class="message-details" style="position:relative;float:left;width:1065px;height:80px;overflow:auto;">
			   asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfa
			   a
			   </div>
			   <div class="message-time" style="position:absolute;right:10px;bottom:0px;">
			     time
			   </div>
			 </div>
		   </li>--%>


			<ul id="kkpager">

			</ul>
			
		</div>
		
	</div>
</body>
<script type="text/javascript" src="../newFile/js/kkpager.min.js"></script>
<script type="text/javascript" src="../newFile/js/about-us.js"></script>
<script type="text/javascript">
	$(function () {
		$("#private-save").click(function () {
			var mes = $("#message").val();
			if(!mes) return alert("请填写留言内容");
			$.post("./save.do",{"message":mes},function(data){
				if(data.error.code == 1){
					alert("留言添加成功！！！");
					window.location.reload();
				}else{
					alert(data.error.reason);
				}
			});
		});
	})
</script>
</html>
