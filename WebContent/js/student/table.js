 
function getStudentAlermMessage() {
			var s = document.getElementById("StartDate").value;
            var e = document.getElementById("EndDate").value;
            var sh = document.getElementById("shebei").value;
            var l = document.form1.deal.value;
            var beijing = document.getElementById("beijing");
            beijing.style.display = "block";
            var lab = document.getElementById("lab");
            lab.style.display = "block";
            var tbody = window.document.getElementById("tbody-result");
            var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);          
            $.ajax({
                type:"get",
                url:ival+"getStudentAlermMessage",
                data:{"StartDate":s,"EndDate":e,"shebei":sh,"listdown":l},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(msg){
                		var str = "";
                		var json = eval(msg);
                		if(json.length == 0){
                			alert("没有查询到报警信息！");
                		}
                		for (i in json){
                			str +="<tr>" + 
                			"<td id=IMEI"+i+">" + json[i].IMEI +
                			"</td>" +
                			"<td id=description"+i+">" + json[i].description +
                			"</td>" +
                			"<td id=name"+i+">" + json[i].name +
                			"</td>" +
                			"<td id=parentname"+i+">" + json[i].parentname +
                			"</td>" +
                			"<td id=parentphone"+i+">" + json[i].parentphone +
                			"</td>" +			               			                			
                			"<td id=school"+i+">" + json[i].school +
                			"</td>" +
                			"<td id=uploadTime"+i+">" + json[i].uploadTime +
                			"</td>" +
                			"<td>" + "<select id=select"+i+">" + "<option value=1";
                			//"<option value=0>"+ "全部" +"</option>"+
                			if(1 == json[i].state){
                				str += " selected=\"selected\""
                			}
                			str += ">" + "未处理" + "</option>" + "<option value=2";
                			if(2 == json[i].state){
                				str += " selected=\"selected\""
                			}
                			str += ">"+ "已处理" +"</option>"+"<option value=3";
                			if(3 == json[i].state){
                				str += " selected=\"selected\""
                			}
                			str += ">"+ "需处理" +"</option>"+ "<option value=4"
                			if(4 == json[i].state){
                				str += " selected=\"selected\""
                			}
                			str += ">"+ "正处理" +"</option>"+
                			"</select>"+"<input id="+i+" type = button value = 确定  onclick = postStudentAlermState(id)>"+                			
                			"</td>" +
                			"</tr>";  
                			 
                		};
                		lab.style.display = "none";
                		beijing.style.display = "none";
                		tbody.innerHTML = str;
                		     
                },
                error:function(data) {
//                    alert("获取学生卡报警信息失败 getStudentAlermMessage");
                    return;
                }
            });
            function onBtn() {
            var starttime = document.getElementsByName("startDate")[0].value;
            var endtime = document.getElementsByName("endDate")[0].value;
            var iemi = document.getElementsByName("IEMI")[0].value;
//            if (starttime.length == 0) {
//                alert("起始时间不能为空！");
//                return false;
//            }
//            if (endtime.length == 0) {
//                alert("结束时间不能为空！");
//                return false;
//            }
            if(iemi.length != 0){
            	
            	 if(!(/^8(62385030)\d{6}$/.test(iemi))){
            		 alert("设备号输入错误，请重新输入！")
            		 return false;
            	 }
            }
            return true;
        }
        onBtn();
       }

//var int=self.setInterval("getStudentAlermMessage()",300*1000);

