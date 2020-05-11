/**
 * 
 */
package org.java.service;

import java.util.List;

import org.java.bean.Department;

/**
 * @author 邱高强
 *
 */
public interface DepartmentService {

	//查找所有部门
	public List<Department> getAll_Department();
}
