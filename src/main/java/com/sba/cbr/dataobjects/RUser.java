package com.sba.cbr.dataobjects;

import java.time.LocalDateTime;
import java.util.Objects;

import com.sba.cbr.entity.AuditFields;

public record RUser(Integer id, String email, String password, String fullname, AuditFields audit, boolean active) {
	public RUser {
		Objects.requireNonNull(email, "User email can not be null");
		Objects.requireNonNull(password, "User passsword can not be null");
		Objects.requireNonNull(fullname, "User fullname can not be null");
		Objects.requireNonNull(audit, "User audits fields can not be null");
		Objects.requireNonNull(active, "User active can not be null");
	}
}
