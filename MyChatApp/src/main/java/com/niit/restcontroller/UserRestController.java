package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDaoInterface;
import com.niit.model.UserInfo;

@RestController
public class UserRestController 
{
@Autowired
UserDaoInterface userDao;
@RequestMapping(value="/user/")
public ResponseEntity<List<UserInfo>>listAllUsers()
{
	System.out.println("i am in user rest controller");
	List<UserInfo>users=userDao.listUsers();
	if(users.isEmpty()){
		return new ResponseEntity<List<UserInfo>>
		(HttpStatus.NO_CONTENT);//You may decide to return HttpStatus.NOT_FOUND
	}
	return new ResponseEntity<List<UserInfo>>(users,HttpStatus.OK);
	
}
@PostMapping(value="/usersave/")
 public ResponseEntity<Void>createUser(@RequestBody UserInfo user){
System.out.println("Creating User"+user.getUsername());
if(userDao.isExistingUser(user)){
	System.out.println("A User with name"+user.getUsername()+"already exist");
return new ResponseEntity<Void>(HttpStatus.CONFLICT);
}
 userDao.addUser(user);

return new ResponseEntity<Void>(HttpStatus.CREATED);
 }
 
		

}
