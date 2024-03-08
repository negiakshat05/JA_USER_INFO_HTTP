package com.sita.task1.user.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserInfoServiceTest {
	
	@InjectMocks
	UserInfoService userInfoService;
	
	@BeforeEach
	void setup() {
		
	}
	
	@Test
	public void testPostToAnotherService() {
		
		userInfoService.postToAnotherService("validUser", "CCUICKB0F1");
		
		
	}
}
