package kr.or.connect.reservation.dto;

import java.sql.Date;

public class Member {

	private Long id;
	private String name;
	private String password;
	private String email;
	private Date createDate;
	private Date modifyDage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDage() {
		return modifyDage;
	}
	public void setModifyDage(Date modifyDage) {
		this.modifyDage = modifyDage;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", createDate="
				+ createDate + ", modifyDage=" + modifyDage + "]";
	}
	
	
}
