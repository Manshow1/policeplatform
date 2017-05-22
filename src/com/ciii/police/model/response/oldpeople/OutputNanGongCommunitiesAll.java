/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class OutputNanGongCommunitiesAll {
	private ArrayList<NanGongCommunitiesAllResult> result;

	/**
	 * 
	 */

	public OutputNanGongCommunitiesAll() {
		super();
		this.result = new ArrayList<NanGongCommunitiesAllResult>();
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongCommunitiesAll [result=" + result + "]";
	}

	/**
	 * 
	 */
	public final ArrayList<NanGongCommunitiesAllResult> getResult() {
		return result;
	}

	/**
	 * 
	 */
	public final void setResult(ArrayList<NanGongCommunitiesAllResult> result) {
		this.result = result;
	}
	
	/**
	 * 
	 */
	public final void addResult(NanGongCommunitiesAllResult result){
		this.result.add(result);
	}
}
