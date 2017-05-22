/**
 * 
 */
package com.ciii.police.timer;

import java.util.TimerTask;

import javax.servlet.ServletContext;

/**
 * @author litong
 *
 */
public class OfficialcarLoginTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public OfficialcarLoginTask() {
		super();
	}
    
	/**
	 * 
	 */
	public OfficialcarLoginTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�й�����¼"); 
        	/**
        	 * �Լ���ҵ�����
        	 */
	        isRunning = false;  
	        context.log("������¼ִ�н���");
        } else {  
            context.log("��һ�ι�����¼ִ�л�δ����");
        }
	}
}
