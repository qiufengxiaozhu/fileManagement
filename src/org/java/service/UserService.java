package org.java.service;

import java.util.List;

import org.java.bean.User;

/**
 * @author thinkp
 *	对公司职员进行增删改查操作
 */
public interface UserService {
	
	//添加新员工
	public int add_Staff(User user);
	
	//停用员工
	public int out_Staff(int id);

	//启用员工
	public int enable_Staff(int id);
	
	//删除员工
	public int del_Staff(int id);
	
	//修改员工信息
	public int update_Staff(User user);
	
	//通过用户名查找指定员工
	public List<User> find_Staff(String userName);
	
	//通过id查找指定员工
	public User find_Staff(int id);
	
	//通过外键查找指定员工
	public List<User> findAll_Staff(int fk_positionId);
	
	//通过外键与用户名查找指定员工
	public List<User> findAll_Staff(int fk_positionId,String userName);
	
	//查看全部员工信息
	public List<User> getAll_Staff();
	
	//通过分页查看全部员工信息
	public List<User> getPage_Staff(int pageNo);
	
	//通过分页查看全部停用员工信息
	public List<User> getPage_OutStaff(int pageNo);
	
	//计算正常用户总的页数
	public int getPage();
	
	//计算停用用户总的页数
	public int getOutPage();
}
