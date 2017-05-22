/**
 * 
 */
package com.ciii.police.timer;

import java.sql.SQLException;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.config.OldPeopleConfig;
import com.ciii.police.database.operator.CommunitiesMapOperator;
import com.ciii.police.database.operator.EldersMapOperator;
import com.ciii.police.database.operator.UsernameIdMapOperator;
import com.ciii.police.manager.OldPeopleManager;

/**
 * @author litong
 *
 */
public class OldpeopleLoginTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public OldpeopleLoginTask() {
		super();
	}
    
	/**
	 * 
	 */
	public OldpeopleLoginTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�����˵�¼"); 
        	isRunning = true;
        	OldPeopleConfig.setHasOldPeopleLogin(true);
        	
        	OldPeopleInfo.initOutputNanGongCommunitiesAll();
        	OldPeopleInfo.initOutputNanGongUsernameID();
        	OldPeopleInfo.initOutputNanGongUserLogin();
        	OldPeopleInfo.initOutputNanGongCommunityIdElders();
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
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
	        isRunning = false;  
	        context.log("���˵�¼ִ�н���");
        } else {  
            context.log("��һ�����˵�¼ִ�л�δ����");
        }
	}
}
