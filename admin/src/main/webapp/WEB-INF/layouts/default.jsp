<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${basePath}static/img/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="${basePath}static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${basePath}static/css/dashboard.css" rel="stylesheet">

    <link href="${basePath}static/css/colorbox.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${basePath}static/js/jquery.min.js"></script>
    <script src="${basePath}static/js/bootstrap.min.js"></script>
    <script src="${basePath}static/js/jquery.colorbox-min.js"></script>
    <%--<script src="http://getbootstrap.com/assets/js/docs.min.js"></script>--%>
    <title><decorator:title default="3D APP 后台"/></title>
    <decorator:head/>
</head>
<body>


<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">3D App 后台</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="javascript:void(0)"><shiro:principal/></a>
                </li>
                <li>
                    <a href="${basePath}user/logout">登出</a>
                </li>
            </ul>
            <form class="navbar-form navbar-right" name="queryForm">
                <input type="text" name="keyword" value="${param.keyword}" class="form-control" placeholder="搜索...">
                <a href="javascript:this.queryForm.submit()">
                    <span class="glyphicon glyphicon-search" style="position: relative;left:-25px;top:3px;"></span>
                </a>
            </form>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li id="user-li"><a href="${basePath}user/list">用户管理</a></li>
                <li id="picture-li"><a href="${basePath}picture/list">图片管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <decorator:body/>
        </div>
    </div>
</div>
</body>
</html>