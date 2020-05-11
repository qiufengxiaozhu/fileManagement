<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/menu.css">
	<title>菜单</title>	
</head>
<body>
	<div id="divMenu">

		<div id="Menu_title">
			菜单栏
		</div>
		<a href="${pageContext.request.contextPath}/files/Notice.jsp" target="content">
			<div id="Notice_title">系统公告</div>	
		</a>
		<a href="${pageContext.request.contextPath}/ValidateServlet?flag=1" target="content">
			<div id="Info_title">个人信息</div>	
		</a>
		<a href="${pageContext.request.contextPath}/AddressListServlet" target="content">
			<div id="Address_title">通讯录</div>				
		</a>		
		<a href="${pageContext.request.contextPath}/files/Upload.jsp" target="content">
			<div id="Upload_title">文件上传</div>				
		</a>
		<a href="${pageContext.request.contextPath}/ListFileServlet" target="content">
			<div id="Download_title">文件下载</div>				
		</a>
		<a href="${pageContext.request.contextPath}/StatisticsServlet" target="content">
			<div id="Statistics_title">信息统计</div>				
		</a>
	</div>
</body>
</html>