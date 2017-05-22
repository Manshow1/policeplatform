/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public final class OutputLocation {
	private Integer code;

	private String Info;
	
	private LocationData data;
	
	/**
	 * 
	 */
	public OutputLocation() {
		super();
		this.code = 0;
		this.Info = "";
		this.data = new LocationData();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputLocation [code=" + code + ", Info=" + Info + ", data=" + data + "]";
	}

	/**
	 * 
	 */
	public final Integer getCode() {
		return code;
	}

	/**
	 * 
	 */
	public final void setCode(Integer code) {
		this.code = code;
	}
	
	/**
	 * 
	 */
	public final String getInfo() {
		return Info;
	}

	/**
	 * 
	 */
	public final void setInfo(String info) {
		Info = info;
	}
	
	/**
	 * 
	 */
	public final LocationData getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(LocationData data) {
		this.data = data;
	}
}
