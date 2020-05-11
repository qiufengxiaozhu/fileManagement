package org.java.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.java.bean.User;
import org.java.service.UserService;
import org.java.service.impl.UserServiceImpl;
import org.java.util.MysqlDButil;

/**
 * Servlet implementation class ShowInfoServlet
 */
public class ShowInfoServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub       
		
		String userNum = request.getParameter("userNum").trim();		//账户
		String userName = request.getParameter("userName");		//用户名
		String userPassword = request.getParameter("userPassword");	//密码
		String userSex = request.getParameter("userSex");	//性别
		String userBirthday = request.getParameter("userBirthday");		//出生年月
		String userTel = request.getParameter("userTel");	//电话号码
		String userMail = request.getParameter("userMail");	//电子邮箱
		int userType = Integer.parseInt(request.getParameter("userType"));	//用户类型
		int fk_positionId = Integer.parseInt(request.getParameter("fk_positionId"));	//职位id
		int id = Integer.parseInt(request.getParameter("id"));		//用户id			
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(userBirthday);
			User user = new User(id, userNum, userName, userPassword, userSex,
					date, userTel, userMail, userType, fk_positionId);
			
			System.out.println("账号："+user.getUserNum()+" - 用户名："+user.getUserName()+" - 密码:"+user.getUserPassword());
			System.out.println("性别："+userSex);
			System.out.println("生日："+user.getUserBirthday()+" - 电话："+user.getUserTel()+" - 邮箱："+user.getUserMail());
			System.out.println("用户类型: "+user.getUserType()+" - 职位id: "+user.getFk_positionId()+" - id: "+user.getId());
			
			if(userService.update_Staff(user) > 0)
				System.out.println("信息修改成功！");
			
			user = userService.find_Staff(user.getId());
			HttpSession session=request.getSession();		
			session.setAttribute("User", user);
			MysqlDButil.userName = user.getUserName();	//得到登录进来的用户名
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("files/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
