package day7TypesOfAuthorizationsFakerLibrary;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


/*
Authentication - valid or not
Authorization - access

Types of Authentication:
	1) Basic
    2) Digest
    3) Preemptive
    4) Bearer token
    5) OAuth 1.0, 2.0
    6) API Key

*/



public class Authentications {
	
	
	@Test(priority=1)
	void testBasicAuthentication() {
		given()
		  .auth().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();	
	}
	
	@Test(priority=2)
	void testDigestAuthentication() {
		given()
		  .auth().digest("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	//Preemptive Authentication: is a combination of Basic and Digest Authentication.

	@Test(priority=3)
	void testPreemptiveAuthentication() {
		given()
		  .auth().preemptive().basic("postman", "password")
		.when()
		  .get("https://postman-echo.com/basic-auth")
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
	}
	
	@Test(priority=4)
	void testBearerTokenAuthentication() {
		String bearerToken= "token id";

		given()
		  .header("Authorization", "Bearer"+bearerToken)
		.when()
		  //.get("https://api.github.com/user/repos")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}

}
