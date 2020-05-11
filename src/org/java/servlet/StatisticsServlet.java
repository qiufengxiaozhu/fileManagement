package org.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.bean.Department;
import org.java.service.DepartmentService;
import org.java.service.PositionService;
import org.java.service.UserService;
import org.java.service.impl.DepartmentServiceImpl;
import org.java.service.impl.PositionServiceImpl;
import org.java.service.impl.UserServiceImpl;

/**
 * Servlet implementation class StatisticsServlet
 */

public class StatisticsServlet extends HttpServlet {
       
	private UserService userService = new UserServiceImpl();
	private PositionService positionService = new PositionServiceImpl();
	private DepartmentService departmentService = new DepartmentServiceImpl();
	private ArrayList<Integer> departmentId = new ArrayList<Integer>();
	private ArrayList<String> departmentName = new ArrayList<String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		departmentId.clear();//清空顺序表中的数据
		departmentName.clear();//清空顺序表中的数据
		
		List<Department> department = departmentService.getAll_Department();
		
		int sum =0;
		for(int i = 0; i < department.size(); i++) {
			
			int fk_departmentId = department.get(i).getId();	//拿到部门id
			String name = department.get(i).getDepartmentName();	//拿到部门名称
			departmentId.add(positionService.all_number(fk_departmentId));	//通过部门id统计该部门人数
			sum+=positionService.all_number(fk_departmentId);
			departmentName.add(name);
			
		}
		
		request.setAttribute("DepartmentId", departmentId);
		request.setAttribute("DepartmentName", departmentName);
		request.setAttribute("SUM", sum);
		request.getRequestDispatcher("files/Statistics.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
