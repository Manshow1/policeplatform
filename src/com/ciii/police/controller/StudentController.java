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

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.database.operator.StudentAlarmMapOperator;
import com.ciii.police.database.operator.StudentIMEIMapOperator;
import com.ciii.police.manager.StudentManager;
import com.ciii.police.model.web.student.NumberInfo;
import com.ciii.police.trans.TimeTransfer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
@Controller
public class StudentController {
	/**
	 * 
	 */
	@RequestMapping(value = "/studenttop", method = RequestMethod.GET)
	public String getStudenttopPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("studenttop");
		return "/student/studenttop";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/studentbuttom1", method = RequestMethod.GET)
	public String getStudentbottom1Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("studentbuttom1");
		return "/student/studentbuttom1";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/studentbuttom2", method = RequestMethod.GET)
	public String getStudentbottom2Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("studentbuttom2");
		return "/student/studentbuttom2";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/studentbuttom3", method = RequestMethod.GET)
	public String getStudentbottom3Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("studentbuttom3");
		return "/student/studentbuttom3";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/studentbuttom4", method = RequestMethod.GET)
	public String getStudentbottom4Page(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException, java.text.ParseException{
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		System.out.println("studentbuttom4");
		return "/student/studentbuttom4";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/getBackFromStudent", method = RequestMethod.GET)
	public String getBackFromStudent(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		System.out.println("getBackFromStudent");
		if (session.getAttribute("password") == null) {
			return "../../index";
		}
		
		return "/guidance";
	}
	
	/**
	 * @throws ParseException 
	 * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getStudentAlermPosition", method = RequestMethod.GET)
	public void getStudentAlermPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException, ParseException, IOException{
		System.out.println("getStudentAlermPosition");
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
        int timestamp = (int) (date.getTime()/1000)-3600*24*14;
        //timestamp = 1490923800;
        StudentInfo.initAlarmPositionInfo();
		if(true == StudentAlarmMapOperator.getAlarmPositionInfo(timestamp)){
			if(true == StudentIMEIMapOperator.getInfoforAlarmPosition()){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = StudentInfo.getAlarmPositionInfoListToJsonArr();
				/*System.out.println(jsonArray.size());
				System.out.println(jsonArray.toString());
				for(int index = 0; index < jsonArray.size(); index++){
					System.out.println(jsonArray.get(index).toString());
				}*/
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
	@RequestMapping(value = "/getStudentNumber", method = RequestMethod.GET)
	public void getStudentNumber(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getStudentNumber");
		if (session.getAttribute("password") == null) {
			//
		}
		
		StudentAlarmMapOperator.GetAlarmNumber();
		
		NumberInfo numInfo = new NumberInfo();
		numInfo.setOnline(StudentInfo.getOnlineStudent());
		numInfo.setTotal(StudentInfo.getTotalStudent());
		numInfo.setUntreatedalarm(StudentInfo.getUntreatedAlarm());
		numInfo.setTotalalarm(StudentInfo.getTotalAlarm());
		try {
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = JSONObject.fromObject(numInfo);
			response.setContentType("textml;charset=UTF-8");
			System.out.println(jsonObject.toString());
			out.write(jsonObject.toString());
	        out.flush();  
	        out.close();
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("catch getStudentNumber");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws ParseException 
	 * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 
	 * 
	 */
	@RequestMapping(value = "/getStudentAlermMessage", method = RequestMethod.GET)
	public void getStudentAlermMessage(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException, ParseException{
		System.out.println("getStudentAlermMessage");
		if (session.getAttribute("password") == null) {
			//
		}
		
		String IEMI = request.getParameter("shebei");
		long startStamp = 0;
		if(false == request.getParameter("StartDate").equals("")){
			startStamp = TimeTransfer.dateToStamp(request.getParameter("StartDate"));
		}
		long endStamp = 0;
		if(false == request.getParameter("EndDate").equals("")){
			endStamp = TimeTransfer.dateToStamp(request.getParameter("EndDate"));
		}
		int state = Integer.valueOf(request.getParameter("listdown"));
		StudentInfo.initAlarmMessageInfo();
		if(true == StudentAlarmMapOperator.getAlarmMessageInfo(IEMI, startStamp, endStamp, state)){
			if(true == StudentIMEIMapOperator.getInfoforAlarmMessage()){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = StudentInfo.getAlarmMessageInfoListToJsonArr();
				response.setContentType( "textml;charset=UTF-8");
				out.write(jsonArray.toString());
		        out.flush();  
		        out.close();
			}
		}
	}
	
	/**
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 */
	@RequestMapping(value = "/getStudentPosition", method = RequestMethod.GET)
	public void getStudentPosition(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		System.out.println("getStudentPosition");
		if (session.getAttribute("password") == null) {
			//
		}
		String studentIEMI = request.getParameter("studentiemi");
		//String policeIEMIA = request.getParameter("placeAiemi");
		//String policeIEMIB = request.getParameter("placeBiemi");
		
		StudentManager sm = new StudentManager();
		try {
			if(true == sm.getLocationInfo(studentIEMI)){
				PrintWriter out = response.getWriter();
				JSONObject jsonObject = JSONObject.fromObject(StudentInfo.getOutputLocation());
				response.setContentType("textml;charset=UTF-8");
				System.out.println(jsonObject.toString());
				out.write(jsonObject.toString());
		        out.flush();  
		        out.close();
			}
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("catch");
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	@RequestMapping(value = "/getStudentTrack", method = RequestMethod.GET)
	public void getStudentTrack(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		System.out.println("getStudentTrack");
		if (session.getAttribute("password") == null) {
			//
		}
		
		String startTime = request.getParameter("startDate");
		String endTime = request.getParameter("endDate");
		String IEMI = request.getParameter("IEMI");
        
        StudentManager sm = new StudentManager();
        try {
			if(true == sm.getTrackInfo(startTime, endTime, IEMI)){
				PrintWriter out = response.getWriter();
				JSONArray jsonArray = StudentInfo.getTrackList();
				System.out.println(jsonArray.toString());
				response.setContentType( "textml;charset=UTF-8");
				out.write(jsonArray.toString());
		        out.flush();  
		        out.close();
			}
		} catch (com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws ParseException 
	 * @throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException 
	 * 
	 */
	@RequestMapping(value = "/postStudentAlermState", method = RequestMethod.POST)
	public void postStudentAlermState(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException, ParseException{
		String IMEI = request.getParameter("imei");
		int timestamp = (int) TimeTransfer.dateToStamp(request.getParameter("uploadtime"));
		int state = Integer.valueOf(request.getParameter("sel"));
		
		StudentAlarmMapOperator.updateAlarmState(IMEI, timestamp, state);
	}
}
