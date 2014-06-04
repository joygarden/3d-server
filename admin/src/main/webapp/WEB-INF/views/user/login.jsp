<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${basePath}static/img/favicon.ico">

    <title>3D APP 后台</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath}static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${basePath}static/css/signin.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${basePath}static/js/jquery.min.js"></script>
    <script src="${basePath}static/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">

    <form class="form-signin" role="form" method="post" action="${basePath}user/login">
        <h2 class="form-signin-heading">欢迎登录</h2>
        <input type="text" name="username" class="form-control" placeholder="用户名" value="${param.username}" required
               autofocus>
        <input type="password" name="password" class="form-control" placeholder="密码" required>
        <label class="checkbox">
            <input type="checkbox" name="rememberMe"> 自动登录
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div>
<!-- /container -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                用户名或密码错误！
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    if ('${param.username}') {
        $('#myModal').modal();
    }
</script>
</body>
</html>
