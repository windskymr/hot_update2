<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>热更新命令列表</title>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="list-group">
  <li class="list-group-item"><a href="javascript:void(0);" onclick="onClickLink('login/applyadd');">添加热更新申请</a></li>
  <li class="list-group-item"><a href="javascript:void(0);" onclick="onClickLink('login/proadd');">添加项目</a></li>
  <li class="list-group-item"><a href="javascript:void(0);" onclick="onClickLink('login/queryApply');">查询热更新申请</a></li>
</ul>
</body>
<script type="text/javascript">
var loginFlag = "${user}";
var before = loginFlag;
function onClickLink(link){
	if(!loginFlag){
		window.parent.reload();
		return;
	}
	window.parent.jumpToWithLoad(link, true);
}
function onLoginSuc(){
	loginFlag = 1;
}
</script>
</html>