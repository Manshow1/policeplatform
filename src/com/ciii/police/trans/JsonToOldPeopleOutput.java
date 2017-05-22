/**
 * 
 */
package com.ciii.police.trans;

import com.ciii.police.model.response.oldpeople.AlarmDataData;
import com.ciii.police.model.response.oldpeople.Family;
import com.ciii.police.model.response.oldpeople.OutputAlarms;
import com.ciii.police.model.response.oldpeople.OutputLocation;
import com.ciii.police.model.response.oldpeople.OutputNanGongCommunitiesAll;
import com.ciii.police.model.response.oldpeople.OutputNanGongCommunityIdElders;
import com.ciii.police.model.response.oldpeople.OutputNanGongUserLogin;
import com.ciii.police.model.response.oldpeople.OutputNanGongUsernameID;
import com.ciii.police.model.response.oldpeople.LocationData;
import com.ciii.police.model.response.oldpeople.NanGongCommunitiesAllResult;
import com.ciii.police.model.response.oldpeople.NanGongCommunityIdEldersResult;
import com.ciii.police.model.response.oldpeople.OutputTrack;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
public final class JsonToOldPeopleOutput {
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
		JsonToOldPeopleOutput.totalDesiredAlarmNum = totalDesiredAlarmNum;
	}
	
	/**
	 * 
	 */
	public static final void initTotalDesiredAlarmNum() {
		JsonToOldPeopleOutput.totalDesiredAlarmNum = 0;
	}
	
	/**
	 * 
	 */
	public static OutputNanGongCommunitiesAll JsonToOutputNanGongCommunitiesAll(String Info){
		JSONObject json;
		JSONArray json1;
		
		OutputNanGongCommunitiesAll out = new OutputNanGongCommunitiesAll();
		
		json = JSONObject.fromObject(Info);
		json1 = json.getJSONArray("result");
		for(int index = 0; index < json1.size(); index++){
			json = (JSONObject) json1.get(index);
			if((-1 != json.get("address").toString().indexOf("ÄÏ¹¬"))||(-1 != json.get("address").toString().indexOf("º£µí"))){
				NanGongCommunitiesAllResult result = new NanGongCommunitiesAllResult();
				result.setGid(json.get("gid").toString());
				result.setTitle(json.get("title").toString());
				result.setAddress(json.get("address").toString());
				result.setManager(json.get("manager").toString());
				out.addResult(result);
			}
		}
		
		return out;
	}
	
	/**
	 * 
	 */
	public static OutputNanGongUsernameID JsonToOutputNanGongUsernameID(String Info){
		JSONObject json;
		OutputNanGongUsernameID out = new OutputNanGongUsernameID();
		
		json = JSONObject.fromObject(Info);
		out.setStatus(json.get("status").toString());
		out.setDescription(json.get("description").toString());
		out.setResult(json.get("result").toString());
		
		return out;
	}
	
	/**
	 * 
	 */
	public static OutputNanGongUserLogin JsonToOutputNanGongUserLogin(String Info, String email){
		JSONObject json;
		OutputNanGongUserLogin out = new OutputNanGongUserLogin();
		
		json = JSONObject.fromObject(Info);
		out.setStatus(json.get("status").toString());
		out.setDescription(json.get("description").toString());
		out.setEmail(email);
		json = JSONObject.fromObject(json.get("result").toString());
		out.getResult().setToken(json.get("token").toString());
		out.getResult().setUid(json.get("uid").toString());
		return out;
	}
	
	/**
	 * 
	 */
	public static OutputNanGongCommunityIdElders JsonToOutputNanGongCommunityIdElders(String Info, String title){
		JSONObject json;
		JSONArray json1, json3;
		OutputNanGongCommunityIdElders out = new OutputNanGongCommunityIdElders();
		
		json = JSONObject.fromObject(Info);
		out.setStatus(json.get("status").toString());
		out.setDescription(json.get("description").toString());
		json1 = json.getJSONArray("result");
		for(int index = 0; index < json1.size(); index++){
			NanGongCommunityIdEldersResult result = new NanGongCommunityIdEldersResult();
			json = (JSONObject) json1.get(index);
			result.setId(json.get("id").toString());
			result.setUsername(json.get("username").toString());
			result.setCreated_at(json.get("created_at").toString());
			result.setUpdated_at(json.get("updated_at").toString());
			result.setName(json.get("name").toString());
			result.setAge(json.get("age").toString());
			result.setSex(json.get("sex").toString());
			result.setTitle(title);
			if(-1 == json.toString().indexOf("mobile")){
				result.getContacts().setStatus("null");
				//continue;
			}
			else{
				json3 = json.getJSONArray("contacts");
				for(int i = 0; i < json3.size(); i++){
					json = (JSONObject) json3.get(i);
					Family family = new Family();
					family.setMobile(json.get("mobile").toString());
					family.setName(json.get("name").toString());
					result.getContacts().getFamily().add(family);
				}
			}
			out.addResult(result);
		}
		
		return out;
	}
	
	/**
	 * 
	 */
	public static boolean JsonToOutputAlarms(String Info, OutputAlarms OutputAlarms, Integer limit, Integer skip){
		JSONObject json;
		JSONArray json1;
		
		json = JSONObject.fromObject(Info);
		OutputAlarms.setCode(Integer.valueOf(json.get("code").toString()));
		OutputAlarms.setInfo(json.get("info").toString());
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
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setDeviceAlarm(Integer.valueOf(json.get("deviceAlarm").toString()));
				data.setAlarmType(Integer.valueOf(json.get("alarmType").toString()));
				data.setUploadTime(json.get("uploadTime").toString());
				OutputAlarms.getData().addData(data);
				JsonToOldPeopleOutput.totalDesiredAlarmNum++;
			}
			
			OutputAlarms.getData().setTotal(JsonToOldPeopleOutput.totalDesiredAlarmNum);
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
				data.setAlarmMode(json.get("alarmMode").toString());
				data.setDescription(json.get("description").toString());
				data.setUserId(json.get("userId").toString());
				data.setIMEI(json.get("IMEI").toString());
				data.set__v(Integer.valueOf(json.get("__v").toString()));
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setDeviceAlarm(Integer.valueOf(json.get("deviceAlarm").toString()));
				data.setAlarmType(Integer.valueOf(json.get("alarmType").toString()));
				data.setUploadTime(json.get("uploadTime").toString());
				OutputAlarms.getData().addData(data);
				JsonToOldPeopleOutput.totalDesiredAlarmNum++;
			}
			return true;
		}
	}
	
	/**
	 * 
	 */
	public static OutputLocation JsonToOutputLocation(String Info){
		JSONObject json;
		OutputLocation lo = new OutputLocation();
		
		json = JSONObject.fromObject(Info);
		lo.setCode(Integer.valueOf(json.get("code").toString()));
		lo.setInfo(json.get("info").toString());
		json = JSONObject.fromObject(json.get("data").toString());
		lo.getData().setLocateType(Integer.valueOf(json.get("locateType").toString()));
		lo.getData().setdescription(json.get("description").toString());
		lo.getData().setLongitude(Double.parseDouble(json.get("longitude").toString()));
		lo.getData().setLatitude(Double.parseDouble(json.get("latitude").toString()));
		lo.getData().setUploadTime(json.get("uploadTime").toString());
		
		return lo;
	}
	
	/**
	 * 
	 */
	public static boolean JsonToOutputTrack(String Info, OutputTrack OutputTrack, Integer limit, Integer skip){
		JSONObject json;
		JSONArray json1;
		
		json = JSONObject.fromObject(Info);
		OutputTrack.setCode(Integer.valueOf(json.get("code").toString()));
		OutputTrack.setInfo(json.get("info").toString());
		json = JSONObject.fromObject(json.get("data").toString());
		OutputTrack.getData().setTotal(Integer.valueOf(json.get("total").toString()));
		json1 = json.getJSONArray("data");
		
		if(OutputTrack.getData().getTotal() <= limit+skip){
			for(Integer index = 0; index < (OutputTrack.getData().getTotal()-skip); index++){
				LocationData data = new LocationData();
				json = (JSONObject) json1.get(index);
				data.setLocateType(Integer.valueOf(json.get("locateType").toString()));
				data.setdescription(json.get("description").toString());
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setUploadTime(json.get("uploadTime").toString());
				OutputTrack.getData().addData(data);
				System.out.println(index+","+data.getLocateType()+","+data.getdescription()+","+data.getLongitude()+","+data.getLatitude()+","+data.getUploadTime());
			}
			return false;
		}
		else{
			for(Integer index = 0; index < limit; index++){
				LocationData data = new LocationData();
				json = (JSONObject) json1.get(index);
				data.setLocateType(Integer.valueOf(json.get("locateType").toString()));
				data.setdescription(json.get("description").toString());
				data.setLongitude(Double.parseDouble(json.get("longitude").toString()));
				data.setLatitude(Double.parseDouble(json.get("latitude").toString()));
				data.setUploadTime(json.get("uploadTime").toString());
				OutputTrack.getData().addData(data);
			}
			return true;
		}
	}
}
