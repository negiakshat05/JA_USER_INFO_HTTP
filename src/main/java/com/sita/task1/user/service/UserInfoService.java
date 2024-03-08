package com.sita.task1.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class UserInfoService {

	public void postToAnotherService(String userName, String workStation) {

		Map<String, String> request = new HashMap<>();
		request.put("user", userName);
		request.put("workStation", workStation);
		request.put("status", "Success");
		request.put("message", "User exists in database and has access to given workstation.");

		String baseURL = "URL of second service you want to make the rest call to.";
		String baseURI = "URI of the api of second service";

		try {
//			Making the rest call to another service in the next line
			ClientResponse response = getWebClient(baseURL).method(HttpMethod.POST).uri(baseURI)
					.body(Mono.just(request), String.class).exchange().block();

			if (null != response && response.statusCode().equals(HttpStatus.OK))
				System.out.println("Successful post call to another service");
			else
				System.out.println("Post call was not successful.");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
	}

	private WebClient getWebClient(String baseUrl) {
		return WebClient.builder().baseUrl(baseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
}
