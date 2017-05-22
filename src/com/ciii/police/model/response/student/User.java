/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class User {
    private String _id;

    private ArrayList<Schedule> schedule;
    
    private long __v;
    
    private boolean online;

    private ArrayList<Integer> schedulePlan;

    private ArrayList<String> keys;

    private boolean lowBatteryState;

    private boolean whiteState;

    private long count;

    private long interval;
    
    private long alarmNote;

    private long paramSet;

    private String deviceId;
    
    private String IMEI;

    private String tdPhone;

    private String userId;

    private String created;

    /**
	 * 
	 */
	public User() {
		super();
		this._id = "";
		this.schedule = new ArrayList<Schedule>();
		this.__v = 0;
		this.online = false;
		this.schedulePlan = new ArrayList<Integer>();
		this.keys = new ArrayList<String>();
		this.lowBatteryState = true;
		this.whiteState = false;
		this.count = 0;
		this.interval = 0;
		this.alarmNote = 0;
		this.paramSet = 0;
		this.deviceId = "";
		this.IMEI = "";
		this.tdPhone = "";
		this.userId = "";
		this.created = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "UserMoreInfo [_id=" + _id + ", schedule=" + schedule + ", __v=" + __v + ", online=" + online
				+ ", schedulePlan=" + schedulePlan + ", keys=" + keys + ", lowBatteryState=" + lowBatteryState
				+ ", whiteState=" + whiteState + ", count=" + count + ", interval=" + interval + ", alarmNote="
				+ alarmNote + ", paramSet=" + paramSet + ", deviceId=" + deviceId + ", IMEI=" + IMEI + ", tdPhone="
				+ tdPhone + ", userId=" + userId + ", created=" + created + "]";
	}

	/**
	 * 
	 */
	public final String get_id() {
		return _id;
	}

	/**
	 * 
	 */
	public final void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * 
	 */
	public final ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	/**
	 * 
	 */
	public final void setSchedule(ArrayList<Schedule> schedule) {
		this.schedule = schedule;
	}

	/**
	 * 
	 */
	public final long get__v() {
		return __v;
	}

	/**
	 * 
	 */
	public final void set__v(long __v) {
		this.__v = __v;
	}

	/**
	 * 
	 */
	public final boolean isOnline() {
		return online;
	}

	/**
	 * 
	 */
	public final void setOnline(boolean online) {
		this.online = online;
	}

	/**
	 * 
	 */
	public final ArrayList<Integer> getSchedulePlan() {
		return schedulePlan;
	}

	/**
	 * 
	 */
	public final void setSchedulePlan(ArrayList<Integer> schedulePlan) {
		this.schedulePlan = schedulePlan;
	}

	/**
	 * 
	 */
	public final ArrayList<String> getKeys() {
		return keys;
	}

	/**
	 * 
	 */
	public final void setKeys(ArrayList<String> keys) {
		this.keys = keys;
	}

	/**
	 * 
	 */
	public final boolean isLowBatteryState() {
		return lowBatteryState;
	}

	/**
	 * 
	 */
	public final void setLowBatteryState(boolean lowBatteryState) {
		this.lowBatteryState = lowBatteryState;
	}

	/**
	 * 
	 */
	public final boolean isWhiteState() {
		return whiteState;
	}

	/**
	 * 
	 */
	public final void setWhiteState(boolean whiteState) {
		this.whiteState = whiteState;
	}

	/**
	 * 
	 */
	public final long getCount() {
		return count;
	}

	/**
	 * 
	 */
	public final void setCount(long count) {
		this.count = count;
	}

	/**
	 * 
	 */
	public final long getInterval() {
		return interval;
	}

	/**
	 * 
	 */
	public final void setInterval(long interval) {
		this.interval = interval;
	}

	/**
	 * 
	 */
	public final long getAlarmNote() {
		return alarmNote;
	}

	/**
	 * 
	 */
	public final void setAlarmNote(long alarmNote) {
		this.alarmNote = alarmNote;
	}

	/**
	 * 
	 */
	public final long getParamSet() {
		return paramSet;
	}

	/**
	 * 
	 */
	public final void setParamSet(long paramSet) {
		this.paramSet = paramSet;
	}

	/**
	 * 
	 */
	public final String getDeviceId() {
		return deviceId;
	}

	/**
	 * 
	 */
	public final void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 
	 */
	public final String getIMEI() {
		return IMEI;
	}

	/**
	 * 
	 */
	public final void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	/**
	 * 
	 */
	public final String getTdPhone() {
		return tdPhone;
	}

	/**
	 * 
	 */
	public final void setTdPhone(String tdPhone) {
		this.tdPhone = tdPhone;
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
		this.userId = userId;
	}

	/**
	 * 
	 */
	public final String getCreated() {
		return created;
	}

	/**
	 * 
	 */
	public final void setCreated(String created) {
		this.created = created;
	}
}
