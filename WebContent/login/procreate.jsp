<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加项目</title>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 
	<form action="proaddPost" method="post" onsubmit="return submitAddPro(this);">
		<span>项目名称：</span><input type="text" name="proName"/><span>*</span><br/>
		<span>项目描述：</span><textarea rows="10" cols="200" name="proDesc"></textarea><br/>
		<input type="submit" value="添加">
	</form>
	 -->
	<div class="row" style="width:100%; height: 1000px;">
		<div class="col-xs-12" style="height: 30%;"></div>
		<div class="col-xs-3" ></div>
			<div style="width:500px; height: 300px; " class="col-xs-5">
				<div class="panel panel-primary">
					<div class="panel-heading">添加项目面板</div>
					<div class="row" >
						<form action="proaddPost" method="post" onsubmit="return submitAddPro(this);">
							<div class="col-xs-12" style="height:50px;"></div>
							<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">项目名称：</span></div>
							<div class="col-xs-6"><input type="text" value="" name="proName" class="form-control"/></div><div class="col-xs-1"></div>
							<div class="col-xs-12" style="height:20px;"></div>
							<div class="col-xs-1"></div><div class="col-xs-4"><span class="form-control">项目描述：</span></div>
							<div class="col-xs-6"><textarea name="proDesc" class="form-control"></textarea></div><div class="col-xs-1"></div>
							<div class="col-xs-12" style="height:20px;"></div>
							<div class="col-xs-9"></div>
							<div class="col-xs-2"><input type="submit" value="添加" class="btn btn-success"/></div>
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
function submitAddPro(form){
	return true;
}
</script>
</html>