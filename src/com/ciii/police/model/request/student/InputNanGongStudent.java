/**
 * 
 */
package com.ciii.police.model.request.student;

/**
 * @author litong
 *
 */
public class InputNanGongStudent {
	private String id;// .../students/{id}
	
	/**
	 * 
	 */
	public InputNanGongStudent() {
		this.id = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "InputNanGongCurrentStudent [id=" + id + "]";
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
