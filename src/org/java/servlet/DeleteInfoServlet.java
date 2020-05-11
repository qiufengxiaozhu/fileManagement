package org.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.service.PositionService;
import org.java.service.UserService;
import org.java.service.impl.PositionServiceImpl;
import org.java.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteInfoServlet
 */
@WebServlet("/DeleteInfoServlet")
public class DeleteInfoServlet extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	private PositionService positionService = new PositionServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");	
		
		//停用人员信息界面的启用功能
		if("2".equals(flag)) {	//单个启用
			String message = "人员启用成功！";
			String id = request.getParameter("id");	
			userService.enable_Staff(Integer.parseInt(id));	//启用员工
			int fk_positionId = userService.find_Staff(Integer.parseInt(id)).getFk_positionId();	//通过id查找指定员工,之后取出外键
			positionService.add_number(fk_positionId);	//启用成功后人数加1
			request.setAttribute("useMessage", message);
			request.getRequestDispatcher("DiscontinueListServlet").forward(request, response);
		}
//		else if("22".equals(flag)) {	//批量启用
//			String message = "人员启用成功！";	
//			Object[] id = request.getParameterValues("select");
//			for(int i=0; i<id.length; i++) {
//				userService.enable_Staff(Integer.parseInt(id[i].toString()));
//			}
//			request.setAttribute("message", message);
//			request.getRequestDispatcher("DiscontinueListServlet").forward(request, response);
//		}	
		//停用人员信息界面的删除功能
		else if("3".equals(flag)) {	//单个删除
			String message = "人员删除成功！";
			String id = request.getParameter("id");	
			userService.del_Staff(Integer.parseInt(id));
//			int fk_positionId = userService.find_Staff(Integer.parseInt(id)).getFk_positionId();	//通过id查找指定员工,之后取出外键
//			positionService.del_number(fk_positionId);	//删除成功后人数减1
			request.setAttribute("useMessage", message);
			request.getRequestDispatcher("DiscontinueListServlet").forward(request, response);
		}
		else if("33".equals(flag)) {	//批量删除
			String message = "人员删除成功！";	
			Object[] id = request.getParameterValues("select");
			for(int i=0; i<id.length; i++) {
				userService.del_Staff(Integer.parseInt(id[i].toString()));
			}
			request.setAttribute("useMessage", message);
			request.getRequestDispatcher("DiscontinueListServlet").forward(request, response);
		}	
		//通讯录界面的停用功能
		else if("1".equals(flag)) {	//批量停用（由通讯录界面得到）
			String message = "人员停用成功！";	
			Object[] id = request.getParameterValues("select");
			for(int i=0; i<id.length; i++) {
				userService.out_Staff(Integer.parseInt(id[i].toString()));
				int fk_positionId = userService.find_Staff(Integer.parseInt(id[i].toString())).getFk_positionId();	//通过id查找指定员工,之后取出外键
				positionService.del_number(fk_positionId);	//删除成功后人数减1
			}
			request.setAttribute("stopMessage", message);
			request.getRequestDispatcher("AddressListServlet").forward(request, response);
		}
		else {		//单个停用
			String message = "人员停用成功！";	
			String id = request.getParameter("id");	
			userService.out_Staff(Integer.parseInt(id));
			int fk_positionId = userService.find_Staff(Integer.parseInt(id)).getFk_positionId();	//通过id查找指定员工,之后取出外键
			positionService.del_number(fk_positionId);	//删除成功后人数减1
			request.setAttribute("stopMessage", message);
			request.getRequestDispatcher("AddressListServlet").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
