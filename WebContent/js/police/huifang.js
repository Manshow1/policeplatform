var markerArray = [];
        function getPoliceTrack() {
            if(false == onBtn()){
                return false;
            }
            var s = document.getElementById("startDate")[0].value;
            var e = document.getElementById("endDate")[0].value;
            var i = document.getElementsByName("IEMI")[0].value;
            var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);
            $.ajax({
                type:"get",
                url:ival+"getPoliceTrack",
                data:{"startDate":s,"endtDate":e,"IEMI":i},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(datas) {
                    //alert("success");
                    var json = eval(datas);
                    var markerArray = [];
                    for(var n=(json.length-1); 0<=n; n--){
                        //alert(n+json[n].locateType+json[n].description+json[n].longitude+json[n].latitude+json[n].uploadTime);
                        /*alert(json[n].locateType);
                        alert(json[n].description);
                        alert(json[n].longitude);
                        alert(json[n].latitude);*/
                        //alert(json[n].uploadTime);
                        markerArray.push(new ObjMarker(json[n].locateType, json[n].description, json[n].longitude, json[n].latitude, json[n].uploadTime));
                    }
                    SearchMap("allmap2", 116.404, 39.915, markerArray);
                    getStudentInfo();

                },
                error:function(data) {
                    alert("无法获取路径，请检查查询条件后，重试。");
                    return;
                }
            });
            //getStudentInfo();
        }
        function getPoliceInfo() {
            var i = document.getElementById("IEMI").value;
            var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);
            var params = {};
            params["IEMI"] = i;
            $.ajax({
                type:"get",
                url:ival+"getPoliceInfo",
                data: params,
                dataType:"text",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(datas) {
                    //document.getElementById("getStudentInfo").innerHTML = "基本信息:"+datas;
                    //alert("基本信息:"+datas)\
                    $("#12345678").html("基本信息:"+datas);
                },
                error:function(data) {
                    alert("无法获取学生信息，请检查查询条件后，重试。");
                    return;
                }
            });
        }
        SearchMap("allmap2", 116.404, 39.915, markerArray);
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
            if (iemi.length != 15) {
                alert("iemi长度必须为15！");
                return false;
            }
            return true;
        }
        // $().ready(function(){
        //     $("#divtop").on("keyup", "[name='iemi']", function () {
        //         this.value = this.value.replace(/[^0-9_]*/g, "");
        //     });
        // });