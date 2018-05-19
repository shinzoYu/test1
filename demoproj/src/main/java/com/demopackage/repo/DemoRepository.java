package com.demopackage.repo;

import java.util.List;

import com.demopackage.model.User;

public interface DemoRepository {

	boolean insert(User user);
	boolean delete(String userId);
	List<User> getAll();

}
