function getStudentAlermMessage() {
            // alert("getStudentAlermMessage");
            var lov = location.pathname;
            var ival = lov.substr(0, lov.lastIndexOf("/")+1);
            $.ajax({
                type:"post",
                url:ival+"getStudentAlermMessage",
                data:{},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success:function(datas) {
                    //alert("success");
                    var json = eval(datas);
                    var markerArray = [];
                    var n = json.length-1;
                    document.getElementById("td0001").innerHTML=json[n].code;
                    document.getElementById("td0002").innerHTML=json[n].uploadTime;
                    document.getElementById("td0003").innerHTML=json[n].name;
                    document.getElementById("td0004").innerHTML=json[n].IMEI;
                    document.getElementById("td0005").innerHTML=json[n].school;
                    document.getElementById("td0006").innerHTML=json[n].description;
                    document.getElementById("td0007").innerHTML=json[n].parent;
                    document.getElementById("td0008").innerHTML=json[n].parentphone;
                    document.getElementById("td0009").innerHTML=json[n].state;
                    //document.getElementById("td0009").innerHTML=;

                    n--;
                    document.getElementById("td0101").innerHTML=json[n].code;
                    document.getElementById("td0102").innerHTML=json[n].uploadTime;
                    document.getElementById("td0103").innerHTML=json[n].name;
                    document.getElementById("td0104").innerHTML=json[n].IMEI;
                    document.getElementById("td0105").innerHTML=json[n].school;
                    document.getElementById("td0106").innerHTML=json[n].description;
                    document.getElementById("td0107").innerHTML=json[n].parent;
                    document.getElementById("td0108").innerHTML=json[n].parentphone;
                    document.getElementById("td0109").innerHTML=json[n].state;
                    //document.getElementById("td0109").innerHTML=;

                    n--;
                    document.getElementById("td0201").innerHTML=json[n].code;
                    document.getElementById("td0202").innerHTML=json[n].uploadTime;
                    document.getElementById("td0203").innerHTML=json[n].name;
                    document.getElementById("td0204").innerHTML=json[n].IMEI;
                    document.getElementById("td0205").innerHTML=json[n].school;
                    document.getElementById("td0206").innerHTML=json[n].description;
                    document.getElementById("td0207").innerHTML=json[n].parent;
                    document.getElementById("td0208").innerHTML=json[n].parentphone;
                    document.getElementById("td0209").innerHTML=json[n].state;
                    //document.getElementById("td0209").innerHTML=;

                    n--;
                    document.getElementById("td0301").innerHTML=json[n].code;
                    document.getElementById("td0302").innerHTML=json[n].uploadTime;
                    document.getElementById("td0303").innerHTML=json[n].name;
                    document.getElementById("td0304").innerHTML=json[n].IMEI;
                    document.getElementById("td0305").innerHTML=json[n].school;
                    document.getElementById("td0306").innerHTML=json[n].description;
                    document.getElementById("td0307").innerHTML=json[n].parent;
                    document.getElementById("td0308").innerHTML=json[n].parentphone;
                    document.getElementById("td0309").innerHTML=json[n].state;
                    //document.getElementById("td0309").innerHTML=;

                    n--;
                    document.getElementById("td0401").innerHTML=json[n].code;
                    document.getElementById("td0402").innerHTML=json[n].uploadTime;
                    document.getElementById("td0403").innerHTML=json[n].name;
                    document.getElementById("td0404").innerHTML=json[n].IMEI;
                    document.getElementById("td0405").innerHTML=json[n].school;
                    document.getElementById("td0406").innerHTML=json[n].description;
                    document.getElementById("td0407").innerHTML=json[n].parent;
                    document.getElementById("td0408").innerHTML=json[n].parentphone;
                    document.getElementById("td0409").innerHTML=json[n].state;
                    //document.getElementById("t0409").innerHTML=;

                    n--;
                    document.getElementById("td0501").innerHTML=json[n].code;
                    document.getElementById("td0502").innerHTML=json[n].uploadTime;
                    document.getElementById("td0503").innerHTML=json[n].name;
                    document.getElementById("td0504").innerHTML=json[n].IMEI;
                    document.getElementById("td0505").innerHTML=json[n].school;
                    document.getElementById("td0506").innerHTML=json[n].description;
                    document.getElementById("td0507").innerHTML=json[n].parent;
                    document.getElementById("td0508").innerHTML=json[n].parentphone;
                    document.getElementById("td0509").innerHTML=json[n].state;
                    //document.getElementById("td0509").innerHTML=;

                    n--;
                    document.getElementById("td0601").innerHTML=json[n].code;
                    document.getElementById("td0602").innerHTML=json[n].uploadTime;
                    document.getElementById("td0603").innerHTML=json[n].name;
                    document.getElementById("td0604").innerHTML=json[n].IMEI;
                    document.getElementById("td0605").innerHTML=json[n].school;
                    document.getElementById("td0606").innerHTML=json[n].description;
                    document.getElementById("td0607").innerHTML=json[n].parent;
                    document.getElementById("td0608").innerHTML=json[n].parentphone;
                    document.getElementById("td0609").innerHTML=json[n].state;
                    //document.getElementById("td0609").innerHTML=;

                    n--;
                    document.getElementById("td0701").innerHTML=json[n].code;
                    document.getElementById("td0702").innerHTML=json[n].uploadTime;
                    document.getElementById("td0703").innerHTML=json[n].name;
                    document.getElementById("td0704").innerHTML=json[n].IMEI;
                    document.getElementById("td0705").innerHTML=json[n].school;
                    document.getElementById("td0706").innerHTML=json[n].description;
                    document.getElementById("td0707").innerHTML=json[n].parent;
                    document.getElementById("td0708").innerHTML=json[n].parentphone;
                    document.getElementById("td0709").innerHTML=json[n].state;
                    //document.getElementById("td0709").innerHTML=;

                    n--;
                    document.getElementById("td0801").innerHTML=json[n].code;
                    document.getElementById("td0802").innerHTML=json[n].uploadTime;
                    document.getElementById("td0803").innerHTML=json[n].name;
                    document.getElementById("td0804").innerHTML=json[n].IMEI;
                    document.getElementById("td0805").innerHTML=json[n].school;
                    document.getElementById("td0806").innerHTML=json[n].description;
                    document.getElementById("td0807").innerHTML=json[n].parent;
                    document.getElementById("td0808").innerHTML=json[n].parentphone;
                    document.getElementById("td0809").innerHTML=json[n].state;
                    //document.getElementById("td0809").innerHTML=;

                    n--;
                    document.getElementById("td0901").innerHTML=json[n].code;
                    document.getElementById("td0902").innerHTML=json[n].uploadTime;
                    document.getElementById("td0903").innerHTML=json[n].name;
                    document.getElementById("td0904").innerHTML=json[n].IMEI;
                    document.getElementById("td0905").innerHTML=json[n].school;
                    document.getElementById("td0906").innerHTML=json[n].description;
                    document.getElementById("td0907").innerHTML=json[n].parent;
                    document.getElementById("td0908").innerHTML=json[n].parentphone;
                    document.getElementById("td0909").innerHTML=json[n].state;
                    //document.getElementById("td0909").innerHTML=;

                    n--;
                    document.getElementById("td1001").innerHTML=json[n].code;
                    document.getElementById("td1002").innerHTML=json[n].uploadTime;
                    document.getElementById("td1003").innerHTML=json[n].name;
                    document.getElementById("td1004").innerHTML=json[n].IMEI;
                    document.getElementById("td1005").innerHTML=json[n].school;
                    document.getElementById("td1006").innerHTML=json[n].description;
                    document.getElementById("td1007").innerHTML=json[n].parent;
                    document.getElementById("td1008").innerHTML=json[n].parentphone;
                    document.getElementById("td1009").innerHTML=json[n].state;
                    //document.getElementById("td1009").innerHTML=;

                    n--;
                    document.getElementById("td1101").innerHTML=json[n].code;
                    document.getElementById("td1102").innerHTML=json[n].uploadTime;
                    document.getElementById("td1103").innerHTML=json[n].name;
                    document.getElementById("td1104").innerHTML=json[n].IMEI;
                    document.getElementById("td1105").innerHTML=json[n].school;
                    document.getElementById("td1106").innerHTML=json[n].description;
                    document.getElementById("td1107").innerHTML=json[n].parent;
                    document.getElementById("td1108").innerHTML=json[n].parentphone;
                    document.getElementById("td1109").innerHTML=json[n].state;
                    //document.getElementById("td1109").innerHTML=;

                    n--;
                    document.getElementById("td1201").innerHTML=json[n].code;
                    document.getElementById("td1202").innerHTML=json[n].uploadTime;
                    document.getElementById("td1203").innerHTML=json[n].name;
                    document.getElementById("td1204").innerHTML=json[n].IMEI;
                    document.getElementById("td1205").innerHTML=json[n].school;
                    document.getElementById("td1206").innerHTML=json[n].description;
                    document.getElementById("td1207").innerHTML=json[n].parent;
                    document.getElementById("td1208").innerHTML=json[n].parentphone;
                    document.getElementById("td1209").innerHTML=json[n].state;
                    //document.getElementById("td1209").innerHTML=;

                    n--;
                    document.getElementById("td1301").innerHTML=json[n].code;
                    document.getElementById("td1302").innerHTML=json[n].uploadTime;
                    document.getElementById("td1303").innerHTML=json[n].name;
                    document.getElementById("td1304").innerHTML=json[n].IMEI;
                    document.getElementById("td1305").innerHTML=json[n].school;
                    document.getElementById("td1306").innerHTML=json[n].description;
                    document.getElementById("td1307").innerHTML=json[n].parent;
                    document.getElementById("td1308").innerHTML=json[n].parentphone;
                    document.getElementById("td1309").innerHTML=json[n].state;
                    //document.getElementById("td1309").innerHTML=;
                    n--;
                    document.getElementById("td1401").innerHTML=json[n].code;
                    document.getElementById("td1402").innerHTML=json[n].uploadTime;
                    document.getElementById("td1403").innerHTML=json[n].name;
                    document.getElementById("td1404").innerHTML=json[n].IMEI;
                    document.getElementById("td1405").innerHTML=json[n].school;
                    document.getElementById("td1406").innerHTML=json[n].description;
                    document.getElementById("td1407").innerHTML=json[n].parent;
                    document.getElementById("td1408").innerHTML=json[n].parentphone;
                    document.getElementById("td1409").innerHTML=json[n].state;
                    //document.getElementById("td1409").innerHTML=;
                },
                error:function(data) {
                    // alert("请求失败，请稍后再试");
                    return;
                }
            });
        }
        // getStudentAlermMessage();

        var int=self.setInterval("getStudentAlermMessage()",1*1000);
        function onBtn() {
            var starttime = document.getElementsByName("startDate")[0].value;
            var endtime = document.getElementsByName("endDate")[0].value;
            var iemi = document.getElementsByName("IEMI")[0].value;
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
