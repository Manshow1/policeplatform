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
public class PolicemanLoginTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public PolicemanLoginTask() {
		super();
	}
    
	/**
	 * 
	 */
	public PolicemanLoginTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�о�Ա��¼"); 
        	/**
        	 * �Լ���ҵ�����
        	 */
	        isRunning = false;  
	        context.log("��Ա��¼ִ�н���");
        } else {  
            context.log("��һ�ξ�Ա��¼ִ�л�δ����");
        }
	}
}
