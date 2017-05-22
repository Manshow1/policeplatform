package com.ciii.police.thread;

import java.sql.SQLException;

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.config.OldPeopleConfig;
import com.ciii.police.database.operator.CommunitiesMapOperator;
import com.ciii.police.database.operator.EldersMapOperator;
import com.ciii.police.database.operator.UsernameIdMapOperator;
import com.ciii.police.manager.OldPeopleManager;

public final class ThreadOldpeopleLogin implements Runnable {
	private Thread t;
	
	private String threadName;
	   
	/**
	 * 
	 */
	public ThreadOldpeopleLogin( String name) {
		threadName = name;
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		OldPeopleInfo.initOldPeopleInfo();
		OldPeopleManager opm = new OldPeopleManager();
    	if(true == opm.getAllCommunities()){
    		try {
				CommunitiesMapOperator.insertCommunitiesMap();
				if(true == opm.getUserName()){
					UsernameIdMapOperator.insertUsernameIdMap();
					if(true == opm.getUserLogin()){
						UsernameIdMapOperator.updateUsernameIdMap();
						if(true == opm.getCommunityIdElders()){
							EldersMapOperator.insertCommunitiesMap();
							OldPeopleConfig.setHasOldPeopleLogin(true);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
