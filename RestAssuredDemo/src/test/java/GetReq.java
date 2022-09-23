import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetReq {
	
	@Test
	
	void test1_get1(){
		//Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		// we can change the above line by removing RestAssured 
		
		
		// we can directly get method by changing static import and add.* in the end or
		//import static io.restassured.RestAssured.*;
		
		
		//that was used in test2_GET()
		Response response=get("https://reqres.in/api/users?page=2");

		System.out.println("Get Body==>"+response.getBody());
		System.out.println(" Response body  string==>"+response.asPrettyString());
		System.out.println("Content type==>"+response.getContentType());
		System.out.println("Status Code==>"+response.getStatusCode());
		System.out.println("Getting header="+response.getHeader("content-type"));
		System.out.println("Status Lin====>"+response.getStatusLine());
		
		int statuscode=response.getStatusCode();
		
		AssertJUnit.assertEquals(statuscode,200);
		}
	@Test
	
	public void test2_get2(){
		

		// we can directly get method by changing static import and add.* in the end or
		//import static io.restassured.RestAssured.*;
		//to use without using RestAssured , we should import the above line
		
		given()
		.header("Content-Type","application/json")
		
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]",equalTo(8))
		.body("data.first_name",hasItems("Michael","Lindsay"))
		//here checks for value 
		
		//to check with data.id[0]===it will fetch the index 0 value
				//for that we should add import static hamcrest matchers  from the below webpage
				//https://github.com/rest-assured/rest-assured/wiki/usage--static imports
				////import static org.hamcrest.Matchers.*;
		
		//{"id":7,"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":
		//"https://reqres.in/img/faces/7-image.jpg"}
		.log().all();
		
	}
	
	
	
	
	
	
	
	@Test(enabled=true)
	
	void test2_GETdatahamcrest() {
		//given().get().then().statusCode(200);-it can be write it in 1 single line or 
		//same thing we can do changes also by formatting in 1 order
		
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]",equalTo(7));
	
		//to check with data.id[0]===it will fetch the index 0 value
		//for that we should add import static hamcrest matchers  from the below webpage
		//https://github.com/rest-assured/rest-assured/wiki/usage--static imports
		////import static org.hamcrest.Matchers.*;
		
		
	}
	

	

}
