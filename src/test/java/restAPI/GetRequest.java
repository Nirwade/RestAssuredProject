package restAPI;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GetRequest {
	
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String Responsebody = response.body().asString();
		
		System.out.println(Responsebody);
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		Assert.assertTrue(Responsebody.contains("name"));
		
		JsonPath jpath= response.jsonPath();
		
		List<String > name = jpath.get("name");
		String frstname = name.get(0);
		
		System.out.println(" frst name is " +  frstname);
	
	
		}	
		 
	 // to fetch the list of names ---> List<String> names = japth.get("name");
       
      // System.out.println(names);

				
@Test	
private void test2() {
		
        RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		
		String Responsebody1 = response.body().asString();
		
		System.out.println(Responsebody1);
		
		int statuscode  = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		JsonPath jpath1= response.jsonPath();
	    ArrayList<String> ss  =jpath1.get("name");
		
		for ( String s : ss)
			
			System.out.println("list of names are " + s);
		
	}
			
	}
	
	
		
		
	


