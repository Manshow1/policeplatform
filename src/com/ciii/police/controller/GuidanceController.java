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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
@Controller
public final class GuidanceController {
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("student");
		return "/student/student";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeople", method = RequestMethod.GET)
	public String getOldpeoplePage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeople");
		return "/oldpeople/oldpeople";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicycle", method = RequestMethod.GET)
	public String getEDbicyclePage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicycle");
		return "/EDbicycle/EDbicycle";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/police", method = RequestMethod.GET)
	public String getPolicePage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("police");
		return "/police";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/officialcar", method = RequestMethod.GET)
	public String getOfficialcarPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("officialcar");
		return "/officialcar";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/guidance", method = RequestMethod.GET)
	public String getGandencePage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("guidance");
		return "/guidance";
	}
}
