package com.example.administrator.travel;

import java.io.Serializable;
/**
 * ͼƬ��Ϣ
 * ����һ�������װһ��ͼƬ����Ϣ ��GetPicInfo����װ ��ֱ��ʹ��
 * @author Administrator
 *
 */
public class PicInfo implements Serializable
{
	int likeNum;
	boolean flag;

	public PicInfo(int likeNum, boolean flag)
	{
		this.flag = flag;
		this.likeNum = likeNum;
	}

	public int getLikeNum()
	{
		return likeNum;
	}

	public boolean getFlag()
	{
		return flag;
	}
}
