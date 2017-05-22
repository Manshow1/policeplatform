/**
 * 
 */
package com.ciii.police.model.response.student;

/**
 * @author litong
 *
 */
public class CurrentStudentData {
	private String id;

	private String name;

	private String cid;

	private String gender;

	private String phone;

	private String avatar;

	private String school;

	private String _class;//接口中名称无下划线

	private Device device;
	
	/**
	 * 
	 */
	public CurrentStudentData() {
		super();
		this.id = "";
		this.name = "";
		this.cid = "";
		this.gender = "";
		this.phone = "";
		this.avatar = "";
		this.school = "";
		this._class = "";
		this.device = new Device();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "CurrentStudentData [id=" + id + ", name=" + name + ", cid=" + cid + ", gender=" + gender + ", phone="
				+ phone + ", avatar=" + avatar + ", school=" + school + ", _class=" + _class + ", device=" + device
				+ "]";
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
	public final String getName() {
		return name;
	}

	/**
	 * 
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public final String getCid() {
		return cid;
	}

	/**
	 * 
	 */
	public final void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 
	 */
	public final String getGender() {
		return gender;
	}

	/**
	 * 
	 */
	public final void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * 
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 */
	public final String getAvatar() {
		return avatar;
	}

	/**
	 * 
	 */
	public final void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * 
	 */
	public final String getSchool() {
		return school;
	}

	/**
	 * 
	 */
	public final void setSchool(String school) {
		this.school = school;
	}

	/**
	 * 
	 */
	public final String get_class() {
		return _class;
	}

	/**
	 * 
	 */
	public final void set_class(String _class) {
		this._class = _class;
	}

	/**
	 * 
	 */
	public final Device getDevice() {
		return device;
	}

	/**
	 * 
	 */
	public final void setDevice(Device device) {
		this.device = device;
	}
}
