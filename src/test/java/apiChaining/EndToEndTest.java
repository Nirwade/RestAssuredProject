package apiChaining;

import java.util.ArrayList;
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

public class EndToEndTest {
	
	Response response;
	
    String BaseURI	= "http://localhost:3000/employees";
      
	
	@Test
	public void test1 () {
		
		
		response = GetMethodsAll ();
		Assert.assertEquals(response.getStatusCode(), 200);
	
		
		response= PostMethod("Shivaaya","40000");
		Assert.assertEquals(response.getStatusCode(), 201);
		JsonPath json = response.jsonPath();
    	int UpEmID	= json.get("id");
    	System.out.println("created id is  " + UpEmID);
    	
    	
    	response = PutMethod(UpEmID, "OOMShivaya", "41000");
    	Assert.assertEquals(response.getStatusCode(), 200);
    	json = response.jsonPath();
    	String upemname =json.get("name");
    	Assert.assertEquals(upemname, "OOMShivaya");
    	System.out.println("updated name is "+ upemname);
    	json = response.jsonPath();
        String salary= json.get("salary");
   	    System.out.println("updated salary is "+ salary);
   	    Assert.assertEquals(salary, "41000");
   	    
   	  
    	
   	response = DelMethod(UpEmID);
   	Assert.assertEquals(response.getStatusCode(), 200);
   	String ResponseBody = response.body().asString();
	System.out.println("Body is empty successfully deleted UpEmID " +ResponseBody);
	Assert.assertEquals(ResponseBody, "{}");
	
	response = GetUpdtedMethod(UpEmID);
	Assert.assertEquals(response.getStatusCode(), 404);
	
	 	   	
		
	}
	
	
	public Response GetMethodsAll () {
		
		 RestAssured.baseURI = BaseURI;
			
			RequestSpecification request = RestAssured.given();
			
			Response response = request.get();
			
			return response;
	}
	
	public Response PostMethod(String Name, String Salary) {
		
		RestAssured.baseURI = BaseURI;
		
        Map<String, Object> MapObj = new HashMap<String, Object> ();
		
		MapObj.put("name", Name);
		MapObj.put("salary", Salary);
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).post("/create");
			
	    return response;
	}
	    
	    public Response PutMethod (int UpEmID, String Name, String Salary) {
	    	
	    	RestAssured.baseURI = BaseURI ;
	    	
	    	JSONObject json = new JSONObject ();
	    	
	    	json.put("name", Name);
	    	json.put("salary", Salary);
	    	
	    	
	    	RequestSpecification request = RestAssured.given();
	    	
	    	Response response =  request.contentType(ContentType.JSON).accept(ContentType.JSON).body(json.toString()).put("/"+ UpEmID);
	    	
	    	return response;
	    	
	    }
	    
	    
   public Response DelMethod(int UpEmID ) {
	   
	   RestAssured.baseURI = BaseURI;
	   
       RequestSpecification request = RestAssured.given(); // send
    	
       Response response = request.delete("/" + UpEmID );
       
        return response;
    	
    }
   
   public Response GetUpdtedMethod (int UpEmID) {
	   
	   RestAssured.baseURI = BaseURI;
	   
	   RequestSpecification request  = RestAssured.given();
	  
	   Response response = request.get("/" + UpEmID );
	   
	   return response;
	   
   }
		
	}


