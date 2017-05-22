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

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.database.operator.EldersMapOperator;
import com.ciii.police.database.operator.OldPeopleAlarmMapOperator;
import com.ciii.police.manager.OldPeopleManager;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public class OldpeopleAlarmTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public OldpeopleAlarmTask() {
		super();
	}
    
	/**
	 * 
	 */
	public OldpeopleAlarmTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	isRunning =true;
        	context.log("��ʼִ�����˱�����Ϣ"); 
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        	String endTime = simpleDateFormat.format(new Date());
        	try {
				ArrayList<String> alluserid = EldersMapOperator.getAllUserid();
				for(int index = 0; index < alluserid.size(); index++){
					OldPeopleInfo.initOutputAlarmsInfoList();
					OldPeopleManager opm = new OldPeopleManager();
		        	//String startTime = "";
		        	//String endTime = "";
		        	if(true == opm.getAlarmInfo(alluserid.get(index), /*startTime,*/ endTime)){
		        		//System.out.println(alluserid.get(index));
		        		OldPeopleAlarmMapOperator.insertAlarmMap();
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
	        context.log("���˱�����Ϣִ�н���");
        } else {  
            context.log("��һ�����˱�����Ϣִ�л�δ����");
        }
	}
}
