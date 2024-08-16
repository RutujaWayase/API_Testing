package day8RestAssuredAPIChaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	void tes_createUser(ITestContext context) {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken= "2de06d40c356b208bb004eb687b3d13d53b90329945e763c3a1710890ec9025a";
		
		//Response res = given()
		int id = given()
		  .header("Authorization", "Barer " + bearerToken)
		  .contentType("application/json")
		  .body(data.toString())
		.when()
		   .post("https://gorest.co.in/public/v2/users")
		   .jsonPath().getInt("id");
		   //;
		
		//System.out.println("Generated response is: "+res);
		System.out.println("Generated id is: "+id);
		
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}

}
