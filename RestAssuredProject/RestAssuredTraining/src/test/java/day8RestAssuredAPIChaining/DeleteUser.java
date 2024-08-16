package day8RestAssuredAPIChaining;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	void test_deleteUser(ITestContext context) {
		
		String bearerToken= "2de06d40c356b208bb004eb687b3d13d53b90329945e763c3a1710890ec9025a";
		
		
		//int id =0;
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		
		given()
		  .headers("Authorization","Bearer "+bearerToken)
		  .pathParam("id", id)
		.when()
		  .delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		  .statusCode(200)
		  .log().all();
		
	}

}
