﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>聊天室</title>
</head>
<body >
<input id="text" type="text"/>
<button onclick="send()">发送</button>
<button onclick="closeWebSocket()">关闭连接</button>
<div id="message">
</div>
 在线人数<span id="onlineCount">1</span>人

</body>
<script type="text/javascript" src="http://localhost:8080/leasplat/newFile/js/jquery-3.0.0.js"></script>
<!-- <script type="text/javascript" src="http://localhost:8080/leasplat/newFile/js/websocket.js"></script> -->
<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/leasplat/websocket.do/1");
    }
    else {
        alert("对不起！你的浏览器不支持webSocket")
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };
    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("加入连接");
    };
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    };
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("断开连接");
    };
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，
    // 防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        var is = confirm("确定关闭窗口？");
        if (is){
            websocket.close();
        }
    };
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        // $("#msg").append(innerHTML+"<br/>")
        console.log(innerHTML);
    };
    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }
    //发送消息
    function send() {
        var message = $("#text").val() ;
        websocket.send(message);
        $("#text").val("") ;
    }
   // function sendMsg(){
       // var msg = ue.getContent();
     //   websocket.send(msg);
        //ue.setContent('');
  //  }
</script>
</html>