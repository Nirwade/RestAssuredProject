package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReqWithFile {
	
@Test
	public void test7 () throws IOException {
	
	RestAssured.baseURI = "http://localhost:3000/employees";
	RequestSpecification request = RestAssured.given();
	
	
	byte[] Databytes= Files.readAllBytes(Paths.get("Data.json"));
	
	
	Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(Databytes).post("/create");
	
	String Responsebody = response.getBody().asString();
	
	System.out.println(Responsebody);
	
	int statuscode = response.getStatusCode();
	System.out.println(statuscode);
	
	Assert.assertEquals(statuscode, 201);
	
	JsonPath jpath1 = response.jsonPath();
	int empId = jpath1.get("id");
	
	System.out.println("emp id is " + empId);
	
	
	
		
		
	}
}
