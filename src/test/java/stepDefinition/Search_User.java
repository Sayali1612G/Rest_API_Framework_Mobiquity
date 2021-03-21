package stepDefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.simple.JSONObject;
import com.jayway.jsonpath.Configuration;
import ReusableFunctions.ConfigFileReader;
import ReusableFunctions.Log;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONArray;

/**
 * <h1> Testing a User Search REST API with Get methods</h1>
 * @author SayaliGulhane
 * @version 1.0
 * @since 2021-20-03
 */

public class Search_User {

	private static Response response_RestAssured;
	private static JsonPath jsonPathEvaluator;
	private static ResponseBody body;
	private static Response response;

	ConfigFileReader configFileReader = new ConfigFileReader();

	@Before
	public static void setup() {
		// This is to start the Log4j logging in the test case
		DOMConfigurator.configure("log4j.xml");
	}
	/**
	 * This method is to search users details

	/**
	 * @param Path
	 * @param username
	 */

	@When("User will search for a user details with {string} , {string}")
	public void user_will_search_for_a_user_details_with(String Path, String username) {
		 
		 
		  RestAssured.baseURI = configFileReader.getValue("BASE_URI"); 
		  RequestSpecification httpRequest = RestAssured.given(); 
		  response = httpRequest.get(Path);
		  String statusLine = response.getStatusLine();
		}

	/**
	 * This method is to validate users details
	 
	/**
	 * @param statusCode
	 * @param content_Type
	 * @param emailid
	 * @param name
	 */

	
	@Then("User will Verify the user details as {int} , {string} , {string} and {string}")
	public void user_will_Verify_the_user_details_as_and(Integer statusCode, String content_Type, String emailid, String name) {
		
		
		Log.info("Successfully verify the StatusCode which is : " + response.getStatusCode());
		
		/**
		 * checking only users body details
		 */
		System.out.println("name "+ name + "email" + emailid);
		if ((response.asString().contains(name)) & (response.asString().contains(emailid))) {
			System.out.println(" ****  User : " + name + " is authorized user with valid Email id : " + emailid + "  ****");
			Log.info(" ****  User : " + name + " is authorized user with valid Email id : " + emailid + " ****");
		}
		else {
			System.out.println(" ****  User : " + name + " is not authorized user with Email id : " + emailid + "  ****");
			Log.info(" ****  User : " + name + " is not authorized user with Email id : " + emailid + " ****");
			assertEquals(response.asString().contains(name),false);
			assertEquals(response.asString().contains(emailid),false);
		}
		
		/**
		 * This method is to validate email details
		 
		/**
		 * @param Email
		 */
		
		 if(response.getStatusCode()==200) {
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 String email = jsonPathEvaluator.get("email");
		 if (email.contains("@dana.io") ) {
			 Log.info(" ****  User is having valid email added : " + email ); 
		 }
		 else {
			 Log.info(" ****  User is having invalid email added : " + email ); 
			 assertEquals(email.contains("@dana.io") , false);
		 	}
		 }
	 }
}