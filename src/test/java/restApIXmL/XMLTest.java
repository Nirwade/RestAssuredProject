package restApIXmL;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		.baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}
	
	
	@Test
	public void test2 () {
		
    Response request =RestAssured.given()
		         .baseUri("https://chercher.tech/sample/api/books.xml")
		         .when()
		         .get();

 NodeChildrenImpl books =request.then().extract().path( "bookstore.book.title".toString());
 System.out.println("" + books);
 System.out.println("All books are --> " + books.toString());
 System.out.println("First book is --> " + books.get(0).toString());
 System.out.println("Second book is --> " + books.get(1).toString());
 
 NodeChildrenImpl authors =request.then().extract().path("bookstore.book.author".toString());
 System.out.println("All authors are --> " + authors.toString());
 System.out.println("First author is --> " + authors.get(0).toString());
 System.out.println("Second author is --> " + authors.get(1).toString());
 
 System.out.println("Language of firstbook" + books.get(0).getAttribute("lang"));
 
 for (String b:books  )  {
	 
	 System.out.println(b.toString());
 }
	                                                    //for(String i:books) {
                                                        //// System.out.println(i); 
   
  for (int index=0; index<authors.size(); index++) {
	     
	 System.out.println("All authors are --> " + authors.get(index).toString());
	 
  }
	                                                    // for(String b:books) {
	
                                                        // System.out.println(b.toString);
  NodeChildrenImpl price =request.then().extract().path("bookstore.book.price".toString());
  
  System.out.println("First price is --> " + price.get(0).children().get("paperback"));
  
  
  for (int pricelist=0; pricelist<price.size();pricelist++) {
	 
	  System.out.println("the prices are " + price.get(pricelist));
	  
  }
  
  




 
		
		
		
		
		
	}

}
