package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDao;
import com.niit.model.JobInfo;

@RestController
public class JobRestController {
	@Autowired
	JobDao jobDao;
	
	@PostMapping("/jobposting")
	public ResponseEntity<JobInfo> jobPosting(@RequestBody JobInfo job)
	{
		jobDao.add(job);
		return new ResponseEntity<JobInfo>(job, HttpStatus.OK);
	}

	
	@GetMapping("/alljobs")
	public ResponseEntity<List<JobInfo>> allJobs()
	{
 		List<JobInfo> list=jobDao.list();
 		for(JobInfo j: list)
 		{
 			System.out.println(j.getDated());
 		}
		return new ResponseEntity<List<JobInfo>>(list,HttpStatus.OK);
	}
}


