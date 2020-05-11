package org.java.service.impl;

import java.util.List;

import org.java.bean.Position;
import org.java.bean.User;
import org.java.dao.PositionDao;
import org.java.dao.impl.PositionDaoImpl;
import org.java.service.PositionService;

public class PositionServiceImpl implements PositionService {

	private PositionDao dao = new PositionDaoImpl();
	
	/**
	 *	通过id 查找职称
	 */
	@Override
	public Position find_position(int id) {
		// TODO Auto-generated method stub
		
		Position position = dao.find_position(id);

		return position;
		
	}
	
	/**
	 * 通过id 更新部门人数
	 */
	@Override
	public int add_number(int id) {
		// TODO Auto-generated method stub

		int rows = dao.add_number(id);
		
		return rows;
	}

	/**
	 * 通过id 更新部门人数
	 */
	@Override
	public int del_number(int id) {
		// TODO Auto-generated method stub

		int rows = dao.del_number(id);
		
		return rows;
	}
	
	/**
	 * 通过部门表（外键）id 统计部门人数
	 */
	@Override
	public int all_number(int fk_departmentId) {
		// TODO Auto-generated method stub
		
		int sum = dao.all_number(fk_departmentId);
		
		return sum;
	}


	
	/**
	 *	通过部门表（外键）id 查找职称id
	 */
	@Override
	public List<Position> find_positionId(int fk_departmentId) {
		// TODO Auto-generated method stub

		List<Position> list = dao.find_positionId(fk_departmentId);
		
		return list;
	}

	/**
	 *	查看全部职称信息
	 */
	@Override
	public List<Position> getAll_Position() {
		// TODO Auto-generated method stub
		
		List<Position> list = dao.getAll_Position();
		
		return list;
	}

}
