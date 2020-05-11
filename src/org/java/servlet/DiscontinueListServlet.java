package org.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.bean.User;
import org.java.service.PositionService;
import org.java.service.UserService;
import org.java.service.impl.PositionServiceImpl;
import org.java.service.impl.UserServiceImpl;
import org.java.util.MysqlDButil;

/**
 * Servlet implementation class DiscontinueListServlet
 */
public class DiscontinueListServlet extends HttpServlet {
       
	private UserService userService = new UserServiceImpl();
	private PositionService positionService = new PositionServiceImpl();
	private ArrayList<String> position = new ArrayList<String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		position.clear();//清空顺序表中的数据
		int pageNo = 1;	//初始化页数
		String pageno=request.getParameter("pageNos");	//获取停用人员页面的页数值
		if(pageno != null){							//第一次执行时还未定义pageNos,页数默认为1，然后点击上下页，此值就会改变
			pageNo=Integer.parseInt(pageno);
		}
		
		List<User> list = userService.getPage_OutStaff(pageNo);	//调用获取停用员工信息的方法		
		for(int i=0; i<list.size(); i++) {
			
			//获取user表的外键id（等价于职称表的id）
			int positionId = list.get(i).getFk_positionId();
			//通过职称表id将职称名称提取出来赋值给ArrayList集合
			position.add(positionService.find_position(positionId).getPositionName());
			
		}
		
		int recordCount = userService.getOutPage();	//得到表中一共能分成多少页数
		
		request.setAttribute("pageNos", pageNo);	//得到获取第几页的记录
		request.setAttribute("recordCount", recordCount);	//得到一共多少页
		request.setAttribute("PositionList", position);		//得到职位名称的集合
		request.setAttribute("LoginName", MysqlDButil.userName);	//得到登录进来的用户名
		request.setAttribute("UserList", list);		//得到user表中全部信息

		request.getRequestDispatcher("files/DiscontinueList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
