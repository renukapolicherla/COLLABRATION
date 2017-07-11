package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Table(name="JobInfo",schema="COLLABRATIONDB")
@Entity
public class JobInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long jobId;
	@Size(min=5,max=50,message="Job Title should be 5-50 characters.")
	private String title;
	@Size(min=5,max=300,message=" Your job name should be 5-10 characters.")
	private String description;
	private Date dated;
	@Size(min=2,max=50,message="Your Qualification should be 5-10 characters.")
	private String qualification;
	private String status;
	@Size(min=5,max=50,message="companeyName should be 5-50 characters.")
	private String companeyName;
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompaneyName() {
		return companeyName;
	}
	public void setCompaneyName(String companeyName) {
		this.companeyName = companeyName;
	}
	}
