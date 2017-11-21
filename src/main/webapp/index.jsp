<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--为IE准备的标签-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>租赁平台主页</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/index.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%--<header class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <!--logo-->
            <a href="index.html" class="navbar-brand logo"><img src="../images/logo.png" alt=""></a>
            <button type="button" data-toggle="collapse" class="navbar-toggle" data-target="#myCollapse">
                <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="myCollapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="reg.do">注册</a></li>
                <li>
                <!--bug: 登陆界面点击任何位置都会消失 -->
                    <a href="" data-toggle="dropdown">登录</a>
                    <div class="dropdown-menu">
                        <div class="login-menu">
                            <form action="login.do" method="post">
                                <h3>登录</h3>
                                <p>您是否在英特尔工作？</p>
                                <div class="form-group form-group-sm">
                                    <label for="uname" class="sr-only"></label>
                                    <input type="text" id="uname" class="form-control" placeholder="用户名" name="name"/>
                                </div>
                                <div class="form-group form-group-sm">
                                    <label for="pwd" class="sr-only"></label>
                                    <input type="password" id="pwd" class="form-control" placeholder="密码" name="password"/>
                                </div>
                                <div class="form-group form-group-sm">
                                    <label for="yz" class="sr-only"></label>
                                    <input type="text" id="yz" class="form-control" placeholder="验证码" name = "checkCode"/>
                                    <img src="./checkCode.do" onclick="src='./checkCode.do?'+Math.random()">
                                </div>
                                <div class="form-group form-group-sm">
                                    <a href="/leasplat/newFile/html/change-password.jsp">忘记密码</a> 
                                </div>
                                <p>您登录表示您同意我们的服务条款</p>
                                <button type="submit" class="btn btn-info btn-xs">登录</button>
                            </form>
                        </div>
                    </div>

                </li>

            </ul>

            <!-- 搜索框-->
            <form action="" class="navbar-form navbar-right">
                <div class="form-group has-feedback">
                    <label for="search" class="sr-only">搜索</label>
                    <input type="text" class="form-control" placeholder="搜索" id="search"/>
                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                </div>
            </form>
        </div>

    </div>
</header>
<section>
    <div class="container">
        <div style="width: 510px;margin: 0 auto;">
            <div class="carousel slide" data-ride="carousel" data-interval="5000" id="banner">
                <div class="carousel-inner ">
                    <div class="item active">
                        <img src="../images/0.jpg" alt=""/>
                    </div>
                    <div class="item"><img src="../images/1.jpg" alt=""/></div>
                    <div class="item"><img src="../images/2.jpg" alt=""/></div>
                    <div class="item"><img src="../images/3.jpg" alt=""/></div>
                    <div class="item"><img src="../images/4.jpg" alt=""/></div>
                </div>
                <ul class="carousel-indicators">
                    <li data-target="#banner" data-slide-to="0" class="active"></li>
                    <li data-target="#banner" data-slide-to="1"></li>
                    <li data-target="#banner" data-slide-to="2"></li>
                    <li data-target="#banner" data-slide-to="3"></li>
                    <li data-target="#banner" data-slide-to="4"></li>
                </ul>
            </div>
            <a href="#banner" class="carousel-control left" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#banner" class="carousel-control right" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
</section>
<section>
    <div class="row">
        <div class="col-xs-3 col-sm-1 col-sm-offset-2">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>主页</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>求租</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>租物</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>留言板</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>租物车</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>忘记密码</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>用户管理</p>
            </a>
        </div>
        <div class="col-xs-3 col-sm-1">
            <a href="">
                <img src="../images/banner_point.png" alt="">
                <p>系统公告</p>
            </a>
        </div>
    </div>
</section>
<nav class="container">
    <div class="row">
        <ul class="list-unstyled">
            <li class="col-xs-5 col-xs-offset-1"></li>
            <li class="col-xs-5"></li>
            <li class="col-xs-5 col-xs-offset-1"></li>
            <li class="col-xs-5"></li>
            <li class="col-xs-5 col-xs-offset-1"></li>
        </ul>
    </div>
</nav>
<footer class="container">
    <p>我去了啊啊上的爱施德啊上大嫂大嫂的</p>
    <p>我去了啊啊上的爱施德啊上大嫂大嫂的</p>
</footer>
<div id="toTop"><img src="../images/arr.png" alt=""></div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery-1.11.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
<script>
    //    (function () {
    //        var s = document.createElement("script");
    //        s.onload = function () {
    //            bootlint.showLintReportForCurrentDocument([]);
    //        };
    //        s.src = "js/bootlint.js";
    //        document.body.appendChild(s)
    //    })();
    $("#toTop").bind("click", function () {
        $('html,body').animate({scrollTop: 0}, 1000);
    });
    
    
    $("#checkCode").click(function reloadImage() {
    	$.post("./checkCode.do"+Math.random(),null,null);
	}
    )
</script>--%>
</body>
<!-- 这个页面作废了，因为另一个主页已经完成了，且里面有很多链接，如果将其提出来需要改动很多，所以
	目前使用这个界面做跳转，根目录访问后跳转这个路径/leasplat/user/toLogin.do
	这个路径是新的首页地址。登录首页也可以直接访问这个地址 -->
<script src="./js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(function(){
		window.location.href = "/leasplat/user/toLogin.do";
	});
</script>
</html>