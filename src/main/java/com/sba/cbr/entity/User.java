package com.sba.cbr.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="user")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@AttributeOverride(name = "active", column = @Column(name = "is_active"))
@NamedQueries({
	@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE email = :email"),
	@NamedQuery(name = "User.findAllActiveUsers", query = "SELECT u FROM User u WHERE active = true ORDER BY u.fullname"),
	@NamedQuery(name = "User.findAllNonActiveUsers", query = "SELECT u FROM User u WHERE active = false ORDER BY u.fullname"),
	@NamedQuery(name = "User.countAllActiveUsers", query = "SELECT COUNT(*) FROM User u WHERE active = true")
})
public class User extends BaseEntity{
	private static final long serialVersionUID = 1L;

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
	
	public User(String email, String password, String fullname, Integer createdBy, LocalDateTime createdAt, Integer updatedBy, LocalDateTime updatedAt, boolean active) {
		
		Objects.requireNonNull(email, "email can not be null");
		Objects.requireNonNull(password, "password can not be null");
		Objects.requireNonNull(fullname, "full name can not be null");
		Objects.requireNonNull(createdBy, "created by can not be null");
		Objects.requireNonNull(createdAt, "created at can not be null");
		Objects.requireNonNull(updatedBy, "updated by can not be null");
		Objects.requireNonNull(updatedAt, "updated at can not be null");
		Objects.requireNonNull(active, "active can not be null");
		
		com.sba.cbr.util.Email validEmail = com.sba.cbr.util.Email.of(email);
		
		this.email = validEmail.get();
		this.password = password;
		this.fullname = fullname;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.active = active;
	}
	
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getEmail() {
		return email;
	}
	
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	public String getPassword() {
		return password;
	}
	
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}

	public String getFullname() {
		return fullname;
	}
	
//	public void setCreatedBy(Integer createdBy) {
//		this.createdBy = createdBy;
//	}
	
	public Integer getCreatedBy() {
		return createdBy;
	}
	
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
//	public void setUpdatedBy(Integer updatedBy) {
//		this.updatedBy = updatedBy;
//	}
	
	public Integer getUpdatedby() {
		return updatedBy;
	}
	
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
//	public void setActive(boolean active) {
//		this.active = active;
//	}
	
	public boolean isActive() {
		return active;
	}
	
	

}
