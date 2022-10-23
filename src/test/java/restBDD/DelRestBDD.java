package restBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DelRestBDD {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.delete("/68")
		.then()
		.log()
		.body()
		.statusCode(200);
		//.body("name", Matchers.equalTo("null"));
		
		
	}

}
