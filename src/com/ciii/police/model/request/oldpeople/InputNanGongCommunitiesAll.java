/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputNanGongCommunitiesAll {
	private long skip;//offset
	
	private long take;//size

	/**
	 * 
	 */
	public InputNanGongCommunitiesAll() {
		super();
		this.skip = 0;
		this.take = 0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String str = "?skip=" + skip;
		str += "&take="+ take;
		return str;
	}

	/**
	 * 
	 */
	public final long getSkip() {
		return skip;
	}

	/**
	 * 
	 */
	public final void setSkip(long skip) {
		this.skip = skip;
	}

	/**
	 * 
	 */
	public final long getTake() {
		return take;
	}

	/**
	 * 
	 */
	public final void setTake(long take) {
		this.take = take;
	}
}
