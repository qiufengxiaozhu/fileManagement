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
import org.java.bean.Position;
import org.java.bean.User;
import org.java.service.DepartmentService;
import org.java.service.PositionService;
import org.java.service.UserService;
import org.java.service.impl.DepartmentServiceImpl;
import org.java.service.impl.PositionServiceImpl;
import org.java.service.impl.UserServiceImpl;
import org.java.util.MysqlDButil;

/**
 * Servlet implementation class AddressListServlet
 */
public class AddressListServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
	private PositionService positionService = new PositionServiceImpl();
	private ArrayList<String> position = new ArrayList<String>();
	private DepartmentService DepartmentService = new DepartmentServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String flag = request.getParameter("flag");	
		String userName = request.getParameter("userName");
		
		List<Department> departmentList = DepartmentService.getAll_Department();	//调用获取全部职称信息的方法
		
//		System.out.println(positionService.all_number(1));
		
		//用户名查询
		if("search".equals(flag)) {	//用户名查询

			position.clear();//清空顺序表中的数据
			
			String department=request.getParameter("department");	//获取通讯录页面的页数值
//			System.out.println("部门id："+Integer.parseInt(department));
//			System.out.println("用户名："+userName);
			
			//选择了部门
			if(!"0".equals(department)) {
					
				//选择了姓名
				if(userName != "") {
					
//					System.out.println("选择了姓名");
					
					//装载查询出的用户
					List<User> userList = new ArrayList<User>();
					//根据部门id找到相应的职务，根据职务id查找员工
					List<Position> list = positionService.find_positionId(Integer.parseInt(department));
					for(int i=0; i<list.size(); i++) {//查询出所有的外键
//						System.out.println("所有的外键"+list.get(i).getId());
						List<User> user = userService.findAll_Staff(list.get(i).getId(), userName);
						for(int j=0; j<user.size(); j++) {//查询出某个外键的所有用户
//							System.out.println(user.get(j));
							//获取user表的外键id（等价于职称表的id）
							int positionId = user.get(j).getFk_positionId();
							//通过职称表id将职称名称提取出来赋值给ArrayList集合
							position.add(positionService.find_position(positionId).getPositionName());
							userList.add(user.get(j));	
						}
					}
					request.setAttribute("PositionList", position);		//得到职位名称的集合
					request.setAttribute("UserList", userList);		//得到user表中全部信息
				}
				//未选择姓名
				if(userName == "") {
							
//					System.out.println("未选择姓名");
					
					//装载查询出的用户
					List<User> userList = new ArrayList<User>();
					//根据部门id找到相应的职务，根据职务id查找员工
					List<Position> list = positionService.find_positionId(Integer.parseInt(department));
					for(int i=0; i<list.size(); i++) {//查询出所有的外键
//						System.out.println("所有的外键"+list.get(i).getId());
						List<User> user = userService.findAll_Staff(list.get(i).getId());
						for(int j=0; j<user.size(); j++) {//查询出某个外键的所有用户
//							System.out.println(user.get(j));
							
							//获取user表的外键id（等价于职称表的id）
							int positionId = user.get(j).getFk_positionId();
							//通过职称表id将职称名称提取出来赋值给ArrayList集合
							position.add(positionService.find_position(positionId).getPositionName());
							userList.add(user.get(j));	
//							userList.add(new User(user.get(j).getId(),user.get(j).getUserNum(),user.get(j).getUserName(),user.get(j).getUserPassword(),
//									user.get(j).getUserSex(),user.get(j).getUserBirthday(),user.get(j).getUserTel(),user.get(j).getUserMail(),
//									user.get(j).getUserType(),user.get(j).getFk_positionId()));
						}
					}
					request.setAttribute("PositionList", position);		//得到职位名称的集合
					request.setAttribute("UserList", userList);		//得到user表中全部信息
				}
			}
			//未选择部门
			else {
				//选择了姓名
				if(userName != null || userName != " ") {
					List<User> userList = userService.find_Staff(userName);	//通过用户名查询
					for(int i=0; i<userList.size(); i++) {//查询出所有的外键
						//获取user表的外键id（等价于职称表的id）
						int positionId = userList.get(i).getFk_positionId();
						//通过职称表id将职称名称提取出来赋值给ArrayList集合
						position.add(positionService.find_position(positionId).getPositionName());
					
					}
					request.setAttribute("PositionList", position);		//得到职位名称的集合
					request.setAttribute("UserList", userList);		//得到user表中全部信息
				}
				//未选择姓名				
				//无任何事情发生！				
			}
			
			
		}
		
		else {	//直接点击通讯录按钮
			position.clear();//清空顺序表中的数据
			//分页操作
			int pageNo = 1;	//初始化页数
			String pageno=request.getParameter("pageNos");	//获取通讯录页面的页数值
			if(pageno != null){							//第一次执行时还未定义pageNos,页数默认为1，然后点击上下页，此值就会改变
				pageNo=Integer.parseInt(pageno);
			}
			
			List<User> list = userService.getPage_Staff(pageNo);	//调用获取全部员工信息的方法		
			for(int i=0; i<list.size(); i++) {
				
				//获取user表的外键id（等价于职称表的id）
				int positionId = list.get(i).getFk_positionId();
				
//				System.out.print(positionId+" ");
				//通过职称表id将职称名称提取出来赋值给ArrayList集合
				position.add(positionService.find_position(positionId).getPositionName());
//				System.out.println(positionService.find_position(positionId).getPositionName()+" ");
	//			//获取user表的用户类型
	//			int type = list.get(i).getUserType();
	//			//将用户类型赋值给ArrayList集合
	//			userType.add(type);
	//			System.out.println(userType.get(i));	//输出集合中的数据
			}
			
			int recordCount = userService.getPage();	//得到表中一共能分成多少页数
			
			request.setAttribute("pageNos", pageNo);	//得到获取第几页的记录
			request.setAttribute("recordCount", recordCount);	//得到一共多少页
			request.setAttribute("PositionList", position);		//得到职位名称的集合
			//request.setAttribute("LoginId", MysqlDButil.userId);	//得到登录进来的用户id
			request.setAttribute("LoginName", MysqlDButil.userName);	//得到登录进来的用户名
			request.setAttribute("UserType", MysqlDButil.userType);	//得到登录进来的用户类型
			request.setAttribute("UserList", list);		//得到user表中全部信息
			
		}
		request.setAttribute("DepartmentList", departmentList);		//得到部门表中全部信息
		request.getRequestDispatcher("files/AddressList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
