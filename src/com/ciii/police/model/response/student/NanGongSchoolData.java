/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public final class NanGongSchoolData {
	private String id;
	
	private String title;
	
	/**
	 * 
	 */
	public NanGongSchoolData() {
		this.id = "";
		this.title = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "SchoolData [id=" + id + ", title=" + title + "]";
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

	/**
	 * 
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * 
	 */
	public final void setTitle(String title) {
		this.title = title;
	}
}
