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
public class EbicycleAlarmsTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public EbicycleAlarmsTask() {
		super();
	}
    
	/**
	 * 
	 */
	public EbicycleAlarmsTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�е綯��������Ϣ"); 
        	/**
        	 * �Լ���ҵ�����
        	 */
        	System.out.println("111111");
	        isRunning = false;  
	        context.log("�綯��������Ϣִ�н���");
        } else {  
            context.log("��һ�ε綯��������Ϣִ�л�δ����");
        }
	}
}
