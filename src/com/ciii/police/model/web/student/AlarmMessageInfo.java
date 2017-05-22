package com.ciii.police.model.web.student;

public final class AlarmMessageInfo {
	private String IMEI;
	
	//private double latitude;	//Î³¶È
	
	//private double longitude;	//¾­¶È
	
	private String description;
	
	private String uploadTime;
	
	private int state;
	
	private String name;
	
	private String school;
	
    private String parentname;
	
	private String parentphone;

	public AlarmMessageInfo() {
		super();
		IMEI = "";
		this.description = "";
		this.uploadTime = "";
		this.state = 0;
		this.name = "";
		this.school = "";
		this.parentname = "";
		this.parentphone = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "AlarmMessageInfo [IMEI=" + IMEI + ", description=" + description + ", uploadTime=" + uploadTime
				+ ", state=" + state + ", name=" + name + ", school=" + school + ", parentname=" + parentname
				+ ", parentphone=" + parentphone + "]";
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
	public final String getUploadTime() {
		return uploadTime;
	}

	/**
	 * 
	 */
	public final void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * 
	 */
	public final int getState() {
		return state;
	}

	/**
	 * 
	 */
	public final void setState(int state) {
		this.state = state;
	}

	/**
	 * 
	 */
	public final String getName() {
		return name;
	}

	/**
	 * 
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public final String getSchool() {
		return school;
	}

	/**
	 * 
	 */
	public final void setSchool(String school) {
		this.school = school;
	}

	/**
	 * 
	 */
	public final String getParentname() {
		return parentname;
	}

	/**
	 * 
	 */
	public final void setParentname(String parentname) {
		this.parentname = parentname;
	}

	/**
	 * 
	 */
	public final String getParentphone() {
		return parentphone;
	}

	/**
	 * 
	 */
	public final void setParentphone(String parentphone) {
		this.parentphone = parentphone;
	}
}
