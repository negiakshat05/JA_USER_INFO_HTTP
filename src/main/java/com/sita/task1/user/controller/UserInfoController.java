package com.sita.task1.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sita.task1.user.service.UserInfoService;
import com.sita.task1.user.service.UserType;

@RestController
public class UserInfoController {

	@Autowired
	UserType userType;

	@Autowired
	UserInfoService userInfoService;

	public UserInfoController(UserType userType) {
		this.userType = userType;
	}

	@GetMapping("/userDetail")
	public ResponseEntity<Map<String, String>> userDetail(@RequestParam("user") String userName) {

		Map<String, String> response = new HashMap<>();
		Map<String, String> user = userType.getUsers();

		if (user.containsKey(userName)) {
			String workStation = user.get(userName);

//			commenting out the call to for making rest call to another service for now.
//			userInfoService.postToAnotherService(userName, workStation);

			response.put("user", userName);
			response.put("workStation", workStation);
			response.put("status", "Success");
			response.put("message", "User exists in database and has access to given workstation.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

}
