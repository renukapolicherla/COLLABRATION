package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.JobInfo;

@Repository("jobdao")
@Transactional
public class JobDaoImpl implements JobDao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}


	public List<JobInfo> list() {
	
		return sessionFactory.getCurrentSession().createQuery("from JobInfo",JobInfo.class).getResultList();

	}

	@SuppressWarnings("deprecation")
	public JobInfo get(int id) {
		Session session=sessionFactory.getCurrentSession();
		JobInfo job=(JobInfo)session.createQuery("from JobInfo where jobId="+id).getSingleResult();
		return job;

	}

	public void add(JobInfo job) {

		System.out.println("i am in add job dao");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(job);
		tx.commit();

	}

	public void delete(int id) {
		JobInfo job = new JobInfo();
		job.setJobId(id);
		sessionFactory.getCurrentSession().delete(job);
		
	}

}

