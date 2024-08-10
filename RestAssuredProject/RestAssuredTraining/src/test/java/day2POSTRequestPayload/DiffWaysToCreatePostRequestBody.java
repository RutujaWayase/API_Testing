package day2POSTRequestPayload;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

/*
Different ways to create POST request body
1) Post request body using Hashmap.
2) Post request body creating using Org.JSON
3) Post request body creating using POJO class
4) Post request using external json file data
*/


import org.testng.annotations.Test;

public class DiffWaysToCreatePostRequestBody {
	
	//1) POST request body using Hashmap
/*	
	//create method
	@Test(priority=1)
	void testPostusingHashmap() {
		HashMap data = new HashMap();
		
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "1234567890");
		
		String courseArr[] = {"C", "C++"};
		
		data.put("courses", courseArr);
		
		given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name", equalTo("Scott"))
		  .body("location", equalTo("France"))
		  .body("phone", equalTo("1234567890"))
		  .body("courses[0]", equalTo("C"))
		  .body("courses[1]", equalTo("C++"))
		  //verify header
		  .header("Content-Type", "application/json; charset=utf-8")
		  //print entire response body
		  .log().all();
		
	}
*/	

		
	//2) Post request body creating using Org.JSON
/*	
		//create method
		@Test(priority=1)
		void testPostusingJSONLibrary() {
			JSONObject data = new JSONObject();
			
			data.put("name", "Scott");
			data.put("location", "France");
			data.put("phone", "1234567890");
			
			String courseArr[] = {"C", "C++"};
			
			data.put("courses", courseArr);
			
			given()
			  .contentType("application/json")
			  .body(data.toString())
			.when()
			  .post("http://localhost:3000/students")
			.then()
			  .statusCode(201)
			  .body("name", equalTo("Scott"))
			  .body("location", equalTo("France"))
			  .body("phone", equalTo("1234567890"))
			  .body("courses[0]", equalTo("C"))
			  .body("courses[1]", equalTo("C++"))
			  //verify header
			  .header("Content-Type", "application/json") //;charset=utf-8")
			  //print entire response body
			  .log().all();
			
		}
*/		
		
		//3) Post request body creating using POJO class
	/*	
			//create method
			@Test(priority=1)
			void testPostusingPOJO() {
				Pojo_PostRequest data = new Pojo_PostRequest();
				//Pojo_PostRequest data = new Pojo_PostRequest();
				
				
				data.setName("Scott");
				data.setLocation("France");
				data.setPhone("1234567890");
				
				String courseArr[] = {"C", "C++"};
				
				data.setCourses(courseArr);
				 
				given()
				  .contentType("application/json")
				  .body(data)
				.when()
				  .post("http://localhost:3000/students")
				.then()
				  .statusCode(201)
				  .body("name", equalTo("Scott"))
				  .body("location", equalTo("France"))
				  .body("phone", equalTo("1234567890"))
				  .body("courses[0]", equalTo("C"))
				  .body("courses[1]", equalTo("C++"))
				  //verify header
				  .header("Content-Type", "application/json") //;charset=utf-8")
				  //print entire response body
				  .log().all();
				
			}
	*/		
		
	//4) Post request using external json file data
	
	//create method
	@Test(priority=1)
	void testPostusingExternalJSONFile() throws FileNotFoundException {
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		
		
		JSONTokener jt = new JSONTokener(fr);
		
		
		JSONObject data = new JSONObject(jt);
		
		 
		given()
		  .contentType("application/json")
		  .body(data.toString())
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name", equalTo("Scott"))
		  .body("location", equalTo("France"))
		  .body("phone", equalTo("1234567890"))
		  .body("courses[0]", equalTo("C"))
		  .body("courses[1]", equalTo("C++"))
		  //verify header
		  .header("Content-Type", "application/json") //;charset=utf-8")
		  //print entire response body
		  .log().all();
		
	}
	
	//Deleting student record
	@Test(priority=2)
	void testDelete() {
		  given()
		  .when()
		      .delete("http://localhost:3000/students/2b50")
		  .then()
		      .statusCode(200);
			  
	}

}
