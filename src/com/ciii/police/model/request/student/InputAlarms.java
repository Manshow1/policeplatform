/**
 * 
 */
package com.ciii.police.model.request.student;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author litong
 *
 */
public class InputAlarms {
	private ArrayList<String>  users;
	
	private long alarmType;//1: SOS, 2: enter fence, 3: leave fence, 4: battery exhaust. without it is all type
	
	private long limit;//default limit value is 50
	
	private long skip;//default limit value is 0
	
	private long start;//track start time, it is millisecond
	
	private long end;//track end time, it is millisecond
	
	private String sort;
	
	/**
	 * 
	 */
	public InputAlarms() {
		super();
		this.users = new ArrayList<String>();
		this.alarmType = 0;
		this.limit = 0;
		this.skip = 0;
		this.start = 0;
		this.end = 0;
		this.sort = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		znxy_Users();
		String str = "{";
		str += "\"users\":[";
		for(int index = 0; true; index++){
			str += users.get(index);
			if(index == (users.size()-1)){
				break;
			}
			str += ",";
		}
		str += "],";
		str += "\"limit\":";
		str += String.valueOf(limit);
		str += ",";
		str += "\"skip\":";
		str += String.valueOf(skip);
		str += ",";
		str += "\"start\":";
		str += String.valueOf(start);
		str += "000";
		str += ",";
		str += "\"end\":";
		str += String.valueOf(end);
		str += "000";
		str += "}";
		
		/*String str = "?";
		//str += "users={";
		for(int index = 0; true; index++){
			str += "users=";
			str += users.get(index);
			str += "&";
			if(index == (users.size()-1)){
				break;
			}
		}
		//str += "}&";
		//str += "&";
		str += "limit=";
		str += String.valueOf(limit);
		str += "&";
		str += "skip=";
		str += String.valueOf(skip);
		str += "&";
		str += "start=";
		str += String.valueOf(start);
		str += "000";
		str += "&";
		str += "end=";
		str += String.valueOf(end);
		str += "000";
		//str += "}";*/
		
		return str;
	}
	
	/**
	 * 
	 */
	public JSONObject toJSONObject() {
		znxy_Users();
		JSONObject alarmsParam = new JSONObject();
		JSONArray users = JSONArray.fromObject(this.users);
		alarmsParam.put("users", users);
		//alarmsParam.put("alarmType", 1);
		alarmsParam.put("limit", this.limit);
		alarmsParam.put("skip", this.skip);
		alarmsParam.put("start", this.start);
		alarmsParam.put("end", this.end);

		return alarmsParam;
	}

	/**
	 * 
	 */
	public final ArrayList<String> getUsers() {
		return users;
	}

	/**
	 * 
	 */
	public final void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	
	/**
	 * 
	 */
	public final void addUsers(String userId){
		this.users.add(userId);
	}
	
	/**
	 * 
	 */
	public final void znxy_Users(){
		for(int index = 0; index < this.users.size(); index++){
			users.set(index, "znxy_"+users.get(index));
		}
	}

	/**
	 * 
	 */
	public final double getAlarmType() {
		return alarmType;
	}

	/**
	 * 
	 */
	public final void setAlarmType(long alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * 
	 */
	public final long getLimit() {
		return limit;
	}

	/**
	 * 
	 */
	public final void setLimit(long limit) {
		this.limit = limit;
	}

	/**
	 * 
	 */
	public final long getSkip() {
		return skip;
	}

	/**
	 * 
	 */
	public final void setSkip(long skip) {
		this.skip = skip;
	}

	/**
	 * 
	 */
	public final long getStart() {
		return start;
	}

	/**
	 * 
	 */
	public final void setStart(long start) {
		this.start = start;
	}

	/**
	 * 
	 */
	public final long getEnd() {
		return end;
	}

	/**
	 * 
	 */
	public final void setEnd(long end) {
		this.end = end;
	}

	/**
	 * 
	 */
	public final String getSort() {
		return sort;
	}

	/**
	 * 
	 */
	public final void setSort(String sort) {
		this.sort = sort;
	}
}
