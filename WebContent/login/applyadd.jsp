<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请热更新</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/ion.calendar.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<div class="row" style="width:100%; height: 1000px;">
		<div class="col-xs-12" style="height: 20%;"></div>
		<div class="col-xs-2" ></div>
			<div style="width:800px; height: 600px; " class="col-xs-6">
				<div class="panel panel-primary">
					<div class="panel-heading">添加热更新申请面板</div>
					<div class="row" >
						<form action="applyaddPost" method="post" onsubmit="return submitApplyAdd(this);">
							<div class="col-xs-6">
								<div class="col-xs-12" style="height:50px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4">更新项目：</span></div>
								<div class="col-xs-4">
									<select onchange="changePro(this)" class="form-control" id="proSelect">
										<c:if test="${proList != null}">
											<c:forEach var="pro" items="${proList}">
												<option value=<c:out value="${pro.id}"/>><c:out value="${pro.name}" /></option>
											</c:forEach>
										</c:if>
									</select>
									<input type="hidden" name="proId" id="proId"/>
								</div><div class="col-xs-3"><a href="proadd" >添加项目</a></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>当前版本号：</span></div>
								<div class="col-xs-6"><input type="text" name="curVer" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span >更新版本号：</span></div>
								<div class="col-xs-6"><input type="text" name="destVer" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span >更新内容：</span></div>
								<div class="col-xs-6"><textarea name="applyDesc" class="form-control"></textarea></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span >期望更新日期：</span></div>
								<div class="col-xs-6"><input type="text" name="hopeDate" class="form-control date" placeholder="请选择日期"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span >前端责任人：</span></div>
								<div class="col-xs-6"><input type="text" name="clientCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
							</div>
							<div class="col-xs-6">
								<div class="col-xs-12" style="height:50px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>后端责任人：</span></div>
								<div class="col-xs-6"><input type="text" name="serverCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>Web端责任人：</span></div>
								<div class="col-xs-6"><input type="text" name="wcCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>测试责任人：</span></div>
								<div class="col-xs-6"><input type="text" name="testCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>美术责任人：</span></div>
								<div class="col-xs-6"><input type="text" name="uiCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
								<div class="col-xs-1"></div><div class="col-xs-4"><span>总负责人：</span></div>
								<div class="col-xs-6"><input type="text" name="masterCharger" class="form-control"/></div><div class="col-xs-1"></div>
								<div class="col-xs-12" style="height:20px;"></div>
							</div>
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
function submitApplyAdd(form){
	return true;
}
$(document).ready(function(){
	changePro(document.getElementById("proSelect"));
});
function changePro(selectObj){
	if(selectObj.options && selectObj.options.length > 0){
		$("#proId").val(selectObj.options[selectObj.selectedIndex].value);
	}
}
</script>
<script src="../js/moment.min.js"></script>
<script src="../js/moment.zh-cn.js"></script>
<script src="../js/ion.calendar.min.js"></script>
<script>
$(function(){
	$('.date').each(function(){
		$(this).ionDatePicker({
			lang: 'zh-cn',
			format: 'YYYY-MM-DD'
		});
	});
});
</script>
</html>