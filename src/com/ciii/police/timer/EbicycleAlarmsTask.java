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
        	context.log("开始执行电动车报警信息"); 
        	/**
        	 * 自己的业务代码
        	 */
        	System.out.println("111111");
	        isRunning = false;  
	        context.log("电动车报警信息执行结束");
        } else {  
            context.log("上一次电动车报警信息执行还未结束");
        }
	}
}
