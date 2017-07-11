package com.niit.restcontroller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.dao.UserDaoInterface;
import com.niit.model.BlogInfo;
import com.niit.model.UserInfo;

@RestController
public class BlogRestController {
@Autowired
BlogDao blogDao;
@Autowired
UserDaoInterface userDao;
@GetMapping(value="/blog/")
 public ResponseEntity<List<BlogInfo>>listAllBlogs(){
	List<BlogInfo>blogs=blogDao.listBlogs();
	if(blogs.isEmpty()){
		return new ResponseEntity<List<BlogInfo>>(HttpStatus.NO_CONTENT);
	}
	
	return new ResponseEntity<List<BlogInfo>>(blogs,HttpStatus.OK);	
	}
@GetMapping(value="/blog/new")
 public ResponseEntity<List<BlogInfo>>listAllNewBlogs(){
	List<BlogInfo>blogs=blogDao.listNewBlogs();
	if(blogs.isEmpty()){
		return new ResponseEntity<List<BlogInfo>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<BlogInfo>>(blogs,HttpStatus.OK);
			
	}
@GetMapping(value="/blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<BlogInfo>getBlog(@PathVariable("id")long id){
	BlogInfo blog=blogDao.getBlogId(id);
	if(blog==null){
		return new ResponseEntity<BlogInfo>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<BlogInfo>(blog,HttpStatus.OK);
	
	}
@PostMapping(value = "/blog/{id}")
public ResponseEntity<Void> createBlog(@RequestBody BlogInfo blog,@PathVariable Integer id) {
UserInfo user=userDao.getUserId(id);
blog.setUser(user);

    blogDao.addBlog(blog);

   
    return new ResponseEntity<Void>(HttpStatus.CREATED);
}
@PutMapping(value="/blog/{id}")
 public ResponseEntity<BlogInfo>updateBlog(@PathVariable("id")long id,@RequestBody BlogInfo blog){
	  BlogInfo currentBlog=blogDao.getBlogId(id);
	  if(currentBlog==null){
		  return new ResponseEntity<BlogInfo>(HttpStatus.NOT_FOUND);
	  }
	  currentBlog.setTitle(blog.getTitle());
      currentBlog.setDescription(blog.getDescription());
      blogDao.updateBlog(currentBlog);
      return new ResponseEntity<BlogInfo>(currentBlog,HttpStatus.OK);
}
@DeleteMapping(value="/blog/{id}")
public ResponseEntity<BlogInfo> deleteBlog(@PathVariable("id") long id) {
    
	 
    BlogInfo blog = blogDao.getBlogId(id);
    if (blog == null) {
        
        return new ResponseEntity<BlogInfo>(HttpStatus.NOT_FOUND);
    }
    blogDao.deleteBlog(blog);
    return new ResponseEntity<BlogInfo>(HttpStatus.NO_CONTENT);
}
@PostMapping(value="/approveblog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<BlogInfo>> approveBlog(@PathVariable("id") long id) {
    
    BlogInfo blog = blogDao.getBlogId(id);
    
    if (blog == null) {
        
        return new ResponseEntity<List<BlogInfo>>(HttpStatus.NOT_FOUND);
    }
    blog.setStatus("Approved");
    blogDao.updateBlog(blog);
    
    
    return new ResponseEntity<List<BlogInfo>>(blogDao.listBlogs(), HttpStatus.OK);
}
    
@PostMapping(value="/rejectblog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<BlogInfo>> rejectBlog(@PathVariable("id") long id) {
    
    BlogInfo blog = blogDao.getBlogId(id);
    
    if (blog == null) {
        
        return new ResponseEntity<List<BlogInfo>>(HttpStatus.NOT_FOUND);
    }
    blog.setStatus("Rejected");
    blogDao.updateBlog(blog);
    return new ResponseEntity<List<BlogInfo>>(blogDao.listBlogs(), HttpStatus.OK);
}

	  
}



