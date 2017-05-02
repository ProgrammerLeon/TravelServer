package com.example.administrator.travel;

import java.io.Serializable;

/**
 * 评论信息
 * 一个对象对应一条评论 被GetRemarkRequest类封装 一般不单独使用
 * Created by Administrator on 2017/3/19.
 */

public class RemarkItem implements Serializable
{
    public String userName;
    public String text;
    public String image;

    public RemarkItem(String userName, String text, String image)
    {
        this.userName = userName;
        this.text = text;
        this.image = image;
    }
}
