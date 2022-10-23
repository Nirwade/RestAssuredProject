package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PutRequest {
	
	@Test
	public void Put () {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> MapObj = new HashMap<String, Object>();
		MapObj.put("name", "Surajj");
		MapObj.put("Salary", "36000");
		
	Response response =	request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).put("/1");
	String Responsebody = response.getBody().asString();
	System.out.println(Responsebody);
	
	int statuscode = response.getStatusCode();
	System.out.println(statuscode);
	
	
	Assert.assertEquals(statuscode, 200);
	
	JsonPath json1 = response.jsonPath();
	
	int UpdatedEM = json1.get("id");
	System.out.println(" Updated Em-id is  " + UpdatedEM);
	
	
		
	 
		
		
		
	}

}
