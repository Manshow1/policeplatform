<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script src="js/jQuery-3.1.0.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Iw8Gl0lbmiS7YGAk3I1fPnYHSFSfd9E6"></script>
        <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
        <script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
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

            .guiji1 .genzong2{
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

            #allmap2{
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
        &nbsp;&nbsp;<div>起始时间&nbsp;&nbsp;<input type="text"  name="starttime" id="startDate" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒',maxDate: '#F{$dp.$D(\'endDate\')||\'new Date()\'}', lang: 'zh-cn'})" class="Wdate" style="width:280px" placeholder="请输入起始时间" /></div>
        &nbsp;&nbsp;<div>结束时间&nbsp;&nbsp;<input type="text"  name="endtime" id="endDate" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒',minDate:'#F{$dp.$D(\'startDate\')}',maxDate: 'new Date()', lang: 'zh-cn'})" class="Wdate" style="width:280px" placeholder="请输入结束时间" /></div>
        &nbsp;&nbsp;<div>手机号&nbsp;&nbsp;<input type="text" placeholder="请输入手机号" style="width:150px" name="phone" id="PHONE"></div>
        &nbsp;&nbsp;<div><input type="submit" value="查询轨迹" class="genzong2" src="#" onclick="getOldpeopleTrack ()" style="width: 150px;border-radius: 5px"></div>
        </div>
        <hr class="fenjiexian">
        </div>
        
        <div id="allmap2"></div>
        
        <div id="beijing"></div>
        
        <div id="lab">页面加载中，请稍候！</div>
    </body>
     <script src="js/oldpeople/mapapihuifang.js"></script>
     <script src="js/oldpeople/huifang.js"></script>

</html>