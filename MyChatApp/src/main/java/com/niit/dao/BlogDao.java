package com.niit.dao;

import java.util.List;

import com.niit.model.BlogInfo;

public interface BlogDao {
 public void addBlog(BlogInfo blog);
 public void updateBlog(BlogInfo blog);
 public void deleteBlog(BlogInfo blog);
 public BlogInfo getBlogId(long blog);
 public List<BlogInfo> listBlogs();
 public List<BlogInfo> listNewBlogs();

}
