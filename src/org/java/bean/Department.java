/**
 * 
 */
package org.java.bean;

/**
 * @author 邱高强
 *
 */
public class Department {

	private int id;	//部门表id
	private String departmentName;	//部门
	
	/**
	 * @param id 
	 * @param department 
	 */
	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}

	public Department() {
		super();
	};
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	
}
