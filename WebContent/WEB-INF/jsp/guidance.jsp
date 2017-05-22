<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
    </head>
    <style type="text/css">
         *{
                padding:0px;
                margin:0px;
         }

         .top{
                width:100%;
                height:100%;
                min-height:800px;
                min-width:1800px;
                background-position:center;
                background-repeat:no-repeat;
                background:url(Pictures/login-bg.png);
                position:absolute;
                left:0%;
                top:0%;
            }

        .title img{
            position:absolute;
            top:2%;
            left:10%;
            width:50px;
            height:50px;
        }

        .title span{
            position:absolute;
            top:3%;
            left:8%;
            height:40px;
            width:500px;
            font-size:30px;
            line-height:40px;
            text-align:center;
            color:white;
        }

        .nangong{
            color:white;
            font-size:50px;
        }

        .main{
            width:80%;
            height:80%;
            min-height:700px;
            min-width:800px;
            margin:auto auto;
            position:absolute;
            top:10%;
            left:10%;
            background:white;
        }

        .main1 div{
            margin-top:6%;
            float:left;
            margin-left:2.5%;
            box-shadow:3px 3px 10px gray;
        }

          .main2 div{
            margin-top:6%;
            float:left;
            margin-left:2.5%;
            box-shadow:3px 3px 10px gray;
        }

    </style>
    <body>
     <div class="top">
     <div class="title"><img src="Pictures/国徽.png" alt="国徽" width="100%" height="100%"><span>南宫警务平台系统</span></div>
     <div class="main">
     <div class="main1">
        <a href="student.html"><div class="student" style=" width: 30%;height:30%"><img src="Pictures/student.png" alt="学生图片" width="100%" height="100%"></div></a>
        <a href="oldpeople.html"><div id="oldpeople" class="oldman" style=" width: 30%;height:30%"><img src="Pictures/oldman.png" alt="老人图片" width="100%" height="100%"></div></a>
       	<a href="#"><div id="Grid member" style=" width: 30%;height:30%"><img src="Pictures/Grid member.png" alt="网格员图片" width="100%" height="100%"></div></a>
     </div>
     <div class="main2">
        <a href="#"><div id="officialcar"  class="radio" style=" width:30%;height:30%"><img src="Pictures/radiocar.png" alt="警车图片" width="100%" height="100%"></div></a>
        <a href="#"><div class="policeman" id="police" style=" width: 30%;height:30%"><img src="Pictures/policeman.png" alt="警员图片" width="100%" height="100%"></div></a>      
        <a href="EDbicycle.html"><div id="EDbicycle" class="electrombile" style="width: 30% ;height:30%"><img src="Pictures/electrombile.png" alt="电动车图片" width="100%" height="100%"></div></a>
     </div>
     </div>
     </div>
    </body>
    <script type="text/javascript">
    var Grid = document.getElementById("Grid member");
    var police = document.getElementById("police");
    var officialcar = document.getElementById("officialcar");
    var oldpeople = document.getElementById("oldpeople");
    var EDbicycle = document.getElementById("EDbicycle");
   
    Grid.onclick=function(){
        alert("网格员界面正在开发中");
    }
    police.onclick=function(){
        alert("警员页面正在开发中");
    }
    officialcar.onclick=function(){
        alert("警车页面正在开发中");
    }
    </script>
</html>