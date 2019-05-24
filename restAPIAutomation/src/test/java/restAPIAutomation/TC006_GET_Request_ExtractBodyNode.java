package restAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Request_ExtractBodyNode {

	@Test
	public void getJSONResponse() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		JsonPath jsonpath = response.jsonPath();
		System.out.println("json path" + jsonpath);
		System.out.println("city value:   " + jsonpath.get("City"));
		jsonpath.get("Temperature");
		jsonpath.get("Humidity");
		jsonpath.get("WeatherDescription");

	}

}
