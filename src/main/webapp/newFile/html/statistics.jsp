<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>用户统计分析</title>
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont2/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="../newFile/iconfont3/iconfont.css" />
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
			margin-top:0px;
		}
		#container .result #private-echar{
			border-collapse:collapse;
			min-width:100%;
			background:#D6E9F0;
		}
		#container .result{
			height:500px;
		}
		#container .result #private-echar{
			background:#67AAED;
		}
		#container .result #private-echar{
			height:470px;
			width:80px;
			cursor:pointer;
			display:inline-block;
			line-height:40px;
			text-align:center;
			border-radius:5px;
			color:#FFF;
		}
		#title{
			height:60px;
			width:1000px;
			line-height:60px;
			font-size:40px;
			font-weight:900;
			text-align:center;
			background:#339966;
			color:#333;
			margin:0 auto;
		}
		#container{
			width:1200px;
			height:600px;
			margin:0 auto;
		}
	</style>
</head>
<body>
<div id="box">
	<div id="main">
		<%@include file="/newFile/html/adminMenu.jsp" %>
			<div id="container">
					<div class="ctx">
						<div class="result">
							<div style="width:100%;overflow-x:auto;">
								<div id="title">5年内总注册人数：<span id="peopleCount"></span>人</div>
								<div id="private-echar"></div>
							</div>
						</div>
					</div>
			</div>
	</div>
</div>
</body>
<script type="text/javascript" src="../newFile/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../newFile/js/echarts.js"></script>
<script type="text/javascript" src="../newFile/js/admin.js"></script>
<script type="text/javascript">
var myChart = null;
$(function () {
		 var dom = document.getElementById("private-echar");
         myChart = echarts.init(dom);
         var app = {};
         var option = null;
         option = {
             color : ["#FFDF25","#FF9900"],
             title : {
                 text: '',
                 subtext: ''
             },
             tooltip : {
                 trigger: 'axis'
             },
             calculable : true,
             xAxis : [
                 {
                     type : 'category',
                    // data : ['2013','2014','2015','2016','2017']
                 	 data:[]
                 }
             ],
             yAxis : [
                 {
                     type : 'value'
                 }
             ],
             series : [
                 {
                     name:'注册人数',
                     type:'bar',
                     barWidth: '25%',
                    // data:[122, 135, 213, 156, 167]
                 	 data:[]
                 }
             ]
         };
         findRegCount(option);
	});
	function findRegCount(option)
	{
		$.post("../count/regMsg.do",null,function(data){
			option.xAxis[0].data = data.data.years;
			option.series[0].data = data.data.yearCount;
			var count = 0;
			for(var i = 0;i < 5;i++)
			{
				count += data.data.yearCount[i];
			}
			$("#peopleCount").text(count);
			toEchart(myChart,option);
		});
	}
	         
	function toEchart(chart, option)
    {
        if (option && typeof option === "object") {
            chart.setOption(option, true);
        }
    }
			
		
</script>
</html>