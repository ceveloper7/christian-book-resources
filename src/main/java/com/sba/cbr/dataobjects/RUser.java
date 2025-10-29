package com.sba.cbr.dataobjects;

import java.time.LocalDateTime;
import java.util.Objects;

public record RUser(
		Integer id, 
		String email, 
		String password, 
		String fullname, 
		Integer createdBy, 
		LocalDateTime createdAt, 
		Integer updatedBy,  
		LocalDateTime updatedAt,
		boolean active) {
	public RUser {
		Objects.requireNonNull(email, "User email field can not be null");
		Objects.requireNonNull(password, "User passsword field can not be null");
		Objects.requireNonNull(fullname, "User fullname field can not be null");
		Objects.requireNonNull(createdBy, "User createdBy field fields can not be null");
		Objects.requireNonNull(createdAt, "User createdAt field can not be null");
		Objects.requireNonNull(updatedBy, "User updatedBy field can not be null");
		Objects.requireNonNull(updatedAt, "User updatedAt field can not be null");
		Objects.requireNonNull(active, "User active field can not be null");
	}
}
