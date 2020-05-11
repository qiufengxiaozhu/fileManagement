/**
 * 
 */
package org.java.dao;

import java.util.List;

import org.java.bean.Department;
import org.java.bean.User;

/**
 * @author 邱高强
 *
 */
public interface DepartmentDao {

	//查找所有部门
	public List<Department> getAll_Department();
}
