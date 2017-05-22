 var markerArray = [];
    function getofficialcarAlermPosition() {
      //alert("getStudentAlermPosition");
      if(false == onBtn()){
        return false;
      }
      var s = document.getElementById("officialcartiemi").value;
      var e = document.getElementById("placeAiemi").value;
      var i = document.getElementById("placeBiemi").value;
      var lov = location.pathname;
      var ival = lov.substr(0, lov.lastIndexOf("/")+1);
      $.ajax({
        type:"post",
        url:ival+"getofficialcarAlermPosition",
        data:{"officialcariemi":s,"placeAiemi":e,"placeBiemi":i},
        dataType:"json",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success:function(datas) {
          //alert("success");
          var json = eval(datas);
          var markerArray = [];
          for(var n=(json.length-1); 0<=n; n--){
            //alert(n);
            //alert(json[n].alarmType);
            //alert(json[n].description);
            //alert(json[n].longitude);
            //alert(json[n].latitude);
            //alert(json[n].uploadTime);
            // var description = json[n].uploadTime+"->"+json[n].description;
                markerArray.push(new ObjMarker(json[n].longitude, json[n].latitude, json[n].uploadTime));
            }
          LoaderMap("allmap1", 116.404, 39.915, markerArray);
        },
        error:function(datas) {
          //alert("请求失败，请稍后再试");
          return;
       }
      });
    }
    LoaderMap("allmap1", 116.404, 39.915, markerArray);
    var int=self.setInterval("getofficialcarAlermPosition()",10*1000);
    function onBtn(){
      var officialcarIemi = document.getElementsByName("officialcarIemi")[0].value;
      var placeAIemi = document.getElementsByName("placeAIemi")[0].value;
      var placeBIemi = document.getElementsByName("placeBImei")[0].value;
      if (officialcarIemi.length != 15) {
        alert("警车设备号长度必须为15！");
        return false;
      }
      if(placeAIemi.length != 15){
        alert("警员A设备号长度必须为15！");
        return false;
      }
      if(placeBImei.length !=15){
        alert("警员B设备号长度必须为15！");
        return false;
      }
      return true;
    }