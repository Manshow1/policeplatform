/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public class OutputNanGongStudent {
	
	private long status;
	  
	private String info;
	  
	private CurrentStudentData data;
	
	/**
	 * 
	 */
	public OutputNanGongStudent() {
		this.status = 0;
		this.info = "";
		this.data = new CurrentStudentData();
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongCurrentStudent [status=" + status + ", info=" + info + ", data=" + data + "]";
	}
	
	/**
	 * 
	 */
	public final long getStatus() {
		return status;
	}
	/**
	 * 
	 */
	public final void setStatus(long status) {
		this.status = status;
	}

	/**
	 * 
	 */
	public final String getInfo() {
		return info;
	}

	/**
	 * 
	 */
	public final void setInfo(String info) {
		this.info = info;
	}

	/**
	 * 
	 */
	public final CurrentStudentData getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(CurrentStudentData data) {
		this.data = data;
	}
}
