/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 * 
 */
public final class InputTrack {
	private String userId;
	
	private double locateType;//0 is compass, 1 is wifi, 2 base station. without it all type
	
	private double limit;//default limit value is 50
	
	private double skip;//default limit value is 0
	
	private long start;//track start time, it is millisecond
	
	private long end;//track end time, it is millisecond

	/**
	 * 
	 */
	@Override
	public String toString() {
		String str = "?userId=" + userId;
		
		if((this.locateType == 0)||((this.locateType == 1))||(this.locateType == 2)){
			str += "&locateType=" + locateType;
		}
		
		if((this.limit > 0) && (this.limit != 50)){
			str += "&limit=" + limit;
		}
		
		if(this.skip > 0){
			str += "&skip=" + skip;
		}
		
		str += "&start=" + start + "000";
		str += "&end=" + end + "000";
		
		return str;
	}

	/**
	 * 
	 */
	public final String getUserId() {
		return userId;
	}

	/**
	 * 
	 */
	public final void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 */
	public final double getLocateType() {
		return locateType;
	}

	/**
	 * 
	 */
	public final void setLocateType(double locateType) {
		this.locateType = locateType;
	}

	/**
	 * 
	 */
	public final double getLimit() {
		return limit;
	}

	/**
	 * 
	 */
	public final void setLimit(double limit) {
		this.limit = limit;
	}

	/**
	 * 
	 */
	public final double getSkip() {
		return skip;
	}

	/**
	 * 
	 */
	public final void setSkip(double skip) {
		this.skip = skip;
	}

	/**
	 * 
	 */
	public final double getStart() {
		return start;
	}

	/**
	 * 
	 */
	public final void setStart(long start) {
		this.start = start;
	}

	/**
	 * 
	 */
	public final double getEnd() {
		return end;
	}

	/**
	 * 
	 */
	public final void setEnd(long end) {
		this.end = end;
	}
}
