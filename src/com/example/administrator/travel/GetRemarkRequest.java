package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/19.
 * 安卓端在需要评论信息时 自动向服务器发送
 */

public class GetRemarkRequest implements Serializable
{
    public String picName;

    public GetRemarkRequest(String picName)
    {
        this.picName = picName;
    }
}
