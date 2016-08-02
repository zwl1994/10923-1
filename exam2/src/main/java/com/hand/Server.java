package com.hand;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
  
public class Server   
{  
    private ServerSocket ss;  
    private Socket socket;  
    private BufferedReader in;  
    private BufferedOutputStream out;  
  
    public Server()   
    {  
        try   
        {  
            ss = new ServerSocket(13245);  
            System.out.println("等待客户端连接。。准备传输文件！");  
            
            FileInputStream fis = new FileInputStream(new File("target.pdf"));
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte b[] = new byte[1000];
            while(bis.read(b)!=0)   
            {  
            	socket = ss.accept();  
            	out = new BufferedOutputStream(socket.getOutputStream());  
                out.write(b);
               
                out.close();  
                socket.close();  
            }  
              
            ss.close();  
            bis.close();
            fis.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args)   
    {  
        new Server();  
    }  
}  