var markerArray = [];
function getStudentTrack() {
    if(false == onBtn()){
        return false;
    }
    var s = document.getElementById("startDate").value; 
    var e = document.getElementById("endDate").value;  
    var i = document.getElementById("IEMI").value;
    var beijing = document.getElementById("beijing");
    beijing.style.display = "block";
    var lab = document.getElementById("lab");
    lab.style.display = "block";
    var lov = location.pathname;
    var ival = lov.substr(0, lov.lastIndexOf("/")+1);
    $.ajax({
        type:"get",
        url:ival+"getStudentTrack",
        data:{"startDate":s,"endDate":e,"IEMI":i},
        dataType:"json",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success:function(datas) {
            var json = eval(datas);
          
            var markerArray = [];
            
            for(var n=(json.length-1); 0<=n; n--){
            	if(json[n].locateType == 0){
                	json[n].locateType = "北斗卫星定位"
    			};
    			if(json[n].locateType == 1){
    				json[n].locateType = "WIFI定位"
    			}
    			if(json[n].locateType == 2){
    				json[n].locateType = "基站定位"
    			}
    			
            	markerArray.push(new ObjMarker(json[n].longitude, json[n].latitude, json[n].locateType, json[n].uploadTime ));
            	 lab.style.display = "none";
            	 beijing.style.display = "none";
            }
            SearchMap("allmap2", 115.3867006,37.3614937, markerArray);
         

        },
        error:function(data) {
//            alert("无法获取路径，请检查查询条件后，重试。");
            return;
        }
    });
}

SearchMap("allmap2", 115.3867006,37.3614937, markerArray);

function onBtn() {
    var starttime = document.getElementsByName("starttime")[0].value;
    var endtime = document.getElementsByName("endtime")[0].value;
    var iemi = document.getElementsByName("iemi")[0].value;
    if (starttime.length == 0) {
        alert("起始时间不能为空！");
        return false;
    }
    if (endtime.length == 0) {
        alert("结束时间不能为空！");
        return false;
    }    	
    if(!(/^8(62385030)\d{6}$/.test(iemi))){
     	alert("设备号输入错误，请重新输入！")
     	return false;
    }
   
    return true;
}

