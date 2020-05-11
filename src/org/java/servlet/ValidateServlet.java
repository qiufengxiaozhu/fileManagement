package org.java.servlet;

import java.io.IOException;

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
 * Servlet implementation class ValidateServlet
 */
public class ValidateServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String flag = request.getParameter("flag");	//判断是否是从Menu.jsp页面进来的
		if("1".equals(flag)) {	//如果是Menu.jsp请求的页面，直接跳转到展示个人信息页面
			User user = userService.find_Staff(MysqlDButil.userId);//通过用户id查找用户信息
			HttpSession session=request.getSession();		
			session.setAttribute("User", user);
			request.getRequestDispatcher("files/ShowInfo.jsp").forward(request, response);
		}
		else {
			String authCode = (String) request.getSession().getAttribute("authCode");//自动生成的验证码		
			String username = request.getParameter("username");	//用户名(对应数据库中的userNum)
			String password = request.getParameter("password");	//密码
			String rand = request.getParameter("rand");	//验证码
			
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			//判断验证码是否正确匹配
			if (rand.equals(authCode)) {
				if(MysqlDButil.login(username, password)) {
					
					//System.out.println("登陆成功");
					User user = userService.find_Staff(MysqlDButil.userId);
					//System.out.println("用户名："+user.getUserName());
					
					HttpSession session=request.getSession();		
					session.setAttribute("User", user);
					session.setAttribute("UserNum", user.getUserNum());
					session.setAttribute("userName", MysqlDButil.userName);	
					session.setAttribute("userId", MysqlDButil.userId);	
					session.setAttribute("userType", MysqlDButil.userType);	
					request.getRequestDispatcher("files/Home.jsp").forward(request, response);
				}
				else {
					
					//System.out.println("用户名或密码输入错误");
					request.setAttribute("loginError", "no");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} else {
				
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				if(username!=null || password!=null)
					request.setAttribute("checkError", "no");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
