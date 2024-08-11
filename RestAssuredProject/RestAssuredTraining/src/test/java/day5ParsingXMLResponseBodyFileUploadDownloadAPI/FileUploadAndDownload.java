package day5ParsingXMLResponseBodyFileUploadDownloadAPI;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	@Test(priority=1)
	void singleFileUpload() {
		 File myfile = new File("D:\\Automation\\API Testing\\API_Testing\\RestAssuredProject\\RestAssuredTraining\\Text1.txt");
			
		given()
		  .multiPart("file",myfile)
		  .contentType("multipart/form-data")
		.when()
		   .post("https://localhost:8080/uploadFile")
		.then()
		   .statusCode(200)
		   .body("fileName", equalTo("Test1.txt"))
		   .log().all();
		
	}
	
	@Test(priority=3)
	void multipleFileUpload() {
		 File myfile1 = new File("D:\\Automation\\API Testing\\API_Testing\\RestAssuredProject\\RestAssuredTraining\\Text1.txt");
		 File myfile2 = new File("D:\\Automation\\API Testing\\API_Testing\\RestAssuredProject\\RestAssuredTraining\\Text2.txt");	
		given()
		  .multiPart("files",myfile1)
		  .multiPart("files",myfile2)
		  .contentType("multipart/form-data")
		.when()
		   .post("https://localhost:8080/uploadMultipleFiles")
		.then()
		   .statusCode(200)
		   .body("[0].fileName", equalTo("Test1.txt"))
		   .body("[1].fileName", equalTo("Test2.txt"))
		   .log().all();
		
	}
	
	
	//Approach - using single array (won't work for all kinds of api)
	@Test(priority=4)
	void multipleFileUpload2() { //(won't work for all kinds of api) 
		 File myfile1 = new File("D:\\Automation\\API Testing\\API_Testing\\RestAssuredProject\\RestAssuredTraining\\Text1.txt");
		 File myfile2 = new File("D:\\Automation\\API Testing\\API_Testing\\RestAssuredProject\\RestAssuredTraining\\Text2.txt");	
		
		 
		 File filearr[] = {myfile1, myfile2};
		 
		 given()
		  .multiPart("files",filearr)
		  .contentType("multipart/form-data")
		.when()
		   .post("https://localhost:8080/uploadMultipleFiles")
		.then()
		   .statusCode(200)
		   .body("[0].fileName", equalTo("Test1.txt"))
		   .body("[1].fileName", equalTo("Test2.txt"))
		   .log().all();
		
	}
	
	// File Download
	@Test(priority=2)
	void fileDownload() {
		given()
		.when()
		  //.get("http://localhost:8080/downloadFile/Test1.txt")
		  .get("http://localhost:8080/downloadFile/Test2.txt")
		.then()
		  .statusCode(200)
		  .log().body();
	}

}
