package com.qa.api.gorest.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI="https://gorest.co.in";
	String basePath="/public-api/users";
	String token="3912828d824d9c9b261c625732d7fea530ca03cce2b89eb5e7b46fadd52d42b4";

	
	@DataProvider
	public Object[][] getUserData(){
		Object userData[][]=ExcelUtil.getTestData("userdata");
	return userData;
	}
	
	@Test(dataProvider="getUserData")
	public void createUserAPIPOSTTest(String name,String gender,String email,String status) {
		
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);

		User user=new User(name,gender,email,status);
		Response response=RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null,true, user);
	
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	
	System.out.println("================================================");
	}
}

