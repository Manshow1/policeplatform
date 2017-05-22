/**
 * 
 */
package com.ciii.police.timer;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author litong
 *
 */
public class OldpeopleLoginListener implements ServletContextListener{
	/**
	 * 
	 */
	public OldpeopleLoginListener() {
		
	}
	
	private java.util.Timer timer = null;  
	 
	/**
	 * ��ʼ����ʱ��
	 * web ��������ʱ���Զ�����  
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/** 
         * ����һ����ʱ�� 
         */  
        timer = new java.util.Timer(true);  
          
        arg0.getServletContext().log("��ʱ��������"); 
  
        /** 
         * ��ʱ����ָ����ʱ��ʱ,ִ��ĳ������(��ĳ����,�򷽷�) 
         */  
        //����ִ��ʱ��
        Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day =calendar.get(Calendar.DAY_OF_MONTH);//ÿ��
        //����ÿ���1:00:00ִ�У�
        calendar.set(year, month, day, 02, 00, 00);
        Date date = calendar.getTime();
        
        int period = 24 * 60 * 60 * 1000;
        //ÿ���dateʱ��ִ��task��ÿ��persion ʱ���ظ�ִ��
        timer.schedule(new OldpeopleLoginTask(arg0.getServletContext()), date, period);
        //�� ָ����dateʱ��ִ��task, ��ִ��һ��
        //timer.schedule(new DelFileTask(arg0.getServletContext()), date);
        arg0.getServletContext().log("�Ѿ�������˵�¼��������ȱ�");
	}

	/**
	 * ����
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		timer.cancel();
	    arg0.getServletContext().log("��ʱ������");
	}
}
