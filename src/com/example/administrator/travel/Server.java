package com.example.administrator.travel;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * ������������
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
			System.out.println("--------�������ɹ�����--------");
			while (true)
			{
				Socket client = serverSocket.accept();
				System.out.println("User Connected");
				//һ���ͻ������ӾͿ����̴߳����д
				//��֤
				//�����߳� ����ͨ��
				//ÿ���û���ӵ��һ��ר�ŵ��߳̽���ͨ��
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
