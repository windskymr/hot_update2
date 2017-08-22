<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<title>提示页面</title>
</head>
<body>
	<div class="row" style="width:100%; height: 1000px;">
		<div class="col-xs-12" style="height: 30%;"></div>
		<div class="col-xs-3" ></div>
			<div style="width:500px; height: 300px; " class="col-xs-5">
				<div class="panel panel-danger">
					<div class="panel-heading">提示面板</div>
					<div class="panel-body">
					    ${error}
					</div>
				</div>
			</div>
		<div class="col-xs-4" ></div>
	</div>
</body>
<script type="text/javascript">
var errorInfo = "${error}";
if(errorInfo=='登陆成功!'){
	window.parent.onLoginSuc();
}
</script>
</html>