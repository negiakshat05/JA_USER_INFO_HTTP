package com.sita.task1.user.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

import com.sita.task1.user.dao.UserInfo;
import com.sita.task1.user.dao.UserRepo;

@ExtendWith(MockitoExtension.class)
public class UserInfoServiceTest {

	@InjectMocks
	UserInfoService userInfoService;

	@Mock
	UserRepo userRepo;

	@Mock
	WebClient webClient;

	@Mock
	WebClient.Builder webClientBuilder;

	@Mock
	WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

	@Mock
	WebClient.RequestHeadersSpec requestHeadersSpec;

	@Mock
	WebClient.RequestBodyUriSpec requestBodyUriSpec;

	@Mock
	WebClient.RequestBodySpec requestBodySpec;

	@Mock
	WebClient.ResponseSpec responseSpec;

	@BeforeEach
	void setup() {

	}

	@Test
	public void testPostToAnotherService() {
		userInfoService.postToAnotherService("validUser", "CCUICKB0F1");
	}

	@Test
	public void testAddUserInfo() {

		UserInfo userInfo = new UserInfo();
		userInfo.setId(1l);
		userInfo.setMessage("OK");
		userInfo.setStatus("Success");
		userInfo.setUserName("testUser");
		userInfo.setWorkStation("CKG79Jf01");

		Mockito.lenient().when(userRepo.save(Mockito.any())).thenReturn(userInfo);
		ReflectionTestUtils.invokeMethod(userInfoService, "addUserInfo", "admin", "CCUI91OI");
	}

}
