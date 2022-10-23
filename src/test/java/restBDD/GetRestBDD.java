package restBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRestBDD {

	@Test
	public void test1 () {
		
		RestAssured.given()
		           .baseUri("http://localhost:3000/employees")
		           .when()
		           .get("/2")
		           .then()
		           .log()
		           .body()
		           .and()
		      .statusCode(200);
		           
		           
		
	}
	
@Test	
public void test2 () {
		
		RestAssured.given()
		           .baseUri("http://localhost:3000/employees")
		           .queryParam("id", "2")
		           .queryParam("name", "David")
		           .when()
		           .get("/2")
		           .then()
		           .log()
		           .body()
		           .and()
		      .statusCode(200)
		      .body("name", Matchers.equalTo("David"))
		      .body("salary", Matchers.equalTo("5000"));
		
}

public void test3 () {
	
	Response response = RestAssured.given()
			           .baseUri("http://localhost:3000/employees")
	                   .queryParam("id", "2")
	                   .queryParam("name", "David")
	                   .when()
	                   .get("/2");
	
	System.out.println(response.getBody().asString());
	JsonPath jpath = response.jsonPath();
	List<String> names = jpath.get("name");
	
	System.out.println(names.get(0));
	Assert.assertEquals(names.get(0), "David");
	
	String Header = response.getHeader("Content-Type");
	System.out.println(Header);
}

}
