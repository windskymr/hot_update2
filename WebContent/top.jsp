<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>热更新系统</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-xs-12" style="height:20px;"></div>
		<div class="col-xs-10"></div>
		<div class="col-xs-2">
			<c:choose>
				<c:when test="${user==null}">
					您还没有登陆，请<a href="javascript:void(0); " onclick="goToLogin()">登陆</a> 
					<a href="javascript:void(0);" onclick="goToRegist()">注册</a>
				</c:when>
				<c:otherwise>
					您好！<a href="javascript:void(0);">
						<c:out value="${user.name}"></c:out>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="logout()">注销</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<script type="text/javascript">
function goToLogin(){
	window.parent.gotoLogin();
}
function goToRegist(){
	window.parent.gotoRegist();
}
function logout(){
	window.parent.logout();
}
</script>
</html>