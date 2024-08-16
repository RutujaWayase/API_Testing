package day8RestAssuredAPIChaining;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	void test_getUser(ITestContext context) {
		
		//int id = 0; // this should come from createuser request
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		String bearerToken = "2de06d40c356b208bb004eb687b3d13d53b90329945e763c3a1710890ec9025a";
	
		given()
		  .headers("Authorization", "Bearer "+ bearerToken)
		  .pathParam("id", id)
		.when()
		  .get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		   .statusCode(200)
		   .log().all();
	}

}
