/**
 * 
 */
package com.ciii.police.http;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author litong
 *
 */
public final class HttpURLConn {
	/**
	 * 
	 */
	public static String getJsonByInternet(String path){
        try {
            URL url = new URL(path.trim());
            //������
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(200 == urlConnection.getResponseCode()){
                //�õ�������
                InputStream is =urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while(-1 != (len = is.read(buffer))){
                    baos.write(buffer,0,len);
                    baos.flush();
                }
                return baos.toString("utf-8");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
	
	/**
	 * 
	 */
	public static String postDownloadJson(String path,String post){
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// �ύģʽ
            // conn.setConnectTimeout(10000);//���ӳ�ʱ ��λ����
            // conn.setReadTimeout(2000);//��ȡ��ʱ ��λ����
            // ����POST�������������������
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // �����������
            printWriter.write(post);//post�Ĳ��� xx=xx&yy=yy
            // flush������Ļ���
            printWriter.flush();
            //��ʼ��ȡ����
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            return bos.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
