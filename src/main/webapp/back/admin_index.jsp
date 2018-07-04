<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>back/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>back/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="<%=request.getContextPath()%>back/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>back/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>back/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>back/assets/css/app.css">
    <script src="<%=request.getContextPath()%>back/assets/js/jquery.min.js"></script>

</head>

<body data-type="index">
    <script src="<%=request.getContextPath()%>back/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="/AdminGoToIndex">
                    <img src="<%=request.getContextPath()%>back/assets/img/logo.png" alt="">
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
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <a href="javascript:;">欢迎你,
                                <span>${username}</span>
                            </a>
                        </li>

                        <%--<!-- 新邮件 -->--%>
                        <%--<li class="am-dropdown tpl-dropdown" data-am-dropdown>--%>
                            <%--<a href="javascript:;" class="am-dropdown-toggle tpl-dropdown-toggle" data-am-dropdown-toggle>--%>
                                <%--<i class="am-icon-envelope"></i>--%>
                                <%--<span class="am-badge am-badge-success am-round item-feed-badge">4</span>--%>
                            <%--</a>--%>
                            <%--<!-- 弹出列表 -->--%>
                            <%--<ul class="am-dropdown-content tpl-dropdown-content">--%>
                                <%--<li class="tpl-dropdown-menu-messages">--%>
                                    <%--<a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">--%>
                                        <%--<div class="menu-messages-ico">--%>
                                            <%--<img src="<%=request.getContextPath()%>back/assets/img/user04.png" alt="">--%>
                                        <%--</div>--%>
                                        <%--<div class="menu-messages-time">--%>
                                            <%--3小时前--%>
                                        <%--</div>--%>
                                        <%--<div class="menu-messages-content">--%>
                                            <%--<div class="menu-messages-content-title">--%>
                                                <%--<i class="am-icon-circle-o am-text-success"></i>--%>
                                                <%--<span>夕风色</span>--%>
                                            <%--</div>--%>
                                            <%--<div class="am-text-truncate"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </div>--%>
                                            <%--<div class="menu-messages-content-time">2016-09-21 下午 16:40</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>

                                <%--<li class="tpl-dropdown-menu-messages">--%>
                                    <%--<a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">--%>
                                        <%--<div class="menu-messages-ico">--%>
                                            <%--<img src="<%=request.getContextPath()%>back/assets/img/user02.png" alt="">--%>
                                        <%--</div>--%>
                                        <%--<div class="menu-messages-time">--%>
                                            <%--5天前--%>
                                        <%--</div>--%>
                                        <%--<div class="menu-messages-content">--%>
                                            <%--<div class="menu-messages-content-title">--%>
                                                <%--<i class="am-icon-circle-o am-text-warning"></i>--%>
                                                <%--<span>禁言小张</span>--%>
                                            <%--</div>--%>
                                            <%--<div class="am-text-truncate"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </div>--%>
                                            <%--<div class="menu-messages-content-time">2016-09-16 上午 09:23</div>--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <%--<li class="tpl-dropdown-menu-messages">--%>
                                    <%--<a href="javascript:;" class="tpl-dropdown-menu-messages-item am-cf">--%>
                                        <%--<i class="am-icon-circle-o"></i> 进入列表…--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>



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
                        <img src="<%=request.getContextPath()%>back/assets/img/user04.png" alt="">
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
                            <a href="/back/admin_message_add.jsp">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>发布信息
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToShowAllMessage">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span>评论管理
                            </a>
                        </li>
                        <li class="sidebar-nav-link">
                            <a href="/AdminToSetMessageImg">
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
                <div class="row  am-cf">
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-primary am-cf">
                            <div class="widget-statistic-header">
                                教师总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['teacheramount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-users"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-statistic-header">
                                实体课总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['lessonamount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-mortar-board"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-primary am-cf">
                            <div class="widget-statistic-header">
                                试听课总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['freelistenamount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-credit-card"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-statistic-header">
                                订单总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['sorderamount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-shopping-cart"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-primary am-cf">
                            <div class="widget-statistic-header">
                                预约总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['freelistenbookamount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-leanpub"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-statistic-header">
                                朋友圈评论&点赞总数
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${indexmsg['messageadditionamount']}
                                </div>

                                <span class="widget-statistic-icon am-icon-comments"></span>
                            </div>
                        </div>
                    </div>
                </div>





            </div>
        </div>
    </div>
    </div>
    <script src="<%=request.getContextPath()%>back/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>back/assets/js/amazeui.datatables.min.js"></script>
    <script src="<%=request.getContextPath()%>back/assets/js/dataTables.responsive.min.js"></script>
    <script src="<%=request.getContextPath()%>back/assets/js/app.js"></script>

</body>

</html>
