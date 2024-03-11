package com.sita.task1.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sita.task1.user.service.UserInfoService;
import com.sita.task1.user.service.UserType;

@ExtendWith(MockitoExtension.class)
public class UserInfoControllerTest {
	
	@InjectMocks
	UserInfoController userInfoController;
	
	@Mock
	UserType userType;
	
	@Mock
	private UserInfoService userInfoService;
	
	@Test
	public void testUserDetail() {
		
		Map<String, String> user = new HashMap<>();
		user.put("validUser", "CCATEGI010");
		Mockito.lenient().when(userType.getUsers()).thenReturn(user);
		Mockito.lenient().when(userInfoService.postToAnotherService(Mockito.anyString(), Mockito.anyString())).thenReturn("Success");
		ResponseEntity<Map<String,String>> response = userInfoController.userDetail("invalid");
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
