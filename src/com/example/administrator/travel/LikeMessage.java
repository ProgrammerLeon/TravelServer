package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/18.
 * ���ޣ��������յ�������� �Զ�����username�û���picName���ޣ�
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
