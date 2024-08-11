package day6JSONXMLSchemaValidationsSerialDEserilisation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Pojo --- Serilize ---> JSON Object --- de-serilize ---> Pojo
public class SerilizationDeserilization {
	
	//POJO -----------> JSON (Serilization)
	@Test
	void convertPojo2Json() throws JsonProcessingException {
		
		//created java object using pojo class
	//	Student stupojo = new Student(); //pojo
		
		
		Student_POJO stupojo=new Student_POJO();
		
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("1234567890");
		String courseArr[] = {"C", "C++"};
		stupojo.setCourses(courseArr);
		
		//convert java object -> json object (serilization)
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsondata);
		
	}
	
	//JSON -----------> POJO (De-Serilization)
		@Test
		void convertJson2Pojo() throws JsonProcessingException {
			
			String jsondata = "{\r\n"
					+ "  \"name\" : \"Scott\",\r\n"
					+ "  \"location\" : \"France\",\r\n"
					+ "  \"phone\" : \"1234567890\",\r\n"
					+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
					+ "}";
			//convert json data ---> Pojo object
			
			ObjectMapper objMapper = new ObjectMapper();
			
			Student_POJO stupojo = objMapper.readValue(jsondata, Student_POJO.class); //convert json to pojo
			
			System.out.println("Name: "+stupojo.getName());
			System.out.println("Location: "+stupojo.getLocation());
			System.out.println("Phone: "+stupojo.getPhone());
			System.out.println("Course 1: "+stupojo.getCourses()[0]);
			System.out.println("Course 2: "+stupojo.getCourses()[1]);
		}

}
