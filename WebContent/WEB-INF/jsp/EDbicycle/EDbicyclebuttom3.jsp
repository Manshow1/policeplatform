<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
         <script src="js/jQuery-3.1.0.js"></script>
         <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Iw8Gl0lbmiS7YGAk3I1fPnYHSFSfd9E6"></script>
        <style>
             .guiji1{
                position:absolute;
                top:0px;
                left:0%;
                width:100%;
                min-width:1200px;
                height:80%;
                font-size:16px;
                color:black;
                background:white;
            }

            .guiji1 div{
                float:left;
                margin-top:10px;
                margin-bottom:10px;
                color:#4b677b;
            }

            .guiji1 .lis div{
                margin-left:20px;
            }

            .guiji1 input{
                width:244px;
                height:34px;
                border:1px black solid;
                text-align:center;
                font-size:16px;
                line-height:34px;
            }

            .guiji1 .genzong1{
                width:210px;
                height:34px;
                font-size:20px;
                color:black;
                text-align:center;
                line-height:34px;
                background-color:#d9e1e7;
                position:absolute;
            }

            .guiji1 span:hover{
                background:#fff;
            }

            .guiji1 span:active{
                background:#fff;
            }

              #allmap1{
                width:100%;
                height:85%;
                position:absolute;
                top:85px;
                left:0%;
                overflow:hidden;
            }
        </style>
    </head>
    <body>
        <div class="guiji1">
        <div class="lis">
        &nbsp;&nbsp;<div>电动车设备号&nbsp;&nbsp;<input type="text" placeholder="请输入电动车设备号" style="width:180px" name="EDbicycleIemi" id="EDbicycleiemi"></div>
        &nbsp;&nbsp;<div>警员设备号A&nbsp;&nbsp;<input type="text" placeholder="请输入警员设备号A" style="width:180px" name="placeAIemi" id="placeAiemi"></div>
        &nbsp;&nbsp;<div>警员设备号B&nbsp;&nbsp;<input type="text" placeholder="请输入警员设备号B" style="width:180px" name="placeBIemi" id="placeBiemi"></div>
        &nbsp;&nbsp;<div><input type="submit" value="开始跟踪" class="genzong1" src="#" onclick="getEDbicyclePosition ()" style="width: 150px;border-radius: 5px"></div>
        </div>
        </div>
        <div id="allmap1"></div>
        <!-- 轨迹跟踪界面  -->
    </body>
     <script src="js/EDbicycle/mapapigenzong.js"></script>
      <script src="js/EDbicycle/genzong.js"></script>
</html>