var markerArray = [];
 function onEDbicyclePositionBtn(){
	 if("开始跟踪" == document.getElementById("EDbicyclePosition").value){
		 document.getElementById("EDbicyclePosition").value="停止跟踪";
   	  	 var EDbicycleIemi = document.getElementsByName("EDbicycleIemi")[0].value;
         //var placeAIemi = document.getElementsByName("placeAIemi")[0].value;
         //var placeBIemi = document.getElementsByName("placeBIemi")[0].value;
         if (EDbicycleIemi.length != 15) {
           alert("电动车设备号长度必须为15！");
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
         
         getEDbicyclePosition();
     }
     else{
    	 document.getElementById("EDbicyclePosition").value="开始跟踪";
     }
	 return true;
}
function getEDbicyclePosition() {
	var s = document.getElementById("EDbicycleiemi").value;
	// var e = document.getElementById("placeAiemi").value;
	// var i = document.getElementById("placeBiemi").value;
	var lov = location.pathname;
	var ival = lov.substr(0, lov.lastIndexOf("/")+1);
	$.ajax({
		type:"get",
		url:ival+"getEDbicyclePosition",
		data:{"EDbicycleiemi":s},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success:function(datas) {
			var json = eval(datas);
			var markerArray = [];
			markerArray.push(new ObjMarker(json.longitude, json.latitude, json.uploadTime));
			/*for(var n=(json.length-1); 0<=n; n--){
				alert("2");
				alert(json[n].uploadTime);
				markerArray.push(new ObjMarker(json[n].longitude, json[n].latitude, json[n].uploadTime));
			}*/
			LoaderMap("allmap1", 115.3867006,37.3614937, markerArray);
		},
		error:function(datas) {
			alert("请核对确认电动车卡设备号，警员A设备号，警员B设备号。");
			return;
		}
	});
	var int=self.setInterval("getEDbicyclePosition()",60*1000);
}
LoaderMap("allmap1", 115.3867006,37.3614937, markerArray);