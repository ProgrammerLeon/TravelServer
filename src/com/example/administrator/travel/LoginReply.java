package com.example.administrator.travel;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *��¼�ظ� ���ص�¼�ɹ�����ʧ�ܵ���Ϣ
 */
public class LoginReply implements Serializable
{
	boolean successful;
    public LoginReply(boolean b)
    {
        successful = b;
    }
    public boolean isSuccessful()
    {
        return successful;
    }
}
