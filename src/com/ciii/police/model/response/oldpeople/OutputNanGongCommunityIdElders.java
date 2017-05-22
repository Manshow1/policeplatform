/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class OutputNanGongCommunityIdElders {
	private String status;
	
	private String description;

	private ArrayList<NanGongCommunityIdEldersResult> result;

	/**
	 * 
	 */
	public OutputNanGongCommunityIdElders() {
		super();
		this.status = "";
		this.description = "";
		this.result = new ArrayList<NanGongCommunityIdEldersResult>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "OutputNanGongCommunityIdElders [status=" + status + ", description=" + description + ", result="
				+ result + "]";
	}

	/**
	 * 
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * 
	 */
	public final void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * 
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 */
	public final ArrayList<NanGongCommunityIdEldersResult> getResult() {
		return result;
	}

	/**
	 * 
	 */
	public final void setResult(ArrayList<NanGongCommunityIdEldersResult> result) {
		this.result = result;
	}
	
	/**
	 * 
	 */
	public final void addResult(NanGongCommunityIdEldersResult result) {
		this.result.add(result);
	}
}
