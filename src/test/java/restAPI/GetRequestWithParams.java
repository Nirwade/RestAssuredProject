package restAPI;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParams {
	
	
	@Test
	public void test3 () {
	
	RestAssured.baseURI = "http://localhost:3000/employees";
	
	RequestSpecification request = RestAssured.given();
	
	Response response = request.param("id", "1").get();
	
	String responsebody = response.getBody().asString();
			
	System.out.println(responsebody);
	
	int responsecode = response.getStatusCode();
	
	Assert.assertEquals(responsecode, 200);
	
	Assert.assertTrue(responsebody.contains("Sharaswathi"));
	
	JsonPath jpath = response.jsonPath();
	
	List<String> name = jpath.get("name");
	System.out.println(name.get(0));
	   name.listIterator(0);
	
	String empName =(name.get(0));
	
	Assert.assertEquals(empName, "Sharaswathi");
	
	String Headeresponsekey =response.getHeader("Content-Type");
	
	System.out.println("Header response value is  " + Headeresponsekey);
	
	
	Iterable<Header> s = response.getHeaders(); // to iterate thought all the header values
	
	System.out.println(s);
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	

