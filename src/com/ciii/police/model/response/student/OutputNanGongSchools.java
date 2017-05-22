/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public final class OutputNanGongSchools {
	private Integer status;
	
	private String info;
	
	private ArrayList<NanGongSchoolData> data;
	
	/**
	 * 
	 */
	public OutputNanGongSchools() {
		this.status = 0;
		this.info = "";
		this.data = new ArrayList<NanGongSchoolData>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongSchools [status=" + status + ", info=" + info + ", data=" + data + "]";
	}

	/**
	 * 
	 */
	public final Integer getStatus() {
		return status;
	}

	/**
	 * 
	 */
	public final void setStatus(Integer status) {
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
	public final ArrayList<NanGongSchoolData> getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(ArrayList<NanGongSchoolData> data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public final void addData(NanGongSchoolData data) {
		this.data.add(data);
	}
}
