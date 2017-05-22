/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputNanGongUserLogin {
	private String email;//OutputNanGongUsernameIDÖÐµÄ"result" 
	
	private String password;//12345678

	/**
	 * 
	 */
	public InputNanGongUserLogin() {
		super();
		this.email = "";
		this.password = "12345678";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "email=" + email + "&password=" + password;
	}

	/**
	 * 
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * 
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * 
	 */
	public final void setPassword(String password) {
		this.password = password;
	}
}
