package restAPI;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test3 () {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response  = request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\r\n"
				
				+ "    \"name\": \"Bajaaj\",\r\n"
				+ "    \"salary\": \"38000\"\r\n"
				+ "}").post("/create");
		
	String 	ResponseBody =response.getBody().asString();
	System.out.println(" Response body is "+ ResponseBody);
	
	int statuscode = response.getStatusCode();
	System.out.println(statuscode);
	
	Assert.assertEquals(statuscode, 201);
	
	JsonPath jpath1 = response.jsonPath();
	int empId = jpath1.get("id");
	
	System.out.println("emp id is " + empId);
	
	
	
		
		
		
	}

}
