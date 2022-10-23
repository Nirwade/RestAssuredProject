package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRestBBD {
	
	@Test
	public void test1 () {
		
		Map<String,Object> Mobj = new HashMap<String,Object>();
		Mobj.put("name", "Danny");
		Mobj.put("salary", "700000");
	
	  RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Mobj)
		.when()
		.post("/create")
		.then()
		.log()
		.body()
		.statusCode(201)
		.body("name", Matchers.equalTo("Danny"))
		.body("salary", Matchers.equalTo("700000"));
		
		
		
		
		
	}

}
