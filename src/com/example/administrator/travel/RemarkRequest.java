package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/20.
 * 获取评论请求
 */

public class RemarkRequest implements Serializable
{
    public String picName;
    public String userName;
    public String text;

    public RemarkRequest(String picName, String userName, String text)
    {
        this.picName = picName;
        this.userName = userName;
        this.text = text;
    }
}
