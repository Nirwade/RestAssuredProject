package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReqWithMap {

	@Test
	public void test6 () {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		
		
		Map<String, Object> MapObj = new HashMap <String, Object>();
		
		MapObj.put("name", "Gerg");
		MapObj.put("salary", "55000");
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).post("/create");
		
		String Responsebody = response.getBody().asString();
		
		System.out.println(Responsebody);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		Assert.assertEquals(statuscode, 201);
		
		JsonPath jpath1 = response.jsonPath();
		int empId1 = jpath1.get("id");
		
		System.out.println("emp id is " + empId1);
		
		
		
		
	}
}
