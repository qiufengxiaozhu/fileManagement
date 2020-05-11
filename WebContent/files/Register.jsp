<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/register.css">
	<title>注册</title>
</head>
<body>
	<p id="register_title">请填写注册信息</p>
	<div id="divForm">
		<form method="post" action="${pageContext.request.contextPath}/RegisterServlet" name="frmRegister" onsubmit="return check()">
			<table>
				<tr>	<!-- 表的第一行 -->
					<th>账 号：</th>
					<td>
						<input type="text" id="num_text" name="usernum" placeholder="请输入6-10个数字" />
						<span id="num_span">账号为6-10位数字！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第二行 -->
					<th>姓 名：</th>
					<td>
						<input type="text" id="user_text" name="username" placeholder="请输入你的名字" />
						<span id="user_span">姓名只能为2-5个中文！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第三行 -->
					<th>密 码：</th>
					<td>
						<input type="password" id="pwd_text" name="password" placeholder="请输入至少6位的密码" />
						<span id="pwd_span">密码只能为6-10位字符！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第四行 -->
					<th>确认密码：</th>
					<td>
						<input type="password" id="repwd_text" name="repassword" placeholder="请再次输入密码" />
						<span id="repwd_span">两次输入的密码不一致！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第五行 -->
					<th>性 别：</th>
					<td>
						<input type="radio" id="sex_radio_1" value="男" name="sex"> <img src="${pageContext.request.contextPath}/images/Male.gif"> 男
						<input type="radio" id="sex_radio_2" value="女" name="sex"> <img src="${pageContext.request.contextPath}/images/Female.gif"> 女
						<span id="sex_span">您需要选择性别！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第六行 -->
					<th>出生年月：</th>
					<td>
						<input type="text" id="birthday_text" name="userBirthday" placeholder="请选择你的生日"/>
						<img id="calendar_btn" src="${pageContext.request.contextPath}/lhgcalendar/images/date.gif" 
							title="选择日期" onclick="J.calendar.get({id:'birthday_text', to:'2000-1-1,min'});"/>
					</td>
				</tr>
				<tr>	<!-- 表的第七行 -->
					<th>电话号码：</th>
					<td>
						<input type="text" id="tel_text" name="usertel" placeholder="请输入你的电话号码" />
						<span id="tel_span">电话号码只能为11位数字！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第八行 -->
					<th>电子邮箱：</th>
					<td>
						<input type="text" id="mail_text" name="usermail" placeholder="请输入你的电子邮箱" />
						<span id="mail_span">邮箱格式不正确！</span>		
					</td>
				</tr>
				<tr>	<!-- 表的第九行 -->
					<th>用户权限：</th>
					<td>
						<select id="user_type" name="usertype">
							<option value="1" selected="selected">普通用户</option>
							<option value="2" >管理员</option>
						</select>
					</td>
				</tr>
				<tr>	<!-- 表的第十行 -->
					<th>用户职称：</th>
					<td>
						<select id="position" name="position">
							<option value="0" selected="selected">请选择职位</option>
							<c:forEach items="${Position}" var="list">				
								<option value="${list.id}">${list.positionName}</option>
							</c:forEach>
						</select>
						<span id="position_span">请选择职位！</span>	
					</td>
				</tr>
				<tr>
					
					<td colspan="2" id="btn">
						<input type="submit" id="register" value="注  册"> 
						<!-- 点击提交调用check()方法 -->
						<!-- <input type="hidden" name="method" value="register" /> -->
						<!-- <input type="button" value="返回" onclick="window.open('../Login.jsp')"> -->
						<a href="${pageContext.request.contextPath}/AddressListServlet" ><input type="button" value="返回"></a>
						<input type="reset" value="重  置">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 外部js放body底部不会产生节点丢失情况，推荐放这里 -->
	<script src="${pageContext.request.contextPath}/Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Js/register.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcalendar.js"></script>
</body>
</html>