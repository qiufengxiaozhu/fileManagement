<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文件下载</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">	
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/listFiles.css">
</head>
   
<body>
  	<span id="Head_title">请选择你要下载的文件：</span>
  	<div id="download" >
	    <table class="table table-striped" id="test">
	      	<tr>
	       		<td>文件名</td>
	       		<td>操作</td>
	      	</tr>
	      	<!-- 遍历map集合 -->
	    	<c:forEach items="${fileNameMap}"  var="me">
	    	
	    		<%-- <c:url>标签将URL格式化为一个字符串，然后存储在一个变量中。 --%>
	        	<c:url value="DownLoadServlet" var="downurl">
	            	<c:param name="filename" value="${me.key}"></c:param>
	        	</c:url>
	        	<tr>
	         		<td>${me.value}</td>
	         		<td><a href="${downurl}">下载</a></td>
	        	</tr>        
	    	</c:forEach> 
	     	<tr class='tr'>
	          	<td colspan="2" align="center">
		          	<a href="javascript:history.go(-1)">
		          		<input class="btn btn-warning" type="button" value="返回">
		          	</a>
	          	</td>
	     	</tr>
	    </table>
	</div>
</body>
</html>