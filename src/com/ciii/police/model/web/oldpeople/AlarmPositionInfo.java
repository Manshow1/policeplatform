/**
 * 
 */
package com.ciii.police.model.web.oldpeople;

/**
 * @author litong
 *
 */
public final class AlarmPositionInfo {
	private String userId;
	
	private String IMEI;
	
	private double latitude;	//Î³¶È
	
	private double longitude;	//¾­¶È
	
	private String description;
	
	private String uploadTime;

	//private int state;
	
	private String name;
	
	private String title;
	
    //private String parentname;
	
	//private String parentphone;
	
	/**
	 * 
	 */
	public AlarmPositionInfo() {
		super();
		this.userId = "";
		this.IMEI = "";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.description = "";
		this.uploadTime = "";
		this.name = "";
		this.title = "";
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
	public final double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 */
	public final void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 */
	public final double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 */
	public final void setLongitude(double longitude) {
		this.longitude = longitude;
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
}
