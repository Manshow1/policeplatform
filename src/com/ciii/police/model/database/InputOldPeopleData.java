/**
 * 
 */
package com.ciii.police.model.database;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public final class InputOldPeopleData {
	private String token;
    
	private String uid;
	
	private ArrayList<String> gidArr;
	
	private ArrayList<String> titleArr;

	/**
	 * 
	 */
	public InputOldPeopleData() {
		super();
		this.token = "";
		this.uid = "";
		this.gidArr = new ArrayList<String>();
		this.titleArr = new ArrayList<String>();
	}

	/**
	 * 
	 */
	public final String getToken() {
		return token;
	}

	/**
	 * 
	 */
	public final void setToken(String token) {
		this.token = token;
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
	public final ArrayList<String> getGidArr() {
		return gidArr;
	}

	/**
	 * 
	 */
	public final void setGidArr(ArrayList<String> gidArr) {
		this.gidArr = gidArr;
	}
	
	/**
	 * 
	 */
	public final void addGid(String gid) {
		this.gidArr.add(gid);
	}

	/**
	 * 
	 */
	public final ArrayList<String> getTitleArr() {
		return titleArr;
	}

	/**
	 * 
	 */
	public final void setTitleArr(ArrayList<String> titleArr) {
		this.titleArr = titleArr;
	}

	/**
	 * 
	 */
	public final void addTitle(String title) {
		this.titleArr.add(title);
	}
}
