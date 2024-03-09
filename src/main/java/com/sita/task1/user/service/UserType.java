package com.sita.task1.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sita.task1.user.helper.UserProperties;

@Service
public class UserType {

	private UserProperties userProperties;

	@Autowired
	public UserType(UserProperties userProperties) {
		this.userProperties = userProperties;
	}

	public Map<String, String> getUsers() {
		return userProperties.getType();
	}

}
