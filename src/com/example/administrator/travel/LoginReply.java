package com.example.administrator.travel;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *登录回复 返回登录成功或者失败的信息
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
