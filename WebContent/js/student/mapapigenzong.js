//对象
  function ObjMarker(lng, lat, locateType, uploadTime)    {
            this.lng = lng;
            this.lat = lat;
            this.locateType = locateType;
            this.uploadTime = uploadTime;
        }
        function LoaderMap(divContainer, lng, lat, markerArray) {
            var map = new BMap.Map("allmap1"); //创建地图实例
            map.centerAndZoom(new BMap.Point(lng, lat), 15); //        创建地图中心点及地图层级
            map.enableScrollWheelZoom();    //启用滚轮放大缩小，默认禁用
            map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
            map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
            map.addControl(new BMap.OverviewMapControl()); //添加默认缩略地图控件
            map.addControl(new BMap.OverviewMapControl({ isOpen: true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT }));   //右下角，打开
            var localSearch = new BMap.LocalSearch(map);
            localSearch.enableAutoViewport();  //允许自动调节窗体大小
            var Pointes = new Array();
    function addMarker(point, content) {
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
        var infowindow = new BMap.InfoWindow(content);
        marker.addEventListener("click", function () {
            this.openInfoWindow(infowindow);
        });
    }

    for (var i = 0; i < markerArray.length; i++) {
        Pointes.push(new BMap.Point(markerArray[i].lng, markerArray[i].lat));
    }

    //坐标转换完之后的回调函数
    translateCallback = function (data) {
    	
        if (data.status === 0) {
            for (var i = 0; i < Pointes.length; i++) {
                var content = "定位时间："+ markerArray[i].uploadTime +"<hr>"+ "定位类型：" + markerArray[i].locateType +"<hr>"+"  经纬度：" + markerArray[i].lng +"/"+markerArray[i].lat +"<hr>";
                addMarker(Pointes[i], content);
            }
        }
    }
    setTimeout(function () {
        var convertor = new BMap.Convertor();
        convertor.translate(Pointes, 1, 5, translateCallback)
    });
    map.setViewport(Pointes);          //调整到最佳视野
}
