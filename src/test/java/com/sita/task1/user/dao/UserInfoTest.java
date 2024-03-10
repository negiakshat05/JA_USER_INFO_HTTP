package com.sita.task1.user.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserInfoTest {
	
	@Test
	public void testUser() {
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setId(1l);
		userInfo.setMessage("OK");
		userInfo.setStatus("Success");
		userInfo.setUserName("testUser");
		userInfo.setWorkStation("CKG79Jf01");
		
	}
	

}
