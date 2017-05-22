/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputUserInfo {
	private String userId;
	
	/**
	 * 
	 */
	public InputUserInfo(String userId) {
		super();
		this.userId = userId;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "InputUserInfo [userId=" + userId + "]";
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
}
