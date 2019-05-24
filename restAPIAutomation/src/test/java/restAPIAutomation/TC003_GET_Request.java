package restAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMaptest() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyAqnwfY0dGj-sQ_42tGMU_ih9e8PQeYpYE");

		// Extract body from response
		String responseBody = response.getBody().asString();
		System.out.println("RESPONSEBODY :=" + responseBody);

		
		//capture details of Content and Encoding header from response
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is :" + contentType);
		Assert.assertEquals(contentType, "application/json; charset=UTF-8");
		
		String ContentEncoding = response.header("Content-Encoding");
		System.out.println("ContentEncoding is :" + ContentEncoding);
		Assert.assertEquals(ContentEncoding, "gzip");
		
		
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
