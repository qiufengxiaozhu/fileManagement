<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<!-- <meta http-equiv="refresh" content="10"> -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/home.css">
	<title>首页</title>	
</head>
<body>
	<div id="divHead">
		<p id="Head_title">欢迎来到办公自动化系统</p>
		
		<div id="name_div">
			<label>账号：</label>
			<input type="text" class="name_text" value="${UserNum }"/>
			<input type="button" value="退出" id="exit_btn"/>
		</div>
	</div>
	
	<!-- 菜单栏页面 Menu.jsp -->
	<c:if test="${userType == '2'}">
		<iframe src="${pageContext.request.contextPath}/files/Menu.jsp" id="menu" name="menu"></iframe>
	</c:if>
	<c:if test="${userType != '2'}">
		<iframe src="${pageContext.request.contextPath}/files/MenuCommon.jsp" id="menu" name="menu"></iframe>
	</c:if>
	<!-- 正文页面 默认ShowInfo.jsp -->
	<iframe src="${pageContext.request.contextPath}/files/Notice.jsp?" id="content" name="content"></iframe>
	
	<!-- 
	<iframe src="${pageContext.request.contextPath}/files/ShowInfo.jsp?value=User" id="content"></iframe>
	 -->
	 
	<script src="${pageContext.request.contextPath}/Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Js/home.js" ></script>
</body>
</html>