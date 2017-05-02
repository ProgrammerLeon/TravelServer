package com.example.administrator.travel;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 服务器主程序
 */
public class Server
{
	public static void main(String[] args)
	{
		Server server = new Server();
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(10000);
			System.out.println("--------服务器成功启动--------");
			while (true)
			{
				Socket client = serverSocket.accept();
				System.out.println("User Connected");
				//一个客户端连接就开启线程处理读写
				//认证
				//开启线程 进行通信
				//每个用户会拥有一个专门的线程进行通信
				new Thread(new ReadHandlerThread(client)).start();
//				new Thread(new WriteHandlerThread(client)).start();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (serverSocket != null)
				{
					serverSocket.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
