package com.sba.cbr.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Embeddable;

@Embeddable
public class AuditFields {
	@Nonnull
	private Integer created_by;
	@Nonnull
	private LocalDateTime created_at;
	@Nonnull
	private Integer updated_by;
	@Nonnull
	private LocalDateTime updated_at;
	
	public AuditFields() {}
	
	public static class Builder{
		private Integer created_by;
		private LocalDateTime created_at;
		private Integer updated_by;
		private LocalDateTime updated_at;
		
		public Builder(Integer created_by, LocalDateTime created_at, Integer updated_by, LocalDateTime updated_at) {
			this.created_by = created_by;
			this.created_at = created_at;
			this.updated_by = updated_by;
			this.updated_at = updated_at;
		}
		
		public AuditFields build() {
			return new AuditFields(this);
		}
	}
	
	private AuditFields(Builder builder) {
		this.created_by = builder.created_by;
		this.created_at = builder.created_at;
		this.updated_by = builder.updated_by;
		this.updated_at = builder.updated_at;
	}
	
	
	public Integer getCreated_by() {
		return created_by;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public Integer getUpdated_by() {
		return updated_by;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
}
