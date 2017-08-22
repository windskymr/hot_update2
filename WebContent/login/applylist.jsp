<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>热更新申请列表</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/dialog.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<table class="table table-condensed">
		<tr>
			<td>项目</td><td width="60px;">当前版本号</td><td width="60px;">更新版本号</td>
			<td>更新内容</td><td width="60px;">前端责任人</td>
			<td width="60px;">后端责任人</td>
			<td width="60px;">Web端责任人</td>
			<td width="60px;">测试责任人</td>
			<td width="60px;">美术责任人</td>
			<td width="60px;">总负责人</td>
			<td>期望更新日期</td>
			<td>提交人</td><td>审核人</td><td>审核状态</td>
			<td>更新状态</td><td>审核理由</td><td>申请时间</td><td>更新时间</td><td>操作</td>
		</tr>
		<c:if test="${pageObj.dataList != null}">
			<c:forEach var="apply" items="${pageObj.dataList}">
				<tr>
				<td>
					<c:out value="${apply.project.name}"></c:out>
				</td>
				<td>
					<c:out value="${apply.curVer}"></c:out>
				</td>
				<td>
					<c:out value="${apply.destVer}"></c:out>
				</td>
				<td>
					<c:out value="${apply.remark}"></c:out>
				</td>
				<td>
					<c:out value="${apply.clientCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.serverCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.wcCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.testCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.uiCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.masterCharger}"></c:out>
				</td>
				<td>
					<c:out value="${apply.hopeDate}"></c:out>
				</td>
				<td>
					<c:out value="${apply.submitUser.name}"></c:out>
				</td>
				<td>
					<c:if test="${apply.auditUser != null}">
						<c:out value="${apply.auditUser.name}"></c:out>
					</c:if>
				</td>
				<td>
					<c:if test="${apply.auditState==0}">
						未审核
					</c:if>
					<c:if test="${apply.auditState==1}">
						已审核
					</c:if>
					<c:if test="${apply.auditState==2}">
						未通过
					</c:if>
				</td>
				<td>
					<c:if test="${apply.updateState==0}">
						未更新
					</c:if>
					<c:if test="${apply.updateState==1}">
						已更新
					</c:if>
				</td>
				<td>
					<c:out value="${apply.auditReason}"></c:out>
				</td>
				<td>
					<c:out value="${apply.submitTime}"></c:out>
				</td>
				<td>
					<c:out value="${apply.updateTime}"></c:out>
				</td>
				<td>
					<c:choose> 
						<c:when test="${apply.auditState==0}">
							<!-- 未审核 -->
							<c:if test="${user.identifyLevel>1}">
								<input type="button" class="btn btn-info" value="审核" onclick="showAuditDialog(${apply.id},'${apply.project.name}', '${apply.submitUser.name}')"/>
							</c:if>						
						</c:when>
						<c:otherwise>
							<c:if test="${apply.auditState==1}">
								<!-- 已审核 -->
								<c:if test="${apply.updateState==0}">
									<!-- 未更新 -->
									<c:if test="${user.id==apply.submitUser.id}">
										<input type="button" class="btn btn-warning" value="更新" onclick="showUpdateDialog(${apply.id},'${apply.project.name}')"/>
									</c:if>
								</c:if>
							</c:if>
						</c:otherwise>
					</c:choose>
				</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div style="float:right;">
		<nav aria-label="...">
		  <ul class="pager">
		  <li style="float: right;"><a href="javascript:void(0);" onclick="showPage(${pageObj.pageCurNum+1})">下一页</a></li>
		    <li style="float: right;">
		    	<div style="height:20px; ">
		    		 <select class="form-control" onchange="changePage(this)">
		    		 	<c:choose>
		    		 		<c:when test="${pageObj.totalPages>0}">
					    		<c:forEach var="i" begin="1" end="${pageObj.totalPages}">
					    			<c:choose>
					    				<c:when test="${pageObj.pageCurNum==i}">
											<option value="${i}" selected="selected">第<c:out value="${i}"></c:out>页</option>					    					
					    				</c:when>
					    				<c:otherwise>
					    					<option value="${i}">第<c:out value="${i}"></c:out>页</option>
					    				</c:otherwise>
					    			</c:choose>
					    		</c:forEach>
		    		 		</c:when>
		    		 		<c:otherwise>
		    		 			<option>第1页</option>
		    		 		</c:otherwise>
			    		</c:choose>
			   		 </select>
			    </div>
		    </li>
		    <li style="float: right;"><a href="javascript:void(0);" onclick="showPage(${pageObj.pageCurNum-1})">上一页</a></li>
		    <li style="float: right;">共<c:out value="${pageObj.totalPages}"></c:out>页, 每页<c:out value="${pageObj.pagePerSize}"></c:out>条</li>
		  </ul>
		</nav>
	</div>
</body>
<script type="text/javascript">
var g_apply={};
var auditDialog = null;
/**
 * 显示第几页
 */
function showPage(pageNum){
	var totalPageNum = "${pageObj.totalPages}";
	if(pageNum <= 0){
		alert("已经到了第一页了");
		return;
	}
	else if(pageNum > totalPageNum){
		alert("已经到了最后一页了");
		return;
	}
	window.parent.showPage(pageNum);
}

function changePage(selectObj){
	if(selectObj.options && selectObj.options.length > 0){
		showPage(selectObj.options[selectObj.selectedIndex].value);
	}
}
/**
 * 显示审核对话框
 */
function showAuditDialog(applyId,proName, submitName){
	g_apply.applyId = applyId;
	g_apply.proName = proName;
	g_apply.submitName = submitName;
    var addPop = new Popup({contentType:1,isReloadOnClose:false,width:450,height:300, isSupportDraging:true});
    auditDialog = addPop;
    //addPop.color = {cColor:"#EEEEEE", bColor:"#FFFFFF", tColor:"#709CD2", wColor:"#FFFFFF"};  
    addPop.setContent("contentUrl","auditDialog.html?rand="+Math.random());  
    addPop.setContent("title","审核热更新对话框");  
    addPop.build();  
    addPop.show();  
    $('#dialogBox').css({
        position:'absolute',
        left: ($(window).width() - $('#dialogBox').outerWidth())/2,
        top: ($(window).height() - $('#dialogBox').outerHeight())/2 -200
    });
}
function updateSure(noticePop, index){
	noticePop.close();
	postUpdate(index);
}
function updateCancel(noticePop){
	noticePop.close();
}
function showUpdateDialog(applyId,proName){
	g_apply.applyId = applyId;
	var noticePop = new Popup({contentType:2,isReloadOnClose:false,width:400,height:100});
    auditDialog = noticePop;
	noticePop.setContent("title","热更新确认"); 
	var content = '';
	content += '<div class="row">';
	content += "<div class='col-md-4'></div>";
	content += "<div class='col-md-6'><input type=\"button\" value='确定' onclick='updateSure(auditDialog,g_apply.applyId)'>&nbsp;&nbsp;&nbsp;<input type=\"button\" value='取消' onclick='updateCancel(auditDialog)'></div>";
	content += "<div class='col-md-2'></div>";
	content += "</div>";
	noticePop.setContent("contentHtml",
			"<div style='margin:15px;'>您确定要更新 申请项目为["
			+proName+"]的热更新申请吗？<br><br>"+content+"</div>");  
	noticePop.build();  
	noticePop.show(); 
    $('#dialogBox').css({
        position:'absolute',
        'background-color': '#FFFFFF',
        left: ($(window).width() - $('#dialogBox').outerWidth())/2,
        top: ($(window).height() - $('#dialogBox').outerHeight())/2 -200
    });
}
/**
 * 提交审核数据
 */
function postAudit(auditState, reason){
	$.ajax({
		url:"applyaudit",
		data:{applyId: g_apply.applyId, auditState: auditState, reason: reason},
		method:"post",
		dataType:"json",
		complete: function(data, code){
			if('success' == code){
				var result = data.responseJSON.result;
				if(result == 1){
					alert("操作成功！");
				}
				else{
					alert(data.responseJSON.errorInfo);
				}
			}
			else{
				alert("操作失败! reason: " + code);
			}
		}
	});
	if(auditDialog){
		auditDialog.close();
		auditDialog = null;
	}
}
/**
 * 提交更新
 */
function postUpdate(id){
	$.ajax({
		url:"applyupdate",
		data:{applyId: id},
		method:"post",
		dataType:"json",
		complete: function(data, code){
			if('success' == code){
				var result = data.responseJSON.result;
				if(result == 1){
					alert("操作成功！");
				}
			}
			else{
				alert("操作失败! reason: " + code);
			}
		}
	});
}
</script>
</html>