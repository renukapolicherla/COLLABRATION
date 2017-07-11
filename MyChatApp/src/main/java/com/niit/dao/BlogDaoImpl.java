package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.BlogInfo;

@Repository("blogDao")
@Transactional

public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	
	public void addBlog(BlogInfo blog) {
		
		blog.setStatus("New");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(blog);
		tx.commit();
	
	}	
	public void updateBlog(BlogInfo blog){
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		
		
	}
	public BlogInfo getBlogId(long blogId) {
		
		Session session=sessionFactory.getCurrentSession();
		BlogInfo blog=(BlogInfo)session.createQuery("from BlogInfo where blogId="+blogId).getSingleResult();
		
		return blog;
	}

	public void deleteBlog(BlogInfo blog) {
		
		Session session=sessionFactory.getCurrentSession();
		session.delete(blog);
		
	}

	@SuppressWarnings("unchecked")
	public List<BlogInfo> listBlogs() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<BlogInfo> blogs=session.createQuery("from BlogInfo").getResultList();
		tx.commit();
		
		
		return blogs;

	}

	@SuppressWarnings("unchecked")
	public List<BlogInfo> listNewBlogs() {
		
		
		Session session=sessionFactory.getCurrentSession();
		List<BlogInfo> blogs=session.createQuery("from BlogInfo where status='New'").getResultList();
		
		return blogs;
	
	}




	


	

	

}

	