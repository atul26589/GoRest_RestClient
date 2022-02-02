package com.qa.api.gorest.util;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

public class Token {
	
	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap = new HashMap<String, String>();
	public static String clientId = "c25a33ed242734c";
	
	@Test
	public static Map<Object, Object> getAccessToken() {
		Map<String,String> formParams=new HashMap<String,String>();
		formParams.put("refresh_token", "14863767c6e1455b167637c4711e6be1b8d4cedc");
		formParams.put("client_id", "c25a33ed242734c");
		formParams.put("client_secret", "4d3ce4968fe4329ec686904af7e22fec062bfd8a");
		formParams.put("grant_type", "refresh_token");
		
		JsonPath tokenJson=given()
				              .formParams(formParams).when()
				              .post("https://api.imgur.com/oauth2/token")
				              .then()
				              .extract()
				              .jsonPath();
		
		System.out.println(tokenJson.getMap(""));
		appTokenMap=tokenJson.getMap("");
		return appTokenMap;
		
	}
	
	
	
	public static Map<String, String> getAuthToken(){
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth Token ====> "+ authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
	}
	
	public static Map<String, String> getClientId(){
		System.out.println("Client id is ====> "+ clientId);
		tokenMap.put("Authorization", "Client-ID "+clientId);
		return tokenMap;
	}

}
