package com.example.administrator.travel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/19.
 * 获取评论信息回复 当服务器接收到GetRemarkRequest后 会生成评论信息报告 并通过该类进行封装 以便发送
 */

public class GetRemarkReply implements Serializable
{
    public ArrayList<RemarkItem> remarkList;
    GetRemarkReply(ArrayList<RemarkItem> remarkList)
    {
        this.remarkList = remarkList;
    }

}
