<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <script src="js/jQuery-3.1.0.js"></script>
        <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
        <script type="text/javascript" src="js/My97DatePicker/calendar.js"></script>
        <script type="text/javascript"> 
        	
        	function postStudentAlermState (id){
        		var a = "PHONE"+id;
        		var b = "uploadTime"+id;
        		var c = "select"+id;
        		var phone = document.getElementById(a).innerHTML;
            	var uploadtime = document.getElementById(b).innerHTML;
            	var sel = document.getElementById(c).value;
            	var lov = location.pathname;
                var ival = lov.substr(0, lov.lastIndexOf("/")+1);
        		$.ajax({
                    type:"post",
                    url:ival+"postStudentAlermState",
                    data:{"phone":phone,"uploadtime":uploadtime,"sel":sel},
                    dataType:"json",
                    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                    success:function(datas) {
                    
        			},
        			error:function(datas) {
		    			alert("状态设置成功");
		    			return;
    				}
        		})
        	}
        </script>
        <style>
            .btn1{
                position:absolute;
                margin-top:140px;
                left:0%;
                width:100%;
                height:86%;
                overflow-y:scroll;
            }

            #tablehead{
                height:50px;
                background:#55cdc7;
				width:100%;
            }

            th{
                width:85px;
                height:26px;
                text-align:center;
                color:black;
                margin-bottom:30px;
            }

            td{
                width:85px;
                height:26px;
                text-align:center;
                color:black;
                vertical-align:top;
            }

            td b{
                padding-top:5px;
                display:block;
            }

            button{
                width:56px;
                height:22px;
                background:#69ab3d;
                margin-top:5px;
                border-radius:5px;
            }

            #query{
                width:100%;
                height:94%;
                min-width:1300px;
                position:absolute;
                background:#f2f2f2;
            }
            
            #beijing{
            	width:100%;
                height:100%;
                min-width:1300px;
                position:absolute;
                background:#f2f2f2;
                filter:alpha(opacity=50); 
				-moz-opacity:0.5; 
				opacity:0.5;
                display:none;
            }

            .search2{
                font-size:16px;
                color:black;
                width:1600px;
                height:50px;
                position:absolute;
                left:2%;
                top:5px;
            }

            .search2 div{
                float:left;
                width:400px;
                height:32px;
                line-height:32px;
                margin-top:22px;
                margin-left:10px;
                display:inline;
            }

            .search2 input{
                height:32px;
                font-size:16px;
                line-height:30px;
                text-align:center;
                border:1px solid #999999;
                display:inline;
            }

            .xiala{
                width:120px;
                height:32px;
                line-height:32px;
                margin-top:22px;
                margin-left:2px;
                display:inline;
                border:1px solid #999999;
            }

            .search3 input{
                width:126px;
                height:32px;
                background-color:#d9e1e7;
                text-align:center;
                border-radius:5px;
                float:left;
                color:black;
                line-height:32px;
                text-align:center;
                font-size:20px;
                margin-left:35px;
            }


            option:hover{
                background:#55cdc7;
            }
            
            #lab{
            	position:absolute;
            	width:300px;
            	height:100px;
            	background:#f2f2f2;
            	top:30%;
            	left:40%;
            	text-align:center;
            	line-height:100px;
            	font-size:20px;
            	font-family:微软雅黑;
            	border:1px solid #999999;
            	border-radius:5px;
            	display:none;
            }
        </style>
    </head>
    <body>
    <div id="query">        
        <table style="width:100%; position:absolute; margin-top:90px;left:0%;" >
        	<tr id="tablehead">
            	<th>ID</th>
                <th>设备号</th> 
            	<th>纬度度</th>
            	<th>经度</th>
                <th>报警描述</th>    
                <th>报警时间</th>
                <th>状态</th>
                <th>姓名</th>
                <th>标题</th>
                <th>子女姓名</th>
                <th>子女电话号</th>
            </tr>
        </table>
        <div class="btn1">
        
        <table class="table table-striped">            
            <tbody id="tbody-result">
            
            </tbody>
    	</table>
    </div>
    <div>
        <div class="search2">
       
        <div>起始时间&nbsp;&nbsp;<input type="text" id="StartDate" name="startDate" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒',maxDate: '#F{$dp.$D(\'EndDate\')||\'new Date()\'}', lang: 'zh-cn'})" class="Wdate" style="width:280px" placeholder="请输入起始时间" /></div>
        <div>结束时间&nbsp;&nbsp;<input type="text" id="EndDate" name="endDate" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒',minDate:'#F{$dp.$D(\'StartDate\')}',maxDate: 'new Date()', lang: 'zh-cn'})"  class="Wdate" style="width:280px" placeholder="请输入结束时间" /></div>
        <div style="width:250px">手机号&nbsp;&nbsp;<input type="text" placeholder="请输入手机号" id="phone" name="PHONE" style="width:150px"></div>
        <!-- Split button -->
        
		 
        
        
        <form name="form1">
        <select class="xiala" id="listdown" name="deal">
          <option value="0">全部</option>
          <option value="1">未处理</option>
          <option value="2">已处理</option>
          <option value="3">需处理</option>
          <option value="4">正处理</option>
        </select>
        </form>
        <form class="search3">
            <div><input type="button" style="position:absolute;top:22px;left:1200px" value="查询" src="#" onclick=" getOldpeopleAlermMessage ()"></div>
        </form>
        </div>
        
        </div>
        <!-- 表格页面查询条件 -->
    </div>
    <div id="beijing"></div>
    <div id="lab">页面正在加载请稍候</div>
    </body>
</html>