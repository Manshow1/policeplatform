package com.ciii.police.trans;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public final class TimeTransfer {
	/* 
     * ��ʱ��ת��Ϊʱ���
     */    
    public static long dateToStamp(String s) throws ParseException, java.text.ParseException{
        //String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        //res = String.valueOf(ts);
        return ts/1000;
    }
    
    /* 
     * ��ʱ��ת��Ϊʱ���1
     */    
    public static long dateToStamp1(String s) throws ParseException, java.text.ParseException{
    	String d = s.substring(0, 10);
    	String t = s.substring(11, 19);
    	String datetime = d+" "+t;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(datetime);
        long ts = date.getTime();
        return ts/1000;
    }
    
	/* 
     * ��ʱ���ת��Ϊʱ��
     */
    public static String stampToDate(long l){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        l = l*1000;
        Date date = new Date(l);
        res = simpleDateFormat.format(date);
        return res;
    }
}
