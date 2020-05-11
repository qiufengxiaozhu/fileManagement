<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
  	<title>文件上传</title>
  	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">	
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/upload.css">
</head>
 
<body>
	<div id="upload">
		<span id="Head_title">请上传你的文件：</span>
	    <form action="${pageContext.request.contextPath}/UploadHandleServlet?userId=${userId}" enctype="multipart/form-data" method="post">
	    	<table class="table table-striped" >
	         	
	         	<tr ><!-- 第一行 -->
	         		<!-- <th>用户id</th> -->
	          		<th>上传用户</th>
	          		<th>上传文件</th>
	         	</tr>
	         	
		         	<tr class='tr' id="first" >	<!-- 第二行 -->
		         		<td colspan="2">${uploadMessage}</td>
		         	</tr>
	         	
	         	<tr class='tr' ><!-- 第三行 -->	    
	          		<td><input type="text" name="username" class="form-control" id="text_one" value="${userName}"></td>
	          		<td><input type="file" name="file1" class="form-control"></td>
	         	</tr>
	         	
	         	<tr class='tr'><!-- 第四行 -->
	          		<td><input type="text" name="username" class="form-control" id="text_two" value="${userName}"></td>
	          		<td><input type="file" name="file2" class="form-control"></td>
	         	</tr>
	         	
	         	<tr class='tr'><!-- 第五行 -->	         		
	          		<td colspan="2" id="five">
	          			<input class="btn btn-success" type="submit" value="提交">
	          		</td>
	         	</tr>
	         	
	         	<tr class='tr'><!-- 第六行 -->
	          		<td colspan="2" id="sex">
	          			<a href="${pageContext.request.contextPath}/files/Upload.jsp">
	          				<input class="btn btn-warning" type="button" value="返回">
	          			</a>
	          		</td>
	         	</tr>
	       </table>           
	    </form>
    </div>
    <!-- 外部js放body底部不会产生节点丢失情况，推荐放这里 -->
	<script src="${pageContext.request.contextPath}/Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Js/upload.js"></script>
</body>
</html>  