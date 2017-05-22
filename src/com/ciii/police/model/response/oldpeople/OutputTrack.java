/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public final class OutputTrack {
	private Integer code;

    private String info;

    private TrackData data;
    
    /**
	 * 
	 */
	public OutputTrack() {
		super();
		this.code = -1;
		this.info = "";
		this.data = new TrackData();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputTrack [code=" + code + ", info=" + info + ", data=" + data + "]";
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
	public final TrackData getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(TrackData data) {
		this.data = data;
	}
    
}
