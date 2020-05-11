package org.java.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.java.bean.Position;
import org.java.bean.User;
import org.java.service.PositionService;
import org.java.service.UserService;
import org.java.service.impl.PositionServiceImpl;
import org.java.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	private PositionService positionService = new PositionServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");	//判断是否是从AddressList.jsp页面进来的
		if("1".equals(flag)) {	//如果是Menu.jsp请求的页面，直接跳转到展示个人信息页面
			List<Position> list = positionService.getAll_Position();	//调用获取全部职称信息的方法	
			
			//输出读出的信息
//			for(int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).getId()+" "+list.get(i).getPositionName());
//			}
			request.setAttribute("Position", list);		//得到user表中全部信息
			request.getRequestDispatcher("files/Register.jsp").forward(request, response);
		}
		else {
			
			String usernum = request.getParameter("usernum").trim();		//账户
			String username = request.getParameter("username");		//用户名
			String password = request.getParameter("password");	//密码
			String[] userSex = request.getParameterValues("sex");	//性别
			String userBirthday = request.getParameter("userBirthday");		//出生年月
			String usertel = request.getParameter("usertel");	//电话号码
			String usermail = request.getParameter("usermail");	//电子邮箱
			int usertype = Integer.parseInt(request.getParameter("usertype"));	//用户类型
			int position = Integer.parseInt(request.getParameter("position"));	//职位id

			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(userBirthday);
				User user = new User(usernum, username, password, userSex[0],
						date, usertel, usermail, usertype, position);
				
				System.out.println("账号："+user.getUserNum()+" - 用户名："+user.getUserName()+" - 密码:"+user.getUserPassword());
				System.out.println("性别："+userSex);
				System.out.println("生日："+user.getUserBirthday()+" - 电话："+user.getUserTel()+" - 邮箱："+user.getUserMail());
				System.out.println("用户类型: "+user.getUserType()+" - 职位id: "+user.getFk_positionId());
				
				if(userService.add_Staff(user) > 0) {
					
					//System.out.println("员工注册成功！");
					positionService.add_number(position);	//注册成功后，部门人数加1
				}
					
				
				String message = "员工注册成功！";	
				request.setAttribute("message", message);
				request.getRequestDispatcher("AddressListServlet").forward(request, response);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
//		System.out.println("注册成功！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
