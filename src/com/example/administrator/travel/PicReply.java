package com.example.administrator.travel;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * �㼣����ͼƬ�б�����Ϣ
 * @author Administrator
 *
 */
public class PicReply implements Serializable
{
	public PicReply(ArrayList<String> filelist)
	{
		this.filelist = filelist;
	}
	public ArrayList<String> filelist = new ArrayList<String>();
	
	public ArrayList<String> getFilelist()
	{
		return filelist;
	}
	
	public void setFilelist(ArrayList<String> filelist)
	{
		this.filelist = filelist;
	}
}
