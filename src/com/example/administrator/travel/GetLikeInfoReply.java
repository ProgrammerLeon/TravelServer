package com.example.administrator.travel;

import java.io.Serializable;
import java.util.HashMap;
/**
 * 
 * @author Administrator
 *????????????? ?????????????GetLikeInfoRequest?? ???????????????? ????????????1?7?1?7?? ?????
 */
public class GetLikeInfoReply implements Serializable
{
	public HashMap<String, PicInfo> hashMap;//?????

	public GetLikeInfoReply(HashMap<String, PicInfo> hashMap)
	{
		this.hashMap = hashMap;
	}
}