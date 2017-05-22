/**
 * 
 */
package com.ciii.police.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ciii.police.buffer.StudentInfo;
import com.ciii.police.database.operator.StudentIMEIMapOperator;
import com.ciii.police.database.operator.StudentMapOperator;
import com.ciii.police.http.HttpUtil;
import com.ciii.police.model.request.student.*;
import com.ciii.police.model.response.student.*;
import com.ciii.police.trans.JsonToStudentOutput;
import com.ciii.police.trans.TimeTransfer;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @author litong
 *
 */
public final class StudentManager {
	private static final String StudentURL1 = "http://dw.paznxy.cn:50404";
	private static final String StudentURL2 = "http://school.znxy.net.cn/api";
	private static final String param = "UTF-8";
	//private static final Integer sendTimes = 3;
	
	/**
	 * 
	 */
	public boolean getSchools(){
		String subURL = "/nangong/schools";
		
		String url = StudentURL2+subURL;
		
		String retSchoolsInfo = HttpUtil.sendGet(url, param);
		
		OutputNanGongSchools outputNanGongSchools = JsonToStudentOutput.JsonToOutputNanGongSchools(retSchoolsInfo);
		
		StudentInfo.setOutputNanGongSchoolsInfo(outputNanGongSchools);
		
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getStudents(){
		String subURL = "/nangong/students";
		
		OutputNanGongStudents outputNanGongStudents = new OutputNanGongStudents();
		
		ArrayList<NanGongSchoolData> nanGongSchoolDatalist = StudentInfo.getOutputNanGongSchoolsInfo().getData();
		String retStudentsInfo = "";
		for(int number = 0; number < nanGongSchoolDatalist.size(); number++){
			InputNanGongStudents in = new InputNanGongStudents();
			outputNanGongStudents.setCurrent_page(0);
			do{
				in.setSchool(nanGongSchoolDatalist.get(number).getId());
				in.setPage(outputNanGongStudents.getCurrent_page()+1);
				String url = StudentURL2+subURL+in.toString();
				retStudentsInfo = HttpUtil.sendGet(url, param);
			}while(JsonToStudentOutput.JsonToOutputNanGongStudents(retStudentsInfo, outputNanGongStudents));
		}
		
		StudentInfo.setOutputNanGongStudentsInfo(outputNanGongStudents);
		
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getStudentInfo(){
		String subURL = "/nangong/students/";
		ArrayList<NanGongStudentData> data = StudentInfo.getOutputNanGongStudentsInfo().getData();
		for(int index = 0; index < data.size(); index++){
			InputNanGongStudent in = new InputNanGongStudent();
			in.setId(data.get(index).getId());
			String url = StudentURL2+subURL+in.getId();
			String retStudentInfo = HttpUtil.sendGet(url, param);
			OutputNanGongStudent out = new OutputNanGongStudent();
			if(true == JsonToStudentOutput.JsonToOutputNanGongStudent(retStudentInfo, out)){
				StudentInfo.addOutputNanGongStudentListInfo(out);
				StudentInfo.addOnlineStudent();
			}
		}
		return true;
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * 
	 */
	public boolean getAlarmsInfo(String startTime, String endTime) throws ParseException, java.text.ParseException, SQLException{
		String subURL = "/batchAlarms";
		
		OutputAlarms out = new OutputAlarms();
		String retAlarmsInfo = "";
		String url = "";
		Integer limit = 50;
		Integer skip = 0 - limit;
		
		InputAlarms in = new InputAlarms();
		/*for(int index = 0; index < StudentInfo.getOutputNanGongStudentsInfo().getData().size(); index++){
			in.addUsers(StudentInfo.getOutputNanGongStudentsInfo().getData().get(index).getId());
		}*/
		in.setUsers(StudentMapOperator.getAllUserid());
		in.setLimit(50);
		in.setSkip(0);
		in.setStart(1481505165);
		in.setEnd(1489281165);
		//in.setStart(TimeTransfer.dateToStamp(startTime));//1477497600
		//in.setEnd(TimeTransfer.dateToStamp(endTime));//1478102400
		
		do{
			skip += limit;
			in.setSkip(skip);
			String param = in.toString();
			url = StudentURL1+subURL;
			retAlarmsInfo = HttpUtil.sendPostUrl(url, param);
		}while(JsonToStudentOutput.JsonToOutputAlarms(retAlarmsInfo, out, limit, skip));
		
		StudentInfo.addOutputAlarmsList(out);
		
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getAlarmInfo(String userid, /*String startTime,*/ String endTime) throws ParseException, java.text.ParseException{
		String subURL = "/alarms";
		
		OutputAlarms out = new OutputAlarms();
		String retAlarmInfo = "";
		String url = "";
		Integer limit = 50;
		Integer skip = 0 - limit;
		
		InputAlarm in = new InputAlarm();
		in.setUserId(userid);
		in.setAlarmType(0);
		in.setLimit(limit);
		in.setTime(TimeTransfer.dateToStamp(endTime));
		
		JsonToStudentOutput.initTotalDesiredAlarmNum();
		
		do{
			skip += limit;
			in.setSkip(skip);
			url = StudentURL1+subURL+in.toString();
			retAlarmInfo = HttpUtil.sendGet(url, param);
		}while(JsonToStudentOutput.JsonToOutputAlarms(retAlarmInfo, out, limit, skip));
		
		StudentInfo.addOutputAlarmsList(out);
		
		return true;
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	public boolean getLocationInfo(String IEMI) throws ParseException, java.text.ParseException{
		String subURL = "/location";
		
		String userId = StudentInfo.GetUserIdByIEMI(IEMI);
		if(userId.equals("")){
			try {
				userId = StudentIMEIMapOperator.GetUserIdByIEMI(IEMI);
				if(userId.equals("")){
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		InputLocation in = new InputLocation();
		in.setUserId(userId);
		in.setLocateType(-1);
		
		String url = StudentURL1+subURL+in.toString();
		String retLocationInfo = HttpUtil.sendGet(url, param);
		
		OutputLocation out = JsonToStudentOutput.JsonToOutputLocation(retLocationInfo);
		
		StudentInfo.setOutputLocation(out);
				
		return true;
	}
	
	/**
	 * 
	 */
	public boolean getTrackInfo(String startTime, String endTime, String IEMI) throws ParseException, java.text.ParseException{
		String subURL = "/track";
		
		String userId = StudentInfo.GetUserIdByIEMI(IEMI);
		if(userId.equals("")){
			try {
				userId = StudentIMEIMapOperator.GetUserIdByIEMI(IEMI);
				if(userId.equals("")){
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		InputTrack trackInput = new InputTrack();
		trackInput.setUserId(userId);
		trackInput.setLocateType(1);
		trackInput.setLimit(50);
		trackInput.setSkip(0);
		trackInput.setStart(TimeTransfer.dateToStamp(startTime));
		trackInput.setEnd(TimeTransfer.dateToStamp(endTime));

		OutputTrack outputTrack = new OutputTrack();
		String retTrackInfo = "";
		String url = "";
		Integer limit = 50;
		Integer skip = 0 - limit;
		
		do{
			skip += limit;
			trackInput.setSkip(skip);
			url = StudentURL1+subURL+trackInput.toString();
			retTrackInfo = HttpUtil.sendGet(url, param);
		}while(JsonToStudentOutput.JsonToOutputTrack(retTrackInfo, outputTrack, limit, skip));
		
		StudentInfo.setOutputTrack(outputTrack);
		
		return true;
	}
}
