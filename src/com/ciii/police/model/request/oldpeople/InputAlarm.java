/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputAlarm {
	private String userId;
	
	private double alarmType;//1: SOS, 2: enter fence, 3: leave fence, 4: battery exhaust. without it is all type
	
	private double limit;//default limit value is 50
	
	private double skip;//default limit value is 0
	
	private long start;//track start time, it is millisecond
	
	private long end;//track end time, it is millisecond

	/**
	 * 
	 */
	@Override
	public String toString() {
		String str = "?userId=" + userId;
		
		if((this.alarmType == 1)||((this.alarmType == 2))||(this.alarmType == 3)||(this.alarmType == 4)){
			str += "&alarmType=" + alarmType;
		}
		
		if(this.limit > 0){
			str += "&limit=" + limit;
		}
		
		if(this.skip >= 0){
			str += "&skip=" + skip;
		}
		
		str += "&start=" + start + "000";
		str += "&end=" + end + "000";
		
		return str;
	}

	/**
	 * 
	 */
	public final String getUserId() {
		return userId;
	}

	/**
	 * 
	 */
	public final void setUserId(String userId) {
		this.userId = userId;//"33329"
		znxy_UserId();
	}
	
	/**
	 * 
	 */
	public final void znxy_UserId(){
		this.userId = "znxy_"+this.userId;
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
	public final void setAlarmType(double alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * 
	 */
	public final double getLimit() {
		return limit;
	}

	/**
	 * 
	 */
	public final void setLimit(double limit) {
		this.limit = limit;
	}

	/**
	 * 
	 */
	public final double getSkip() {
		return skip;
	}

	/**
	 * 
	 */
	public final void setSkip(double skip) {
		this.skip = skip;
	}

	/**
	 * 
	 */
	public final double getStart() {
		return start;
	}
	
	/**
	 * 
	 */
	public final void setTime(long end) {
		this.start = end-30*24*7200;//7200Ϊ1Сʱ
		this.end = end;
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
	public final double getEnd() {
		return end;
	}

	/**
	 * 
	 */
	public final void setEnd(long end) {
		this.end = end;
	}
}
