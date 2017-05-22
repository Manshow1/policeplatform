/**
 * 
 */
package com.ciii.police.model.database;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public final class InputOldPeoples {
	ArrayList<InputOldPeopleData> data;

	/**
	 * 
	 */
	public InputOldPeoples() {
		super();
		this.data = new ArrayList<InputOldPeopleData>();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "InputOldPeoples [data=" + data + "]";
	}

	/**
	 * 
	 */
	public final ArrayList<InputOldPeopleData> getData() {
		return data;
	}

	/**
	 * 
	 */
	public final void setData(ArrayList<InputOldPeopleData> data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public final void addData(InputOldPeopleData data) {
		this.data.add(data);
	}
}
