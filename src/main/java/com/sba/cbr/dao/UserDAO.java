package com.sba.cbr.dao;

import java.util.List;

import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User>{
	
	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public User create(User user) {
		return super.create(user);
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
