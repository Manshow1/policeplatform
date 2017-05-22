<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script src="js/jQuery-3.1.0.js"></script>
        <style type="text/css" media="screen">
            *{
            padding:0px;
            margin:0px;
        }
            body{
                background:#4b677b;
            }

            .top{
                width:100%;
                height:30%;
            }

            .title img{
                position:relative;
                margin-top:2px;
                left:5%;
                width:50px;
                height:50px;
            }

            .title span{
                position:absolute;
                top:10px;
                left:5%;
                height:40px;
                width:500px;
                font-size:30px;
                line-height:40px;
                text-align:center;
                color:white;
            }

            #navb{
                width:900px;
                height:26px;
                position:absolute;
                left:5%;
                top:60px;
            }

            #navb li{
                list-style:none;
                float:left;
                width:150px;
                height:46px;
                font-size:28px;
                line-height:46px;
                margin-left:5px;
                border:1px solid #324964;
                text-align:center;
                cursor:pointer;
                background:#324964;
                color:white;
            }

             #navb li:hover{
                background:white;
                color:#324964;
            }

             #navb li:visited{
                background:white;
                color:#324964;
            }

            .topanv{
                width:100%;
                height:37px;
            }

            .navleft input:focus {
            	outline:none;
            }

            .navleft button{
                position:absolute;
                left:1200px;
                top:65px;
                background-color:#324964;
                width:100px;
                height:36px;
                color:white;
                text-align:center;
                line-height:30px;
                font-size:24px;
                border:none;
                border-radius:5px;
                margin-left: 20px;
            }

            .navleft button:hover{
                background:#ffffff;
                color:#5a9cdb;
            }
        </style>
    </head>
    <body>
        <div class="title"><img src="Pictures/国徽.png" alt="国徽" width="100%" height="100%"><span>南宫警务平台系统(学生)</span></div>
    <!-- 页面头部 -->
    <div class="topnav">
    <!-- 页面列表 -->
    <ul id="navb">
        <a href="studentbuttom1.html" target="mainFrame"><li id="li1" onclick="change(this)" style="background: white;color: #324964" >实时监控</li></a>
        <a href="studentbuttom2.html" target="mainFrame"><li id="li2" onclick="change(this)">报警查询</li></a>
        <a href="studentbuttom3.html" target="mainFrame"><li id="li3" onclick="change(this)">轨迹跟踪</li></a>
        <a href="studentbuttom4.html" target="mainFrame"><li id="li4" onclick="change(this)">轨迹回放</li></a>
    </ul>
         <script type="text/javascript">
            function change(obj){
                var arr = document.getElementsByTagName("li");
                for (var i = 0; i < arr.length; i++) {
                    var a = arr[i];
                    a.style.background = "#324964";
                    a.style.color = "white";
                };
                obj.style.background = "white";
                obj.style.color = "#324964";
            }
        </script>
    <div class="navleft">
    <a href="guidance.html" target = "_parent"><button type="button" id="back">退出</button></a>
    <script type="text/javascript">
    var back = document.getElementById("back");
    back.onclick=function getBackFromStudent(){

    }
    </script>

    <div style="position: absolute; width:200px;height:36px;top:65px;left:750px;font-size:20px; color:white;background: #4b677b;line-height: 36px;text-align: center; ">(<span id="onlineStudent">0</span>/<span id="totalStudent">0</span>)在线/总数</div>
    <div style="position: absolute; width:230px;height:36px;top:65px;left:950px;font-size:20px; color:white;background: #4b677b;line-height: 36px;text-align: center;border-radius: 5px; margin-left: 20px; ">(<span id="untreated">0</span>/<span id="allnumber">0</span>)未处理/总数</div>
    </div>
    <script type="text/javascript">
        var onlineStudent = document.getElementById("onlineStudent");
        var totalStudent = document.getElementById("totalStudent");
        var untreated = document.getElementById("untreated");
        var allnumber = document.getElementById("allnumber");

    function getStudentNumber() { 
    	    var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);
            $.ajax({
            	type:"get",
                url:ival+"getStudentNumber",               
                data:{},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(datas) {
                    var json = eval(datas);
                    onlineStudent.innerHTML = json.online;
                    totalStudent.innerHTML = json.total;
                    untreated.innerHTML = json.untreatedalarm;
                    allnumber.innerHTML = json.totalalarm;
                },
                error:function(){
                     console.log("获取在线数和总数出现错误")
                }
            })
        }
    var a=self.setInterval("getStudentNumber()",10*1000);
    </script>
    </div>
    </body>
</html>