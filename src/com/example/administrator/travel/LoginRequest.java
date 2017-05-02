package com.example.administrator.travel;

import java.io.Serializable;
/**
 * 登录请求 安卓端发往服务器 包含登录必须的信息
 * @author Administrator
 *
 */
public class LoginRequest implements Serializable
{
	private String Type = "Login Request";
    private String ID, PSW;
    public LoginRequest()
    {
    }
    public LoginRequest(String ID, String PSW)
    {
        this.ID = ID;
        this.PSW = PSW;
    }
    public String getType()
    {
        return Type;
    }
    public String getID()
    {
        return ID;
    }
    public String getPSW()
    {
        return PSW;
    }
}
