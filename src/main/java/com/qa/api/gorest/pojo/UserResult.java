package com.qa.api.gorest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.response.Response;

public class UserResult {
	
	@Test
	public void createUserWithFullJson() {
		
		String token="_3912828d824d9c9b261c625732d7fea530ca03cce2b89eb5e7b46fadd52d42b4";
		Self sf=new Self("www.sf.com");
		Edit ed=new Edit("www.edu.com");
		Avatar av=new Avatar("www.avt.com");
		
		Links ln=new Links(sf,ed,av);
		
		
		UserInfo uf=new UserInfo("Atul","male","atul.anand@gmail.com","active",ln);
	String UserJsonPayLoad=TestUtil.getSerializedJSON(uf);
	System.out.println(UserJsonPayLoad);
	
	Map<String ,String> authTokenMap=new HashMap<String,String>();
	authTokenMap.put("Authorization","Bearer" + token);
	Response response=RestClient.doPost("JSON", "http://gorest.co.in","/public-api/users", authTokenMap, null, true, UserJsonPayLoad);
	System.out.println(response.prettyPrint());
	System.out.println(response.getStatusCode());
	}

}
