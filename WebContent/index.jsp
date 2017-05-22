<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <style type="text/css">
        *{
            padding:0px;
            margin:0px;
        }

        .main{
            width:40%;
            height:18%;
            min-width:500px;
            min-height:300px;
            position:absolute;
            top:400px;
            bottom:200px;
            left:30%;
        }

        .title img{
            position:absolute;
            top:-200px;
            left:2%;
            width:10%;
            height:24%;
        }

        .title span{
            position:absolute;
            top:-180px;
            left:1%;
            height:40px;
            width:500px;
            font-size:30px;
            line-height:40px;
            text-align:center;
            color:white;
        }

        .title1{
            color:white;
            font-size: 20px;
            margin-left:20px;
            line-height:40px;
        }

        .tupian{
            width: 30%;
            height:100%;
            min-height:350px;
            position:absolute;
            top:-100px;
            left:0px;
        }

        .allform{
            width:70%;
            height:100%;
            min-height:350px;
            background:white;
            float:left;
            position:absolute;
            top:-100px;
            left:30%;
        }

        .acc{
            margin-top:13%;
            margin-left:15%;
            width: 60%;
            height:49px;
        }

        .account{
            position: absolute;
            left:5%+49px;
            width:55%;
            height:48px;
            background:#dfdfdf;
            border:none;
            font-size: 30px;
            line-height: 49px;
        }

        .pss{
            margin-top:20px;
            margin-left:15%;
            width: 60%;
            height:49px;
        }

        .password{
            position: absolute;
            left:5%+49px;
            width:55%;
            height:48px;
            background:#dfdfdf;
            border:none;
            font-size: 30px;
            line-height: 49px;
        }

        #login{
            height:40px;
            width:65%;
            font-family:'Microsoft YaHei';
            font-size:25px;
            background:#0282c9;
            margin-top:45px;
            margin-left:15%;
            color:white;
            border-radius:5px;
        }

    </style>
    <script type="text/javascript">
        function onBtn(){
        var account = document.getElementsByName("account")[0].value;
        var password = document.getElementsByName("password")[0].value;
                if (account.length == 0) {
                    alert("账号不能为空");
                    return false;
                }
                if (password.length == 0) {
                    alert("密码不能为空");
                    return false;
                }
                // if (account != "nangong") {
                //     alert("账号不存在请重新输入");
                //     return false;
                // }
                // if (password != 123456) {
                //     alert("密码不正确请重新输入");
                //     return false;
                // }
                return true;

    }
    </script>
    </head>

    <body>

    <div style="position:absolute; left:0px; top:0px; width:100%; height:100%; min-height:800px;
                min-width:500px;">
        <img src="Pictures/bg.index.png" width="100%" height="100%"/>
          <div class="main">
            <div class="title"><img src="Pictures/国徽.png" alt="国徽" width="100%" height="100%"><span>南宫警务平台系统</span></div>
            <div class="tupian" ><img src="Pictures/weixing.png" alt="北斗" width="100%" height="100%"></div>
            <div class="allform">
            <form action="index" method="post">
                <div class="acc"><img src="Pictures/username.png" alt=""><input class="account" type="text" name="account" maxlength="15" onpaste="return false" placeholder="账号"></div>
                <div class="pss"><img src="Pictures/password.png" alt="" /><input class="password" type="password" name="password" maxlength="10" onpaste="return false" placeholder="密码"></div>
                <a href="#"><input type="submit"  id="login" value="登录" onclick="return onBtn()"/></a>
            </form>
            </div>
        </div>
        </div>


    </body>

</html>