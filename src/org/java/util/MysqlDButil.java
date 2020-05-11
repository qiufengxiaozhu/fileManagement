package org.java.util;

import java.sql.*;

public class MysqlDButil {
	
	
	//MySQL8的配置
//	public static final String URL ="jdbc:mysql://localhost:3306/file?useSSL=false&serverTimezone=UTC";//mydb为Mysql数据库中创建的数据库实例名
//	public static final String DRIVER="com.mysql.cj.jdbc.Driver";    
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/file?useUnicode=true&characterEncoding=UTF8";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";
		
	public static String userName;
	public static int userId;
	public static int userType;
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return conn;
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//用户登录
	public static boolean login(String name,String password) {
		
		//System.out.println("123");
		
		boolean flag = false;
		
		String sql = "select * from user where userNum = ? and userPassword = ? and userType > '0' ";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {	
				
				userId = rs.getInt("id");
				userName = rs.getString("userName");
				userType = rs.getInt("userType");
				
				//System.out.println("userName="+userName);
				
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MysqlDButil.closeAll(rs, pstmt, conn);
		
		return flag;	
	}
	
	//用户注册
	public static boolean register(String name,String password) {
		
		boolean flag = false;
		
		String sql = "select * from user where userNum = ?  ";
		
		Connection conn = MysqlDButil.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);   
            
            rs = pstmt.executeQuery();  
            
            if(!rs.next()){           
                              
            	pstmt = conn.prepareStatement("Insert into user(user,password) values('" + name + "','" + password + "')");  
               
            	int rows = pstmt.executeUpdate();  
                if (rows > 0){  
                	flag = true;
                } 
            }           
        }catch(SQLException e){
            e.getStackTrace();
        }
		
		MysqlDButil.closeAll(rs, pstmt, conn);
		
		return flag;
	}
}
