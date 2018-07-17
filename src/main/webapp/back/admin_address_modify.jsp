<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/back/";
    //String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/img/";
    //System.out.println(imgPath);
    //String videoPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/video/";
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Neuedu Admin</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=basePath%>assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="<%=basePath%>assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=basePath%>assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=basePath%>assets/css/app.css">
    <script src="<%=basePath%>assets/js/jquery.min.js"></script>
    <script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp&key=NY4BZ-LPH3U-7ORV6-2J4YO-6DBLZ-Y2BIV"></script>

    <script>
        var citylocation, map, marker = null;
		var searchService, markers = [];
        window.onload = function () {

            //直接加载地图


            //初始化地图函数  自定义函数名init
            function init() {
                //定义map变量 调用 qq.maps.Map() 构造函数   获取地图显示容器
                var map = new qq.maps.Map(document.getElementById("mapcontainer"), {
                    center: new qq.maps.LatLng("${address.latitude}", "${address.longitude}"), // 地图的中心地理坐标。
                    zoom: 18 // 地图的中心地理坐标。
                });
                qq.maps.event.addListener(map, 'click', function (event) {
                    document.getElementById("latLng").value = event.latLng.getLat() + ',' +
                        event.latLng.getLng();
                    alert('您点击的位置为: [' + event.latLng.getLat() + ',' +
                        event.latLng.getLng() + ']');
                });

                citylocation = new qq.maps.CityService({
                    complete: function (results) {
                        map.setCenter(results.detail.latLng);
                        city.style.display = 'inline';
                        city.innerHTML = '所在位置: ' + results.detail.name;

                        if (marker != null) {
                            marker.setMap(null);
                        }
                        //设置marker标记
                        marker = new qq.maps.Marker({
                            map: map,
                            position: results.detail.latLng
                        });
                    }
                });

                var latlngBounds = new qq.maps.LatLngBounds();
                //设置Poi检索服务，用于本地检索、周边检索
                searchService = new qq.maps.SearchService({
                    //设置搜索范围为北京
                    location: "中国",
                    //设置搜索页码为1
                    pageIndex: 1,
                    //设置每页的结果数为5
                    pageCapacity: 5,
                    //设置展现查询结构到infoDIV上
                    panel: document.getElementById('infoDiv'),
                    //设置动扩大检索区域。默认值true，会自动检索指定城市以外区域。
                    autoExtend: true,
                    //检索成功的回调函数
                    complete: function (results) {
                        //设置回调函数参数
                        var pois = results.detail.pois;
                        for (var i = 0, l = pois.length; i < l; i++) {
                            var poi = pois[i];
                            //扩展边界范围，用来包含搜索到的Poi点
                            latlngBounds.extend(poi.latLng);
                            var marker = new qq.maps.Marker({
                                map: map,
                                position: poi.latLng
                            });

                            marker.setTitle(i + 1);

                            markers.push(marker);

                        }
                        //调整地图视野
                        map.fitBounds(latlngBounds);
                    },
                    //若服务请求失败，则运行以下函数
                    error: function () {
                        alert("出错了。");
                    }
                });
            }

            //调用初始化函数地图
            init();


        }

        function geolocation_latlng() {
            //获取经纬度信息
            var input = document.getElementById("latLng").value;
            //用,分割字符串截取两位长度
            var latlngStr = input.split(",", 2);
            //解析成浮点数 取值第一位 第二位
            var lat = parseFloat(latlngStr[0]);
            var lng = parseFloat(latlngStr[1]);
            //设置经纬度信息
            var latLng = new qq.maps.LatLng(lat,lng);
            //调用城市经纬度查询接口实现经纬查询
            citylocation.searchCityByLatLng(latLng);
        }

        function clearOverlays(overlays) {
            var overlay;
            while (overlay = overlays.pop()) {
                overlay.setMap(null);
            }
        }
        //设置搜索的范围和关键字等属性
        function searchKeyword() {
            var keyword = document.getElementById("keyword").value;
			var mylocation = document.getElementById("mylocation").value;
            clearOverlays(markers);
            //根据输入的城市设置搜索范围
             searchService.setLocation(mylocation);
            //根据输入的关键字在搜索范围内检索
            searchService.search(keyword);
        }
    </script>

</head>

<body data-type="widgets">
    <script src="<%=basePath%>assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="/test/Admin/AdminGoToIndex">
                    <img src="<%=basePath%>assets/img/logo.png" alt="">
                </a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                    </span>
                </div>

                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>


                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="/test/AdminExit">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        <!-- 风格切换 -->
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>

        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="<%=basePath%>assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
                        <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
                        管理员<%=session.getAttribute("username")%>
                    </span>

                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-cubes sidebar-nav-link-logo"></i> 企业管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminGoToEnterpriseBasic">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 企业基本信息浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllAddress">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 企业分部信息浏览及修改
                            </a>
                        </li>


                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-trophy sidebar-nav-link-logo"></i> 师资管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllTeacher">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>师资信息浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/test/back/admin_teacher_add.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 添加老师
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToSetTeacherImg">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 师资首页图片修改
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 课程管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllLesson">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>实体课程浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllFreelisten">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>体验课程浏览及修改
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToAddOneLesson">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>添加实体课程
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToAddOneFreelisten">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>添加体验课程
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-leanpub sidebar-nav-link-logo"></i>预约管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllFreelistenbook">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>预约查询及处理
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-shopping-bag sidebar-nav-link-logo"></i>订单管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllSorder">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>订单查询
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllSorderForRefund">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>退款处理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllSorderForCAV">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>订单核销
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-comment sidebar-nav-link-logo"></i>朋友圈管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">

                        <li class="sidebar-nav-link">
                            <a href="/test/back/admin_message_add.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>发布信息
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToShowAllMessage">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>评论管理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/test/Admin/AdminToSetMessageImg">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>首页图片
                            </a>
                        </li>

                    </ul>
                </li>
                

            </ul>
        </div>
        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">



            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">修改分部</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-line-form" action="/test/Admin/AdminSetOneAddress" method="post">

                                    <input type="hidden" name="id" class="tpl-form-input" id="user-name" value="${address.id}">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">分部名字
                                            <span class="tpl-form-line-small-title"></span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="branch" class="tpl-form-input" id="user-name" value="${address.branch}">
                                        </div>
                                    </div>





                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">分部电话
                                            <span class="tpl-form-line-small-title"></span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="tel" class="tpl-form-input" id="user-name" value="${address.tel}">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">分部地址
                                            <span class="tpl-form-line-small-title"></span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            <input type="text"  class="tpl-form-input" id="user-name" name="address" value="${address.address}">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">分部坐标</label>

                                        <!--<div class="am-u-sm-9" id="allmap"></div>-->
                                        <div>
                                            <input id="latLng" style="color:#40E0D0" type="textbox" name="pot" value="${pot}">
                                            <input style="color:#40E0D0" type="button" value="search" onclick="geolocation_latlng()">
                                            <span style="height:30px;display:none" id="city"></span>
                                        </div>

                                        <div>
                                            <input id="keyword" style="color:#40E0D0" type="textbox" value="东软">
                                            <input type="button" style="color:#40E0D0 " value="search" onclick="searchKeyword()">
                                        </div>




                                    </div>


                                    <div class="am-form-group">

                                        <label for="user-intro" class="am-u-sm-3 am-form-label">地图</label>
                                        <div id="mapcontainer" style="width:500px; height:400px"></div>

                                    </div>





                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <input type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="确认修改"></input>
                                        </div>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
        </div>
    </div>
    </div>



    <script src="<%=basePath%>assets/js/amazeui.min.js"></script>
    <script src="<%=basePath%>assets/js/amazeui.datatables.min.js"></script>
    <script src="<%=basePath%>assets/js/dataTables.responsive.min.js"></script>
    <script src="<%=basePath%>assets/js/app.js"></script>

</body>

</html>
