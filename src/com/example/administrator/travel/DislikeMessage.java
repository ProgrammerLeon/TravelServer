package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/18.
 * 取消点赞（服务器收到该请求后 自动取消username用户对picName图片的点赞）
 */

public class DislikeMessage implements Serializable
{
    public String username;
    public String picName;

    DislikeMessage(String picName, String username)
    {
        this.username = username;
        this.picName = picName;
    }
}
