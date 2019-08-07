package com.example.demo.jdbcConnect;

import javax.transaction.Transactional;
import java.util.List;
@Transactional()
public interface UserService {
	public void save(User user);
	public List<User> getUsers();
}
