package com.sita.task1.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

	@Autowired
	UserType userType;

	@Autowired
	UserInfoService userInfoService;

	public UserInfoController(UserType userType) {
		this.userType = userType;
	}

	@GetMapping("/userDetail")
	public ResponseEntity<Map<String, String>> userDetail(@RequestParam("user") String userName) {

		logger.info("Start of userDetail in controller.");
		
		Map<String, String> response = new HashMap<>();
		Map<String, String> user = userType.getUsers();

		if (user.containsKey(userName)) {
			String workStation = user.get(userName);
			String status = userInfoService.postToAnotherService(userName, workStation);

			response.put("user", userName);
			response.put("workStation", workStation);
			response.put("status", "Success");
			response.put("message", "User exists in database and has access to given workstation.");
			logger.info("End of userDetail in controller.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			logger.info("User not valid");
			response.put("message", "User not found.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}
