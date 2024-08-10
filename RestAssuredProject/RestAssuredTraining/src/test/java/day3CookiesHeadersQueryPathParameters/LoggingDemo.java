package day3CookiesHeadersQueryPathParameters;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test(priority=1)
	void testLogs() {
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		  //.log().body()
		  //.log().cookies() //to print only cookies from the response
		  //.log().headers() //to print only headers in response
		  .log().all(); //to print all the logs in response
	}

}
