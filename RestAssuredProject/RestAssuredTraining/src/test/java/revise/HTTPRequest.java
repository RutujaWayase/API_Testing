package revise;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class HTTPRequest {
	@Test
	void getUsers() {
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .statusCode(200)
		   .body("page", equalTo(2))
		   .log().all();
	}

}
