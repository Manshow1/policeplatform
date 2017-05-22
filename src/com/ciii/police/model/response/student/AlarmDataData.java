/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public final class AlarmDataData extends Coordinate {
	private String _id;
	
	private String alarmMode;
	
	private String description;
	
	private String userId;
	
	private String IMEI;
	
	private Integer __v;
	
	private String extraDes;

	private Integer deviceAlarm;
	
	private Integer alarmType;
	
	private long uploadTime;

	/**
	 * 
	 */
	public AlarmDataData() {
		super();
		this._id = "";
		this.alarmMode = "";
		this.description = "";
		this.userId = "";
		this.IMEI = "";
		this.__v = 0;
		this.deviceAlarm = 0;
		this.alarmType = 0;
		this.uploadTime = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "AlarmItem [_id=" + _id + ", alarmMode=" + alarmMode + ", description=" + description + ", userId="
				+ userId + ", IMEI=" + IMEI + ", __v=" + __v + ", deviceAlarm=" + deviceAlarm + ", alarmType="
				+ alarmType + ", uploadTime=" + uploadTime + "]";
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
	public final String getAlarmMode() {
		return alarmMode;
	}

	/**
	 * 
	 */
	public final void setAlarmMode(String alarmMode) {
		this.alarmMode = alarmMode;
	}

	/**
	 * 
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * 
	 */
	public final void setDescription(String description) {
		this.description = description;
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
	public final Integer get__v() {
		return __v;
	}

	/**
	 * 
	 */
	public final void set__v(Integer __v) {
		this.__v = __v;
	}
	
	/**
	 * 
	 */
	public final String getExtraDes() {
		return extraDes;
	}

	/**
	 * 
	 */
	public final void setExtraDes(String extraDes) {
		this.extraDes = extraDes;
	}

	/**
	 * 
	 */
	public final Integer getDeviceAlarm() {
		return deviceAlarm;
	}

	/**
	 * 
	 */
	public final void setDeviceAlarm(Integer deviceAlarm) {
		this.deviceAlarm = deviceAlarm;
	}

	/**
	 * 
	 */
	public final Integer getAlarmType() {
		return alarmType;
	}

	/**
	 * 
	 */
	public final void setAlarmType(Integer alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * 
	 */
	public final long getUploadTime() {
		return uploadTime;
	}

	/**
	 * 
	 */
	public final void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}
}
