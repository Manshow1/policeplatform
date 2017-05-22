/**
 * 
 */
package com.ciii.police.timer;

import java.sql.SQLException;
import java.util.TimerTask;
import javax.servlet.ServletContext;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.config.StudentConfig;
import com.ciii.police.database.operator.SchoolMapOperator;
import com.ciii.police.database.operator.StudentIMEIMapOperator;
import com.ciii.police.database.operator.StudentMapOperator;
import com.ciii.police.manager.StudentManager;

/**
 * @author litong
 *
 */
public class StudentLoginTask extends TimerTask{
	private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public StudentLoginTask() {
		super();
	}
    
	/**
	 * 
	 */
	public StudentLoginTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ��ѧ����¼"); 
        	isRunning = true;
        	StudentConfig.setHasStudentLogin(true);
        	
        	StudentInfo.initOutputNanGongSchoolsInfo();
        	StudentInfo.initOutputNanGongStudentsInfo();
        	StudentInfo.initOutputNanGongStudentListInfo();
        	StudentManager sm = new StudentManager();
        	if(true == sm.getSchools()){
        		if(true == sm.getStudents()){
        			if(true == sm.getStudentInfo()){
        				try {
							SchoolMapOperator.insertSchoolMap();
							StudentMapOperator.insertStudentMap();
							StudentIMEIMapOperator.insertIEMIMap();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                	}
            	}
        	}
	        isRunning = false;  
	        
	        context.log("ѧ����¼ִ�н���");
        } else {  
            context.log("��һ��ѧ����¼ִ�л�δ����");
        }
	}

}
