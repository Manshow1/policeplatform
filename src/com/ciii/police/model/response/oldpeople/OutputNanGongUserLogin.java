/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class OutputNanGongUserLogin {
	private String status;
	  
	private String description;
	
	private String email;
	
	private NanGongUserLoginResult result;

	/**
	 * 
	 */
	public OutputNanGongUserLogin() {
		super();
		this.status = "";
		this.description = "";
		this.email = "";
		this.result = new NanGongUserLoginResult();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongUserLogin [status=" + status + ", description=" + description + ", result=" + result + "]";
	}

	/**
	 * 
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * 
	 */
	public final void setStatus(String status) {
		this.status = status;
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
	public final NanGongUserLoginResult getResult() {
		return result;
	}

	/**
	 * 
	 */
	public final void setResult(NanGongUserLoginResult result) {
		this.result = result;
	}
}
