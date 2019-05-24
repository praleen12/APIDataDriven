package restAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getWeatherDetails() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Extract body from response
		String responseBody = response.getBody().asString();
		System.out.println("RESPONSEBODY :=" + responseBody);

		// Extract status code
		int statusCode = response.getStatusCode();
		System.out.println("STATUSCODE: = " + statusCode);

		// Extract status line
		String statusLine = response.getStatusLine();
		System.out.println("STATUSLINE: =" + statusLine);

		// validation
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		Assert.assertEquals(String.valueOf(statusCode), "200");

	}

}
