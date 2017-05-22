/**
 * 
 */
package com.ciii.police.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciii.police.config.OldPeopleConfig;
import com.ciii.police.config.StudentConfig;
import com.ciii.police.database.operator.PoliceMapOperator;
import com.ciii.police.thread.ThreadOldpeopleLogin;
import com.ciii.police.thread.ThreadStudentLogin;

/**
 * @author litong
 *
 */
@Controller
public class PoliceController {	
	/**
	 * 
	 */
	private static Log log = LogFactory.getLog(PoliceController.class);
	
	/**
	 * ��ҳ
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginUser(HttpSession session, HttpServletRequest request){
		log.info("loginUser");
		return "/index";
	}
	
	/**
	 * ��¼
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(String account, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		log.info("login");
		
		PoliceMapOperator polManager = new PoliceMapOperator();
		switch(polManager.verification(account, password)){
		case 1:
		case 2:
		case 3:
			return "../../index";
		default:
			if(false == StudentConfig.isHasStudentLogin()){
				//��ȡѧ������ص�¼��Ϣ
				ThreadStudentLogin threadStudentLogin = new ThreadStudentLogin("ThreadStudentLogin");
				threadStudentLogin.start();
			}
			if(false == OldPeopleConfig.isHasOldPeopleLogin()){
				//��ȡ���꿨��ص�¼��Ϣ
				ThreadOldpeopleLogin threadOldPeopleLogin = new ThreadOldpeopleLogin("ThreadOldPeopleLogin");
				threadOldPeopleLogin.start();
			}
			break;
		}
		
		session.setAttribute("account", account);
		session.setAttribute("password", password);
		
		return "/guidance";
	}
}
