<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<div class="row" style="width:100%; height: 1000px;">
		<div class="col-xs-12" style="height: 30%;"></div>
		<div class="col-xs-3" ></div>
			<div style="width:500px; height: 300px; " class="col-xs-5">
				<div class="panel panel-primary">
					<div class="panel-heading">登陆面板</div>
					<div class="row" >
						<form action="loginPost" method="post" onsubmit="return submitLogin(this);">
							<div class="col-xs-12" style="height:50px;"></div>
							<div class="col-xs-1"></div><div class="col-xs-3"><span class="form-control">用户名：</span></div>
							<div class="col-xs-7"><input type="text" value="" name="userName" class="form-control"/></div><div class="col-xs-1"></div>
							<div class="col-xs-12" style="height:20px;"></div>
							<div class="col-xs-1"></div><div class="col-xs-3"><span class="form-control">密码：</span></div>
							<div class="col-xs-7"><input type="password" value="" name="password" class="form-control"/></div><div class="col-xs-1"></div>
							<div class="col-xs-12" style="height:20px;"></div>
							<div class="col-xs-7"></div>
							<div class="col-xs-2"><input type="submit" value="登陆" class="btn btn-success"/></div>
							<div class="col-xs-2"><a href="./registPage" style="margin-bottom:1px;">注册</a></div>
							<div class="col-xs-1"></div>
							<div class="col-xs-12" style="height:20px;"></div>
						</form>
					</div>
				</div>
			</div>
		<div class="col-xs-4" ></div>
	</div>
</body>
<script type="text/javascript">
function submitLogin(form){
	return true;
}
</script>
</html>