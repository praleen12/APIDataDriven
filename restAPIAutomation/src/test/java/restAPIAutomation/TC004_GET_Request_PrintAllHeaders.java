package restAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_PrintAllHeaders {

	@Test
	public void GetHeaderDetails() {

		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,
				"/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyAqnwfY0dGj-sQ_42tGMU_ih9e8PQeYpYE");

		// Extract body from response
		String responseBody = response.getBody().asString();
		System.out.println("RESPONSEBODY :=" + responseBody);

		Headers allheaders = response.headers();
		for (Header header : allheaders) {
			System.out.println(header.getName() + " " + header.getValue());
		}

	}

}
