/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class Device {
	private String imei;
	
	private String state;
    
	private ArrayList<Sims> sims;
	
    /**
	 * 
	 */
	public Device() {
		this.imei = "";
		this.state = "";
		this.sims = new ArrayList<Sims>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Device [imei=" + imei + ", state=" + state + ", sims=" + sims + "]";
	}

	/**
	 * 
	 */
	public final String getImei() {
		return imei;
	}

	/**
	 * 
	 */
	public final void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * 
	 */
	public final String getState() {
		return state;
	}

	/**
	 * 
	 */
	public final void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 */
	public final ArrayList<Sims> getSims() {
		return sims;
	}

	/**
	 * 
	 */
	public final void setSims(ArrayList<Sims> sims) {
		this.sims = sims;
	}
	
	/**
	 * 
	 */
	public final void addSims(Sims sims) {
		this.sims.add(sims);
	}
}
