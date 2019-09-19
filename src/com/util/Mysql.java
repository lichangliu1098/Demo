package com.util;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Mysql {

	private static final String URL="jdbc:mysql://172.16.29.128:3306/cbis_misc?useUnicode=true";
    private static final String USER="cbis";
    private static final String PASSWORD="zy#CBIS@2";

	 private static Connection conn=null;

	 static {
	     try {
	             //1.加载驱动程序
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             //2.获得数据库的连接
	             conn=DriverManager.getConnection(URL, USER, PASSWORD);

				 /*Statement statement=conn.createStatement();
				 //查询数据,其中输入sql语句
				 ResultSet rSet=statement.executeQuery("SELECT * FROM account");

				 //rSet.next()返回的是一个布尔类型的值，而且将指针指向下一条记录
				 while(rSet.next()){
					 *//*
					  * 将获得的数据输入到控制台上，注意得到的方法，因为之前查询时获得的是两个值，一个string，一个int，
					  * 使用其中的参数为string的方法，将值得名称传进去
					  *//*
					 System.out.println(rSet.getString("name")+","+rSet.getInt("username"));
				 }*/
			 System.out.println("end======");
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
		/*System.setProperty("socksProxySet", "true");
		System.setProperty("socksProxyHost", "localhost");
		System.setProperty("socksProxyPort", "3081");
		Mysql.getConnection();*/


	}
 
}