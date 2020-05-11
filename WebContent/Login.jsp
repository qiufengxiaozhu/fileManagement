<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" type="text/css" href="styles/login.css">
	<title>登录</title>	
</head>
<body>
	<div id="divHead">
		<p id="Head_title">欢迎来到办公自动化系统</p>
	</div>
	<div id="divMain">
		<div id="divPhoto">
		</div>
		<p id="login_title">欢迎登录</p>
		<div id="divForm">
		   	<form action="ValidateServlet" method="post" onsubmit="return check()"> 
		       <table> 
					<tr id="first_Line"><!-- 表的第一行 -->
						<th>用户名：</th>	<!-- <td>表示内容单元格 <th>则表示标题,一般用在一列的第一格,里面的内容会自动加粗加黑他们  -->
						<td>
							<c:if test="${username != null}" >
								<input type="text" id="user_text" name="username" value='${username}'/>						
							</c:if>	
							<c:if test="${username == null}" >
								<input type="text" id="user_text" name="username" placeholder="请输入您的用户名"/>						
							</c:if>	
							<span id="user_span">请输入您的用户名!</span>
							<span id="reg1_span">用户名为6-10位数字！</span>
						</td>
					</tr>
					<tr id="second_Line">	<!-- 表的第二行 -->
						<th>密   码：</th>
						<td>
							<c:if test="${password != null}" >
								<input type="password" id="pwd_text" name="password" value='${password}'/>
							</c:if>	
							<c:if test="${password == null}" >
								<input type="password" id="pwd_text" name="password" placeholder="请输入您的密码"/>
							</c:if>	
							<span id="pwd_span">请输入您的密码!</span>
							<span id="reg2_span">密码为3-10位字符！</span>
						</td>
					</tr>	
					<tr id="third_Line">	<!-- 表的第三行 --><%--123 --%>
						<th>验证码：</th>
						<td>
							<input type="text" id="verify_text" name="rand" placeholder="验证码" />						
							<a href="javascript:loadimage();">
								<!-- 生成验证码 -->
								<img alt="验证码" name="randImage" id="randImage" src="ImageServlet" />
							</a>
							<a href="javascript:loadimage();">换一换</a>
							<span id="verify_span">请输入验证码!</span>
							<!-- 判断验证码是否输入正确，输入错误返回提示 -->
							<c:if test="${checkError == 'no'}" >
								<span id="check_span" >验证码错误!</span>
							</c:if>	
						</td>
					</tr>		
					<tr id="fourth_Line">
						<!-- colspan="2"表示表格单元横跨两列的表格： -->
						<td colspan="2" id="btn">
							<c:if test="${loginError == 'no'}" >
								<span id="login_span" >用户名或密码输入错误，请重新输入！</span><br />
							</c:if>
							<!-- button-普通按钮，submit-提交按钮；submit按钮一般出现在网页上需要提交信息到服务器是才使用，
							而button按钮是创建一个按钮，对于实现按钮将会发生什么事这个不一定 -->
							<input type="hidden" name="method" value="login" />
		       				<input type="submit" value="登录" id="login" name="login"></input>
		       				<!-- <input type="button" value="注 册" id="register" onclick="window.open('files/Register.jsp')"> -->
		       				<input type="button" value="重  置"  id="emptyAll" >
		       			</td>
		       		</tr>
				</table>
		  	</form>  
		</div>
	</div>
	<!-- 外部js放body底部不会产生节点丢失情况，推荐放这里 -->
	<script src="Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="Js/login.js"></script>
</body>
</html>