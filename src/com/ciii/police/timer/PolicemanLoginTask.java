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
        	context.log("开始执行警员登录"); 
        	/**
        	 * 自己的业务代码
        	 */
	        isRunning = false;  
	        context.log("警员登录执行结束");
        } else {  
            context.log("上一次警员登录执行还未结束");
        }
	}
}
