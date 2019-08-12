<%--
  Created by IntelliJ IDEA.
  User: 皓珺
  Date: 2019/8/6
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itdr.pojo.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>这是主页</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/zyys.css">
 <%--f   <link rel="stylesheet" href="css/home.css">--%>
</head>
<body>
<%--左边栏--%>
<div id="tb">
    <div id="hy">
        <div>
            <span>foodie,欢迎${user.uname}</span>
        </div>
    </div>
    <div id="li_wk">
        <div id="li1">
            <img src="${pageContext.request.contextPath }/imgs/gly.png" height="70px" width="70px">
            <span class="li_a">管理员列表</span>
            <%--<a href="" class="li_a" target="neilian">管理员列表</a>--%>
        </div>
        <div id="li2">
            <img src="${pageContext.request.contextPath }/imgs/yhgl.png" height="70px" width="70px">
            <span id="li2_s">用户管理</span>
        </div>
        <div id="li3">
            <img src="${pageContext.request.contextPath }/imgs/spgl.png" height="70px" width="70px">
            <span id="li3_s">商品管理</span>
            <%--<a href="" class="li_a"  id="li3_a">商品管理</a>--%>
        </div>
        <div id="li4">
            <img src="${pageContext.request.contextPath }/imgs/ddgl.png" height="70px" width="70px">
            <span id="li4_s">订单管理</span>
        </div>
        <div id="li5">
            <img src="${pageContext.request.contextPath }/imgs/flgl.png" height="70px" width="70px">
            <span id="li5_s">分类管理</span>
            <%--<a href="/manage/order/list.do" class="li_a">分类功能</a>--%>
        </div>
    </div>
</div>
<%--下拉菜单--%>
   <%--用户管理--%>
      <div id="li2_ul">
          <div class="li2_ul_div">
              <div id="li2tp" >
                  <img src="${pageContext.request.contextPath }/imgs/lb.png"  height="40px" width="40px">
              </div>
              <div id="li2wz">
                  <span>用户列表</span>
              </div>
          </div>

     </div>
   <%--商品--%>
      <div id="li3_ul">
          <div class="li3_ul_div">
              <div id="tp">
                  <img src="${pageContext.request.contextPath }/imgs/lb.png" height="40px" width="40px">
              </div>
               <div id="wz">
                   <span>商品列表</span>
               </div>
          </div>
          <div class="li3_ul_div">
              <div id="tp1">
                  <img src="${pageContext.request.contextPath }/imgs/ss.png" height="40px" width="40px">
              </div>
              <div id="wz1">
                  <span>商品搜索</span>
              </div>
          </div>
          <div class="li3_ul_div">
          <div id="tp3">
              <img src="${pageContext.request.contextPath }/imgs/gg.png" height="40px" width=40px">
          </div>
          <div id="wz3">
              <span>新增/更新商品</span>
          </div>
          </div>
     </div>
   <%--订单--%>
      <div id="li4_ul">
          <div class="li4_ul_div">
              <div id="li4tp">
                  <img src="${pageContext.request.contextPath }/imgs/lb.png" height="40px" width="40px">
              </div>
              <div id="li4wz">
                  <span>订单列表</span>
              </div>
          </div>
          <div class="li4_ul_div">
              <div id="li4tp1">
                  <img src="${pageContext.request.contextPath }/imgs/ss.png" height="40px" width="40px">
              </div>
              <div id="li4wz1">
                  <span>订单号查询</span>
              </div>
          </div>
       </div>
    <%--分类--%>
      <div id="li5_ul">
          <div class="li5_ul_div">
              <div id="li5tp">
                  <img src="${pageContext.request.contextPath }/imgs/lb.png" height="40px" width="40px">
              </div>
              <div id="li5wz">
                  <span>获取品类子节点</span>
              </div>
          </div>
          <div class="li4_ul_div">
              <div id="li5tp1">
                  <img src="${pageContext.request.contextPath }/imgs/ss.png" height="40px" width="40px">
              </div>
              <div id="li5wz1">
                  <span>增加节点</span>
              </div>
          </div>
          <div class="li4_ul_div">
              <div id="li5tp2">
                  <img src="${pageContext.request.contextPath }/imgs/xq.png" height="40px" width="40px">
              </div>
              <div id="li5wz2">
                  <span>修改品类名</span>
              </div>
          </div>
          <div class="li4_ul_div">
              <div id="li5tp3">
                  <img src="${pageContext.request.contextPath }/imgs/xq.png" height="40px" width="40px">
              </div>
              <div id="li5wz3">
                  <span>获取类</span>
              </div>
          </div>
      </div>
<%--主视窗--%>
<div id="zy">
    <div id="zy1"></div>
</div>
</body>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>
 //侧边栏鼠标点击
   $("#li2").click(function () {
        $("#li2_ul").slideDown("slow");
        $("#li3_ul").slideUp("slow");
        $("#li4_ul").slideUp("slow");
        $("#li5_ul").slideUp("slow");
        // if ($("#li2_ul").style("display")=="block"){
        //     $("#li2_ul").slideUp();
        // }
    });
   $("#li3").click(function () {
       $("#li3_ul").slideDown("slow");
       $("#li2_ul").slideUp("slow");
       $("#li4_ul").slideUp("slow");
       $("#li5_ul").slideUp("slow");
   });
   $("#li4").click(function () {
       $("#li4_ul").slideDown("slow");
       $("#li3_ul").slideUp("slow");
       $("#li2_ul").slideUp("slow");
       $("#li5_ul").slideUp("slow");
   });
   $("#li5").click(function () {
       $("#li5_ul").slideDown("slow");
       $("#li3_ul").slideUp("slow");
       $("#li4_ul").slideUp("slow");
       $("#li2_ul").slideUp("slow");
   });
//鼠标经过
    $("#li2tp").mouseover(function () {
        $("#li2tp").css("display", "none");
        $("#li2wz").css("display", "block");

    });
    $("#li2wz").mouseout(function () {
        $("#li2wz").css("display","none");
        $("#li2tp").css("display","block");
    });
    //商品鼠标经过
    $("#tp").mouseover(function () {
            $("#tp").css("display", "none");
            $("#wz").css("display", "block");

        });
    $("#wz").mouseout(function () {
            $("#wz").css("display","none");
            $("#tp").css("display","block");
        });
    $("#tp1").mouseover(function () {
            $("#tp1").css("display", "none");
            $("#wz1").css("display", "block");

        });
    $("#wz1").mouseout(function () {
            $("#wz1").css("display","none");
            $("#tp1").css("display","block");
        });
    $("#tp2").mouseover(function () {
            $("#tp2").css("display", "none");
            $("#wz2").css("display", "block");

        });
    $("#wz2").mouseout(function () {
            $("#wz2").css("display","none");
            $("#tp2").css("display","block");
        });
    $("#tp3").mouseover(function () {
            $("#tp3").css("display", "none");
            $("#wz3").css("display", "block");
        });
    $("#wz3").mouseout(function () {
            $("#wz3").css("display","none");
            $("#tp3").css("display","block");
        });
    //订单鼠标经过
    $("#li4tp").mouseover(function () {
        $("#li4tp").css("display", "none");
        $("#li4wz").css("display", "block");

    });
    $("#li4wz").mouseout(function () {
        $("#li4wz").css("display","none");
        $("#li4tp").css("display","block");
    });
    $("#li4tp1").mouseover(function () {
        $("#li4tp1").css("display", "none");
        $("#li4wz1").css("display", "block");

    });
    $("#li4wz1").mouseout(function () {
        $("#li4wz1").css("display","none");
        $("#li4tp1").css("display","block");
    });
    $("#li4tp2").mouseover(function () {
        $("#li4tp2").css("display", "none");
        $("#li4wz2").css("display", "block");

    });
    $("#li4wz2").mouseout(function () {
        $("#li4wz2").css("display","none");
        $("#li4tp2").css("display","block");
    });
    //节点鼠标经过事件
    $("#li5tp").mouseover(function () {
        $("#li5tp").css("display", "none");
        $("#li5wz").css("display", "block");

    });
    $("#li5wz").mouseout(function () {
        $("#li5wz").css("display","none");
        $("#li5tp").css("display","block");
    });
    $("#li5tp1").mouseover(function () {
        $("#li5tp1").css("display", "none");
        $("#li5wz1").css("display", "block");

    });
    $("#li5wz1").mouseout(function () {
        $("#li5wz1").css("display","none");
        $("#li5tp1").css("display","block");
    });
    $("#li5tp2").mouseover(function () {
        $("#li5tp2").css("display", "none");
        $("#li5wz2").css("display", "block");

    });
    $("#li5wz2").mouseout(function () {
        $("#li5wz2").css("display","none");
        $("#li5tp2").css("display","block");
    });
    $("#li5tp3").mouseover(function () {
        $("#li5tp3").css("display", "none");
        $("#li5wz3").css("display", "block");

    });
    $("#li5wz3").mouseout(function () {
     $("#li5wz3").css("display","none");
     $("#li5tp3").css("display","block");
 });
//列表功能,详情功能
    //userlist
    $("#li2wz").click(function () {
        $("#zy").empty();
        $.post(
           "/manage/user/list.do",
            function (du) {
               var bt = " <tr id=\'utable_tou\'><th>ID</th>" +
                   "<th>用户名</th>" +
                   "<th>密码</th>" +
                   "<th>电话</th>" +
                   "<th>权限</th>" +
                   "<th>状态</th>" +
                   "<th>操作</th>" +
                   "</tr>";
                $("#zy").append(bt);
               for (var i=0; i<du.data.length ; i++) {
                   var bg ="<tr id=\'utable_ti\'> <td>"+du.data[i].uid+"</td>"+
                           "<td>"+du.data[i].uname+"</td>"+
                           "<td>"+du.data[i].psd+"</td>"+
                           "<td>"+du.data[i].tel+"</td>"+
                       "<td>"+du.data[i].type+"</td>"+
                       "<td>"+du.data[i].states+"</td>"+
                       "<td>"+"<button type=\"button\" value="+du.data[i].uid+" id=\"kq\" onclick=\"kaiqi(this)\">开启</button>"+
                       "<button type=\"button\" value="+du.data[i].uid+" id=\"jy\" onclick=\"jinyong(this)\">禁用</button>"+
                   "</td></tr>";
                   $("#zy").append(bg)
               }
            },
            "JSON"
        )
        });
    //productlist
    $("#wz").click(function () {
        $("#zy").empty();
      $.post(
         "/manage/product/list.do",
         function (dtt) {
             var ssk = "<input type=\"text\" placeholder=\"商品ID\" id=\"suk\" name=\"pid\">" +
                 "<input type=\"submit\" value=\"搜索\" id=\"suaj\" onclick=\"xqss()\">";
             $("#zy").append(ssk);
             var pbt = " <tr id =\"pro_tou\"><th>ID</th>" +
                 "<th>商品名</th>" +
                 "<th>图片地址</th>" +
                 "<th>传图</th>" +
                 "<th>价格</th>" +
                 "<th>父类ID</th>" +
                 "<th>上架状态</th>" +
                 "<th>上架操作</th>" +
                 "</tr>";
             $("#zy").append(pbt);
             for (var j=0; j<dtt.data.length ; j++) {
                 var pbg ="<tr id = \"pro_ti\"> <td>"+dtt.data[j].pid+"</td>"+
                     "<td>"+dtt.data[j].pname+"</td>"+
                     "<td>"+dtt.data[j].mainImage+"</td>"+
                     "<td><form action=\"/manage/product/upload.do\" method=\"post\" enctype=\"multipart/form-data\" id=\"upform\">" +
                     "<input type=\"file\" name=\"uping\" id=\"up\" multiple=\"multiple\">" +
                     "<input type=\"submit\" value="+dtt.data[j].pid+" onclick=\"sctp()\"></form></td>"+
                     "<td>"+dtt.data[j].price+"</td>"+
                     "<td>"+dtt.data[j].parentId+"</td>"+
                     "<td>"+dtt.data[j].stats+"</td>"+
                     "<td>"+ "<button type=\"button\" value="+dtt.data[j].pid+" id=\"sj\" onclick=\"shangjia(this)\">上架</button>" +
                     "<button type=\"button\" value="+dtt.data[j].pid+" id=\"xj\" onclick=\"xiajia(this)\">下架</button>" +
                     "</td></tr>";
                 $("#zy").append( pbg );
             }
         },
         "JSON"
     )
 });
    //orderlist
    $("#li4wz").click(function () {
        $("#zy").empty();
     $.post(
         "/manage/order/list.do",
         function (doo) {
             var ssk = "<input type=\"text\" placeholder=\"订单号\" id=\"osuk\" name=\"pid\">" +
                 "<input type=\"submit\" value=\"搜索\" id=\"osuaj\" onclick=\"oxqss()\">";
             $("#zy").append(ssk);
             var obt = " <tr id='ortou'><th>订单号</th>" +
                 "<th>支付状态</th>" +
                 "<th>发货状态</th>" +
                 "<th>订单信息</th>" +
                 "<th>购物总数</th>" +
                 "<th>购物详情</th>" +
                 "<th>操作</th>" +
                 "</tr>";
             $("#zy").append(obt);
             for (var p=0; p<doo.data.length ; p++) {
                 var obg ="<tr id='ordti'> <td>"+doo.data[p].orderNo+"</td>"+
                     "<td>"+doo.data[p].payment+"</td>"+
                     "<td>"+doo.data[p].status+"</td>"+
                     "<td>"+doo.data[p].orderItemVoList+"</td>"+
                     "<td>"+doo.data[p].shippingId+"</td>"+
                     "<td>"+doo.data[p].shippingVo+"</td>"+
                     "<td>"+"<button type=\"button\" value="+doo.data[p].orderNo+" id=\"fh\" onclick=\"fahuo(this)\">发货</button>"+
                     "</td></tr>";
                 $("#zy").append( obg )
             }
         },
         "JSON"
     )
 });
    //分类
    $("#li5wz").click(function () {
        $("#zy").empty();
        var flcx = "<input type=\"text\" placeholder=\"父类ID\" id=\"flk\" name=\"pid\">" +
            "<input type=\"submit\" value=\"搜索\" id=\"flaj\" onclick=\"flss()\">";
        $("#zy").append(flcx)
    });
    function flss() {
        $.post(
            "/manage/category/get_category.do?parentId="+$("#flk").val(),
            function (flans) {
                var flbt = " <tr id=\'fls_tou\'><th>ID</th>" +
                    "<th>父类ID</th>" +
                    "<th>类名称</th>" +
                    "<th>状态</th>" +
                    "</tr>";
                $("#zy").append(flbt);
                for (var z=0; z<flans.data.length ; z++) {
                    var flbg ="<tr id=\'fls_ti\'> <td>"+flans.data[z].id+"</td>"+
                        "<td>"+flans.data[z].parentId+"</td>"+
                        "<td>"+flans.data[z].categoryName+"</td>"+
                        "<td>"+flans.data[z].status+ "</td></tr>";
                    $("#zy").append(flbg)
                }
            },
            "json"
        )
    }

//开启禁用
    function kaiqi(kqq){
        $.post(
            "/manage/user/ableuser.do?uid="+kqq.value ,
            function (kqqs) {
                alert("开启成功");
                $("#zy").empty();
                $.post(
                    "/manage/user/list.do",
                    function (du) {
                        var bt = " <tr id=\'utable_tou\'><th>ID</th>" +
                            "<th>用户名</th>" +
                            "<th>密码</th>" +
                            "<th>电话</th>" +
                            "<th>权限</th>" +
                            "<th>状态</th>" +
                            "<th>操作</th>" +
                            "</tr>";
                        $("#zy").append(bt);
                        for (var i=0; i<du.data.length ; i++) {
                            var bg ="<tr id=\'utable_ti\'> <td>"+du.data[i].uid+"</td>"+
                                "<td>"+du.data[i].uname+"</td>"+
                                "<td>"+du.data[i].psd+"</td>"+
                                "<td>"+du.data[i].tel+"</td>"+
                                "<td>"+du.data[i].type+"</td>"+
                                "<td>"+du.data[i].states+"</td>"+
                                "<td>"+"<button type=\"button\" value="+du.data[i].uid+" id=\"kq\" onclick=\"kaiqi(this)\">开启</button>"+
                                "<button type=\"button\" value="+du.data[i].uid+" id=\"jy\" onclick=\"jinyong(this)\">禁用</button>"+
                                "</td></tr>";
                            $("#zy").append(bg)
                        }
                    },
                    "JSON"
                )
            },
            "JSON"
        )
    }
    function jinyong(jyy){
        $.post(
            "/manage/user/disableuser.do?uid="+jyy.value ,
            function (kqqk) {
                alert("禁用成功");
                $("#zy").empty();
                $.post(
                    "/manage/user/list.do",
                    function (du) {
                        var bt = " <tr id=\'utable_tou\'><th>ID</th>" +
                            "<th>用户名</th>" +
                            "<th>密码</th>" +
                            "<th>电话</th>" +
                            "<th>权限</th>" +
                            "<th>状态</th>" +
                            "<th>操作</th>" +
                            "</tr>";
                        $("#zy").append(bt);
                        for (var i=0; i<du.data.length ; i++) {
                            var bg ="<tr id=\'utable_ti\'> <td>"+du.data[i].uid+"</td>"+
                                "<td>"+du.data[i].uname+"</td>"+
                                "<td>"+du.data[i].psd+"</td>"+
                                "<td>"+du.data[i].tel+"</td>"+
                                "<td>"+du.data[i].type+"</td>"+
                                "<td>"+du.data[i].states+"</td>"+
                                "<td>"+"<button type=\"button\" value="+du.data[i].uid+" id=\"kq\" onclick=\"kaiqi(this)\">开启</button>"+
                                "<button type=\"button\" value="+du.data[i].uid+" id=\"jy\" onclick=\"jinyong(this)\">禁用</button>"+
                                "</td></tr>";
                            $("#zy").append(bg)
                        }
                    },
                    "JSON"
                )
            },
            "json"
        )
    }
//上下架
    function shangjia(sjj){
        $.post(
            "/manage/product/set_sale_status.do?pid="+sjj.value+"&stats=0" ,
            function (kqqs) {
                if (kqqs.status!==0){
                   alert(kqqs.mag)
                } else {
                    alert("上架成功");
                    // window.location.reload();
                    $("#zy").empty();
                    $.post(
                        "/manage/product/list.do",
                        function (dtt) {
                            var ssk = "<input type=\"text\" placeholder=\"商品ID\" id=\"suk\" name=\"pid\">" +
                                "<input type=\"submit\" value=\"搜索\" id=\"suaj\" onclick=\"xqss()\">";
                            $("#zy").append(ssk);
                            var pbt = " <tr id =\"pro_tou\"><th>ID</th>" +
                                "<th>商品名</th>" +
                                "<th>图片地址</th>" +
                                "<th>传图</th>" +
                                "<th>价格</th>" +
                                "<th>父类ID</th>" +
                                "<th>上架状态</th>" +
                                "<th>上架操作</th>" +
                                "</tr>";
                            $("#zy").append(pbt);
                            for (var j=0; j<dtt.data.length ; j++) {
                                var pbg ="<tr id = \"pro_ti\"> <td>"+dtt.data[j].pid+"</td>"+
                                    "<td>"+dtt.data[j].pname+"</td>"+
                                    "<td>"+dtt.data[j].mainImage+"</td>"+
                                    "<td><form action=\"/manage/product/upload.do\" method=\"post\" enctype=\"multipart/form-data\"><input type=\"file\" name=\"uping\" id=\"up\" multiple=\"multiple\">" +
                                    "<input type=\"submit\" value=\"上传\"></form></td>"+
                                    "<td>"+dtt.data[j].price+"</td>"+
                                    "<td>"+dtt.data[j].parentId+"</td>"+
                                    "<td>"+dtt.data[j].stats+"</td>"+
                                    "<td>"+ "<button type=\"button\" value="+dtt.data[j].pid+" id=\"sj\" onclick=\"shangjia(this)\">上架</button>" +
                                    "<button type=\"button\" value="+dtt.data[j].pid+" id=\"xj\" onclick=\"xiajia(this)\">下架</button>" +
                                    "</td></tr>";
                                $("#zy").append( pbg );
                            }
                        },
                        "JSON"
                    )
                }

            },
            "JSON"
        )
    }
    function xiajia(xjj){
     $.post(
         "/manage/product/set_sale_status.do?pid="+xjj.value +"&stats=1",
         function (kqqss) {
             if (kqqss.status!==0){
                 alert(kqqss.mag)
             } else {
                 alert("下架成功");
                 $("#zy").empty();
                 $.post(
                     "/manage/product/list.do",
                     function (dtt) {
                         var ssk = "<input type=\"text\" placeholder=\"商品ID\" id=\"suk\" name=\"pid\">" +
                             "<input type=\"submit\" value=\"搜索\" id=\"suaj\" onclick=\"xqss()\">";
                         $("#zy").append(ssk);
                         var pbt = " <tr id =\"pro_tou\"><th>ID</th>" +
                             "<th>商品名</th>" +
                             "<th>图片地址</th>" +
                             "<th>传图</th>" +
                             "<th>价格</th>" +
                             "<th>父类ID</th>" +
                             "<th>上架状态</th>" +
                             "<th>上架操作</th>" +
                             "</tr>";
                         $("#zy").append(pbt);
                         for (var j=0; j<dtt.data.length ; j++) {
                             var pbg ="<tr id = \"pro_ti\"> <td>"+dtt.data[j].pid+"</td>"+
                                 "<td>"+dtt.data[j].pname+"</td>"+
                                 "<td>"+dtt.data[j].mainImage+"</td>"+
                                 "<td><form action=\"/manage/product/upload.do\" method=\"post\" enctype=\"multipart/form-data\"><input type=\"file\" name=\"uping\" id=\"up\" multiple=\"multiple\">" +
                                 "<input type=\"submit\" value=\"上传\"></form></td>"+
                                 "<td>"+dtt.data[j].price+"</td>"+
                                 "<td>"+dtt.data[j].parentId+"</td>"+
                                 "<td>"+dtt.data[j].stats+"</td>"+
                                 "<td>"+ "<button type=\"button\" value="+dtt.data[j].pid+" id=\"sj\" onclick=\"shangjia(this)\">上架</button>" +
                                 "<button type=\"button\" value="+dtt.data[j].pid+" id=\"xj\" onclick=\"xiajia(this)\">下架</button>" +
                                 "</td></tr>";
                             $("#zy").append( pbg );
                         }
                     },
                     "JSON"
                 )
             }

         },
         "JSON"
     )
 }
//发货
    function fahuo(fh){
        $.post(
            "/manage/order/send_goods.do?orderNo="+fh.value ,
            function (kqqs) {
                if (kqqs.status !==0){
                    alert(kqqs.mag)
                } else {
                    alert("发货成功");
                    $("#zy").empty();
                    $.post(
                        "/manage/order/list.do",
                        function (doo) {
                            var ssk = "<input type=\"text\" placeholder=\"订单号\" id=\"osuk\" name=\"pid\">" +
                                "<input type=\"submit\" value=\"搜索\" id=\"osuaj\" onclick=\"oxqss()\">";
                            $("#zy").append(ssk);
                            var obt = " <tr id='ortou'><th>订单号</th>" +
                                "<th>支付状态</th>" +
                                "<th>发货状态</th>" +
                                "<th>订单信息</th>" +
                                "<th>购物总数</th>" +
                                "<th>购物详情</th>" +
                                "<th>操作</th>" +
                                "</tr>";
                            $("#zy").append(obt);
                            for (var p=0; p<doo.data.length ; p++) {
                                var obg ="<tr id='ordti'> <td>"+doo.data[p].orderNo+"</td>"+
                                    "<td>"+doo.data[p].payment+"</td>"+
                                    "<td>"+doo.data[p].status+"</td>"+
                                    "<td>"+doo.data[p].orderItemVoList+"</td>"+
                                    "<td>"+doo.data[p].shippingId+"</td>"+
                                    "<td>"+doo.data[p].shippingVo+"</td>"+
                                    "<td>"+"<button type=\"button\" value="+doo.data[p].orderNo+" id=\"fh\" onclick=\"fahuo(this)\">发货</button>"+
                                    "</td></tr>";
                                $("#zy").append( obg )
                            }
                        },
                        "JSON"
                    )
                }

            },
            "JSON"
        )
    }
//搜索
    //商品搜索
    $("#wz1").click(function () {
        $("#zy").empty();
        var sskk ="<div class='kkwk'>商品名搜索：<input type=\"text\" id=\"sps\" name=\"pname\" placeholder=\"请输入商品名称\">" +
            "<button type=\"submit\" value=\"\" id =\"spsaj\" onclick=\"spss()\">搜索</button></div>";
        var sskk2 ="</br><div class='kkwk'>商品ID搜索：<input type=\"text\" id=\"spsl2\" name=\"pname\" placeholder=\"请输入商品ID\">" +
            "<button type=\"submit\" value=\"\" id =\"spsaj2\" onclick=\"spss2()\">搜索</button></div>";
        $("#zy").append(sskk2);
        $("#zy").append(sskk);
    });
    function spss(){
        var keyword = $("#sps").val();
        $.post(
            "/manage/product/search.do?pname="+keyword,
            function (keyss) {
                if (keyss.status !==0){
                    alert(keyss.mag);
                } else {
                    var anstou = "<tr id=\'ans_tou\'><th>ID</th><th>用户名</th></tr>";
                    $("#zy").append(anstou);
                    for (var k =0;k<keyss.data.length;k++ ){
                        var ansti = "<tr id=\'ans_ti\'><td>"+keyss.data[k].pid+"</td>"+
                            "<td>"+keyss.data[k].pname+"</td></tr>";
                        $("#zy").append(ansti);
                    }
                }
            },
            "json"
        )}
    function spss2(){
     var keyword1 = $("#spsl2").val();
     $.post(
         "/manage/product/search.do?pid="+keyword1,
         function (keyss2) {
             if (keyss2.status !==0){
                 alert(keyss2.mag);
             } else {
                 var anstou2 = "<tr id=\'ans_tou\'><th>ID</th><th>用户名</th></tr>";
                 $("#zy").append(anstou2);
                     var ansti2 = "<tr id=\'ans_ti\'><td>"+keyss2.data.pid+"</td>"+
                         "<td>"+keyss2.data.pname+"</td></tr>";
                 $("#zy").append(ansti2);
             }
         },
         "json"
     )}
    //订单号查询
      $("#li4wz1").click(function () {
          $("#zy").empty();
          var dd ="<input type=\"text\" id=\"ddh\" placeholder=\"请输入订单号\">" +
              "<button type=\"submit\"  id =\"ddhaj\" onclick=\"chaxun(this)\">查询</button>";
          $("#zy").append(dd)
      });
     function chaxun(ddh) {
         var ddhw = $("#ddh").val();
         $.post(
             "/manage/order/search.do?orderNo="+ddhw,
             function (ddhj) {
                 if (ddhj.status !==0){
                     alert(ddhj.mag);
                 } else {
                     var ddtou = "<tr id=\'ans_tou\'><th>订单号</th><th>发货状态</th></tr>";
                     $("#zy").append(ddtou);
                     alert(ddhj.data.orderNo);
                      var ddti = "<tr id=\'ans_ti\'><td>"+ddhj.data.orderNo+"</td>"+
                             "<td>"+ddhj.data.status+"</td></tr>";
                      $("#zy").append(ddti);
                 }
             },
             "json"
         )
     }
    //商品详情
    function xqss(){
     var xqkeyword = $("#suk").val();
     $.post(
         "/manage/product/detail.do?pid="+xqkeyword,
         function (keyss3) {
             if (keyss3.status !==0){
             } else {
                 $("#zy").empty();
                 var anstou3 = "<input type=\"text\" placeholder=\"商品ID\" id=\"suk\" name=\"pid\">" +
                     "<input type=\"submit\" value=\"搜索\" id=\"suaj\" onclick=\"xqss()\">";
                 $("#zy").append(anstou3);
                 var ansti3 = " <tr id =\"pro_tou\"><th>ID</th>" +
                     "<th>商品名</th>" +
                     "<th>图片地址</th>" +
                     "<th>传图</th>" +
                     "<th>价格</th>" +
                     "<th>父类ID</th>" +
                     "<th>上架状态</th>" +
                     "<th>上架操作</th>" +
                     "</tr>";
                 $("#zy").append(ansti3);
                     var ansti33 ="<tr id = \"pro_ti\"> <td>"+keyss3.data.pid+"</td>"+
                         "<td>"+keyss3.data.pname+"</td>"+
                         "<td>"+keyss3.data.mainImage+"</td>"+
                         "<td><form action=\"/manage/product/upload.do\" method=\"post\" enctype=\"multipart/form-data\">" +
                         "<input type=\"file\" name=\"uping\" id=\"up\"  multiple=\"multiple\">" +
                         "<input type=\"submit\" value=\"上传\" formmethod=\"post\"></form></td>"+
                         "<td>"+keyss3.data.price+"</td>"+
                         "<td>"+keyss3.data.parentId+"</td>"+
                         "<td>"+keyss3.data.stats+"</td>"+
                         "<td>"+ "<button type=\"button\" value=\"+keyss3.data.pid+\" id=\"sj\" onclick=\"shangjia(this)\">上架</button>" +
                         "<button type=\"button\" value=\"+dtt.keyss3.pid+\" id=\"xj\" onclick=\"xiajia(this)\">下架</button>" +
                         "</td></tr>";
                     $("#zy").append( ansti33 );

             }
         },
         "json"
     )}
    //订单详情
    function oxqss(){
     var okeyword = $("#osuk").val();
     $.post(
         "/manage/order/detail.do?orderNo="+okeyword,
         function (doo1) {
             if (doo1.status !==0){
                 alert(doo1.mag);
             } else {
                 $("#zy").empty();
                 var ssk1 = "<input type=\"text\" placeholder=\"订单号\" id=\"osuk\" name=\"pid\">" +
                     "<input type=\"submit\" value=\"搜索\" id=\"osuaj\" onclick=\"oxqss()\">";
                 $("#zy").append(ssk1);
                 var obt1 = " <tr id='ddxa1'><th>订单号</th>" +
                     "<th>支付状态</th>" +
                     "<th>发货状态</th>" +
                     "<th>订单信息</th>" +
                     "<th>购物总数</th>" +
                     "<th>购物详情</th>" +
                     "<th>操作</th>" +
                     "</tr>";
                 $("#zy").append(obt1);
                     var obg1 ="<tr id='ddhxa2'> <td>"+doo1.data.orderNo+"</td>"+
                         "<td>"+doo1.data.payment+"</td>"+
                         "<td>"+doo1.data.status+"</td>"+
                         "<td>"+doo1.data.orderItemVoList+"</td>"+
                         "<td>"+doo1.data.shippingId+"</td>"+
                         "<td>"+doo1.data.shippingVo+"</td>"+
                         "<td>"+"<button type=\"button\" value=\"+dtt.data[p].orderNo+\" id=\"fh\" onclick=\"fahuo(this)\">发货</button>"+
                         "</td></tr>";
                     $("#zy").append( obg1 )
             }
         },
         "json"
     )}

 //图片上传name="uping" id="up"!!!!!
   function sctp(){

       $.ajax({
           url : "/manage/product/upload.do",
           type : "POST",
           data : $( '#upform').serialize(),    //表单序列化 ,【注意】上传文件的文件流是无法被序列化并传递的
           processData:false,   //  告诉jquery不要处理发送的数据
           contentType:false,    // 告诉jquery不要设置content-Type请求头
           success : function(data) {
                  alert("上传成功")
           }
       });
   }

//新增或更新
    $("#wz3").click(function () {
        $("#zy").empty();
        var xzbf = "<div id=\"xzwk\"><h4 id=\"xzh\" )>新增</h4>" +
            "<table id=\"xztable\"><tr id=\"xzbt\"><th>商品名</th><th>传图</th>" +
            "<th>父类ID</th><th>价格</th><th>上架状态</th>" +
            "</tr> " +
            "<tr id=\"xzbs\"><td><input type=\"text\" id='xzspm'></td>" +
            "<td><input type=\"text\" multiple></td> " +
            "<td><input type=\"text\" id='xzcate' ></td>" +
            "<td><input type=\"text\" id='xzjg'></td>" +
            "<td><input type=\"text\" id='xzsta'></td></tr>" +
            "</table><button type=\"submit\" id=\"xztj\" onclick=xz()>提交</button>" +
            "</div>";
        $("#zy").append(xzbf);
        var gxbf = "<div id=\"gxwk\"><h4 id=\"gxh\">更新</h4>" +
            "<table id=\"gxtable\"><tr id=\"gxbt\"><th>ID</th><th>商品名</th><th>传图</th>" +
            "<th>父类ID</th><th>价格</th><th>上架状态</th>" +
            "</tr> " +
            "<tr id=\"gxbs\"><td><input type=\"text\" id='gxid'></td>" +
            "<td><input type=\"text\" id='gxspm' ></td>" +
            "<td><input type=\"text\" multiple></td> " +
            "<td><input type=\"text\" id='gxcate'></td>" +
            "<td><input type=\"text\" id='gxjg'></td>" +
            "<td><input type=\"text\" id='gxstau'></td></tr>" +
            "</table><button type=\"submit\" id=\"gxtj\" onclick=gx()>提交</button>" +
            "</div>";
        $("#zy").append(gxbf)
    });
    //新增 parentId ,price,pname,stats
     function xz(){
         $.post(
             "/manage/product/save.do?parentId="+$("#xzcate").val()+"&price="+$("#xzjg").val()+"&pname="+$("#xzspm").val()+"&stats="+$("#xzsta").val(),
             function (xzanswer) {
              if (xzanswer.status!==0){
                  alert(xzanswer.mag)
              } else {
                  alert("新增成功")
              }
         })
     }
     //更新
      function gx(){
     $.post(
         "/manage/product/save.do?pid="+$("#gxid").val()+"&parentId="+$("#gxcate").val()+"&price="+$("#gxjg").val()+"&pname="+$("#gxspm").val()+"&stats="+$("#gxstau").val(),
         function (gxanswer) {
             if (gxanswer.status!==0){
                 alert(gxanswer.mag)
             } else {
                 alert("更新成功")
             }
         })
 }
//增加节点
   $("#li5wz1").click(function () {
       $("#zy").empty();
       var zhjd = "<div id=\"zjjd\"><table><tr id=\"zjjdt\"><th>节点ID</th>" +
           "<th>品类名</th><th>状态（默认）</th> </tr>" +
           "<tr id=\"zjjds\"> <td><input type=\"text\" id ='parid'></td>" +
           "<td><input type=\"text\"  id='catname'></td><td><p>true</p></td>" +
           "</tr></table><button type=\"submit\" id=\"xztj\" onclick=jdtj()>提交</button>" +
           "</div>";
       $("#zy").append(zhjd)
   });
   function jdtj() {
       $.post(
           "/manage/category/add_category.do?parentId="+$("#parid").val()+"&categoryName="+$("#catname").val(),
           function (zjjdans) {
               if (zjjdans.status!==0){
                   alert(zjjdans.mag)
               } else {
                   alert("添加成功")
               }
           }
       )
   }
//修改品类名称
   $("#li5wz2").click(function () {
       $("#zy").empty();
       var plmc = "<div>" +
           "要修改的品类ID：<input type=\"text\" placeholder=\"ID\" id=\"xgid\"></br>" +
           "修改后品类名称：<input type=\"text\" placeholder=\"名称\" id=\"xghmc\"></br>" +
           "<button type=\"submit\" id=\"xgmctj\" onclick=xgmctj()>提交</button>"+
           "</div>";
       $("#zy").append(plmc)
   });
    function xgmctj() {
        alert("diaoyongle");
      $.post(
          "/manage/category/set_category_name.do?parentId="+$("#xgid").val()+"&categoryName="+$("#xghmc").val(),
          function (zjjdanss) {
              if (zjjdanss.status!==0){
                  alert(zjjdanss.mag)
              } else {
                  alert("添加成功")
              }
          }
      )
  }
//递归
   $("#li5wz3").click(function (){
           $("#zy").empty();
           var dd1 ="<input type=\"text\" id=\"ddh1\" placeholder=\"请输入节点\">" +
               "<button type=\"submit\"  id =\"ddhaj1\" onclick=\"dgcx(this)\">查询</button>";
           $("#zy").append(dd1)
       });
   function dgcx(dgpas) {
       var dgkey = $("#ddh1").val();
       $.post(
           "/manage/category/get_deep_category.do?parentId="+dgkey,
           function (dghj) {
               if (dghj.status !==0){
                   alert(dghj.mag);
               } else {
                   var dgtou = "<tr id=\'dg_tou\'><th>ID</th></tr>";
                   $("#zy").append(dgtou);
                   for (var v =0;v<dghj.data.length;v++){
                       var dgti = "<tr id=\'dg_ti\'><td>"+dghj.data[v].id+"</td></tr>";
                       $("#zy").append(dgti);
                   }
               }
           },
           "json"
       )
   }
//100秒刷新一次zy
//  setInterval("refreshTime()",1000); //每格1秒刷新一次
// function refreshTime(){
//      var dateObj = new Date();
//      $("#zy").innerHTML = dateObj.toLocaleDateString(); //刷新div里面的内容
//  }
</script>

</html>
