package org.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.bean.Position;
import org.java.bean.User;
import org.java.dao.PositionDao;
import org.java.util.MysqlDButil;

public class PositionDaoImpl implements PositionDao {

	/**
	 *	通过id 查找职称
	 */
	@Override
	public Position find_position(int id) {

		String sql = "select * from position where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Position position = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			position = new Position();
			
			if(rs.next()) {		
				
				position.setId(rs.getInt("id"));
				position.setPositionName(rs.getString("positionName"));
				position.setNumber(rs.getInt("number"));			
				position.setFk_departmentId(rs.getInt("fk_departmentId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		MysqlDButil.closeAll(rs, pstmt, conn);
		
		return position;
	}
	
	/**
	 * 通过id 增加部门人数
	 */
	@Override
	public int add_number(int id) {
		// TODO Auto-generated method stub

		String sql = "update position set number = number + 1 where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, id);
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(null, pstmt, conn);  
		
		return rows;
	}

	/**
	 * 通过id 减少部门人数
	 */
	@Override
	public int del_number(int id) {
		// TODO Auto-generated method stub

		String sql = "update position set number = number - 1 where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, id);
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(null, pstmt, conn);  
		
		return rows;
	}
	
	/**
	 * 通过部门表（外键）id 统计部门人数
	 */
	@Override
	public int all_number(int fk_departmentId) {

		String sql = "select sum(p.number) as number from position p where p.fk_departmentId = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int sum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fk_departmentId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sum = rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return sum;
	}
	
	/**
	 *	通过部门表（外键）id 查找职称id
	 */
	@Override
	public List<Position> find_positionId(int fk_departmentId) {

		String sql = "select * from position where fk_departmentId = ? ";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Position> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fk_departmentId);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Position>();
			while(rs.next()) {
				Position position = new Position();
				
				position.setId(rs.getInt("id"));
				position.setPositionName(rs.getString("positionName"));
				
				list.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;
	}

	/**
	 *	查看全部职称信息
	 */
	@Override
	public List<Position> getAll_Position() {
		
		String sql = "select * from position";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Position> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Position>();
			while(rs.next()) {
				Position position = new Position();
				
				position.setId(rs.getInt("id"));
				position.setPositionName(rs.getString("positionName"));
				
				list.add(position);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;	
	}
	
}
