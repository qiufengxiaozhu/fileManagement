/**
 * 
 */
package org.java.service.impl;

import java.util.List;

import org.java.bean.Department;
import org.java.dao.DepartmentDao;
import org.java.dao.impl.DepartmentDaoImpl;
import org.java.service.DepartmentService;

/**
 * @author 邱高强
 *
 */
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao dao = new DepartmentDaoImpl();

	/**
	 * 查找所有部门
	 */
	@Override
	public List<Department> getAll_Department() {
		// TODO Auto-generated method stub

		List<Department> list = dao.getAll_Department();
		
		return list;
	}

}
