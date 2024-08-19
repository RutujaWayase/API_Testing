package api.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
User userPayload;
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String mail, String pass, String ph){
		
		userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(mail);
		userPayload.setPassword(pass);
		userPayload.setPhone(ph);
	
		Response res = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2, dataProvider = "UserName", dataProviderClass = DataProviders.class)
	public void testGetUserByName(String userName) {
		
		Response res = UserEndPoints.readUser(userName);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3, dataProvider = "UserName", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response res = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
