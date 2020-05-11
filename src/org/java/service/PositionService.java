package org.java.service;

import java.util.List;

import org.java.bean.Position;

/**
 * @author thinkp
 *	对职位表进行增删改查操作
 */
public interface PositionService {

	//通过id 查找职称
	public Position find_position(int id);
	
	//通过id 更新部门人数
	public int add_number(int id);
	
	//通过id 减少部门人数
	public int del_number(int id);
	
	//通过部门表（外键）id 统计部门人数
	public int all_number(int fk_departmentId);
	
	//通过部门表（外键）id 查找职称id
	public List<Position> find_positionId(int fk_departmentId);
	
	//查看全部职称信息
	public List<Position> getAll_Position();
}
