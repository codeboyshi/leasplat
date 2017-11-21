<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--为IE准备的标签-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>校园租赁平台注册界面</title>

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
<header class="navbar navbar-default">
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
                <li><a href="">注册</a></li>
                <li>
                    <a href="" data-toggle="dropdown">登录</a>
                    <div class="dropdown-menu">
                        <div class="login-menu">
                            <form action="login.do" method="post">
                                <h3>登录</h3>
                                <p>您是否在英特尔工作？</p>
                                <div class="form-group form-group-sm">
                                    <label for="uname" class="sr-only"></label>
                                    <input type="text" id="uname" class="form-control" placeholder="用户名"/>
                                </div>
                                <div class="form-group form-group-sm">
                                    <label for="pwd" class="sr-only"></label>
                                    <input type="password" id="pwd" class="form-control" placeholder="密码"/>
                                </div>
                                <div class="form-group form-group-sm">
                                    <label for="yz" class="sr-only"></label>
                                    <input type="text" id="yz" class="form-control" placeholder="验证码" name = "checkCode"/>
                                    <img src="./checkCode.do" alt="">
                                </div>
                                <p>您登录表示您同意我们的服务条款</p>
                                <button type="button" class="btn btn-info btn-xs">登录</button>
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
        <div class="login-menu">
            <form action="save.do" method="post">
                <h3>注册</h3>
                <div class="form-group form-group-sm">
                    <label for="zc-uname" class="sr-only"></label>
                    <input type="text" id="zc-uname" name="userName" class="form-control"maxlength="10" placeholder="用户名"/>
                    <span class="hi">1</span>
                </div>
                <div class="form-group form-group-sm">
                    <label for="zc-pwd" class="sr-only"></label>
                    <input type="password" id="zc-pwd" name="password" class="form-control" placeholder="密码"/>
                    <span class="hi">2</span>
                </div>
                <div class="form-group form-group-sm">
                    <label for="zc-yz" class="sr-only"></label>
                    <input type="password" id="zc-yz" class="form-control" name="repassword" placeholder="确认密码"/>
                    <span class="hi">3</span>
                </div>
                <p>您注册表示您同意本软件的服务条款，希望能为您提供更便利的服务！！！</p>
                <button type="submit" class="btn btn-info">注册</button>
                <button type="button" class="btn btn-info rese">返回</button>
            </form>
        </div>
    </div>
</section>
<%--
<footer class="container">
    <p>我去了啊啊上的爱施德啊上大嫂大嫂的</p>
    <p>我去了啊啊上的爱施德啊上大嫂大嫂的</p>
</footer> 
--%>
<div id="toTop"><img src="../images/arr.png" alt=""></div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery-1.11.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
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
    $(".rese").click(function () {
		window.history.go(-1);
	});
</script>
<script src="../js/bootstrap.js"></script>
</body>
</html>