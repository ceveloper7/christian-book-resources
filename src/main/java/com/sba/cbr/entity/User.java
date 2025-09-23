package com.sba.cbr.entity;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="user")
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
	
	@NotNull
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@NotNull
	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
//	@Embedded
//	private AuditFields audit;
	
	@NotNull
	@Column(name = "is_active")
	private boolean active;
	
	public User() {}

	public static class Builder{
		private String email;
		private String password;
		private String fullname;
		private Integer createdBy;
		private LocalDateTime createdAt;
		private Integer updatedBy;
		private LocalDateTime updatedAt;
//		private AuditFields audit;
		private boolean active;
		
		public Builder(String email, String password, String fullname, Integer createdBy, 
						LocalDateTime createAt, Integer updatedBy, LocalDateTime updatedAt, boolean active) {
			this.email = email;
			this.password = password;
			this.fullname = fullname;
			this.createdBy = createdBy;
			this.createdAt = createAt;
			this.updatedBy = updatedBy;
			this.updatedAt = updatedAt;
			this.active = active;
		}
		
//		public Builder withAudits(AuditFields audit) {
//			this.audit = audit;
//			return this;
//		}
		
//		public Builder Active(boolean active) {
//			this.active = active;
//			return this;
//		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		this.email = builder.email;
		this.password = builder.password;
		this.fullname = builder.fullname;
		this.createdBy = builder.createdBy;
		this.createdAt = builder.createdAt;
		this.updatedBy = builder.updatedBy;
		this.updatedAt = builder.updatedAt;
		
//		this.audit = builder.audit;
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
	
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public Integer getUpdatedby() {
		return updatedBy;
	}
	
	public LocalDateTime getUpdatedAT() {
		return updatedAt;
	}

//	public AuditFields getAuditFields() {
//		return audit;
//	}
	
	public boolean isActive() {
		return active;
	}
	
	

}
