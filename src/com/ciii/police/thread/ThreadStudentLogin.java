package com.ciii.police.thread;

import java.sql.SQLException;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.config.StudentConfig;
import com.ciii.police.database.operator.SchoolMapOperator;
import com.ciii.police.database.operator.StudentIMEIMapOperator;
import com.ciii.police.database.operator.StudentMapOperator;
import com.ciii.police.manager.StudentManager;

public final class ThreadStudentLogin implements Runnable {
	private Thread t;
	
	private String threadName;
	   
	/**
	 * 
	 */
	public ThreadStudentLogin( String name) {
		threadName = name;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		StudentInfo.initStudentInfo();
    	StudentManager sm = new StudentManager();
    	if(true == sm.getSchools()){
    		if(true == sm.getStudents()){
    			if(true == sm.getStudentInfo()){
    				try {
						SchoolMapOperator.insertSchoolMap();
						StudentMapOperator.insertStudentMap();
						StudentIMEIMapOperator.insertIEMIMap();
						StudentConfig.setHasStudentLogin(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
        	}
    	}
	}

	/**
	 * 
	 */
	public void start () {
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	}
}
