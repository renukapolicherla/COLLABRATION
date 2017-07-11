package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.BlogDao;
import com.niit.dao.JobDao;
import com.niit.dao.UserDaoInterface;
import com.niit.model.BlogInfo;
import com.niit.model.JobInfo;
//import com.niit.dao.UserDaoInterface;
import com.niit.model.UserInfo;

public class AppTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		
		System.out.println("main started");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		System.out.println("main ended");
	   /*UserDaoInterface userDao=(UserDaoInterface)context.getBean("userDao");
	    UserInfo user=new UserInfo();
	    user.setUsername("renuka");
	    user.setMobileno("9676437927");
	    user.setEmail("renukapolicherla@gmail.com");
	    user.setPassword("mypassword");
	    user.setIsactive(true);
	    user.setRole("user");
	    userDao.addUser(user);
	    
	    BlogDao blogDao=(BlogDao)context.getBean("blogDao");
	    BlogInfo blog=new BlogInfo();
	    blog.setTitle("collabrate");
	    blog.setDescription("Angular js application");
	    blog.setUser(userDao.getUserId(2));
	    blogDao.addBlog(blog);
	    
	  blog = blogDao.getBlogId(4);
	  System.out.println("blog title="+blog.getTitle());
	    
	    
	    */
		JobDao jobdao=(JobDao)context.getBean("jobdao");
		JobInfo job=new JobInfo();
        job.setTitle("newchat");
		job.setDescription("It is a app");
		job.setCompaneyName("ChatModel");
		job.setQualification("B.tech");
		job.setDated(new Date());
		job.setStatus("Available");
		jobdao.add(job);
	   System.out.println("successfully record enterd"); 
	}

}
