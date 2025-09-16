package com.sba.cbr.dataobjects;

import java.awt.print.Book;
import java.util.Objects;
import java.util.Set;

import com.sba.cbr.entity.AuditFields;

public record RCategory(Integer id, String name, AuditFields audit, Set<Book> books, boolean active) {
	public RCategory{
		Objects.requireNonNull(name, "Category name can not be null");
		Objects.requireNonNull(audit, "Category audit fields can not be null");
		Objects.requireNonNull(active, "Category active can not be null");
	}
}
