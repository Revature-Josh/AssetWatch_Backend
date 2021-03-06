package com.revature.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public class InvestmentDAO {

	@PersistenceContext
	private EntityManager investmentDAO;
	
	public String testUserDAO() {
		return "You've accessed the UserDAO class";
	}
	
	public List<User> getAll(){
		return (List<User>)investmentDAO.createQuery("SELECT i FROM Investment i").getResultList();
	}
	
}
