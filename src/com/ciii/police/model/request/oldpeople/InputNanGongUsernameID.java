/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputNanGongUsernameID {
	private String id;

	/**
	 * 
	 */
	public InputNanGongUsernameID() {
		super();
		this.id = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return id;
	}

	/**
	 * 
	 */
	public final String getId() {
		return id;
	}

	/**
	 * 
	 */
	public final void setId(String id) {
		this.id = id;
	}
}
