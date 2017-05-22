/**
 * 
 */
package com.ciii.police.model.web.student;

/**
 * @author litong
 *
 */
public final class NumberInfo {
	private long online; //在线学生数
	
	private long total;	//总学生数
	
	private long Untreatedalarm;
	
	private long totalalarm;

	/**
	 * 
	 */
	public NumberInfo() {
		super();
		this.online = 0;
		this.total = 0;
		this.Untreatedalarm = 0;
		this.totalalarm = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "NumberInfo [online=" + online + ", total=" + total + ", Untreatedalarm=" + Untreatedalarm
				+ ", totalalarm=" + totalalarm + "]";
	}

	/**
	 * 
	 */
	public final long getOnline() {
		return online;
	}

	/**
	 * 
	 */
	public final void setOnline(long online) {
		this.online = online;
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
	public final long getUntreatedalarm() {
		return Untreatedalarm;
	}

	/**
	 * 
	 */
	public final void setUntreatedalarm(long untreatedalarm) {
		Untreatedalarm = untreatedalarm;
	}

	/**
	 * 
	 */
	public final long getTotalalarm() {
		return totalalarm;
	}

	/**
	 * 
	 */
	public final void setTotalalarm(long totalalarm) {
		this.totalalarm = totalalarm;
	}
}
