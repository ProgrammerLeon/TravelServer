package com.example.administrator.travel;
/**
 * 用于服务器向客户端发送任何文字 可用于拓展
 * @author Administrator
 *
 */
public class TextMessage
{
	public String text;

	public TextMessage(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	
}
