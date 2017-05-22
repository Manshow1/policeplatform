/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class NanGongUserLoginResult {
	private String token;
    
	private String uid;

	/**
	 * 
	 */
	public NanGongUserLoginResult() {
		super();
		this.token = "";
		this.uid = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "NanGongUserLoginResult [token=" + token + ", uid=" + uid + "]";
	}

	/**
	 * 
	 */
	public final String getToken() {
		return token;
	}

	/**
	 * 
	 */
	public final void setToken(String token) {
		this.token = token;
	}

	/**
	 * 
	 */
	public final String getUid() {
		return uid;
	}

	/**
	 * 
	 */
	public final void setUid(String uid) {
		this.uid = uid;
	}
}
