/**
 * 
 */
package com.ciii.police.model.request.oldpeople;

/**
 * @author litong
 *
 */
public class InputNanGongCommunityIdElders {
	private String id;//NanGongCommunitiesAllResult中的gid
	
	private String access_token;//NanGongUserLoginResult中的token
	
	private String uid;//NanGongUserLoginResult中的uid
	
	private double skip;
	
	private double take;

	/**
	 * 
	 */
	public InputNanGongCommunityIdElders() {
		super();
		this.id = "";
		this.access_token = "";
		this.uid = "";
		this.skip = 0.0;
		this.take = 0.0;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return id + "/elders?access_token=" + access_token + "&uid=" + uid;
	}

	/**
	 * 
	 */
	public final String getId() {
		return id;
	}

	/**
	 * 
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public final String getAccess_token() {
		return access_token;
	}

	/**
	 * 
	 */
	public final void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 
	 */
	public final String getUid() {
		return uid;
	}

	/**
	 * 
	 */
	public final void setUid(String uid) {
		this.uid = uid;
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
	public final double getTake() {
		return take;
	}

	/**
	 * 
	 */
	public final void setTake(double take) {
		this.take = take;
	}
}
