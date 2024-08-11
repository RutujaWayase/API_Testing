package day6JSONXMLSchemaValidationsSerialDEserilisation;


//import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

//json -> jsonschema converter
// https://www.liquid-technologies.com/online-json-to-schema-converter

public class JSONSchemaValidation {
	
	@Test(priority=1)
	void JSONschemavalidation() {
		
		given()
		.when()
		  .get("http://localhost:3000/store")
		.then()
//		  .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJSONSchema.json"));
		 // .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJSONSchema.json"));
		;
	}

}
