/**
 * 
 */
package org.java.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.java.bean.Files;
import org.java.dao.FilesDao;
import org.java.util.MysqlDButil;

/**
 * @author 邱高强
 *	对员工档案进行增删改查操作
 */
public class FilesDaoImpl implements FilesDao {

	/**
	 * 新增档案
	 * @param files
	 * @return
	 */
	@Override
	public int addFiles(Files files) {
		// TODO Auto-generated method stub
		
		String sql = "insert into files(id,userId,userName,path,fileName,createTime,del) values (default,?,?,?,?,?,?)";
		
		Connection conn = MysqlDButil.getConnection();

	    PreparedStatement pstmt = null;
	    int rows = 0;
		try {
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, files.getUserId());
			pstmt.setString(2, files.getUserName());
			pstmt.setString(3, files.getPath());
			pstmt.setString(4, files.getFileName());
			pstmt.setDate(5, new Date(files.getCreateTime().getTime()));
			pstmt.setInt(6, files.getDel());
						
		    rows = pstmt.executeUpdate();	
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(null, pstmt, conn);  

		return rows;
	}

	/**
	 * 通过id删除档案
	 * @param id
	 * @return
	 */
	@Override
	public int delFiles(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 查询全部档案
	 * @return
	 */
	@Override
	public List<Files> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过id查找档案
	 * @param id
	 * @return
	 */
	@Override
	public Files selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
