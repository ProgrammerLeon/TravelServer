package com.example.administrator.travel;

import java.io.File;
import java.util.ArrayList;
/**
 * 
 * @author Administrator
 *ͼƬ������ �Զ��������ص�ͼƬ ������ͼƬ�б���
 *ע�⣺������Ҫ�޸�IP
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
 * ��ȡͼƬ�б�
 */
	public ArrayList<String> getFilelist()
	{
		//		String filePath = "C:\\Users\\Administrator\\Downloads\\devAid-v1.1\\devAid-v1.1\\upload";
		//		getFiles(filePath);
		String filePath = "/Users/lianghuanxiang/Desktop/TravelServer/���η�����/apache-tomcat-7.0.77/webapps/ROOT/upload";
		getFiles(filePath);
		System.out.println(filelist);
		return filelist;
	}
	/*
	 * ������ҳͼƬ�б�����ͼƬ
	 */
	public ArrayList<String> getFileNameList()
	{
		String filePath = "/Users/lianghuanxiang/Desktop/TravelServer/���η�����/apache-tomcat-7.0.77/webapps/ROOT/upload";
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
	 * ͨ���ݹ�õ�ĳһ·�������е�Ŀ¼�����ļ�
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
				 * �ݹ����
				 */
				getFiles(file.getAbsolutePath());
				// filelist.add(file.getName());
				// System.out.println("��ʾ"+filePath+"��������Ŀ¼�����ļ�"+file.getAbsolutePath());
				// System.out.println(file.getAbsolutePath());
			}
			else
			{
				// System.out.println("��ʾ"+filePath+"��������Ŀ¼"+file.getAbsolutePath());
				// System.out.println(file.getName());
				String filename = file.getName();
				filelist.add("http://192.168.0.153:8080/upload/" + filename);
				fileNameList.add(filename);
			}
		}

	}
}