package com.example.administrator.travel;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/18.
 * ȡ�����ޣ��������յ�������� �Զ�ȡ��username�û���picNameͼƬ�ĵ��ޣ�
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
