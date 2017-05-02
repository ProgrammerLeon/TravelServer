package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/18.
 * 安卓端在需要点赞信息时 自动向服务器发送信息
 */

public class GetLikeInfoRequest implements Serializable
{
	private String username;

	GetLikeInfoRequest(String username)
	{
		this.username = username;
	}

	public String getUser()
	{
		return username;
	}

}
