/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class NanGongCommunitiesAllResult {
	private String gid;
	
	private String title;
	
    private String address;
    
    private String manager;

    /**
	 * 
	 */
	public NanGongCommunitiesAllResult() {
		super();
		this.gid = "";
		this.title = "";
		this.address = "";
		this.manager = "";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "NanGongCommunitiesAllData [gid=" + gid + ", title=" + title + ", address=" + address + ", manager="
				+ manager + "]";
	}

	/**
	 * 
	 */
	public final String getGid() {
		return gid;
	}

	/**
	 * 
	 */
	public final void setGid(String gid) {
		this.gid = gid;
	}

	/**
	 * 
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * 
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * 
	 */
	public final void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 */
	public final String getManager() {
		return manager;
	}

	/**
	 * 
	 */
	public final void setManager(String manager) {
		this.manager = manager;
	}
}
