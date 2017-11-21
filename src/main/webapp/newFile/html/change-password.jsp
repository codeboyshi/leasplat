<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="../css/change-password.css">
	<link rel="stylesheet" href="../css/sweetalert2.min.css">
	<style>
.swal2-styled{
display:none;
}
</style>
</head>
<body>
	<div id="container">
		<ul class="progress">
			<li>
				<p>1</p>
				<span>登录账号</span>
			</li>
			<li>
				<p>2</p>
				<span>密保问题</span>
			</li>
			<li>
				<p>3</p>
				<span>设置新密码</span>
			</li>
			<li>
				<p>4</p>
				<span>完成</span>
			</li>
		</ul>
		<ol class="content">
			<li>
				<label>账号:</label>
				<input type="text" name="account" id="account"/>
				<a href="javascript:;" id="accountSubmit">确定</a>
			</li>
			<li>
				<label>密保问题:</label>
					<input type="text" name="security" id="security" readonly="readonly" value="${sessionScope.security}"/>
				<%-- <select>
					<option value = "1">我的真实姓名</option>
					<option value = "2">印象最深刻的童年好友的名字</option>
					<option value = "3">小学班主任的名字</option>
				</select>--%>
				<br>
				<label>密保答案:</label>
				<input type="text" name="secretanswer" id = "secretanswer"/>
				<a href="javascript:;" id="secretanswerSubmit">确定</a>
			</li>
			<li>
				<label>设置新密码:</label>
				<input type="password" name="password" id="password"/>
				<label>确认密码:</label>
				<input type="password" name="rePassword" id="rePassword" />
				<a href="javascript:;" id="pwdSubmit">确定</a>
			</li>
			<li>

			</li>
		</ol>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../js/sweetalert2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#container .progress li").on("change",function(){
			var index = $(this).index();
			$(this).children("p").css({"background":"green"});
			$("#container .content li").removeClass("show");
			$("#container .content li").css({"left":0});
			$("#container .content li:not(.show)").css({"top":"350px"});
			$("#container .content li:eq("+index+")").addClass("show");
			setTimeout(function(){
				$("#container .content li:eq("+index+")").animate({"top":"0"},400);
			},100);
		});
		//进入第一步
		$("#container .progress li:eq(0)").change();
		
		//验证账号，成功进入第二步
		$("#accountSubmit").click(function(){
			if($("#account").val()){
				$.post("../../user/forgetPwd.do",{userName:$("#account").val()},function(data){
					if(data.error.code == 1){
						$("#container .progress li:eq(1)").change();
						$("#security").val(data.data);
					}else{
						//console.log(data);
						alert(data.error.reason);
					}
				});
			}else{
				alert("请先输入账号！！！");
			}
		});
		
		//验证密保答案，成功进入第三步
		$("#secretanswerSubmit").click(function(){
			if($("#secretanswer").val()){
				$.post("../../user/check.do",{secretanswer:$("#secretanswer").val()},function(data){
					console.log(data);
					if(data.error.code == 1){
						$("#container .progress li:eq(2)").change();
					}else{
						alert("密保答案错误！！！");
					}
				});
			}else{
				alert("密保答案不能为空");
			}
		});
		
		//密码修改，完成。。。
		$("#pwdSubmit").click(function(){
			if($("#password").val() && $("#password").val() && $("#password").val() == $("#password").val()){
				$.post("../../user/updatePwd.do",{password:$("#password").val()},function(data){
					if(data.error.code == 1){
						$("#container .progress li:eq(3)").change();
						swal('success!', '', 'success').catch(swal.noop);
							setTimeout(function(){
								window.location = "../../user/toLogin.do";
							},2000);
						//window.setTimeout("window.location='../../user/toLogin.do'",2000);
					}else{
						alert(data.error.reason);
					}
				});
			}else if($("#password").val()){
				alert("请输入密码");
			}else if($("#password").val()){
				alert("请输入确认密码");
			}else if($("#password").val() != $("#password").val()){
				alert("密码与确认密码不同");
			}
		});
		
	});
	console.log(18 / 21* 500);
</script>
</html>