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
	
	@Test(priority=5)
	void testOAuth1Authentication() {
		given()
		  .auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecrate ") //this is for OAuth 1.0 authentication
		.when()
		  .get("url")
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(priority=6)
	void testOAuth2Authentication() {
		given()
		  .auth().oauth2("ghp_24pH....") //access token  
		.when()
		   .get("https://api.github.com/user/repos")
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	@Test(priority=7)
	void testAPIKeyAuthentication() {
		
		//Method 1
	/*
		given()
		 .queryParam("appid", "440baa7b154f693e1bee2cac80a48561") //appid is APIKey
		.when()
		  //.get("https://api.openweathermap.org/data/2.5/forecast/daily?lat=57&lon=-2.15&appid={API key}")
		  .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
		  .statusCode(200)
		  .log().all();
	*/
		//Method 2
		//https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7
		given()
		  //.queryParam("appid", "440baa7b154f693e1bee2cac80a48561")
		.queryParam("appid", "token value")
		  .pathParam("mypath", "data/2.5/forecast/daily")
		  .queryParam("q", "Delhi")
		  .queryParam("units", "metric")
		  .queryParam("cnt", "7")
		.when()
		  .get("https://api.openweathermap.org/{mypath}")
		.then()
		  .statusCode(200)
		  .log().all();
	}

}
