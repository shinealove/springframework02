package com.example.demo.jdbcConnect;

import java.util.List;

public interface UserService {
	public void save(User user);
	public List<User> getUsers();
}
