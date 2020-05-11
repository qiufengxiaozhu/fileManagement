package org.java.test;

import java.sql.Connection;

import org.java.util.MysqlDButil;

public class testConn {

	public void test() throws Exception{
		// TODO Auto-generated constructor stub
		
		Connection conn = MysqlDButil.getConnection();
		System.out.println(conn);
	}
}
