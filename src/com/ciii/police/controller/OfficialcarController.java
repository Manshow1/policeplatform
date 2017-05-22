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
public class OfficialcarController {
	/**
	 * 
	 */
	@RequestMapping(value = "/getBackFromOfficialcar", method = RequestMethod.GET)
	public String getBackFromOfficialcar(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		System.out.println("getBackFromOfficialcar");
		return "/guidance";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getOfficialcarAlermPosition", method = RequestMethod.GET)
	public void getOfficialcarAlermPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getOfficialcarAlermPosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getOfficialcarNumber", method = RequestMethod.GET)
	public void getOfficialcarNumber(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getOfficialcarNumber");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getOfficialcarAlermMessage", method = RequestMethod.GET)
	public void getOfficialcarAlermMessage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getOfficialcarAlermMessage");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getOfficialcarPosition", method = RequestMethod.GET)
	public void getOfficialcarPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getOfficialcarPosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getOfficialcarTrack", method = RequestMethod.GET)
	public void getOfficialcarTrack(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getOfficialcarTrack");
		//
	}
}
