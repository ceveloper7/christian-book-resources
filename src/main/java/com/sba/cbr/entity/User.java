package com.sba.cbr.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@AttributeOverride(name = "active", column = @Column(name = "is_active"))
public class User extends BaseEntity{
	@NotNull
	@Size(max = 64)
	@Email
	private String email;
	
	@NotNull
	@Size(max = 16)
	private String password;
	
	@NotNull
	@Size(max = 50)
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
