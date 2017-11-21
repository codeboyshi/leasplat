<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"> 
    <title></title>
    <style type="text/css">
        html,body,div,img{
            padding:0;
            margin:0;
        }
        #box1{
            margin:100px auto;
        }
        #box1 img:nth-child(1){
            height:185px;
            width:142px;
            position:absolute;
            left:8px;
            top:19px;
        }
        #box1 img:nth-child(2){
            height:185px;
            width:142px;
            position:absolute;
            right:52px;
            top:19px;
        }
         #box1 img:nth-child(3){
            height:100px;
            width:100px;
            position:absolute;
            left:12px;
            bottom:31px;
        }
         #box1 img:nth-child(4){
            height:100px;
            width:100px;
            position:absolute;
            left:149px;
            bottom:31px;
        }
         #box1 img:nth-child(5){
            height:100px;
            width:100px;
            position:absolute;
            left:288px;
            bottom:31px;
        }

        @keyframes first{
            0% {
                transform:rotate(0deg);
            }
            25% {
                transform: rotate(10deg);
            }
            50% {
                transform:rotate(20deg);
            }
            75% {
                transform:rotate(10deg);
            }
            100% {
                transform:rotate(0deg);
            }
        }
        @keyframes two{
            0% {
                transform:rotate(0deg) translate(0px,0px);
            }
            25% {
                transform: rotate(-10deg) translate(0px,15px);
            }
            50% {
                transform:rotate(-20deg) translate(0px,15px);
            }
            75% {
                transform:rotate(-10deg) translate(0px,15px);
            }
            100% {
                transform:rotate(0deg) translate(0px,0px);
            }
        }
        @keyframes three{
            0% {
                transform: translate(0px,0px);
            }
            25% {
                transform: translate(0px,20px);
            }
            50% {
                transform: translate(0px,0px);
            }
            75% {
                transform: translate(0px,-20px);
            }
            100% {
                transform: translate(0px,0px);
            }
        }
        #box1 img:nth-child(1){
            animation:first 2.5s linear  infinite alternate;
        }
        #box1 img:nth-child(2){
            animation:two 2.5s linear infinite alternate;
        }
        #box1 img:nth-child(3){
            animation:three 0.5s ease 0s infinite alternate;
        }
        #box1 img:nth-child(4){
            animation:three 0.5s ease 0.1s infinite alternate;
        }
        #box1 img:nth-child(5){
            animation:three 0.5s ease 0.2s infinite alternate;
        }
    </style>
</head>
<body>
    <div id="box1" style="height:402px;width:400px;background:url(../newFile/images/2.png) no-repeat;background-size:contain;position:relative;">
        <img src="../newFile/images/s.png" />

        <img src="../newFile/images/g.png" />

        <img src="../newFile/images/xiao.png" />

        <img src="../newFile/images/wu.png" />

        <img src="../newFile/images/pin.png" />
    </div>
</body>
</html>