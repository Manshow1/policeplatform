package com.ciii.police.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;;

public class HttpUtil {  
	private static final Log log = LogFactory.getLog(HttpUtil.class);  
	
    /** 
     * ʹ��Get��ʽ��ȡ���� 
     *  
     * @param url 
     * @param charset
     * @return 
     */
    public static String sendGet(String url, String charset) {  
        String result = "";
        BufferedReader in = null;  
        try {  
            URL realUrl = new URL(url);  
            // �򿪺�URL֮�������  
            URLConnection connection = realUrl.openConnection();  
            // ����ͨ�õ���������  
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");  
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // ����ʵ�ʵ�����  
            connection.connect();  
            // ���� BufferedReader����������ȡURL����Ӧ  
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } 
        catch (Exception e) {  
            log.error("����GET��������쳣��" + e.getMessage());  
            e.printStackTrace();  
        }
        // ʹ��finally�����ر�������  
        finally {  
            try {  
                if (in != null) {  
                    in.close();
                }  
            } 
            catch (Exception e2) { 
            	log.error(e2.getMessage());
                e2.printStackTrace();  
            }  
        }  
        return result;
    }  
  
    /**  
     * POST�����ַ�����ʽ����  
     * @param url �����ַ  
     * @param param ��������  
     */  
    public static String sendPostUrl(String url, String param) {  
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try {  
            URL realUrl = new URL(url);  
            // �򿪺�URL֮�������  
            URLConnection conn = realUrl.openConnection();  
            // ����ͨ�õ���������  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            conn.setRequestProperty("contentType", "application/json");
            // ����POST�������������������  
            conn.setDoOutput(true);  
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������  
            out = new PrintWriter(conn.getOutputStream());  
            // �����������             
            out.print(param);  
            //out.write(param);
            // flush������Ļ���  
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ  
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } 
        catch (Exception e) {  
            log.error("���� POST ��������쳣��" + e.getMessage());  
            e.printStackTrace();  
        }  
        // ʹ��finally�����ر��������������  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } 
            catch (IOException ex) {  
            	log.error(ex.getMessage());
                ex.printStackTrace();  
            }  
        } 
        return result;  
    }
    
    /**  
     * POST�����ַ�����ʽ����  
     * @param address �����ַ  
     * @param param ��������  
     */  
    public static String sendPostUrl1(String address, String param) {
    	String ret = null;
    	try {

            JSONObject  obj = JSONObject.fromObject(param);

            // ����url��Դ
            URL url = new URL(address);
            // ����http����
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // �����������
            conn.setDoOutput(true);

            conn.setDoInput(true);

            // ���ò��û���
            conn.setUseCaches(false);
            // ���ô��ݷ�ʽ
            conn.setRequestMethod("POST");
            // ����ά�ֳ�����
            conn.setRequestProperty("Connection", "Keep-Alive");
            // �����ļ��ַ���:
            conn.setRequestProperty("Charset", "UTF-8");
            //ת��Ϊ�ֽ�����
            byte[] data = (obj.toString()).getBytes();
            // �����ļ�����
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            // �����ļ�����:
            conn.setRequestProperty("contentType", "application/json");


            // ��ʼ��������
            conn.connect();
            OutputStream  out = conn.getOutputStream();     
            // д��������ַ���
            out.write((obj.toString()).getBytes());
            out.flush();
            out.close();

            // ���󷵻ص�״̬
            if (conn.getResponseCode() == 200) {
                System.out.println("���ӳɹ�");
                // ���󷵻ص�����
                InputStream in = conn.getInputStream();
                try {
                    byte[] data1 = new byte[in.available()];
                    in.read(data1);
                    // ת���ַ���
                    ret = new String(data1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("no++");
            }

        } catch (Exception e) {

        }
    	return ret;
    }
}
    
	
