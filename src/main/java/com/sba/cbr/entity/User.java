package com.sba.cbr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User extends BaseEntity{
	private String email;
	private String password;
	
	@Column(name = "full_name")
	private String fullname;
	
	@Embedded
	private AuditFields audit;
	

	public User() {
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public AuditFields getAuditFields() {
		return audit;
	}
	
	public void setAuditFields(AuditFields audit) {
		this.audit = audit;
	}

}
