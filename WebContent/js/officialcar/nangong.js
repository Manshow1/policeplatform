// 页面打开时调用


 $(function(){



    // $('.guiji').hide();//轨迹跟踪隐藏
    // $('.guijihuifang').hide();//轨迹回放隐藏
//     $('#allmap1').hide();//轨迹跟踪地图隐藏
//     $('#allmap2').hide();//轨迹回放地图隐藏
 window.addEventListener("load",function(){
//   var div1 = document.createElement("div");
//   div1.setAttribute("id", "allmap1");//给元素加id
// var div2 = document.createElement("div");
//   div2.setAttribute("id", "allmap2");//给元素加id
     $("#allmap1").css("display","none");
     $("#allmap2").css("display","none");
    //  $('#allmap1').hide();//轨迹跟踪地图隐藏
    // $('#allmap2').hide();//轨迹回放地图隐藏

  });

    $('#li1').click(function () {
       $('#allmap').show();//地图显示
       $('.informshow').show();//表格信息显示
       $('.query').hide();//报警信息管理隐藏
       $('.guiji').hide();//轨迹跟踪隐藏
       $('.guijihuifang').hide();//轨迹回放隐藏
          $('#allmap1').hide();//轨迹跟踪地图隐藏
          $('#allmap2').hide();//轨迹回放地图隐藏
          $('guiji1').css("display","none");
          $('.zhanwei').css("display","block");

 });
    $('#li2').click(function () {
       $('.query').show();//报警信息管理显示
       $('.informshow').show();//表单信息显示
       $('#allmap').hide();//地图隐藏
       $('.guiji').hide();//轨迹跟踪隐藏
       $('.guijihuifang').hide();//轨迹回放隐藏
       $('#allmap1').hide();//轨迹跟踪地图隐藏
       $('#allmap2').hide();//轨迹回放地图隐藏
       $('.guiji1').css("display","none");
       $('.zhanwei').css("display","block");

 });
    $('#li3').click(function () {
       $('.guiji').show();//轨迹跟踪显示
       $('#allmap1').css("display","block");
       $('#allmap').hide();//地图隐藏
       $('.informshow').hide();//表格信息隐藏
       $('.query').hide();//报警信息管理隐藏
       $('.guijihuifang').hide();//轨迹回放隐藏
       $('#allmap2').hide();//轨迹回放地图隐藏
       $('.guiji').css("display","block");
       $('.guiji1').css("display","block");
       $('.zhanwei').css("display","none");
 });
    $('#li4').click(function () {
       $('.guijihuifang').show();//轨迹回放显示
       $('#allmap2').css("display","block")
       $('#allmap').hide();//地图隐藏
       $('.informshow').hide();//表格信息隐藏
       $('.query').hide();//报警信息管理隐藏
       $('#allmap1').hide();//轨迹跟踪地图隐藏
       $('.guiji').hide();//轨迹跟踪显示
       $('.guiji1').css("display","block");
       $('.guiji').css("display","none");
       $('.zhanwei').css("display","none")
 });

  });








