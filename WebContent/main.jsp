<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>热更新系统</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="row" style="height:800px; ">
	<div class="col-xs-12">
		<iframe src="top.jsp" height="50px;" width="100%" class="embed-responsive-item" frameborder="1" scrolling="no"></iframe>
	</div>
	<div  class="col-md-2" style="height:100%;">
		<iframe src="left.jsp" height="100%" width="100%" class="embed-responsive-item" frameborder="1" scrolling="no" id="leftFrame"></iframe>
	</div>
	<div  class="col-md-10" style="height:100%; ">
		<c:choose>
			<c:when test="${param.subURL==null || user==null}">
				<iframe src="loginPage" width="100%" height="100%" id="centPanel" class="embed-responsive-item" frameborder="0" scrolling="no"></iframe>				
			</c:when>
			<c:otherwise>
				<iframe src="${param.subURL}?pagePerSize=10&pageCurNum=1" width="100%" height="100%" id="centPanel" class="embed-responsive-item" frameborder="0" scrolling="no"></iframe>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div>
	<form action="login/logout" method="post"></form>
</div>
</body>
<script type="text/javascript">
function jumpTo(url){
	if(url.indexOf('?') < 0 ){
		url += "?pagePerSize=10&pageCurNum=1";
	}
	$("#centPanel").attr("src", url);
}
function jumpToWithLoad(url,willReload){
	var location = window.location.href;
	var index = location.indexOf("?");
	if(index >= 0){
		location = location.substring(0, index);
	}
	if(!willReload){
		jumpTo(url);
	}
	else{
		var targetURL = location;
		targetURL += "?subURL="+url;
		window.location.href = targetURL;
	}
}
function gotoLogin(){
	jumpTo("loginPage");
}
function gotoRegist(){
	jumpTo("registPage");
}
function logout(){
	$("form").submit();
}
function reload(){
	window.location.href="main";
}
function onLoginSuc(){
	$("#leftFrame")[0].contentWindow.onLoginSuc();
}
</script>
</html>