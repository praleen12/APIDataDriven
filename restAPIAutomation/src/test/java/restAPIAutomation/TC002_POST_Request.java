package restAPIAutomation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	
	@Test
	public void registerCustomer() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParameters = new JSONObject();
		requestParameters.put("FirstName", "123P");
		requestParameters.put("LastName", "VBavan");
		requestParameters.put("UserName", "VBkmpavan");
		requestParameters.put("Password", "VBklpavan");
		requestParameters.put("Email", "VBTpavan@gmail.com");

		// Add header stating the request body is JSON
		request.header("Content-Type", "application/json");

		// Add json to the body of the request
		request.body(requestParameters.toJSONString());

		// Post the request and check the response
		Response response = request.post("/register");
		int responseStatusCode = response.getStatusCode();

		// Printing response
		System.out.println("RESPONSEBODY: " + response.body().asString());
		System.out.println("RESPONSECODE: " + responseStatusCode);

		// Validation the response status code
		Assert.assertEquals(responseStatusCode, 201);

		// validate response success code
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}


}
