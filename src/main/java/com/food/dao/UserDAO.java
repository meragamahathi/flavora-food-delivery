package com.food.dao;

import java.util.List;

import com.food.model.User;
public interface UserDAO {
	  int addUser(User user);
	  User validateUser(String email,String password);
	  User getUserByEmail(String email);
	  void updateUser(User user);
	  void deleteUser(int userId);
	  List<User> getAllUsers();
	  public int getUserCount();
	  public User getUser(int userId);

}
