/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class AlarmData{
	private Integer total;
	
	private ArrayList<AlarmDataData> data;

	/**
	 * 
	 */
	public AlarmData() {
		super();
		this.total = 0;
		this.data = new ArrayList<AlarmDataData>();
	}

	/**
	 * 
	 */
	public final Integer getTotal() {
		return total;
	}

	/**
	 * 
	 */
	public final void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 
	 */
	public final ArrayList<AlarmDataData> getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(ArrayList<AlarmDataData> data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public final void addData(AlarmDataData data) {
		this.data.add(data);
	}
}
