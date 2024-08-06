package day1HTTPMatehods;

import org.testng.annotations.Test;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

/*
given():
 Content type, set cookies, add auth i.e. authentication, add param i.e. parameters, set headers info i.e. information, etc.
when():
 get, post, put, delete requests.
then():
 validate status code, extract response, extract headers cookies & response body
*/

public class HTTPRequests {
	
	//using testng test
	//for single user
	
	@Test
	void getUser() {
		given()
		
		.when()
		
		.then()
	}
	
	
	

}
