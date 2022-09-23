package postDDframework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class PostReqddt  extends Base{
	

	
	
	
	
	@Test(dataProvider="postddt")
	
	public void test_post(String name,String job) {
		
	
		
	
		
		JSONObject request=new JSONObject();
		logger.info("getting name from excel file");
		request.put("name",name);
		logger.info("getting job from excel file");
		request.put("job", job);
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
		log().all();
		
	}
	
	@DataProvider(name="postddt")
	String[][] getdata() throws IOException{
		String path="/Users/sharmi/eclipse-workspace/RestAssuredDemo/src/test/java/utilities/PostDDT.xlsx";
		int rownum=ReadFromExcel.getRowCount(path, "Sheet1");
		int colcount=ReadFromExcel.getCellCount(path, "Sheet1", 1);
		String postddt[][]=new String[rownum][colcount]; 
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++ ) {
				postddt[i-1][j]=ReadFromExcel.getCellData(path, "Sheet1", i, j);//1  0
			}
		}
		return postddt;//return the name of dataprovider
		
	}

}
