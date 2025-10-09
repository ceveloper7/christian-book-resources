package com.sba.cbr.dao;

import java.util.List;

import com.sba.cbr.dataobjects.RUser;
import com.sba.cbr.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User>{
	
	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public User create(User user) {
		return super.create(user);
	}

	@Override
	public User update(User user) {
		return super.update(user);
	}

	@Override
	public User get(Object id) {
		return super.find(User.class, id);
	}

	@Override
	public void delete(Object id) throws EntityNotFoundException {
		try {
			super.delete(User.class, id);
		}
		catch (EntityNotFoundException e) {
			throw new EntityNotFoundException();
		}
	}
	
	public User findByEmail(String email) {
		List<User> users = super.findWithNamedQuery("User.findByEmail", "email", email);
		if(users != null && users.size() > 0)
			return users.get(0);
		return null;
	}

	@Override
	public List<User> listAllActive() {
		return super.findWithNamedQuery("User.findAllActiveUsers");
	}
	
	@Override
	public List<User> listAllNonActive(){
		return super.findWithNamedQuery("User.findAllNonActiveUsers");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("User.countAllActiveUsers");
	}

}
