package com.paularanas.booking.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Component("usersDao")
@Transactional
public class UsersDao {

	
	@Autowired
	private SessionFactory sessionFactory;

    @Transactional
	public void create(User user) {
	 currentSession().save(user);
		 
	}

	public Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		
		return currentSession().createQuery("from User").list();
		
	}
	//Check if username already exists-- using Hibernate
	public boolean usernameExists(String username) {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		return user!=null;
	}
	
	public boolean passwordExists(String password) {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("password", password));
		User user = (User) criteria.uniqueResult();
		return user!=null;
	}

}
