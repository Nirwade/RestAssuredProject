package gitHub;

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

public class EndToEndGitTest {
	
	Response response;
	
	String BaseURI = "https://api.github.com/users/Nirwade/repos";
	
	String token = "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";
	
	@Test
	public void Test2 () throws IOException {
		
		response = GetReqAll ();
		
		String ResponseBody = response.getBody().asString();
		System.out.println(" The responsebody is " +ResponseBody); 
		int Statuscode = response.getStatusCode();
		Assert.assertEquals(Statuscode, 200);
		System.out.println("status code successful " + Statuscode );
		
		
		
		
		response = PostReqAll();
		
		int Statuscode1 = response.getStatusCode();
		Assert.assertEquals(Statuscode1, 201);
		JsonPath jpth = response.jsonPath();
		String des = jpth.get("desription");
		System.out.println("description is " + des);
		
		
		
	}
	
	
	
	public Response GetReqAll () {
		
		RestAssured.baseURI = BaseURI;
		
		RequestSpecification request = RestAssured.given();
		 
	    Response response = request.get();
	
	    return response;
	
		
	}
	
	public Response PostReqAll () throws IOException {
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		
		byte[] DataBytes = Files.readAllBytes(Paths.get("GitData"));
		
		Response response = request.auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).body(DataBytes).post();
		return response;
		
	}

}
