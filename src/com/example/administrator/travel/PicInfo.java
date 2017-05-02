package com.example.administrator.travel;

import java.io.Serializable;
/**
 * 图片信息
 * 该类一个对象封装一个图片的信息 被GetPicInfo所包装 不直接使用
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
