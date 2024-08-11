package day4ParsingResponseBodyJSONObject;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {
	
	@Test(priority=1)
	void testJSONResponse() {
		
		//Approach 1
	/*	
		given()
		  .contentType("ContentType.JSON")
		.when()
		  .get("http://localhost:3000/store")
		.then()
		  .statusCode(200)
		  .header("Content-Type", "application/json") //; charset=utf-8")
		  //find JSON Path from https://jsonpathfinder.com/ 
		  .body("book[3].title", equalTo("The Lord of the Rings"))
		  ;
	*/	
		//Approach 2 => Capture entire response in one variable
		
		Response res = given()
		  //.contentType("ContentType.JSON")
				.contentType(ContentType.JSON)
		.when()
		  .get("http://localhost:3000/store");
		
		//res.getStatusCode()
		Assert.assertEquals(res.getStatusCode(), 200) ; //validation 1
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");

	}
	
	
	@Test(priority=2)
	void testJSONResponsebodyData() {
	
		
		Response res = 
		given()
		  .contentType(ContentType.JSON)
		.when()
		  .get("http://localhost:3000/store");
	/*	
		//res.getStatusCode()
		Assert.assertEquals(res.getStatusCode(), 200) ; //validation 1
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");
   */
		
		//JSONObject class
		JSONObject jo = new JSONObject(res.toString()); //converting response to json object type
	/*	
		for(int i=0; i<jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
	*/
		
		//search for title of book in json - validation 1
		boolean status=false;
		
		for(int i=0; i<jo.getJSONArray("book").length(); i++) {
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(bookTitle.equals("The Lord of the Rings"))
			{
				status=true;
				break;
			}
		
			
		}
		
		Assert.assertEquals(status, true);
	/*
		if(status==false) {
			//not found
			
		}
	*/
		
		
		//validating total price of books - validation 2
		double totalprice=0;
		for(int i=0; i<jo.getJSONArray("book").length(); i++) {
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString()  ;
			
			totalprice = totalprice + Double.parseDouble(price);
		
			
		}
		
		System.out.println("total price of book is:"+totalprice);
		Assert.assertEquals(totalprice, 53.92);
	}

}
