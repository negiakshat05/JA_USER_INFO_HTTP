package com.sita.task1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTypeTest {
	
	@InjectMocks
	UserType userType;
	
	@Test
	public void testUserType() {
		Map<String, String> user = userType.getUsers();
		
		assertEquals("CCUICKB0F1", user.get("admin"));
		assertEquals("CCUICKB0F1", user.get("staff"));
		assertEquals("CCATEGI010", user.get("testUser"));
	}
	

}
