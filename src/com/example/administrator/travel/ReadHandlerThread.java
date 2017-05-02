package com.example.administrator.travel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * 
 * @author Administrator
 *
 */
public class ReadHandlerThread implements Runnable
{

	private static Socket socket;

	public ReadHandlerThread(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		JdbcUtils jdbcUtils = new JdbcUtils();//Jdbc������
		Connection connection = null;
		FileTest fileTest = new FileTest();//�����ļ���ѯ��
		try
		{
			connection = jdbcUtils.getConnection();//����SQL����
		}
		catch (SQLException e1)
		{
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		DataInputStream dis = null;//�ͻ��˷������Ķ��������������
		DataOutputStream dos = null;//�����������ͻ��˷�����Ϣ
		try
		{
			while (true)//��ʼ����
			{
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				String s = dis.readUTF();//�ӿͻ����յ���Ϣ������������
				//				dos.writeUTF("����������˵�ĺܶԣ�");
				XStream xStream = new XStream(new DomDriver());//XStream���� ����XML��װ �˽⼴��
//				http://blog.csdn.net/scyatcs/article/details/12625099

				Object object = xStream.fromXML(s);//����׿�˷��͹����������ؽ�Ϊ����
				if (object instanceof LoginRequest)
				{
					LoginRequest loginRequest = (LoginRequest) object;
					System.out.println(loginRequest.getID() + "�����¼");
					System.out.println("���룺" + loginRequest.getPSW());
					//�˻���֤

					try
					{
						PreparedStatement preparedStatement = connection.prepareStatement("exec login ?,?");
						preparedStatement.setString(1, loginRequest.getID());
						preparedStatement.setString(2, loginRequest.getPSW());
						preparedStatement.execute();
						//������֤��Ϣ
						String s1 = xStream.toXML(new LoginReply(true));//����¼�ɹ�����Ϣ�������ΪXML
						dos.writeUTF(s1);//��������
					}
					catch (SQLException e)
					{
						String s1 = xStream.toXML(new LoginReply(false));
						dos.writeUTF(s1);
					}

				}
				else if (object instanceof RegisterRequest)
				{
					RegisterRequest registerRequest = (RegisterRequest) object;
					System.out.println(registerRequest.getUserame() + "����ע��");
					System.out.println("����:" + registerRequest.getPSW());

					try
					{
						PreparedStatement preparedStatement = connection.prepareStatement("exec register ?,?");
						preparedStatement.setString(1, registerRequest.getUserame());
						preparedStatement.setString(2, registerRequest.getPSW());
						preparedStatement.execute();
						//������֤��Ϣ
						String s1 = xStream.toXML(new RegisterReply(true));
						dos.writeUTF(s1);
					}
					catch (SQLException e)
					{
						String s1 = xStream.toXML(new RegisterReply(false));
						dos.writeUTF(s1);
						e.printStackTrace();
					}
				}
				else if (object instanceof PicRequest)//��Ƭ��ȡ����
				{
					System.out.println("Pic!!!");

					//					System.out.println(fileTest.getFilelist());
					String s2 = xStream.toXML(new PicReply(fileTest.getFilelist()));
					dos.writeUTF(s2);
				}
				else if (object instanceof TextMessage)
				{
					TextMessage textMessage = (TextMessage) object;
					System.out.println(textMessage.text);
				}
				else if (object instanceof GetLikeInfoRequest)
				{
					System.out.println("���յ�������ȡ����");
					HashMap<String, PicInfo> hashMap = new HashMap();
					GetLikeInfoRequest getLikeInfoRequest = (GetLikeInfoRequest) object;
					System.out.println(getLikeInfoRequest.getUser() + "������ȡ������Ϣ");
					ArrayList<String> fileNameList = fileTest.getFileNameList();
					Iterator<String> iterator = fileNameList.iterator();
					synchronized (iterator)
					{
						while (iterator.hasNext())
						{
							String picName = iterator.next();
							int likeNum;
							boolean flag;
							PreparedStatement pStatement = connection
									.prepareStatement("select count(*) from LikeList where picName = ?");
							pStatement.setString(1, picName);
							ResultSet rs = pStatement.executeQuery();
							rs.next();
							likeNum = rs.getInt(1);

							PreparedStatement pStatement2 = connection.prepareStatement(
									"select count(*) from LikeList where picName = ? and userName = ?");
							pStatement2.setString(1, picName);
							pStatement2.setString(2, getLikeInfoRequest.getUser());
							ResultSet rSet = pStatement2.executeQuery();
							rSet.next();
							if (rSet.getInt(1) == 0)
							{
								flag = false;
							}
							else
							{
								flag = true;
							}
							hashMap.put(picName, new PicInfo(likeNum, flag));
						}
					}
					GetLikeInfoReply getLikeInfoReply = new GetLikeInfoReply(hashMap);
					String s1 = xStream.toXML(getLikeInfoReply);
					dos.writeUTF(s1);
					System.out.println("���͵��޻ظ��ɹ�");
				}
				else if (object instanceof LikeMessage)
				{
					LikeMessage likeMessage = (LikeMessage) object;
					String picName = likeMessage.picName;
					String username = likeMessage.username;
					System.out.println("���� " + picName + ":" + username);
					PreparedStatement preparedStatement = connection.prepareStatement("exec likes ?,?");
					preparedStatement.setString(1, picName);
					preparedStatement.setString(2, username);
					preparedStatement.execute();
				}
				else if (object instanceof DislikeMessage)
				{
					DislikeMessage dislikeMessage = (DislikeMessage) object;
					String picName = dislikeMessage.picName;
					String username = dislikeMessage.username;
					System.out.println("ȡ���� " + picName + ":" + username);
					PreparedStatement preparedStatement = connection.prepareStatement("exec dislikes ?,?");
					preparedStatement.setString(1, picName);
					preparedStatement.setString(2, username);
					preparedStatement.execute();
				}
				else if (object instanceof GetRemarkRequest)
				{
					System.out.println("���յ�������ȡ����");
					ArrayList<RemarkItem> arrayList = new ArrayList();
					GetRemarkRequest getRemarkRequest = (GetRemarkRequest) object;
					String picName = getRemarkRequest.picName;
					PreparedStatement pStatement = connection
							.prepareStatement("select * from remarkList where picName = ? order by time desc");
					pStatement.setString(1, picName);
					ResultSet rSet = pStatement.executeQuery();
					while (rSet.next())
					{
						String userName = rSet.getString(3);
						System.out.println("username="+userName);
						String remark = rSet.getString(4);
						arrayList.add(new RemarkItem(userName, remark, ""));
					}
					GetRemarkReply getRemarkReply = new GetRemarkReply(arrayList);
					String string = xStream.toXML(getRemarkReply);
					dos.writeUTF(string);
					System.out.println(string);
				}
				else if(object instanceof RemarkRequest)
				{
					RemarkRequest remarkRequest = (RemarkRequest)object;
					PreparedStatement pStatement = connection.prepareStatement("exec remark ?,?,?");
					pStatement.setString(1, remarkRequest.picName);
					pStatement.setString(2, remarkRequest.userName);
					pStatement.setString(3, remarkRequest.text);
					pStatement.execute();
				}
				else if(object instanceof DeleteRemarkRequest)
				{
					DeleteRemarkRequest deleteRemarkRequest = (DeleteRemarkRequest)object;
					PreparedStatement preparedStatement = connection.prepareStatement("exec deleteRemark ?,?");
					preparedStatement.setString(1, deleteRemarkRequest.picName);
					preparedStatement.setString(2, deleteRemarkRequest.userName);
					preparedStatement.execute();
				}
			}
		}
		catch (Exception e)
		{
			//			JOptionPane.showMessageDialog(null, "�ͻ���������");
						e.printStackTrace();

		}

	}

}
