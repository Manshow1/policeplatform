/**
 * 
 */
package com.ciii.police.timer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.database.operator.StudentAlarmMapOperator;
import com.ciii.police.database.operator.StudentMapOperator;
import com.ciii.police.manager.StudentManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public class StudentAlarmTask extends TimerTask{
	private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public StudentAlarmTask() {
		super();
	}
    
	/**
	 * 
	 */
	public StudentAlarmTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	isRunning =true;
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        	String endTime = simpleDateFormat.format(new Date());
        	context.log("��ʼִ��ѧ��������Ϣ"); 
        	try {
				ArrayList<String> alluserid = StudentMapOperator.getAllUserid();
				for(int index = 0; index < alluserid.size(); index++){
					StudentInfo.initOutputAlarmsInfoList();
		        	StudentManager sm = new StudentManager();
		        	//String startTime = "";
		        	//String endTime = "";
		        	//if(alluserid.get(index).equals("33165")){
		        		//System.out.println(alluserid.get(index));
		        	//}
		        	if(true == sm.getAlarmInfo(alluserid.get(index), /*startTime,*/ endTime)){
		        		//System.out.println(alluserid.get(index));
		        		StudentAlarmMapOperator.insertAlarmMap();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.text.ParseException e) {
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
