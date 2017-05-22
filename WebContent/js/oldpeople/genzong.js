var markerArray = [];
var OnOffConnection = 1;//1OFF  2ON
function onOldpeoplePositionBtn(){
//	var beijing = document.getElementById("beijing");
//    beijing.style.display = "block";
	if("开始跟踪" == document.getElementById("OldpeoplePosition").value){
   	  	var oldpeoplePhoneNumber = document.getElementsByName("oldpeoplePhoneNumber")[0].value;
        
        	
   	  	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(oldpeoplePhoneNumber))){ 
   	  		alert("不是完整的11位手机号或者正确的手机号前七位");         		
        	return false; 
        		 } 
        document.getElementById("OldpeoplePosition").value="停止跟踪";
        OnOffConnection = 2;
        getOldpeoplePosition();
    }
    else{
    	document.getElementById("OldpeoplePosition").value="开始跟踪";
    	OnOffConnection = 1;
    }
	return true;
}
function getOldpeoplePosition() {
	
	if(1== OnOffConnection){
		return;
	}
	 var s = document.getElementById("oldpeoplephonenumber").value;
	// var e = document.getElementById("placeAiemi").value;
	// var i = document.getElementById("placeBiemi").value;
	var lov = location.pathname;
	var ival = lov.substr(0, lov.lastIndexOf("/")+1);
	$.ajax({
		type:"get",
		url:ival+"getOldpeoplePosition",
		data:{"oldpeoplephonenumber":s},
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
	var int=self.setInterval("getOldpeoplePosition()",60*1000);
}
LoaderMap("allmap1", 115.3867006,37.3614937, markerArray);