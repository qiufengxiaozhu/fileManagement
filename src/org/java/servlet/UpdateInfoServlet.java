package org.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.java.bean.User;
import org.java.service.UserService;
import org.java.service.impl.UserServiceImpl;
import org.java.util.MysqlDButil;

/**
 * Servlet implementation class UpdateInfoServlet
 */

public class UpdateInfoServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		User user = userService.find_Staff(Integer.parseInt(id));
		
		System.out.println("账号："+user.getUserNum()+" - 用户名："+user.getUserName()+" - 密码:"+user.getUserPassword());
		System.out.println("性别："+user.getUserSex());
		System.out.println("生日："+user.getUserBirthday()+" - 电话："+user.getUserTel()+" - 邮箱："+user.getUserMail());
		System.out.println("用户类型: "+user.getUserType()+" - 职位id: "+user.getFk_positionId()+" - id: "+user.getId());
		
		//request.setAttribute("User", user);
		HttpSession session=request.getSession();		
		session.setAttribute("User", user);
		request.getRequestDispatcher("files/ShowInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
