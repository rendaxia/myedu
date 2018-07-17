<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/back/";
    String imgPath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/img/";
    System.out.println(imgPath);
    String videoPath = request.getScheme()+"://"+"123.207.154.240:8080"+path+"/video/";
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
                            <a href="/test/Admin/AdminAddOneTeacher">
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
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="widget-title  am-cf">朋友圈评论管理</div>
                                </div>




                            </div>
                            <div class="widget-body  am-fr">
                                <c:forEach items="${list}" var="m">


                                    <div class="am-u-sm-12">
                                        <table width="100%">

                                            <tbody>

                                            <tr>


                                                <article class="am-article">
                                                    <div class="am-article-hd">
                                                        <img src="<%=imgPath%>${enterpriseImg}" style="width: 100px;height:100px" class="tpl-table-line-img" alt=""> ${enterpriseName}
                                                        <a href="/test/Admin/AdminDeleteOneMessage">
                                                            <i class="am-icon-trash"></i>
                                                        </a>
                                                    </div>



                                                </article>
                                                <br>

                                                <!--<td>
                                                    <div class="tpl-table-black-operation">

                                                        <a href="book-change.html">
                                                            <i class="am-icon-pencil"></i>
                                                        </a>
                                                        <a href="javascript:;" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i>
                                                        </a>
                                                    </div>
                                                </td>-->
                                            </tr>

                                            </tbody>

                                        </table>


                                        <table width="100%">
                                            <tbody>
                                            <tr>
                                                <div class="am-panel am-panel-success">
                                                    <div class="am-panel-hd">
                                                        <h3 class="am-panel-title">内容

                                                        </h3>
                                                    </div>
                                                    <div class="am-panel-bd">
                                                        <div class="tpl-table-black-operation">
                                                            <p align="left">${m.mtitle}</p>

                                                            <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2  am-avg-md-3 am-avg-lg-4 am-gallery-default" data-am-gallery="{ pureview: true }">

                                                                <c:forEach items="${m.messageimgs}" var="img">
                                                                    <li>
                                                                        <div class="am-gallery-item">
                                                                            <img src="<%=imgPath%>${img.imgurl}" style="width:220px;height: 160px"  />
                                                                        </div>
                                                                    </li>
                                                                </c:forEach>

                                                            </ul>
                                                            发布时间:${m.mtime}
                                                        </div>
                                                    </div>
                                                </div>
                                            </tr>

                                            </tbody>
                                        </table>



                                        <%--<table width="100%">--%>
                                            <%--<tbody>--%>

                                            <%--<tr>--%>
                                                <%--<td>--%>
                                                    <%--<div class="tpl-table-black-operation">--%>
                                                        <%--&nbsp;&nbsp;&nbsp;&nbsp;发布时间:${m.mtime}--%>
                                                    <%--</div>--%>
                                                <%--</td>--%>

                                            <%--</tr>--%>
                                            <%--</tbody>--%>
                                        <%--</table>--%>


                                        <table width="100%">
                                            <tbody>
                                            <tr>
                                                <div class="am-panel am-panel-success">
                                                    <div class="am-panel-hd">
                                                        <h3 class="am-panel-title">点赞者共${m.messagelikesamount}人:

                                                        </h3>
                                                    </div>
                                                    <div class="am-panel-bd">
                                                        <div class="tpl-table-black-operation">
                                                            <c:forEach items="${m.messagelikes}" var="like">
                                                                ${like.nickname}&nbsp;&nbsp;
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
                                            </tr>
                                            <!--  <tr>
                                                  <td>
                                                      <div class="tpl-table-black-operation">
                                                          &nbsp;&nbsp;&nbsp;&nbsp;点赞者共10人：
                                                      </div>
                                                  </td>
                                                  <td style="width: 600px;">
                                                      <div class="tpl-table-black-operation">
                                                          小玉 小王 小赵 小李 飞哥 小林 小玉 小王 小赵 小李 飞哥 小林
                                                      </div>
                                                  </td>
                                            </tr>  -->
                                            </tbody>
                                        </table>

                                        <table width="100%">
                                            <tbody>
                                            <tr>
                                                <div class="am-panel am-panel-default">
                                                    <div class="am-panel-hd">
                                                        <h3 class="am-panel-title">评论</h3>
                                                    </div>


                                                    <div class="am-panel-bd">

                                                        <c:forEach items="${m.messagereplies}" var="reply">
                                                            <div class="tpl-table-black-operation">
                                                                    ${reply.nickname}：${reply.content}&nbsp;&nbsp;于${reply.stime}
                                                                <a href="/test/Admin/AdminDeleteOneMessagereply?id=${reply.id}&page=${p.page}" class="tpl-table-black-operation-del">
                                                                    <i class="am-icon-trash"></i>
                                                                </a>
                                                                <br>

                                                            </div>
                                                        </c:forEach>
                                                    </div>



                                                </div>
                                            </tr>
                                            </tbody>
                                        </table>

                                    </div>

                                    <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
                                </c:forEach>


                                <div class="am-u-lg-12 am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li><a href="/test/Admin/AdminToShowAllMessage?page=1">首页</a></li>
                                            <li><a href="/test/Admin/AdminToShowAllMessage?page=${p.page-1}">上一页</a></li>

                                            <c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
                                                <%--<li><a href="/test/MyHandler_findSome?page=${i }">${i }</a></li>--%>
                                                <c:choose>
                                                    <c:when test="${i == p.page}">
                                                        <a style="opacity: 0.1" onclick="return false;" >${i }</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="/test/Admin/AdminToShowAllMessage?page=${i }">${i }</a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>

                                            <li><a href="/test/Admin/AdminToShowAllMessage?page=${p.page+1}">下一页</a></li>
                                            <li><a href="/test/Admin/AdminToShowAllMessage?page=${p.maxPage }">尾页</a></li>
                                        </ul>
                                    </div>
                                </div>
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
