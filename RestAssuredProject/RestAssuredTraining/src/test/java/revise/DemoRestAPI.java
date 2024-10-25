package revise;

//import org.testng.annotations.Test;
//import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class DemoRestAPI {
	@Test
	void testAPI() {
	//RestAssured.baseURI = "https://petstore.swagger.io/";
	given()
	.when()
	 .get("https://petstore.swagger.io/")
	.then();
}

}
