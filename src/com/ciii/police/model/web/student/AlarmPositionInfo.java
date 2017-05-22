/**
 * 
 */
package com.ciii.police.model.web.student;

/**
 * @author litong
 *
 */
public final class AlarmPositionInfo {
	private String IMEI;
	
	private double latitude;	//Î³¶È
	
	private double longitude;	//¾­¶È
	
	private String description;
	
	private String uploadTime;

	//private int state;
	
	private String name;
	
	private String school;
	
    //private String parentname;
	
	//private String parentphone;
	
	/**
	 * 
	 */
	public AlarmPositionInfo() {
		super();
		IMEI = "";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.description = "";
		this.uploadTime = "";
		this.name = "";
		this.school = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "AlarmPositionInfo [IMEI=" + IMEI + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", description=" + description + ", uploadTime=" + uploadTime + ", name=" + name + ", school="
				+ school + "]";
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
	public final String getSchool() {
		return school;
	}

	/**
	 * 
	 */
	public final void setSchool(String school) {
		this.school = school;
	}
}
