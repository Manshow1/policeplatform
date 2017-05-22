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
public class EbicycleController {
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicycletop", method = RequestMethod.GET)
	public String getEDbicycletopPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicycletop");
		return "/EDbicycle/EDbicycletop";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicyclebuttom1", method = RequestMethod.GET)
	public String getEDbicyclebuttom1Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicyclebuttom1");
		return "/EDbicycle/EDbicyclebuttom1";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicyclebuttom2", method = RequestMethod.GET)
	public String getEDbicyclebuttom2Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicyclebuttom2");
		return "/EDbicycle/EDbicyclebuttom2";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicyclebuttom3", method = RequestMethod.GET)
	public String getEDbicyclebuttom3Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicyclebuttom3");
		return "/EDbicycle/EDbicyclebuttom3";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/EDbicyclebuttom4", method = RequestMethod.GET)
	public String getEDbicyclebuttom4Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("EDbicyclebuttom4");
		return "/EDbicycle/EDbicyclebuttom4";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getBackFromEDbicycle", method = RequestMethod.GET)
	public String getBackFromEDbicycle(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		System.out.println("getBackFromEDbicycle");
		return "/guidance";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getEbicycleAlermPosition", method = RequestMethod.GET)
	public void getEbicycleAlermPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getEbicycleAlermPosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getEbicycleNumber", method = RequestMethod.GET)
	public void getEbicycleNumber(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getEbicycleNumber");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getEbicycleAlermMessage", method = RequestMethod.GET)
	public void getEbicycleAlermMessage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getEbicycleAlermMessage");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getEbicyclePosition", method = RequestMethod.GET)
	public void getEbicyclePosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getEbicyclePosition");
		//
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getEbicycleTrack", method = RequestMethod.GET)
	public void getEbicycleTrack(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			//
		}
		
		System.out.println("getEbicycleTrack");
		//
	}
}
