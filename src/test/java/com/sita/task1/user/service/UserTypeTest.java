package com.sita.task1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sita.task1.user.helper.UserProperties;

@ExtendWith(MockitoExtension.class)
public class UserTypeTest {
	
	@InjectMocks
	UserType userType;
	
	@Mock
	UserProperties userProperties;
	
	@Test
	public void testUserType() {
		
		Map<String, String> type = new HashMap<>();
		type.put("validUser", "C11FGIG01");
		type.put("admin", "CCUICKB0F1");
		Mockito.lenient().when(userProperties.getType()).thenReturn(type);

		Map<String, String> result = userType.getUsers();
		assertEquals("C11FGIG01", result.get("validUser"));
		assertEquals("CCUICKB0F1", result.get("admin"));
	}
	

}
