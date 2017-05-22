/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class OutputNanGongUsernameID {
	private String status;

	private String description;

	private String result;

	/**
	 * 
	 */
	public OutputNanGongUsernameID() {
		super();
		this.status = "";
		this.description = "";
		this.result = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongUsernameID [status=" + status + ", description=" + description + ", result=" + result
				+ "]";
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
	public final String getResult() {
		return result;
	}

	/**
	 * 
	 */
	public final void setResult(String result) {
		this.result = result;
	}
}
