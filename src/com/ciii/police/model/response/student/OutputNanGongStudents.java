/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class OutputNanGongStudents {
	private long total;
	  
	private long per_page;
	  
	private long current_page;
	  
	private long last_page;
	  
	private long from;
	  
	private long to;
	  
	private ArrayList<NanGongStudentData> data;
	
	/**
	 * 
	 */
	public OutputNanGongStudents() {
		super();
		this.total = 0;
		this.per_page = 0;
		this.current_page = 1;
		this.last_page = 0;
		this.from = 0;
		this.to = 0;
		this.data = new ArrayList<NanGongStudentData>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongStudents [total=" + total + ", per_page=" + per_page + ", current_page=" + current_page
				+ ", last_page=" + last_page + ", from=" + from + ", to=" + to + ", data=" + data + "]";
	}

	/**
	 * 
	 */
	public final long getTotal() {
		return total;
	}

	/**
	 * 
	 */
	public final void setTotal(long total) {
		this.total = total;
	}

	/**
	 * 
	 */
	public final long getPer_page() {
		return per_page;
	}

	/**
	 * 
	 */
	public final void setPer_page(long per_page) {
		this.per_page = per_page;
	}

	/**
	 * 
	 */
	public final long getCurrent_page() {
		return current_page;
	}

	/**
	 * 
	 */
	public final void setCurrent_page(long current_page) {
		this.current_page = current_page;
	}

	/**
	 * 
	 */
	public final long getLast_page() {
		return last_page;
	}

	/**
	 * 
	 */
	public final void setLast_page(long last_page) {
		this.last_page = last_page;
	}

	/**
	 * 
	 */
	public final long getFrom() {
		return from;
	}

	/**
	 * 
	 */
	public final void setFrom(long from) {
		this.from = from;
	}

	/**
	 * 
	 */
	public final long getTo() {
		return to;
	}

	/**
	 * 
	 */
	public final void setTo(long to) {
		this.to = to;
	}

	/**
	 * 
	 */
	public final ArrayList<NanGongStudentData> getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(ArrayList<NanGongStudentData> data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public final void addData(NanGongStudentData data) {
		this.data.add(data);
	}
}
