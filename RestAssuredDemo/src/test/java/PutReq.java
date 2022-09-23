import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutReq {
	@Test
	
	public void test1_put() {
		JSONObject request= new JSONObject();
		request.put("name","George");
		request.put("job", "PL");
		System.out.println("Json Body Format=="+request);
		System.out.println("Convert into to String==="+request.toJSONString());
		
		//we need to import static restassured 
		
		//in the post we need to send the endpoint of putrequest
		System.out.println("Here the putrequest starts------->");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).
		log().all();
	}
	@Test
	
	public void test2_patch() {
		JSONObject request= new JSONObject();
		request.put("name","Linsay");
		request.put("job", "BA");
		System.out.println("Json Body Format=="+request);
		System.out.println("Convert into to String==="+request.toJSONString());
		
		//we need to import static restassured 
		
		//in the post we need to send the endpoint of patchrequest
		System.out.println("Here the patchrequest starts------->");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).
		log().all();
	}
	
	@Test
	public void test3_del() {
		
		System.out.println("For delete request---->");
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204).
		log().all();
	}
	
	
	

}
