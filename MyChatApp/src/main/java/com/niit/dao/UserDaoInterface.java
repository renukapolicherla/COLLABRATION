package com.niit.dao;

import java.util.List;

import com.niit.model.UserInfo;

public interface UserDaoInterface {
	public void addUser(UserInfo user);
	public List<UserInfo> listUsers();
	public boolean isExistingUser(UserInfo user);
	public UserInfo getUserByUsername(String username);
	public UserInfo getEmailid(String email,String password);
	public UserInfo getUserId(int userId);


}
