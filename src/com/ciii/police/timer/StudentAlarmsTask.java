/**
 * 
 */
package com.ciii.police.timer;

import java.sql.SQLException;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.manager.StudentManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public class StudentAlarmsTask extends TimerTask{
	private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public StudentAlarmsTask() {
		super();
	}
    
	/**
	 * 
	 */
	public StudentAlarmsTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	isRunning =true;
        	context.log("��ʼִ��ѧ��������Ϣ"); 
        	StudentInfo.initOutputAlarmsInfoList();
        	StudentManager sm = new StudentManager();
        	String startTime = "";
        	String endTime = "";
        	try {
				try {
					if(true == sm.getAlarmsInfo(startTime, endTime)){
						//��������Ϣд�����ݿ�
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParseException | java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        isRunning = false;  
	        context.log("ѧ��������Ϣִ�н���");
        } else {  
            context.log("��һ��ѧ��������Ϣִ�л�δ����");
        }
	}

}
