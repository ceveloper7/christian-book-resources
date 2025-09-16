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
	
	@NotNull
	@Column(name = "is_active")
	private boolean active;
	
	public User() {}

	public static class Builder{
		private String email;
		private String password;
		private String fullname;
		private AuditFields audit;
		private boolean active;
		
		public Builder(String email, String password, String fullname) {
			this.email = email;
			this.password = password;
			this.fullname = fullname;
		}
		
		public Builder withAudits(AuditFields audit) {
			this.audit = audit;
			return this;
		}
		
		public Builder isActive(boolean active) {
			this.active = active;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		this.email = builder.email;
		this.password = builder.password;
		this.fullname = builder.fullname;
		this.audit = builder.audit;
		this.active = builder.active;
	}

	public String getEmail() {
		return email;
	}

	
	public String getPassword() {
		return password;
	}

	public String getFullname() {
		return fullname;
	}

	public AuditFields getAuditFields() {
		return audit;
	}
	
	public boolean getActive() {
		return active;
	}
	
	

}
