package org.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.java.bean.User;
import org.java.constants.Constants;
import org.java.dao.UserDao;
import org.java.util.MysqlDButil;

public class UserDaoImpl implements UserDao{

	/**
	 *	添加新员工
	 */
	@Override
	public int add_Staff(User user) {

		String sql ="insert into user(id,userNum,userName,userPassword,userSex,userBirthday,"
				+ "userTel,userMail,userType,fk_positionId) values (default,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = MysqlDButil.getConnection();

	    PreparedStatement pstmt = null;
	    int rows = 0;
		try {
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, user.getUserNum());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserSex());
			pstmt.setDate(5, new Date(user.getUserBirthday().getTime()));
			pstmt.setString(6, user.getUserTel());
			pstmt.setString(7, user.getUserMail());
			pstmt.setInt(8, user.getUserType());
			pstmt.setInt(9, user.getFk_positionId());
						
		    rows = pstmt.executeUpdate();	
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(null, pstmt, conn);  

		return rows;
	}

	/**
	 *	停用员工
	 */
	@Override
	public int out_Staff(int id) {
		
		String sql = "update user set userType = 0 where id = ?";
		
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
	 *	启用员工
	 */
	@Override
	public int enable_Staff(int id) {
		
		String sql = "update user set userType = 1 where id = ?";
		
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
	 *	删除员工
	 */
	@Override
	public int del_Staff(int id) {
		
		String sql = "delete from user where id = ?";

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
	 *	修改员工信息
	 */
	@Override
	public int update_Staff(User user) {
		
		String sql = "update user set userNum = ?, userName = ?, userPassword = ?, userSex = ?, "
				+ "userBirthday = ?, userTel = ?, userMail = ?,userType = ?, fk_positionId = ?"
				+ " where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, user.getUserNum());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserSex());
			pstmt.setDate(5,  new Date(user.getUserBirthday().getTime()));
			pstmt.setString(6, user.getUserTel());
			pstmt.setString(7, user.getUserMail());
			pstmt.setInt(8, user.getUserType());
			pstmt.setInt(9, user.getFk_positionId());
			pstmt.setInt(10, user.getId());
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(null, pstmt, conn);  
		
		return rows;
	}
	
	/**
	 * 通过id查找外键
	 */
	@Override
	public int find_fk_positionId(int id) {

		String sql = "select fk_positionId from user where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rows = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {		
				rows = 1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		MysqlDButil.closeAll(rs, pstmt, conn);
		//System.out.println("5"+user.getUserName());
		
		return rows;
	}	
	

	/**
	 *	通过用户名查找指定员工
	 */
	@Override
	public List<User> find_Staff(String userName) {
		
		String sql = "select * from user where userName = ? and userType > 0";
		
//		System.out.println("用户名："+userName);
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUserName());
		}
		return list;
	}
	
	/**
	 *	通过id查找指定员工
	 */
	@Override
	public User find_Staff(int id) {
		
		String sql = "select * from user where id = ?";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			user = new User();
			
			if(rs.next()) {		
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		MysqlDButil.closeAll(rs, pstmt, conn);
		//System.out.println("5"+user.getUserName());
		
		return user;
	}

	/**
	 * //通过外键查找指定员工
	 */
	@Override
	public List<User> findAll_Staff(int fk_positionId) {

		String sql = "select * from user where fk_positionId = ? and userType > 0";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fk_positionId);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;
	}
	
	/**
	 * 通过外键与用户名查找指定员工
	 */
	@Override
	public List<User> findAll_Staff(int fk_positionId, String userName) {
		// TODO Auto-generated method stub

		String sql = "select * from user where fk_positionId = ? and userName = ? and userType > 0";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fk_positionId);
			pstmt.setString(2, userName);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;
	}

	
	/**
	 *	查看全部员工信息
	 */
	@Override
	public List<User> getAll_Staff() {
		
		String sql = "select * from user";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;	
	}

	/**
	 *	通过分页查看全部员工信息
	 */
	@Override
	public List<User> getPage_Staff(int pageNo) {
		
		int pageSize = Constants.pageNum;		//每次取出多少条数据
		int page=(pageNo-1)*Constants.pageNum;	//取数据时从第几行开始取
		
		//System.out.println("每页容量：" + pageSize +"从第几页开始："+page);
		
		String sql = "select * from user where userType > 0 order by id limit ?,?";
		
		Connection conn = MysqlDButil.getConnection();		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;	
	}

	/**
	 * 通过分页查看全部停用员工信息
	 */
	@Override
	public List<User> getPage_OutStaff(int pageNo) {

		int pageSize = Constants.pageNum;		//每次取出多少条数据
		int page=(pageNo-1)*Constants.pageNum;	//取数据时从第几行开始取
		
		String sql = "select * from user where userType = 0 order by id limit ?,?";
		
		Connection conn = MysqlDButil.getConnection();		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUserNum(rs.getString("userNum"));
				user.setUserName(rs.getString("userName"));				
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserBirthday(rs.getDate("userBirthday"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserMail(rs.getString("userMail"));
				user.setUserType(rs.getInt("userType"));
				user.setFk_positionId(rs.getInt("fk_positionId"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return list;	
		
	}
	
	/**
	 *	计算正常用户总的页数
	 */
	@Override
	public int getPage() {
		// TODO Auto-generated method stub
		
		int recordCount=0,lastRows=0,pageNum=0;
		String sql = "select count(*) from user where userType > 0";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				recordCount = rs.getInt(1);	//得到总条数
				lastRows = recordCount % Constants.pageNum;	//最后一页的条数
				pageNum = recordCount / Constants.pageNum;	//有多少个整页数
				if(lastRows != 0){
					pageNum += 1;
				}					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return pageNum;
	}

	/**
	 *	计算停用用户总的页数
	 */
	@Override
	public int getOutPage() {
		// TODO Auto-generated method stub

		int recordCount=0,lastRows=0,pageNum=0;
		String sql = "select count(*) from user where userType = 0";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				recordCount = rs.getInt(1);	//得到总条数
				lastRows = recordCount % Constants.pageNum;	//最后一页的条数
				pageNum = recordCount / Constants.pageNum;	//有多少个整页数
				if(lastRows != 0){
					pageNum += 1;
				}					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		return pageNum;
	}



}
