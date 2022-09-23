package postDDframework;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class Base {
	public static Logger logger;
	@BeforeClass
	public void setup() {
		System.out.println("Setuppp for logger");
		logger=Logger.getLogger("RestAssured-Loggers");
		PropertyConfigurator.configure("/Users/sharmi/eclipse-workspace/RestAssuredDemo/src/test/java/utilities/log4j.properties");
	}
}	
