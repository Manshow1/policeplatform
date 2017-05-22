/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class TrackData {
	private Integer total;
	
	private ArrayList<LocationData> data;

	/**
	 * 
	 */
	public TrackData() {
		super();
		this.total = 0;
		this.data = new ArrayList<LocationData>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "TrackData [total=" + total + ", data=" + data + "]";
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
	public final ArrayList<LocationData> getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(ArrayList<LocationData> data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public final void addData(LocationData data) {
		this.data.add(data);
	}
}
