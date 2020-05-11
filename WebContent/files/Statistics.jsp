<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/stylenew.css">
	<title>统计</title>	
</head>
<body>
  <%
Object user = request.getSession().getAttribute("username");
/* if(user==null){
	response.sendRedirect("Login.jsp");
} */
%>
 <table border= '1px' cellpadding="10" cellspacing="0" align="center">
      <tr>
       	 <td>部门名称</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       	 <c:forEach items="${DepartmentName}" var="departmentName">
 			<td>${departmentName}</td>
   		</c:forEach> 
       	    
      </tr>
      <tr style="background-color: red">
      	<td>部门人数</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
   		<c:forEach items="${DepartmentId}" var="departmentId">
   			<td>${departmentId}</td>
   		</c:forEach> 
  		
	 </tr>     	
    
   </table>  
   <div style="border-color: blue ;width: 100%;height: 10px;" align="center"><h1>部门人数百分比统计图</h1></div>
   <div id="bar-chart">
     <div class="graph">    
       <ul class="x-axis">
          <c:forEach items="${DepartmentName}" var="departmentName">
            <li><span>${departmentName}</span></li>
          </c:forEach> 			
	   </ul>
	  
		<ul class="y-axis">
		    
			<li><span>100%</span></li>
			<li><span>75%</span></li>
			<li><span>50%</span></li>
			<li><span>25%</span></li>
			<li><span>0</span></li>
		</ul>
			<div class="bars">
			<c:forEach items="${DepartmentId}" var="departmentId">
				<div class="bar-group">
					<div class="bar bar-1 stat-1" style="height: ${departmentId/SUM*100}%;">      
					</div>
				</div>
			</c:forEach> 	
		</div>
     </div>  
   </div>
</body>
</html>