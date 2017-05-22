/**
 * 
 */
package com.ciii.police.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author litong
 *
 */
@Controller
public class PolicemanController {	
	/**
	 * 
	 */
	@RequestMapping(value = "/getBackFromPolice", method = RequestMethod.GET)
	public String getBackFromPolice(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		System.out.println("getBackFromPolice");
		return "/guidance";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getPolicemanAlermPosition", method = RequestMethod.GET)
	public void getPolicemanAlermPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getPolicemanAlermPosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getPolicemanNumber", method = RequestMethod.GET)
	public void getPolicemanNumber(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getPolicemanNumber");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getPolicemanAlermMessage", method = RequestMethod.GET)
	public void getPolicemanAlermMessage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getPolicemanAlermMessage");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getPolicemanPosition", method = RequestMethod.GET)
	public void getPolicemanPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getPolicemanPosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getPolicemanTrack", method = RequestMethod.GET)
	public void getPolicemanTrack(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getPolicemanTrack");
		//
	}
}
