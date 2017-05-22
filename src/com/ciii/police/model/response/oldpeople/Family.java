/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public final class Family {
	private String mobile;
	
    private String name;

    /**
	 * 
	 */
	public Family() {
		super();
		this.mobile = "";
		this.name = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Family [mobile=" + mobile + ", name=" + name + "]";
	}

	/**
	 * 
	 */
	public final String getMobile() {
		return mobile;
	}

	/**
	 * 
	 */
	public final void setMobile(String mobile) {
		this.mobile = mobile;
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
}
