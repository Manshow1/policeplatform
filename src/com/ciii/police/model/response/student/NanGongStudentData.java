/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public class NanGongStudentData {
	private String id;
	
	private String name;
	
	private String school_id;
	
    private String avatar;
    
    private String school;
    
	/**
	 * 
	 */
	public NanGongStudentData() {
		super();
		this.id = "";
		this.name = "";
		this.school_id = "";
		this.avatar = "";
		this.school = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "NanGongStudentData [id=" + id + ", name=" + name + ", school_id=" + school_id + ", avatar=" + avatar
				+ ", school=" + school + "]";
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
	public final String getName() {
		return name;
	}

	/**
	 * 
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public final String getSchool_id() {
		return school_id;
	}

	/**
	 * 
	 */
	public final void setSchool_id(String school_id) {
		this.school_id = school_id;
	}

	/**
	 * 
	 */
	public final String getAvatar() {
		return avatar;
	}

	/**
	 * 
	 */
	public final void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * 
	 */
	public final String getSchool() {
		return school;
	}

	/**
	 * 
	 */
	public final void setSchool(String school) {
		this.school = school;
	}
}
