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
public class OfficialcarAlarmsTask extends TimerTask{
    private static boolean isRunning = false;  
  
    private ServletContext context = null;  
  
    /**
	 * 
	 */
	public OfficialcarAlarmsTask() {
		super();
	}
    
	/**
	 * 
	 */
	public OfficialcarAlarmsTask(ServletContext context) {  
        this.context = context;  
    }  
	
	/**
	 * 
	 */
	@Override
	public void run() {
        if (!isRunning) {
        	context.log("��ʼִ�й���������Ϣ"); 
        	/**
        	 * �Լ���ҵ�����
        	 */
        	System.out.println("111111");
	        isRunning = false;  
	        context.log("����������Ϣִ�н���");
        } else {  
            context.log("��һ�ι���������Ϣִ�л�δ����");
        }
	}
}
