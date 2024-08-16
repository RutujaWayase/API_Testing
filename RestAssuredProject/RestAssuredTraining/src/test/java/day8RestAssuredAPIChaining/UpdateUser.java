package day8RestAssuredAPIChaining;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class UpdateUser {
	
	@Test
	void test_updateUser(ITestContext context) {
    
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken= "2de06d40c356b208bb004eb687b3d13d53b90329945e763c3a1710890ec9025a";
		
		//int id=0;
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		given()
		  .header("Authorization", "Barer " + bearerToken)
		  .contentType("application/json")
		  .pathParam("id", id)
		  .body(data.toString())
		.when()
		   .put("https://gorest.co.in/public/v2/users/{id}")
		.then() //.statusCode(200)
		  .statusCode(200)
		  .log().all();
		;
	}

}
