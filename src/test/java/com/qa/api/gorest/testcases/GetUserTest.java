package com.qa.api.gorest.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "_418fa82795f567d49b430fe5c825980873e0299870a9416cb75c67c3d9c5aa33";

	@Test(priority = 1)
	public void getAllUserListAPITest() {

		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);

		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

	@Test(priority = 2)
	public void getUserWithQueryParamsAPITest() {

		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "John");
		params.put("gender", "male");

		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());

	}
}
