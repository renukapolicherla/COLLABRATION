package com.niit.dao;

import java.util.List;

import javax.persistence.NoResultException;
//import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserInfo;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDaoInterface
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory; 
	}
	@Override
	public void addUser(UserInfo user) {
		System.out.println("i am in add user dao");
	 Session session =sessionFactory.openSession();
	Transaction tx = session.beginTransaction();		 
	 session.saveOrUpdate(user);
	 tx.commit();
		
		
	}
	public UserInfo getUserByUsername(String username)
	{
		Session session=sessionFactory.openSession();
		UserInfo user=(UserInfo)session.createQuery("from UserInfo where username='"+username+"'").getSingleResult();
         return user;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<UserInfo>listUsers(){
		Session session=sessionFactory.openSession();
		List<UserInfo> users=session.createQuery("from UserInfo").getResultList();
		return users;
		}
	@Override
	public boolean isExistingUser(UserInfo user) {
		UserInfo u=null;
		try {
		u=getUserByUsername(user.getUsername());
		}catch(NoResultException nre){
		}
		if(u!=null)
		{
		return true;
		}
		else
		return false;
	}

	@Override
	public UserInfo getEmailid(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo useremail = (UserInfo)session.createQuery("from UserInfo where email ='"+email+"' and password='"+password+"'").getSingleResult();
		return useremail;
	}

	@Override
	public UserInfo getUserId(int userId) {
		Session session=sessionFactory.getCurrentSession();
		UserInfo user=(UserInfo)session.createQuery("from UserInfo where userid="+userId).getSingleResult();
		return user;

		}


		}
