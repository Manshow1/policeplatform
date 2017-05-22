/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public class Sims {
	private String phone;
	
    private String name;
    
	/**
	 * 
	 */
	public Sims() {
		this.phone = "";
		this.name = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Sims [phone=" + phone + ", name=" + name + "]";
	}

	/**
	 * 
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * 
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
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
