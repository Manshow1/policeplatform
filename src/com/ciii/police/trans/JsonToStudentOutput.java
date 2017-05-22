/**
 * 
 */
package com.ciii.police.trans;

import com.ciii.police.model.response.student.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
public final class JsonToStudentOutput {
	private static int totalDesiredAlarmNum = 0;
	
	/**
	 * 
	 */
	public static final int getTotalDesiredAlarmNum() {
		return totalDesiredAlarmNum;
	}

	/**
	 * 
	 */
	public static final void setTotalDesiredAlarmNum(int totalDesiredAlarmNum) {
		JsonToStudentOutput.totalDesiredAlarmNum = totalDesiredAlarmNum;
	}
	
	/**
	 * 
	 */
	public static final void initTotalDesiredAlarmNum() {
		JsonToStudentOutput.totalDesiredAlarmNum = 0;
	}

	/**
	 * 
	 */
	public static OutputNanGongSchools JsonToOutputNanGongSchools(String Info){
		JSONObject json;
		JSONArray json1;
		OutputNanGongSchools Sch = new OutputNanGongSchools();
		
		json = JSONObject.fromObject(Info);
		Sch.setStatus(Integer.valueOf(json.get("status").toString()));
		Sch.setInfo(json.get("info").toString());
		json1 = json.getJSONArray("data");
		for(Integer index = 0; index < json1.size(); index++){
			NanGongSchoolData data = new NanGongSchoolData();
			json = (JSONObject) json1.get(index);
			if(json == null){
				break;
			}
			data.setId(json.get("id").toString());
			data.setTitle(json.get("title").toString());
			Sch.getData().add(data);
		}
		
		return Sch;
	}
	
	/**
	 * 
	 */
	public static boolean JsonToOutputNanGongStudents(String Info, OutputNanGongStudents outputNanGongStudents){
		JSONObject json;
		JSONArray json1;
		json = JSONObject.fromObject(Info);
		outputNanGongStudents.setTotal(Long.valueOf(json.get("total").toString()));
		outputNanGongStudents.setPer_page(Long.valueOf(json.get("per_page").toString()));
		outputNanGongStudents.setCurrent_page(Long.valueOf(json.get("current_page").toString()));
		outputNanGongStudents.setLast_page(Long.valueOf(json.get("last_page").toString()));
		outputNanGongStudents.setFrom(Long.valueOf(json.get("from").toString()));
		outputNanGongStudents.setTo(Long.valueOf(json.get("to").toString()));
		json1 = json.getJSONArray("data");
		for(Integer index = 0; index < json1.size(); index++){
			NanGongStudentData nanGongStudentData = new NanGongStudentData();
			json = (JSONObject) json1.get(index);
			nanGongStudentData.setId(json.get("id").toString());
			nanGongStudentData.setName(json.get("name").toString());
			//System.out.println(json.get("name").toString());
			nanGongStudentData.setSchool_id(json.get("school_id").toString());
			nanGongStudentData.setAvatar(json.get("avatar").toString());
			nanGongStudentData.setSchool(json.get("school").toString());
			outputNanGongStudents.addData(nanGongStudentData);
		}
		
		if(outputNanGongStudents.getCurrent_page() == outputNanGongStudents.getLast_page()){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * 
	 */
	public static boolean JsonToOutputNanGongStudent(String Info, OutputNanGongStudent out){
		JSONObject json;
		JSONArray json1;
		json = JSONObject.fromObject(Info);
		out.setInfo(json.get("info").toString());
		if(false == out.getInfo().equals("OK")){
			return false;
		}
		out.setStatus(Long.valueOf(json.get("status").toString()));
		json = JSONObject.fromObject(json.get("data").toString());
		out.getData().setId(json.get("id").toString());
		out.getData().setName(json.get("name").toString());
		//System.out.println("name"+out.getData().getName());
		out.getData().setCid(json.get("cid").toString());
		out.getData().setGender(json.get("gender").toString());
		out.getData().setPhone(json.get("phone").toString());
		out.getData().setAvatar(json.get("avatar").toString());
		out.getData().setSchool(json.get("school").toString());
		//out.getData().set_class(json.get("class").toString());
		json = JSONObject.fromObject(json.get("device").toString());
		out.getData().getDevice().setImei(json.get("imei").toString());
		if(out.getData().getDevice().getImei().equals("")){
			return false;
		}
		//System.out.println("iemi:"+out.getData().getDevice().getImei());
		out.getData().getDevice().setState(json.get("state").toString());
		if("" != json.get("sims").toString()){
			json1 = json.getJSONArray("sims");
			for(Integer index = 0; index < json1.size(); index++){
				Sims sims = new Sims();
				json = (JSONObject) json1.get(index);
				sims.setPhone(json.get("phone").toString());
				sims.setName(json.get("name").toString());
				out.getData().getDevice().getSims().add(sims);
			}
		}
		else{
			//
		}
		
		return true;
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	public static boolean JsonToOutputAlarms(String Info, OutputAlarms OutputAlarms, Integer limit, Integer skip) throws ParseException, java.text.ParseException{
		JSONObject json;
		JSONArray json1;
		
		json = JSONObject.fromObject(Info);
		OutputAlarms.setCode(Integer.valueOf(json.get("code").toString()));
		OutputAlarms.setInfo(json.get("info").toString());
		if(false == OutputAlarms.getInfo().equals("OK")){
			return false;
		}
		json = JSONObject.fromObject(json.get("data").toString());
		OutputAlarms.getData().setTotal(Integer.valueOf(json.get("total").toString()));
		json1 = json.getJSONArray("data");
		if(OutputAlarms.getData().getTotal() <= limit+skip){
			for(Integer index = 0; index < (OutputAlarms.getData().getTotal()-skip); index++){
				json = (JSONObject) json1.get(index);
				if(1 != Integer.valueOf(json.get("alarmType").toString())){
					continue;
				}
				AlarmDataData data =new AlarmDataData();
				data.set_id(json.get("_id").toString());
				data.setAlarmMode(json.get("alarmMode").toString());
				data.setDescription(json.get("description").toString());
				data.setUserId(json.get("userId").toString());
				data.setIMEI(json.get("IMEI").toString());
				data.set__v(Integer.valueOf(json.get("__v").toString()));
				//data.setExtraDes(json.get("extraDes").toString());
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setDeviceAlarm(Integer.valueOf(json.get("deviceAlarm").toString()));
				data.setAlarmType(Integer.valueOf(json.get("alarmType").toString()));
				data.setUploadTime(TimeTransfer.dateToStamp1(json.get("uploadTime").toString())+3600*8);
				OutputAlarms.getData().addData(data);
				JsonToStudentOutput.totalDesiredAlarmNum++;
			}
			OutputAlarms.getData().setTotal(JsonToStudentOutput.totalDesiredAlarmNum);
			return false;
		}
		else{
			for(Integer index = 0; index < limit; index++){
				json = (JSONObject) json1.get(index);
				if(1 != Integer.valueOf(json.get("alarmType").toString())){
					continue;
				}
				AlarmDataData data =new AlarmDataData();
				data.set_id(json.get("_id").toString());
				System.out.println(json.toString());
				data.setAlarmMode(json.get("alarmMode").toString());
				data.setDescription(json.get("description").toString());
				data.setUserId(json.get("userId").toString());
				data.setIMEI(json.get("IMEI").toString());
				data.set__v(Integer.valueOf(json.get("__v").toString()));
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setDeviceAlarm(Integer.valueOf(json.get("deviceAlarm").toString()));
				data.setAlarmType(Integer.valueOf(json.get("alarmType").toString()));
				data.setUploadTime(TimeTransfer.dateToStamp1(json.get("uploadTime").toString())+3600*8);
				OutputAlarms.getData().addData(data);
				JsonToStudentOutput.totalDesiredAlarmNum++;
			}
			return true;
		}
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	public static OutputLocation JsonToOutputLocation(String Info) throws ParseException, java.text.ParseException{
		JSONObject json;
		OutputLocation lo = new OutputLocation();
		
		json = JSONObject.fromObject(Info);
		lo.setCode(Integer.valueOf(json.get("code").toString()));
		lo.setInfo(json.get("info").toString());
		if(false == lo.getInfo().equals("OK")){
			return lo;
		}
		String s = json.get("data").toString();
		if(s.equals("null")){
			return lo;
		}
		json = JSONObject.fromObject(json.get("data").toString());
		lo.getData().setLocateType(Integer.valueOf(json.get("locateType").toString()));
		//lo.getData().setdescription(json.get("description").toString());
		lo.getData().setLongitude(Double.parseDouble(json.get("longitude").toString()));
		lo.getData().setLatitude(Double.parseDouble(json.get("latitude").toString()));
		lo.getData().setUploadTime(TimeTransfer.stampToDate(TimeTransfer.dateToStamp1(json.get("uploadTime").toString())+3600*8));
		
		return lo;
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * 
	 */
	public static boolean JsonToOutputTrack(String Info, OutputTrack OutputTrack, Integer limit, Integer skip) throws ParseException, java.text.ParseException{
		JSONObject json;
		JSONArray json1;
		
		json = JSONObject.fromObject(Info);
		OutputTrack.setCode(Integer.valueOf(json.get("code").toString()));
		OutputTrack.setInfo(json.get("info").toString());
		if(false == OutputTrack.getInfo().equals("OK")){
			return false;
		}
		json = JSONObject.fromObject(json.get("data").toString());
		OutputTrack.getData().setTotal(Integer.valueOf(json.get("total").toString()));
		json1 = json.getJSONArray("data");
		
		if(OutputTrack.getData().getTotal() <= limit+skip){
			for(Integer index = 0; index < (OutputTrack.getData().getTotal()-skip); index++){
				LocationData data = new LocationData();
				json = (JSONObject) json1.get(index);
				data.setLocateType(Integer.valueOf(json.get("locateType").toString()));
				//data.setdescription(json.get("description").toString());
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setUploadTime(TimeTransfer.stampToDate(TimeTransfer.dateToStamp1(json.get("uploadTime").toString())+3600*8));
				OutputTrack.getData().addData(data);
				//System.out.println(index+","+data.getLocateType()+","+data.getdescription()+","+data.getLongitude()+","+data.getLatitude()+","+data.getUploadTime());
			}
			return false;
		}
		else{
			for(Integer index = 0; index < limit; index++){
				LocationData data = new LocationData();
				json = (JSONObject) json1.get(index);
				data.setLocateType(Integer.valueOf(json.get("locateType").toString()));
				//data.setdescription(json.get("description").toString());
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setUploadTime(TimeTransfer.stampToDate(TimeTransfer.dateToStamp1(json.get("uploadTime").toString())+3600*8));
				OutputTrack.getData().addData(data);
			}
			return true;
		}
	}
}
