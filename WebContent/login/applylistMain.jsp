<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>热更新申请列表</title>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/ion.calendar.css">

<script src="../js/jquery-3.2.1.min.js"></script>

<script src="../bootstrap/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<div style="width:100%; height:20%; background-color:#0">
		<form action="test" method="get">
			<table class="table table-condensed">
				<tr>
					<td>项目:</td><td>
						<select class="form-control" onchange="changeSelect(this, 'proId')">
							<option value="">全部</option>
							<c:if test="${proList != null}">
								<c:forEach var="pro" items="${proList}">
									<option value=<c:out value="${pro.id}"/>><c:out value="${pro.name}" /></option>
								</c:forEach>
							</c:if>
						</select>
						<input type="hidden" name="proId" id="proId"/>
					</td><td>申请人:</td><td><input type="text" name="submitTrueName"/></td>
					<td>审核人:</td><td><input type="text" name="auditTrueName"/></td>
					<td>审核状态:</td>
					<td>
						<select class="form-control" onchange="changeSelect(this,'auditState')">
							<option value="">全部</option>
							<option value="0">未审核</option>
							<option value="1">已审核</option>
							<option value="2">未通过</option>
						</select>
						<input type="hidden" name="auditState" id="auditState"/>
					</td>
					<td>更新状态:</td>
					<td>
						<select class="form-control" onchange="changeSelect(this,'updateState')">
							<option value="">全部</option>
							<option value="0">未更新</option>
							<option value="1">已更新</option>
						</select>
						<input type="hidden" name="updateState" id="updateState"/>
					</td>
					<td><input type="button" value="查询" class="btn btn-success" onclick="clickQuery(1)"/></td>
				</tr>
				<tr>
					<td>当前版本号：</td><td><input type="text" name="curVer"/></td><td>更新版本号：</td><td><input type="text" name="destVer"/></td>
					<td>前端责任人：</td><td><input type="text" name="clientCharger"/></td>
					<td>后端责任人：</td><td><input type="text" name="serverCharger"/></td>
					<td>Web端责任人：</td><td><input type="text" name="wcCharger"/></td>
					<td></td>
				</tr>
				<tr>
					<td>测试责任人：</td><td><input type="text" name="testCharger"/></td>
					<td>美术责任人：</td><td><input type="text" name="uiCharger"/></td>
					<td>总负责人：</td><td><input type="text" name="masterCharger"/></td>
					<td colspan="5">
					<div class="row">
						<div class="col-md-2">
	                		期望更新日期:
	                	</div>
	                	<div class="col-md-8" >
                			<input type="text" class="date" placeholder="请选择日期" name="fromHopeDate"/>至
                			<input type="text" class="date" placeholder="请选择日期" name="toHopeDate"/>
                    	</div>
                    	<div class="col-md-2"></div>
                    </div>
					</td>
				</tr>
			</table>
			<input type="hidden" name="pagePerSize" value="${param.pagePerSize}" id="pagePerSize"/>
			<input type="hidden" name="pageCurNum" value="${param.pageCurNum}" id="pageCurNum"/>
		</form>
	</div>
	<div style="width:100%; float:bottom; height:1000px;">
		<iframe class="embed-responsive-item" id="contentFrame" 
			src="applylist.jsp?pagePerSize=10&pageCurNum=1" frameborder="0" width="100%" height="100%" scrolling="no"></iframe>
	</div>
</body>
<script type="text/javascript">
function clickQuery(pageNum){
	var url = "queryApply?jmpUrl=applylist";
	$("#pageCurNum").val(pageNum);
	var param = $("form").serialize();
	$("#contentFrame").attr("src",url+"&"+decodeURI(param));
}
function showPage(pageNum){
	$("#pageCurNum").val(pageNum+"");
	clickQuery(pageNum);
}

function changeSelect(selectObj, deskInputId){
	if(selectObj.options && selectObj.options.length > 0){
		$("#" + deskInputId).val(selectObj.options[selectObj.selectedIndex].value);
	}
}
</script>
<script src="../js/moment.min.js"></script>
<script src="../js/moment.zh-cn.js"></script>
<script src="../js/ion.calendar.min.js"></script>
<script>
$(document).ready(function(){
	$('.date').each(function(){
		$(this).ionDatePicker({
			lang: 'zh-cn',
			format: 'YYYY-MM-DD',
			onReady: function(){
			},
			onclick: function(){
				alert(1);
			}
		});
	});
});
</script>
</html>