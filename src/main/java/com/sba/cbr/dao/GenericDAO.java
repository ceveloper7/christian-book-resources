package com.sba.cbr.dao;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

/**
 * CRUD Operations
 */
public interface GenericDAO<T> {
	T create(T t);
	T update(T t);
	T get(Object id);
	void delete(Object id) throws EntityNotFoundException;
	List<T> listAll();
	long count();
}
