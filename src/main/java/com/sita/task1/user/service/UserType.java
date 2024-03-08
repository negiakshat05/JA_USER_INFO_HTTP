package com.sita.task1.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserType {

	private Map<String, String> user = new HashMap<>();

	public UserType() {
		user.put("admin", "CCUICKB0F1");
		user.put("staff", "CCUICKB0F1");
		user.put("testUser", "CCATEGI010");
	}

	public Map<String, String> getUsers() {
		return user;
	}

}
