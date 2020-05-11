<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/discontinueList.css">
	<title>通讯录</title>	
</head>
<body>	
	<div id="address_list">
		<span id="Head_title">公司全部停用人员信息如下：<span id="message">${useMessage }</span></span>
		<br /><br />
		<form action="DeleteInfoServlet?flag=33" method="post" onsubmit="return out_staff()">
			<table id="info_table">				
				<tr>
					<td>选择</td>
					<td>ID</td>
					<td>账号</td>
					<td>姓名</td>
					<td>职务</td>
					<td>电话</td>
					<td>邮箱</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${UserList}" var="list" varStatus="id">
					<!-- id.index代表当前循环的索引值 -->
					<tr >
						<td><%-- 选择框 --%>
							<input type='checkbox' name='select' value='${list.id}'  />							
						</td>
						<td>${list.id}</td>
						<td>${list.userNum}</td>
						<td>${list.userName}</td>
						<!-- 根据索引获取职称列表中的值 -->
						<td>${PositionList.get(id.index)}</td>
						<td>${list.userTel}</td>
						<td>${list.userMail}</td>
						<td id="img_btn"><!-- 修改信息 -->
							<a href="${pageContext.request.contextPath}/DeleteInfoServlet?id=${list.id}&flag=2">
								<img title="启用" src="${pageContext.request.contextPath}/images/update.PNG">
							</a>
							<a href='${pageContext.request.contextPath}/DeleteInfoServlet?id=${list.id}&flag=3' >
								<img title="删除" src="${pageContext.request.contextPath}/images/delete.PNG">
							</a>
						</td>
					</tr>				
				</c:forEach>
				<tr>
					<td colspan="8">						
						
						<input type="submit" id="out" value="删除用户">
						
					</td>
				</tr>
			</table>
		</form>
		<div id="paging">
			<c:if test="${pageNos > 1 }">
				<a href="DiscontinueListServlet?pageNos=1">首页</a>
				<a href="DiscontinueListServlet?pageNos=${pageNos-1}">上一页</a>
			</c:if>
			<c:if test="${pageNos == 1 }">
				首页  上一页
			</c:if>
			<c:if test="${pageNos < recordCount }">
				<a href="${pageContext.request.contextPath}/DiscontinueListServlet?pageNos=${pageNos+1}">下一页</a>
				<a href="${pageContext.request.contextPath}/DiscontinueListServlet?pageNos=${recordCount }">末页</a>
			</c:if>
		</div>
		<form action="${pageContext.request.contextPath}/DiscontinueListServlet" method="post">
			<h4>
				共${recordCount} 页 
				<%--<input type="text" value="${pageNos}" name="pageNos" >页 --%>
				<select id="page_option" name="pageNos">
					<option value="${pageNos}" selected="selected">第- ${pageNos} -页</option>
					<c:forEach begin="1" end="${recordCount}" step="1" varStatus="id">	
						<c:if test="${pageNos != id.index }">					
							<option value="${id.index }">第- ${id.index } -页</option>
						</c:if>
					</c:forEach>
				</select>
				<input type="submit" id="page_turning" value="确定">
			</h4>
		</form>
	</div>
	
	<script src="${pageContext.request.contextPath}/Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="../${pageContext.request.contextPath}/Js/discontinueList.js" ></script>
</body>
</html>