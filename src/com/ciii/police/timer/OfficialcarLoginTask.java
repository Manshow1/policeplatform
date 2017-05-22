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
        	context.log("开始执行公车登录"); 
        	/**
        	 * 自己的业务代码
        	 */
	        isRunning = false;  
	        context.log("公车登录执行结束");
        } else {  
            context.log("上一次公车登录执行还未结束");
        }
	}
}
