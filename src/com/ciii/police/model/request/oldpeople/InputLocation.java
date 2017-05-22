/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 * 
 */
public final class InputLocation {
	private String userId;
	
	private double locateType;//0 is compass, 1 is wifi, 2 base station. without it all type

	/**
	 * 
	 */
	public InputLocation() {
		super();
		this.userId = "";
		this.locateType = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		if((this.locateType == 0)||((this.locateType == 1))||(this.locateType == 2)){
			return "?userId=" + userId + "&locateType=" + locateType;
		}
		else{
			return "?userId=" + userId;
		}
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
	public final double getLocateType() {
		return locateType;
	}

	/**
	 * 
	 */
	public final void setLocateType(double locateType) {
		this.locateType = locateType;
	}
}
