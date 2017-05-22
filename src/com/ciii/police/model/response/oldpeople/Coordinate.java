/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 * 
 */
public class Coordinate {
	private double latitude;	//Î³¶È
	
	private double longitude;	//¾­¶È

	public Coordinate() {
		super();
		this.latitude = 0.0;
		this.longitude = 0.0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	/**
	 * 
	 */
	public final double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 */
	public final void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 */
	public final double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 */
	public final void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
