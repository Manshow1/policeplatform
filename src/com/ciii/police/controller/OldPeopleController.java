/**
 * 
 */
package com.ciii.police.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciii.police.buffer.OldPeopleInfo;
import com.ciii.police.database.operator.EldersMapOperator;
import com.ciii.police.database.operator.OldPeopleAlarmMapOperator;
import com.ciii.police.manager.OldPeopleManager;
import com.ciii.police.model.web.student.NumberInfo;
import com.ciii.police.trans.TimeTransfer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
@Controller
public class OldPeopleController {
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeopletop", method = RequestMethod.GET)
	public String getOldpeopletopPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeopletop");
		return "/oldpeople/oldpeopletop";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeoplebuttom1", method = RequestMethod.GET)
	public String getOldpeoplebuttom1Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeoplebuttom1");
		return "/oldpeople/oldpeoplebuttom1";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeoplebuttom2", method = RequestMethod.GET)
	public String getOldpeoplebuttom2Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeoplebuttom2");
		return "/oldpeople/oldpeoplebuttom2";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeoplebuttom3", method = RequestMethod.GET)
	public String getOldpeoplebuttom3Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeoplebuttom3");
		return "/oldpeople/oldpeoplebuttom3";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/oldpeoplebuttom4", method = RequestMethod.GET)
	public String getOldpeoplebuttom4Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("oldpeoplebuttom4");
		return "/oldpeople/oldpeoplebuttom4";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getBackFromOldpeople", method = RequestMethod.GET)
	public String getBackFromOldpeople(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		System.out.println("getBackFromOldpeople");
		return "/guidance";
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getOldPeopleAlermPosition", method = RequestMethod.GET)
	public void getOldPeopleAlermPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getOldPeopleAlermPosition");
		if (session.getAttribute("password") == null) {
			//
		}
		
		//设置时间限制
        Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day =calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, 00, 00, 00);
        Date date = calendar.getTime();
        int timestamp = (int) (date.getTime()/1000)-7200*24*14;
        //timestamp = 1490923800;
        OldPeopleInfo.initAlarmPositionInfo();
		if(true == OldPeopleAlarmMapOperator.getAlarmPositionInfo(timestamp)){
			if(true == EldersMapOperator.getInfoforAlarmPosition()){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = OldPeopleInfo.getAlarmPositionInfoListToJsonArr();
				System.out.println(jsonArray.toString());
				response.setContentType( "textml;charset=UTF-8");
				out.write(jsonArray.toString());
		        out.flush();
		        out.close();
			}
		}
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getOldPeopleNumber", method = RequestMethod.GET)
	public void getOldPeopleNumber(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getOldPeopleNumber");
		if (session.getAttribute("password") == null) {
			//
		}
		
		OldPeopleAlarmMapOperator.GetAlarmNumber();
		
		NumberInfo numInfo = new NumberInfo();
		numInfo.setOnline(OldPeopleInfo.getOnlineOldPeople());
		numInfo.setTotal(OldPeopleInfo.getTotalOldPeople());
		numInfo.setUntreatedalarm(OldPeopleInfo.getUntreatedAlarm());
		numInfo.setTotalalarm(OldPeopleInfo.getTotalAlarm());
		try {
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = JSONObject.fromObject(numInfo);
			response.setContentType("textml;charset=UTF-8");
			System.out.println(jsonObject.toString());
			out.write(jsonObject.toString());
	        out.flush();  
	        out.close();
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			System.out.println("catch getOldPeopleNumber");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 
	 * 
	 */
	@RequestMapping(value = "/getOldPeopleAlermMessage", method = RequestMethod.GET)
	public void getOldPeopleAlermMessage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException, ParseException{
		System.out.println("getOldPeopleAlermMessage");
		if (session.getAttribute("password") == null) {
			//
		}
		
		String oldpeoplephone = request.getParameter("oldpeoplephone");
		long startStamp = 0;
		if(false == request.getParameter("StartDate").equals("")){
			startStamp = TimeTransfer.dateToStamp(request.getParameter("StartDate"));
		}
		long endStamp = 0;
		if(false == request.getParameter("EndDate").equals("")){
			endStamp = TimeTransfer.dateToStamp(request.getParameter("EndDate"));
		}
		int state = Integer.valueOf(request.getParameter("listdown"));
		OldPeopleInfo.initAlarmMessageInfo();
		if(true == OldPeopleAlarmMapOperator.getAlarmMessageInfo(oldpeoplephone, startStamp, endStamp, state)){
			if(true == EldersMapOperator.getInfoforAlarmMessage()){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = OldPeopleInfo.getAlarmMessageInfoListToJsonArr();
				System.out.println(jsonArray.toString());
				response.setContentType( "textml;charset=UTF-8");
				out.write(jsonArray.toString());
		        out.flush();  
		        out.close();
			}
		}
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getOldPeoplePosition", method = RequestMethod.GET)
	public void getOldPeoplePosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getOldPeoplePosition");
		if (session.getAttribute("password") == null) {
			//
		}
		String oldpeoplephone = request.getParameter("oldpeoplephone");
		//String policeIEMIA = request.getParameter("placeAiemi");
		//String policeIEMIB = request.getParameter("placeBiemi");
		
		OldPeopleManager opm = new OldPeopleManager();
		try {
			if(true == opm.getLocationInfo(oldpeoplephone)){
				PrintWriter out = response.getWriter();
				JSONObject jsonObject = JSONObject.fromObject(OldPeopleInfo.getOutputLocation());
				response.setContentType("textml;charset=UTF-8");
				System.out.println(jsonObject.toString());
				out.write(jsonObject.toString());
		        out.flush();  
		        out.close();
			}
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			System.out.println("catch");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getOldPeopleTrack", method = RequestMethod.GET)
	public void getOldPeopleTrack(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getOldPeopleTrack");
		if (session.getAttribute("password") == null) {
			//
		}
		
		String startTime = request.getParameter("startDate");
		String endTime = request.getParameter("endDate");
		String oldpeoplephone = request.getParameter("oldpeoplephone");
        
        OldPeopleManager opm = new OldPeopleManager();
        try {
			if(true == opm.getTrackInfo(startTime, endTime, oldpeoplephone)){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = OldPeopleInfo.getTrackList();
				System.out.println(jsonArray.toString());
				response.setContentType( "textml;charset=UTF-8");
				out.write(jsonArray.toString());
		        out.flush();  
		        out.close();
			}
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
