package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRestBDD {
	
	@Test
	public void Test1() {
		
		Map <String,Object> Mobj =new HashMap <String,Object>();
		Mobj.put("name", "Danel");
		Mobj.put("salary", "8000000");
	
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Mobj)
		.when()
		.put("/68")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("name", Matchers.equalTo("Danel"))
		.body("salary", Matchers.equalTo("8000000"));
		
		
	
		
	}

}
