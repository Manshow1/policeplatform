/**
 * 
 */
package com.ciii.police.model.response.oldpeople;

/**
 * @author litong
 *
 */
public class NanGongCommunityIdEldersResult {
	private String id;
	
	private String username;
	
    private String created_at;
    
    private String updated_at;
    
    private String name;
    
    private String age;
    
	private String sex;
	
	private String title;

	private Contacts contacts;

	/**
	 * 
	 */
	public NanGongCommunityIdEldersResult() {
		super();
		this.id = "";
		this.username = "";
		this.created_at = "";
		this.updated_at = "";
		this.name = "";
		this.age = "";
		this.sex = "";
		this.title = "";
		this.contacts = new Contacts();
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "NanGongCommunityIdEldersResult [id=" + id + ", username=" + username + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", name=" + name + ", age=" + age + ", sex=" + sex + ", contacts="
				+ contacts + "]";
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
	public final String getUsername() {
		return username;
	}

	/**
	 * 
	 */
	public final void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 */
	public final String getCreated_at() {
		return created_at;
	}

	/**
	 * 
	 */
	public final void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * 
	 */
	public final String getUpdated_at() {
		return updated_at;
	}

	/**
	 * 
	 */
	public final void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
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
	public final String getAge() {
		return age;
	}

	/**
	 * 
	 */
	public final void setAge(String age) {
		this.age = age;
	}

	/**
	 * 
	 */
	public final String getSex() {
		return sex;
	}

	/**
	 * 
	 */
	public final void setSex(String sex) {
		this.sex = sex;
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
	public final Contacts getContacts() {
		return contacts;
	}

	/**
	 * 
	 */
	public final void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}
}
