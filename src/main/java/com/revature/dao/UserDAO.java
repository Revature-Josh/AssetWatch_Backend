package com.revature.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dto.UserDTO;
import com.revature.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public String testUserDAO() {
		return "You've accessed the UserDAO class";
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){
		Session session = sessionFactory.getCurrentSession();		
		return (List<User>)session.createQuery("SELECT u FROM User u").getResultList();
	}

	@Transactional(readOnly = true)
	public User login(UserDTO userDTO) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = (User) session.createQuery("FROM User u WHERE u.username = :user AND u.password = :pass")
				.setParameter("user", userDTO.getUsername().trim())
				.setParameter("pass", userDTO.getPassword().trim())
				.getSingleResult();
		
		return user;
	}
	
}
