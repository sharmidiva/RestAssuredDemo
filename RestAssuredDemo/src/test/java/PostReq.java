import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq {
	
	//for post-it will create and we need to send the body
	//here the body should be in json format
	//for that we should add libraries -dependencies
	
	@Test
	public void test1_POST1() {
		Map<String,Object> map=new HashMap<String,Object>();
		//here the collection works, as we need to post the values
		map.put("name","Sharmila");
		map.put("job","QA");
		System.out.println("Normal HashMap in key value pair="+map);
		
		//here json object is used 
		//JSONObject request= new JSONObject(map);
		
		//from the above we can change into by removing map
		JSONObject request= new JSONObject();
		request.put("name","David");
		request.put("job", "PL");
		System.out.println("Json Body Format=="+request);
		System.out.println("Convert into to String==="+request.toJSONString());
		
		//we need to import static restassured 
		
		//in the post we need to send the endpoint of postrequest
		System.out.println("Here the postrequest starts------->");
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201).
		log().all();//logs will add/fetch all the information where we can see in json format-craete/post
		}

}
