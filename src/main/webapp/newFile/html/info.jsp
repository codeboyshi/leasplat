<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>出租方完善信息</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/css/inf.css">
</head>
<body>
	<div id="box">
		<header><a href="javascript:;"></a></header>
		<div id="login">
			
			</div>
		</div>
		<%@ include file = "/newFile/html/menu.jsp"%>
		<div id="infor">
			<div>
				<h3>请完善您的信息</h3>
				<form id="form">
					<ul>
						<li class="form-group">
							<label>手机号：</label>
							<input type="text" name="phone" id="phone">
						</li>
						<li class="form-group">
							<label>密保问题：</label>
							<input type="text" name="security">
						</li>
						<li class="form-group">
							<label>密保答案：</label>
							<input type="text" name="secretAnswer">
						</li>
						<li class="form-group">
							<label>性别：</label>
							<select name="userSex" style="width: 290px;height: 30px;border: 0;border-radius: 5px;outline: 0;border: 1px solid #333;padding-left: 10px;">
								<option value="0">男</option>
								<option value="1">女</option>
							</select>
						</li>
					</ul>
					<input type="button" id="private-save" value="确认">
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript">
		$("#private-save").click(function(){
			var phone = $("#phone").val();
			if(!phone) return alert("手机号不能为空");
			$.post("../user/info.do",$("form").serialize(),function(data){
				console.log(data);
				if(data.error.code == 1)
				{
					alert("信息完善成功");
					window.location.href="../user/toLogin.do";
				}
				else
				{
					alert(data.error.reason);
				}
			});
		});
</script>
</html>