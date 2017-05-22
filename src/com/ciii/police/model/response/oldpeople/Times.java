/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class Times {
	private long start_h;
	
	private long start_m;
	
	private long end_h;
	
	private long end_m;
	
	private long interval;
	
	private long control;
	
	/**
	 * 
	 */
	public Times() {
		super();
		this.start_h = 0;
		this.start_m = 0;
		this.end_h = 0;
		this.end_m = 0;
		this.interval = 0;
		this.control = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Times [start_h=" + start_h + ", start_m=" + start_m + ", end_h=" + end_h + ", end_m=" + end_m
				+ ", interval=" + interval + ", control=" + control + "]";
	}

	/**
	 * 
	 */
	public final long getStart_h() {
		return start_h;
	}

	/**
	 * 
	 */
	public final void setStart_h(long start_h) {
		this.start_h = start_h;
	}

	/**
	 * 
	 */
	public final long getStart_m() {
		return start_m;
	}

	/**
	 * 
	 */
	public final void setStart_m(long start_m) {
		this.start_m = start_m;
	}

	/**
	 * 
	 */
	public final long getEnd_h() {
		return end_h;
	}

	/**
	 * 
	 */
	public final void setEnd_h(long end_h) {
		this.end_h = end_h;
	}

	/**
	 * 
	 */
	public final long getEnd_m() {
		return end_m;
	}

	/**
	 * 
	 */
	public final void setEnd_m(long end_m) {
		this.end_m = end_m;
	}

	/**
	 * 
	 */
	public final long getInterval() {
		return interval;
	}

	/**
	 * 
	 */
	public final void setInterval(long interval) {
		this.interval = interval;
	}

	/**
	 * 
	 */
	public final long getControl() {
		return control;
	}

	/**
	 * 
	 */
	public final void setControl(long control) {
		this.control = control;
	}
}
