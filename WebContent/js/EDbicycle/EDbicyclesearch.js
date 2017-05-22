
        function ObjMarker(locateType, lng, lat, uploadTime)    {
            this.locateType = locateType;
            this.description = description;
            this.lng = lng;
            this.lat = lat;
            this.uploadTime = uploadTime;
        }
        function showMap(divContainer, lng, lat, markerArray) {
            var map = new BMap.Map("allmap"); //创建地图实例
            map.centerAndZoom(new BMap.Point(lng, lat), 13); //        创建地图中心点及地图层级
            map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
            map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
            map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
            map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
            map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor:         BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开
            var localSearch = new BMap.LocalSearch(map);
            localSearch.enableAutoViewport();  //允许自动调节窗体大小

            function addMarker(point, content) {
                var marker = new BMap.Marker(point);
                map.addOverlay(marker);
                marker.setAnimation(BMAP_ANIMATION_BOUNCE);
                var infowindow = new BMap.InfoWindow(content);
                marker.addEventListener("click", function () {
                    this.openInfoWindow(infowindow);
                });
            }

    //----------------------------------------
    var poes = new Array();//转换后的数组
    var total = 0; //总记录数
    var groupCount = 0; //每次转十条
    if (markerArray.length % 10 > 0) {
        groupCount = ((markerArray.length - (markerArray.length % 10)) / 10) + 1;
    }
    else {
        groupCount = (markerArray.length / 10);
    }
    var index = 0
    for (var i = 0; i < groupCount; i++) {
        //外层循环，有多少组十条
        var pos = new Array();
        for (var j = 0; j < 10; j++) {
            //内层循环，每组十条
            if (total < markerArray.length) {
                //不超过总记录数结束
                var point = new BMap.Point(markerArray[(i * 10) + j].lng, markerArray[(i * 10) + j].lat);
                pos.push(point);
            }
            total++;
        }
        //闭包开始
        (function () {
            //将调用与回调封装在一个闭包内，为保持发送和回调后的顺序号ii的一致性
            var ii = i;
            var callback = function (data) {
                if (data.status === 0) {
                    var poss = new Array();
                    for (var a = 0; a < data.points.length; a++) {
                        poss.push(data.points[a]);
                    }
                    for (var j = 0; j < poss.length; j++) {
                        //关键的整理顺序部分
                        poes[ii * 10 + j] = poss[j];
                    }
                }
                if (poes.length == markerArray.length) {
                    for (var z = 0; z < poes.length; z++) {
                        var content = markerArray[z].description;
                        addMarker(poes[z], content);
                        map.setCenter(poes[z]);
                    }
                    map.setViewport(poes);
                }
            }
            convert(pos, callback);
        })();
        //闭包结束
    }

}


function convert(pos, callback) {
    var convertor = new BMap.Convertor();
    convertor.translate(pos, 1, 5, callback);
};

   var markerArray = [];
        function EDbicycleSearch () {
            var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);
            $.ajax({
                type:"get",
                url:ival+"EDbicycleSearch",
                // data:{"startDate":s,"endDate":e,"IEMI":i},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(datas) {
                    var json = eval(datas);
                    var markerArray = [];
                    for(var n=(json.length-1); 0<=n; n--){
                        //alert(n+json[n].locateType+json[n].description+json[n].longitude+json[n].latitude+json[n].uploadTime);
                        /*alert(json[n].locateType);
                        alert(json[n].description);
                        alert(json[n].longitude);
                        alert(json[n].latitude);*/
                        //alert(json[n].uploadTime);
                        markerArray.push(new ObjMarker(json[n].locateType, json[n].longitude, json[n].latitude, json[n].uploadTime));
                    }


                },
                error:function(data) {
                    alert("出现错误");
                    return;
                }
            });

            //getStudentInfo();
        }
         showMap("allmap", 115.3867006,37.3614937, markerArray);
         electrombileSearch();


