package com.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

public class testForHTTP {
	
	public static void main(String[] args){  
        String s=httpRequest("http://www.qq.com","GET",null);  
        System.out.println(s);  
    }
	
	//处理http请求  requestUrl为请求地址  requestMethod请求方式，值为"GET"或"POST"  
    public static String httpRequest(String requestUrl,String requestMethod,String outputStr){  
        StringBuffer buffer=null;  
        try{  
        URL url=new URL(requestUrl);  
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
        conn.setDoOutput(true);  
        conn.setDoInput(true);  
        conn.setRequestMethod(requestMethod);  
        conn.connect();  
        //往服务器端写内容 也就是发起http请求需要带的参数  
        if(null!=outputStr){  
            OutputStream os=(OutputStream) conn.getOutputStream();  
            os.write(outputStr.getBytes("utf-8"));  
            os.close();  
        }  
          
        //读取服务器端返回的内容  
        InputStream is=(InputStream) conn.getInputStream();  
        InputStreamReader isr=new InputStreamReader(is,"utf-8");  
        BufferedReader br=new BufferedReader(isr);  
        buffer=new StringBuffer();  
        String line=null;  
        while((line=br.readLine())!=null){  
            buffer.append(line);  
        }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        return buffer.toString();  
    }  

}
