package com.ccxia.firstmod.serial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialTool {
	    //ɨ���ȡ���õĴ���
		public static final ArrayList<String> uartPortUseAblefind()
		{
			//��ȡ��ǰ���еĿ��ô���
			Enumeration<CommPortIdentifier> portList=CommPortIdentifier.getPortIdentifiers();
			ArrayList<String> portNameList=new ArrayList();
			//��Ӳ�����ArrayList
			while(portList.hasMoreElements())
			{
				String portName=portList.nextElement().getName();
				portNameList.add(portName);
			}
			return portNameList;
		}
		
		//�򿪴���
		public static final SerialPort openPort(String portName,int baudrate)
		{
			SerialPort serialPort=null;
			try
			{
				//ͨ��������ʶ�𴮿�
				CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
				//�򿪶˿ڲ����ö˿����� serialPort�ͳ�ʱʱ�� 2000ms
		        CommPort commPort=portIdentifier.open(portName,2000);
		        //�ж϶˿��Ƿ�Ϊ����
		        if(commPort instanceof SerialPort)
		        {
		        	System.out.println("��COM�˿��Ǵ��ڣ�");
		        	serialPort=(SerialPort)commPort;
		        	//���ô��ڣ������ʣ�8λ����λ��1λֹͣλ������żУ��
		        	serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8,SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		        	System.out.println("���ڲ�����������ɣ�������Ϊ"+baudrate+",����λ8bits,ֹͣλ1λ,����żУ��");
		        }
		        else
		        {
		        	System.out.println("��com�˿ڲ��Ǵ���,�����豸!");
		        }
			}
			catch (NoSuchPortException e) 
	        {
	            e.printStackTrace();
	        } 
	        catch (PortInUseException e) 
	        {
	            e.printStackTrace();
	        } 
	        catch (UnsupportedCommOperationException e)
	        {
	            e.printStackTrace();
	        }
			return serialPort;
		}
		
		//�رմ���
		public static void closePort(SerialPort serialPort)
		{
			if(serialPort!=null)
			{
				serialPort.close();
				serialPort=null;
			}
		}
		
		//��λ�������ڷ�������,��������Ϊ��ѹ�趨ֵ��Ӧ�ĵ�ѹֵ��0~255��
		public static void sendToPort(SerialPort serialPort,int settings)
		{
			OutputStream out=null;
			try
			{
				out=serialPort.getOutputStream();
				out.write(settings);
				out.flush();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(out!=null)
				{
					try
					{
						out.close();
						out=null;
						System.out.println("�����ѷ������!");
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		//��λ���Ӵ��ڽ�������
		public static int readFromPort(SerialPort serialPort)
		{
			int receiveData=0;
			try {
				InputStream in=serialPort.getInputStream();
				int bufferLength=in.available();
			    receiveData=in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return receiveData;
		}

}
