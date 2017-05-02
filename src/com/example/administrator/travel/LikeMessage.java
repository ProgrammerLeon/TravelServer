package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/18.
 * 点赞（服务器收到该请求后 自动创建username用户对picName点赞）
 */

public class
LikeMessage implements Serializable
{
    public String username;
    public String picName;

    LikeMessage(String picName, String username)
    {
        this.username = username;
        this.picName = picName;
    }
}
