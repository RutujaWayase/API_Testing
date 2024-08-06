package day1HTTPMatehods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


/*
given():
 Content type, set cookies, add auth i.e. authentication, add param i.e. parameters, set headers info i.e. information, etc.
when():
 get, post, put, delete requests.
then():
 validate status code, extract response, extract headers cookies & response body
*/

public class HTTPRequests {
	
	
	int id;
	
	//using testng test
	//for single user
	
	@Test(priority=1)
	void getUser() {
		given()
		
		.when()
		 .get("https://reqres.in/api/users?page=2")
		
		.then()
		 .statusCode(200)
		 .body("page", equalTo(2))
		 .log().all();
	}
	
	@Test(priority=2)
	void createUser() {
		HashMap data = new HashMap(); //hashmap is in key value pair
		data.put("name", "rutuja");
		data.put("job", "sdet");
		
		id = given()
		     .contentType("application/json")
		     .body(data)
		     
		.when()
		     .post("https://reqres.in/api/users")
		     .jsonPath().getInt("id");
		
	/*	     
		.then()
		     .statusCode(201)
		     .log().all();
    */
		     
	}
	
	@Test(priority=3,dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap data = new HashMap();
		data.put("name", "John");
		data.put("job", "SDE");
		
		given()
				.contentType("application/json")
				.body(data)
		.when()
		    .put("https://reqres.in/api/users/"+id)
		.then()
		    .statusCode(200)
		    .log().all();
		   
				
	}
	
	@Test(priority=4)
	void deleteUser() {
		given()
		.when()
		   .delete("https://reqres.in/api/users/"+id)
		.then()
		   .statusCode(204)
		   .log().all();
	}
	
	
	
	

}
