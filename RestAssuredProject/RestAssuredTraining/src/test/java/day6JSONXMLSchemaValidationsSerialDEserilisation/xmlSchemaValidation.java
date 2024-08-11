package day6JSONXMLSchemaValidationsSerialDEserilisation;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class xmlSchemaValidation {
	
	@Test
	void xmlSchemavalidation() {
		
		given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		  .assertThat().body(RestAssuredMatchers.matchesXsd("traveler.xsd"));
		;
		
	}

}
