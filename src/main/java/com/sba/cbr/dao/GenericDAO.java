package com.sba.cbr.dao;

import java.util.List;

/**
 * CRUD Operations
 */
public interface GenericDAO<T> {
	T create(T t);
	T update(T t);
	T get(Object id);
	void delete(Object id);
	List<T> listAll();
	long count();
}
