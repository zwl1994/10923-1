package com.hand;
import java.io.*;  
import java.net.*;  
 
public class Client   
{  
    Socket socket;  
    BufferedInputStream in;  
    PrintWriter out;  
  
    public Client()   
    {  
        try   
        {  
            socket = new Socket("127.0.0.1", 13245); 
            System.out.println("文件传输完毕!");
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File("targer1.pdf"));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte b[] = new byte[1000];
            is.read(b);
            	bos.write(b);
            

            bos.close();  
            fos.close();  
            is.close();
            
              
            socket.close();  
              
        } catch (IOException e) {  
        }  
    }  
  
    public static void main(String[] args)   
    {  
        new Client();  
    }  
}  