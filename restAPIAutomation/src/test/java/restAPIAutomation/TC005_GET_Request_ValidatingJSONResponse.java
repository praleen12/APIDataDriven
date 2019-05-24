package restAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_ValidatingJSONResponse {
	
	@Test
	public void getJSONResponse() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Hyderabad");

		// Extract body from response
		String responseBody = response.getBody().asString();
		System.out.println("RESPONSEBODY :=" + responseBody);

		
		Assert.assertTrue((responseBody.contains("Hyderabad")));

		
	}

}
