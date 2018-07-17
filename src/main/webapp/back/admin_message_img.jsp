<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/back/";
    String imgPath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/img/";
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
                        管理员<%=session.getAttribute("username")%>>
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
                            <div class="widget-title am-fl">朋友圈首页图片</div>
                            <div class="widget-function am-fr">
                                <a href="javascript:;" class="am-icon-cog"></a>
                            </div>
                        </div>
                        <div class="widget-body am-fr">

                            <form class="am-form tpl-form-line-form"  action="/test/Admin/AdminSetMessageImg" method="post" enctype="multipart/form-data">


                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">原图片
                                        <span class="tpl-form-line-small-title"></span>
                                    </label>
                                    <div class="am-u-sm-9">
                                        <div class="am-form-group am-form-file">
                                            <div class="tpl-form-file-img">
                                                <img src="<%=imgPath%>${messageImg}" style="width: 500px;height: 360px" alt="">
                                            </div>
                                            <button type="button" class="am-btn am-btn-danger am-btn-sm">
                                                <i class="am-icon-cloud-upload"></i> 点击图片修改</button>
                                            <input id="doc-form-file" accept="image/*" onchange="changepic(this)" type="file" name="img">
                                        </div>
                                        <div  class="am-form-group am-form-file">
                                            <img src="" id="show" width="300" >
                                        </div>

                                        <script>
                                            function changepic() {
                                                var reads= new FileReader();
                                                f=document.getElementById('doc-form-file').files[0];
                                                reads.readAsDataURL(f);
                                                reads.onload=function (e) {
                                                    document.getElementById('show').src=this.result;
                                                };
                                            }
                                        </script>

                                    </div>
                                </div>







                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <input type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success " value="保存"></input>
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
