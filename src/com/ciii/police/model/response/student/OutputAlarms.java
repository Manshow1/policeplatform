/**
 * 
 */package com.ciii.police.model.response.student;

 /**
  * @author litong
  *
  */
public final class OutputAlarms {
	private Integer code;

    private String info;

    private AlarmData data;

	public OutputAlarms() {
		super();
		this.code = 0;
		this.info = "";
		this.data = new AlarmData();
	}

	public final Integer getCode() {
		return code;
	}

	public final void setCode(Integer code) {
		this.code = code;
	}

	public final String getInfo() {
		return info;
	}

	public final void setInfo(String info) {
		this.info = info;
	}

	public final AlarmData getData() {
		return data;
	}

	public final void setData(AlarmData data) {
		this.data = data;
	}
}
