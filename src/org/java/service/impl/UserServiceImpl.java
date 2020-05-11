package org.java.service.impl;

import java.util.List;

import org.java.bean.User;
import org.java.dao.UserDao;
import org.java.dao.impl.UserDaoImpl;
import org.java.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao dao = new UserDaoImpl();
	
	/**
	 *	添加新员工
	 */
	@Override
	public int add_Staff(User user) {
		// TODO Auto-generated method stub
		
		int rows = dao.add_Staff(user);
		
		return rows;
	}

	/**
	 *	停用员工
	 */
	@Override
	public int out_Staff(int id) {
		// TODO Auto-generated method stub

		int rows = dao.out_Staff(id);
		
		return rows;
	}
	
	/**
	 *	启用员工
	 */
	@Override
	public int enable_Staff(int id) {
		// TODO Auto-generated method stub

		int rows = dao.enable_Staff(id);
		
		return rows;
	}

	/**
	 *	删除员工
	 */
	@Override
	public int del_Staff(int id) {
		// TODO Auto-generated method stub
		
		int rows = dao.del_Staff(id);
		
		return rows;
	}

	/**
	 *	修改员工信息
	 */
	@Override
	public int update_Staff(User user) {
		// TODO Auto-generated method stub
		
		int rows = dao.update_Staff(user);
		
		return rows;
	}

	/**
	 *	通过用户名查找指定员工
	 */
	@Override
	public List<User> find_Staff(String userName) {
		// TODO Auto-generated method stub

		List<User> list = dao.find_Staff(userName);
//		System.out.println("我在这里！！！");
		return list;
	}
	
	/**
	 *	通过id查找指定员工
	 */
	@Override
	public User find_Staff(int id) {
		// TODO Auto-generated method stub

		User user = dao.find_Staff(id);

		return user;
	}

	/**
	 * 通过外键查找指定员工
	 */
	@Override
	public List<User> findAll_Staff(int fk_positionId) {
		// TODO Auto-generated method stub

		List<User> list = dao.findAll_Staff(fk_positionId);
		
		return list;
	}

	/**
	 * 通过外键与用户名查找指定员工
	 */
	@Override
	public List<User> findAll_Staff(int fk_positionId, String userName) {
		// TODO Auto-generated method stub

		List<User> list = dao.findAll_Staff(fk_positionId, userName);
		
		return list;
	}
	
	/**
	 *	查看全部员工信息
	 */
	@Override
	public List<User> getAll_Staff() {
		// TODO Auto-generated method stub
		
		List<User> list = dao.getAll_Staff();
		
		return list;
	}

	/**
	 *	通过分页查看全部员工信息
	 */
	@Override
	public List<User> getPage_Staff(int pageNo) {
		// TODO Auto-generated method stub
		
		List<User> list = dao.getPage_Staff(pageNo);
		
		return list;
	}

	/**
	 * 通过分页查看全部停用员工信息
	 */
	@Override
	public List<User> getPage_OutStaff(int pageNo) {
		// TODO Auto-generated method stub

		List<User> list = dao.getPage_OutStaff(pageNo);
		
		return list;
	}
	
	/**
	 *	计算正常用户总的页数	
	 */
	@Override
	public int getPage() {
		// TODO Auto-generated method stub
		
		int rows = dao.getPage();
		
		return rows;
	}
	
	/**
	 *	计算停用用户总的页数	
	 */
	@Override
	public int getOutPage() {
		// TODO Auto-generated method stub
		
		int rows = dao.getOutPage();
		
		return rows;
	}
	
}
