package com.niit.dao;

import java.util.List;

import com.niit.model.JobInfo;

public interface JobDao {
public List<JobInfo> list();
	
	public JobInfo get(int id);

	public void add(JobInfo job);

	public void delete(int id);
	



}
