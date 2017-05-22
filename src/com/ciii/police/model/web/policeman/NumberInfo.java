/**
 * 
 */
package com.ciii.police.model.web.policeman;

/**
 * @author litong
 *
 */
public final class NumberInfo {
	private long online; //在线警员数
	
	private long total;	//总警员数

	public NumberInfo() {
		super();
		this.online = 0;
		this.total = 0;
	}

	@Override
	public String toString() {
		return "NumberInfo [online=" + online + ", total=" + total + "]";
	}

	public final long getOnline() {
		return online;
	}

	public final void setOnline(long online) {
		this.online = online;
	}

	public final long getTotal() {
		return total;
	}

	public final void setTotal(long total) {
		this.total = total;
	}
}
