<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/back/";
    String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/img/";
    System.out.println(imgPath);
    String videoPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/video/";
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
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
                    alert('您点击的位置为: [' + event.latLng.getLat() + ', ' +
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
            var latLng = new qq.maps.LatLng(lat, lng);
            //调用城市经纬度查询接口实现经纬查询
            citylocation.searchCityByLatLng(latLng);
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
                <a href="/AdminGoToIndex">
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
                            <a href="javascript:;">
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
                        管理员${username}
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
                            <a href="/AdminGoToEnterpriseBasic">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 企业基本信息浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/AdminToShowAllAddress">
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
                            <a href="/AdminToShowAllTeacher">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>师资信息浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/back/admin_teacher_add.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 添加老师
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/AdminToSetTeacherImg">
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
                            <a href="/AdminToShowAllLesson">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>实体课程浏览及修改
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="/AdminToShowAllFreelisten">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>体验课程浏览及修改
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToAddOneLesson">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>添加实体课程
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToAddOneFreelisten">
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
                            <a href="/AdminToShowAllFreelistenbook">
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
                            <a href="/AdminToShowAllSorder">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>订单查询
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToShowAllSorderForRefund">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>退款处理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToShowAllSorderForCAV">
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
                            <a href="message-see.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>信息列表
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="message-add.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>发布信息
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="message-comments.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>评论管理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="message-img.html">
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
                                <div class="widget-title am-fl">分部具体信息</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-line-form">

                                    <input type="hidden" name="id" value="${address.id}" name="id"/>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">分部名字
                                            <span class="tpl-form-line-small-title"></span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            ${address.branch}
                                        </div>
                                    </div>





                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">分部电话
                                            <span class="tpl-form-line-small-title"></span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            ${address.tel}
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">分部地址</label>

                                        <!--<div class="am-u-sm-9" id="allmap"></div>-->
                                        <div>
                                            ${address.address}+${address.id}
                                        </div>




                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">分部纬度经度</label>

                                        <!--<div class="am-u-sm-9" id="allmap"></div>-->
                                        <div>
                                            ${address.latitude},${address.longitude}
                                        </div>




                                    </div>

                                    <div class="am-form-group">

                                        <label for="user-intro" class="am-u-sm-3 am-form-label">地图</label>
                                        <div id="mapcontainer" style="width:500px; height:400px"></div>

                                    </div>





                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <a href="/AdminToSetOneAddress?id=${address.id}" class="am-btn am-btn-primary tpl-btn-bg-color-success ">修改</a>
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
