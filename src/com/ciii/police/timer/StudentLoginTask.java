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
        	context.log("开始执行学生登录"); 
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
	        
	        context.log("学生登录执行结束");
        } else {  
            context.log("上一次学生登录执行还未结束");
        }
	}

}
