package com.example.administrator.travel;

import java.io.File;
import java.util.ArrayList;
/**
 * 
 * @author Administrator
 *图片工具类 自动检索本地的图片 并生成图片列表备用
 *注意：本类需要修改IP
 */
public class FileTest
{
	private static ArrayList<String> filelist = new ArrayList<String>();
	private static ArrayList<String> fileNameList = new ArrayList();

	static
	{
		//		String filePath = "C:\\Users\\Administrator\\Downloads\\devAid-v1.1\\devAid-v1.1\\upload";
		//		getFiles(filePath);
	}
/*
 * 获取图片列表
 */
	public ArrayList<String> getFilelist()
	{
		//		String filePath = "C:\\Users\\Administrator\\Downloads\\devAid-v1.1\\devAid-v1.1\\upload";
		//		getFiles(filePath);
		String filePath = "/Users/lianghuanxiang/Desktop/TravelServer/旅游服务器/apache-tomcat-7.0.77/webapps/ROOT/upload";
		getFiles(filePath);
		System.out.println(filelist);
		return filelist;
	}
	/*
	 * 返回主页图片列表及其他图片
	 */
	public ArrayList<String> getFileNameList()
	{
		String filePath = "/Users/lianghuanxiang/Desktop/TravelServer/旅游服务器/apache-tomcat-7.0.77/webapps/ROOT/upload";
		getFiles(filePath);
		fileNameList.add("badaguan-win.png");
		fileNameList.add("fangte-win.png");
		fileNameList.add("haijun-win.png");
		fileNameList.add("jianyu-win.png");
		fileNameList.add("liuqinghe-win.png");
		fileNameList.add("pichaiyuan-win.png");
		fileNameList.add("shilaoren-win.png");
		fileNameList.add("xiaoyushan-win.png");
		fileNameList.add("zhanqiao-win.png");
		fileNameList.add("zhongshan-win.png");
		System.out.println("FileNameList:"+fileNameList);
		return fileNameList;
	}

	public static void main(String[] args) throws Exception
	{

		//		String filePath = "C:\\Users\\Administrator\\Downloads\\devAid-v1.1\\devAid-v1.1\\upload";
		//		getFiles(filePath);
		System.out.println(filelist);
	}

	/*
	 * 通过递归得到某一路径下所有的目录及其文件
	 */
	public static void getFiles(String filePath)
	{
		File root = new File(filePath);
		File[] files = root.listFiles();
		filelist.removeAll(filelist);
		for (File file : files)
		{
			if (file.isDirectory())
			{
				/*
				 * 递归调用
				 */
				getFiles(file.getAbsolutePath());
				// filelist.add(file.getName());
				// System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
				// System.out.println(file.getAbsolutePath());
			}
			else
			{
				// System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
				// System.out.println(file.getName());
				String filename = file.getName();
				filelist.add("http://192.168.0.153:8080/upload/" + filename);
				fileNameList.add(filename);
			}
		}

	}
}