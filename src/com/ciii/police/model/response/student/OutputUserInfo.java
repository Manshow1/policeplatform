/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public class OutputUserInfo {
	private long code;
	
	private User user;
	
	/**
	 * 
	 */
	public OutputUserInfo() {
		this.code = 0;
		this.user = new User();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputUserInfo [code=" + code + ", user=" + user + "]";
	}

	/**
	 * 
	 */
	public final long getCode() {
		return code;
	}

	/**
	 * 
	 */
	public final void setCode(long code) {
		this.code = code;
	}

	/**
	 * 
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * 
	 */
	public final void setUser(User user) {
		this.user = user;
	}
}
