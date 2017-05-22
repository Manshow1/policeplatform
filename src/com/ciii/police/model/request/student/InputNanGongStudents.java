/**
 * 
 */
package com.ciii.police.model.request.student;

/**
 * @author litong
 *
 */
public class InputNanGongStudents {
	private String school;
	
	private long page;
	
	private long limiy;
	
	/**
	 * 
	 */
	public InputNanGongStudents() {
		super();
		this.school = "";
		this.page = 0;
		this.limiy = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String str = "?school=" + school;
		str += "&page="+ String.valueOf(page);
		return str;
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

	/**
	 * 
	 */
	public final long getPage() {
		return page;
	}

	/**
	 * 
	 */
	public final void setPage(long page) {
		this.page = page;
	}

	/**
	 * 
	 */
	public final long getLimiy() {
		return limiy;
	}

	/**
	 * 
	 */
	public final void setLimiy(long limiy) {
		this.limiy = limiy;
	}
}
