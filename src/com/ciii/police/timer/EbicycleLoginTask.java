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
public class EbicycleLoginTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public EbicycleLoginTask() {
		super();
	}
    
	/**
	 * 
	 */
	public EbicycleLoginTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�е綯����¼"); 
        	/**
        	 * �Լ���ҵ�����
        	 */
	        isRunning = false;  
	        context.log("�綯����¼ִ�н���");
        } else {  
            context.log("��һ�ε綯����¼ִ�л�δ����");
        }
	}
}
