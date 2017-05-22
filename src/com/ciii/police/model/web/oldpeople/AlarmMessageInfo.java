package com.ciii.police.model.web.oldpeople;

public class AlarmMessageInfo {
	private String userId;
	
	private String IMEI;
	
	//private double latitude;	//Î³¶È
	
	//private double longitude;	//¾­¶È
	
	private String description;
	
	private String uploadTime;
	
	private int state;
	
	private String name;
	
	private String title;
	
    private String kinsfolkname;
	
	private String kinsfolkphone;

	public AlarmMessageInfo() {
		super();
		userId = "";
		IMEI = "";
		this.description = "";
		this.uploadTime = "";
		this.state = 0;
		this.name = "";
		this.title = "";
		this.kinsfolkname = "";
		this.kinsfolkphone = "";
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
	public final String getTitle() {
		return title;
	}

	/**
	 * 
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 */
	public final String getKinsfolkname() {
		return kinsfolkname;
	}

	/**
	 * 
	 */
	public final void setKinsfolkname(String kinsfolkname) {
		this.kinsfolkname = kinsfolkname;
	}

	/**
	 * 
	 */
	public final String getKinsfolkphone() {
		return kinsfolkphone;
	}

	/**
	 * 
	 */
	public final void setKinsfolkphone(String kinsfolkphone) {
		this.kinsfolkphone = kinsfolkphone;
	}
}
