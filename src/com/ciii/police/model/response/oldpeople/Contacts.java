/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class Contacts {
	private String status;
	
    private String message;
    
    private ArrayList<Family> family;

    /**
	 * 
	 */
	public Contacts() {
		super();
		this.status = "";
		this.message = "";
		this.family = new ArrayList<Family>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Contacts [status=" + status + ", message=" + message + "]";
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
	public final String getMessage() {
		return message;
	}

	/**
	 * 
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public final ArrayList<Family> getFamily() {
		return family;
	}

	/**
	 * 
	 */
	public final void setFamily(ArrayList<Family> family) {
		this.family = family;
	}
	
	/**
	 * 
	 */
	public final void setFamily(Family family) {
		this.family.add(family);
	}
}
