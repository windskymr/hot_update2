<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
	<script src="./js/jquery-3.2.1.min.js"></script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row" style="width:100%; height: 1000px;">
		<div class="col-xs-12" style="height: 20%;"></div>
		<div class="col-xs-3" ></div>
		<div style="width:500px; height: 500px; " class="col-xs-5">
			<div class="panel panel-primary">
				<div class="panel-heading">登陆面板</div>
				<div class="row" >
					<form action="registPost" id="registForm" method="post" onsubmit="return onSubmitForm(this);">
						<div class="col-xs-12" style="height:50px;"></div>
						<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">用户名：</span></div>
						<div class="col-xs-6"><input type="text" value="" name="userName" class="form-control"/></div><div class="col-xs-1"></div>
						<div class="col-xs-12" style="height:20px;"></div>
						<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">姓名：</span></div>
						<div class="col-xs-6"><input type="text" value="" name="name" class="form-control"/></div><div class="col-xs-1"></div>
						<div class="col-xs-12" style="height:20px;"></div>
						<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">密码：</span></div>
						<div class="col-xs-6"><input type="password" value="" name="password" class="form-control"/></div><div class="col-xs-1"></div>
						<div class="col-xs-12" style="height:20px;"></div>
						<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">密码确认：</span></div>
						<div class="col-xs-6"><input type="password" value="" name="confirmPs" class="form-control"/></div><div class="col-xs-1"></div>
						<div class="col-xs-12" style="height:20px;"></div>
						<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">身份级别：</span></div>
						<div class="col-xs-6"><select onchange="changeLvel(this);" id="levelSelect" class="form-control">
							<option value="1">申请者</option>
							<option value="2" selected="true">审核者</option>
						</select></div><div class="col-xs-1"></div>
						<div class="col-xs-12" style="height:20px;"></div>
						<input type="hidden" name="identifyLevel" id="identifyLevel">
						<div class="col-xs-9"></div>
						<div class="col-xs-2"><input type="submit" value="注册" class="btn btn-success"/></div>
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
function onSubmitForm(form){
	return true;
}
$(document).ready(function(){
	changeLvel(document.getElementById("levelSelect"));
});
function changeLvel(selectObj){
	$("#identifyLevel").val(selectObj.options[selectObj.selectedIndex].value);
}
</script>
</html>