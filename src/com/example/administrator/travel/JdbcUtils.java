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
 * ���ݿ⹤���� �ṩ���� getConnection() ���ø÷��� ֱ�ӷ���Connection���� ֱ��ʹ�ü���
 * GetRowCount(ResultSet rs) ���ݽ���� ��������
 * 1.���������ļ�
 * 2.����������
 * 3.����DriverManager.getConnection()
 */
public class JdbcUtils
{
	private static Properties prop = null;
//	http://www.cnblogs.com/bakari/p/3562244.html
	//ֻ��JdbcUtils�����ʱִ��һ��
	static
	{
		//��prop���г�ʼ�� ������dbconfig.properties�ļ���prop������
		try
		{
			//���������ļ�
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
			//����������
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
		//��ȡ����
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

	public static int GetRowCount(ResultSet rs) throws SQLException
	{
		//ͨ���ķ�����ȡ�����������
		int result = 0;
		if (rs.last())
		{
			result = rs.getRow();
			rs.beforeFirst();//���ع�
		}
		return result;
	}
}
