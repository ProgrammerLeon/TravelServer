package com.example.administrator.travel;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * v1.0
 * @author Administrator
 *
 */
/*
 * 数据库工具类 提供方法 getConnection() 调用该方法 直接返回Connection对象 直接使用即可
 * GetRowCount(ResultSet rs) 根据结果集 计算行数
 * 1.加载配置文件
 * 2.加载驱动类
 * 3.调用DriverManager.getConnection()
 */
public class JdbcUtils
{
	private static Properties prop = null;
//	http://www.cnblogs.com/bakari/p/3562244.html
	//只在JdbcUtils类加载时执行一次
	static
	{
		//给prop进行初始化 即加载dbconfig.properties文件到prop对象中
		try
		{
			//加载配置文件
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop = new Properties();
			prop.load(in);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		//		System.out.println("Loading Driver");
		try
		{
			//加载驱动类
						Class.forName(prop.getProperty("driverClassName"));
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//			System.out.println("Class Loaded");
		}
		catch (Exception e)
		{
			//			System.out.println("Class NOT Loaded");
			System.out.println(e);
		}
	}

	public static Connection getConnection() throws SQLException
	{
		//获取链接
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

	public static int GetRowCount(ResultSet rs) throws SQLException
	{
		//通过改方法获取结果集的行数
		int result = 0;
		if (rs.last())
		{
			result = rs.getRow();
			rs.beforeFirst();//光标回滚
		}
		return result;
	}
}
