/**
 * 
 */
package org.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.bean.Department;
import org.java.dao.DepartmentDao;
import org.java.util.MysqlDButil;

/**
 * @author 邱高强
 *
 */
public class DepartmentDaoImpl implements DepartmentDao{

	/**
	 * 查找全部部门
	 */
	@Override
	public List<Department> getAll_Department() {
		// TODO Auto-generated method stub
		
		String sql = "select * from department";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Department> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Department>();
			while(rs.next()) {
				Department department = new Department();
				
				department.setId(rs.getInt("id"));
				department.setDepartmentName(rs.getString("departmentName"));
				
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;
	}

}
