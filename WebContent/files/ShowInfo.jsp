<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/showInfo.css">
	<title>个人信息</title>	
</head>
<body>
	<div id="showInfo">
		<form action="${pageContext.request.contextPath}/ShowInfoServlet?userType=${User.userType}
			&&fk_positionId=${User.fk_positionId}&&id=${User.id}" method="post" onsubmit="return check()">
			<input type="button" id="edit_btn" value="信息修改" />
			<input type="button" id="cancel_btn" value="取消" 
				onClick="window.location.reload('${pageContext.request.contextPath}/files/ShowInfo.jsp')" />
			<input type="submit" id="save_btn" name="update_info" value="保存"  />
			<span id="empty_span">账号、姓名、密码不可设置为空！</span>
			<table>
				<tr>	<!-- 表的第一行 -->
					<th>账号：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="num_text" name="userNum" value='${User.userNum } ' />
						</c:if>	
						<c:if test="${User == null }">
							<input type="text" id="num_text" placeholder="您还没有账户，请先注册" />
						</c:if>								
					</td>
				</tr>
				<tr>	<!-- 表的第二行 -->
					<th>姓名：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="user_text" name="userName" value='${User.userName }' />
						</c:if>	
						<c:if test="${User == null }">
							<input type="text" id="user_text" placeholder="您还没有用户名，请先注册" />
						</c:if>	
						<span id="user_span">姓名只能为2-5个中文！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第三行 -->
					<th>密码：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="pwd_text" name="userPassword" value='${User.userPassword }' />
						</c:if>
						<c:if test="${User == null }">
							<input type="text" id="pwd_text" placeholder="您还没有密码，请先注册" />
						</c:if>
						<span id="pwd_span">密码只能为6-10位字符！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第四行 -->
					<th>性 别：</th>
					<td>
						<c:choose>
							<c:when test="${User.userSex == '男'}"> 	
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;							
								<img src="${pageContext.request.contextPath}/images/Male.gif" > 
								<input class="sex_text" name="userSex" value="${User.userSex}">
							</c:when>
							<c:when test="${User.userSex == '女'}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="${pageContext.request.contextPath}/images/Female.gif" > 
								<input class="sex_text" name="userSex" value="${User.userSex}">
							</c:when>
							<c:otherwise>  
								<input type="radio" id="sex_radio" > 
								<img src="${pageContext.request.contextPath}/images/Male.gif"> 男				
								<input type="radio" id="sex_radio" > 
								<img src="${pageContext.request.contextPath}/images/Female.gif"> 女
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>	<!-- 表的第五行 -->
					<th>出生年月：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="birthday_text" name="userBirthday" value="${User.userBirthday }"/>
							<img id="calendar_btn" src="${pageContext.request.contextPath}/lhgcalendar/images/date.gif" 
								title="选择日期" onclick="J.calendar.get({id:'birthday_text', to:'2000-1-1,min'});"/>
						</c:if>
						<c:if test="${User == null }">
							<input type="text" id="birthday_text" placeholder=" 您还没有生日，请先注册"> 								
						</c:if>					
					</td>
				</tr>
				<tr>	<!-- 表的第六行 -->
					<th>电话号码：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="tel_text" name="userTel" value='${User.userTel }' />
						</c:if>
						<c:if test="${User == null }">
							<input type="text" id="tel_text" placeholder="您还没有电话号码，请先注册" />
						</c:if>
						<span id="tel_span">电话号码只能为11位数字！</span>
					</td>
				</tr>
				<tr>	<!-- 表的第七行 -->
					<th>电子邮箱：</th>
					<td>
						<c:if test="${User != null }">
							<input type="text" id="mail_text" name="userMail" value='${User.userMail }' />
						</c:if>
						<c:if test="${User == null }">
							<input type="text" id="mail_text" placeholder=" 您还没有邮箱，请先注册" />
						</c:if>	
						<span id="mail_span">邮箱格式不正确！</span>					
					</td>
				</tr>	
			</table>
		</form>		
	</div>
	
	<script src="${pageContext.request.contextPath}/Js/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/Js/showInfo.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcore.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lhgcalendar/lhgcalendar.js"></script>
</body>
</html>