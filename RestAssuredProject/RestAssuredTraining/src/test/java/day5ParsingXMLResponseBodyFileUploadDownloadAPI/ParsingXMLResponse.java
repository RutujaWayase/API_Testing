package day5ParsingXMLResponseBodyFileUploadDownloadAPI;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {
	
	@Test(priority=1)
	void testXMLResponse() {
		//Approach 1
	/*	
		given()
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		   .statusCode(200)
		  // .header("Content-Type", "text/html; charset=us-ascii")
		   .header("Content-Type", "application/xml")
		   .body("TravelerinformationResponse.page", equalTo("1"))
		   .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay Bharat Reddy"))
		   
		   ;
	*/
		
		//Aproach 2
		
		Response res = given()
				.when()
				  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(res.getStatusCode(), 200 );
		Assert.assertEquals(res.header("Content-Type"), "application/xml");
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String travelName = res.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travelName, "Vijay Bharat Reddy");
	}
	
	@Test(priority=2)
	void testXMLResponseBody() {
		
		
		Response res = given()
				.when()
				  .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xmlobj = new XmlPath(res.asString());
		
		
		//Verify total number of travelers
		List<String> travelers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travelers.size(), 10);
		
		//Verify traveler name is present in response
		List<String> traveler_names = xmlobj.getList("TravelerinformationResponse.travellers.Travelerinformation.name");
		
		boolean status=false;
		for(String travelername:traveler_names) {
			//System.out.println(travelername);
			if(travelername.equals("Vijay Bharat Reddy")) {
				status=true;
				break;
			}
		}
		
		
		Assert.assertEquals(status, true);
		
		;
	}


}
