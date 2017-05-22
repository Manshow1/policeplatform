var markerArray = [];
var OnOffConnection = 1;//1OFF  2ON
function onStudentPositionBtn(){
//	var beijing = document.getElementById("beijing");
//    beijing.style.display = "block";
	if("开始跟踪" == document.getElementById("StudentPosition").value){
   	  	var studentIemi = document.getElementsByName("studentIemi")[0].value;
        //var placeAIemi = document.getElementsByName("placeAIemi")[0].value;
        //var placeBIemi = document.getElementsByName("placeBIemi")[0].value;
        
        	 if(!(/^8(62385030)\d{6}$/.test(studentIemi))){
          		 alert("设备号输入错误，请重新输入！");
          		return false;
          	 }         
        
        	
          	
         
        /*if(placeAIemi.length != 15){
           alert("警员A设备号长度必须为15！");
           return false;
        }
         
        if(placeBImei.length !=15){
           alert("警员B设备号长度必须为15！");
           return false;
        }*/
        document.getElementById("StudentPosition").value="停止跟踪";
        OnOffConnection = 2;
        getStudentPosition();
    }
    else{
    	document.getElementById("StudentPosition").value="开始跟踪";
    	OnOffConnection = 1;
    }
	return true;
}
function getStudentPosition() {
	
	if(1== OnOffConnection){
		return;
	}
	 var s = document.getElementById("studentiemi").value;
	// var e = document.getElementById("placeAiemi").value;
	// var i = document.getElementById("placeBiemi").value;
	var lov = location.pathname;
	var ival = lov.substr(0, lov.lastIndexOf("/")+1);
	$.ajax({
		type:"get",
		url:ival+"getStudentPosition",
		data:{"studentiemi":s},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success:function(datas) {
			var json = eval(datas);
			var markerArray = [];
			if(json.locateType == 0){
				json.locateType = "北斗卫星定位"
			};
			if(json.locateType == 1){
				json.locateType = "WIFI定位"
			}
			if(json.locateType == 2){
				json.locateType = "基站定位"
			}
			
			markerArray.push(new ObjMarker(json.longitude, json.latitude, json.locateType, json.uploadTime ));
			/*for(var n=(json.length-1); 0<=n; n--){
				alert("2");
				alert(json[n].uploadTime);
				markerArray.push(new ObjMarker(json[n].longitude, json[n].latitude, json[n].uploadTime));
			}*/
			LoaderMap("allmap1", 115.3867006,37.3614937, markerArray);
		},
		error:function(datas) {
//			alert("请核对确认学生卡设备号，警员A设备号，警员B设备号。");
			return;
		}
	});
	var int=self.setInterval("getStudentPosition()",60*1000);
}
LoaderMap("allmap1", 115.3867006,37.3614937, markerArray);
