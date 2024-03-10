package com.sita.task1.user.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.sita.task1.user.dao.UserInfo;
import com.sita.task1.user.dao.UserRepo;

import reactor.core.publisher.Mono;

@Service
public class UserInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

	@Value("${baseURL}")
	private String baseURL;

	@Value("${baseURI}")
	private String baseURI;

	@Autowired
	private UserRepo userRepo;

	public String postToAnotherService(String userName, String workStation) {

		logger.info("Entering into postToAnotherService method.");
		String status = null;
		Map<String, String> request = new HashMap<>();
		request.put("user", userName);
		request.put("workStation", workStation);
		request.put("status", "Success");
		request.put("message", "User exists in database and has access to given workstation.");

		try {
//			Making the rest call to another service in the next line
			ClientResponse response = getWebClient(baseURL).method(HttpMethod.POST).uri(baseURI)
					.body(Mono.just(request), Map.class).exchange().block();

			if (null != response && response.statusCode().equals(HttpStatus.OK)) {
				logger.info("Successful post call to another service");
				addUserInfo(userName, workStation);
				status = "SUCCESS";
			} else {
				logger.info("Post call was not successful.");
				status = "FAILED";
			}
		} catch (Exception e) {
			logger.error("Exception occered due to: {}", e.getMessage());
		}
		return status;
	}

	private WebClient getWebClient(String baseUrl) {
		return WebClient.builder().baseUrl(baseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	private void addUserInfo(String user, String workStation) {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(user);
		userInfo.setWorkStation(workStation);
		userInfo.setStatus("Success");
		userInfo.setMessage("User exists in database and has access to given workstation.");
		userRepo.save(userInfo);
	}
}
