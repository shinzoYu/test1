package com.demopackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demopackage.model.User;
import com.demopackage.repo.DemoRepository;

@Service("demoService")
public class DemoService {
	
	@Autowired
	private DemoRepository demoRepository;
	
	public boolean insert(User user)
	{
		return demoRepository.insert(user);
	}

	public boolean delete(String userId) {
		return demoRepository.delete(userId);
	}
	
	public List<User> getAll() {
		return demoRepository.getAll();
	}
}
