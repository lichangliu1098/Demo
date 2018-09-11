package com.util;

import java.sql.*;

public class Mysql {

	private static final String URL="jdbc:mysql://127.0.0.1:3306/cbis_user?useUnicode=true";
    private static final String USER="bruce";
    private static final String PASSWORD="bruce.1234";

	 private static Connection conn=null;

	 static {
	     try {
	             //1.加载驱动程序
	             Class.forName("com.mysql.jdbc.Driver");
	             //2.获得数据库的连接
	             conn=DriverManager.getConnection(URL, USER, PASSWORD);
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	 }

	public static Connection getConnection(){
		return conn;
	}

	public static void main(String[] args) {
		Mysql.getConnection();
	}
 
}