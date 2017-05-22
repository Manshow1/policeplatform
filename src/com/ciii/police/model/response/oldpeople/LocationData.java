/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class LocationData extends Coordinate{
	private Integer locateType;//0 is compass, 1 is wifi, 2 base station. without it all type

	private String uploadTime;
	
	private String description;
	
	/**
	 * 
	 */
	public LocationData() {
		super();
		this.locateType = -1;
		this.uploadTime = "";
		this.description = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "PlaceInfo [locateType=" + locateType + ", uploadTime="
				+ uploadTime + ", description=" + description + "]";
	}
	
	/**
	 * 
	 */
	public final Integer getLocateType() {
		return locateType;
	}

	/**
	 * 
	 */
	public final void setLocateType(Integer locateType) {
		this.locateType = locateType;
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
	public final String getdescription() {
		return description;
	}

	/**
	 * 
	 */
	public final void setdescription(String description) {
		this.description = description;
	}
}
