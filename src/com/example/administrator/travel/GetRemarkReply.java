package com.example.administrator.travel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/19.
 * ��ȡ������Ϣ�ظ� �����������յ�GetRemarkRequest�� ������������Ϣ���� ��ͨ��������з�װ �Ա㷢��
 */

public class GetRemarkReply implements Serializable
{
    public ArrayList<RemarkItem> remarkList;
    GetRemarkReply(ArrayList<RemarkItem> remarkList)
    {
        this.remarkList = remarkList;
    }

}
