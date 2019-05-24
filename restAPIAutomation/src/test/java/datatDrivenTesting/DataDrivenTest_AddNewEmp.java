package datatDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmp {

	
//	public void postaddNewEmp() {
//
//		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
//
//		RequestSpecification httpRequest = RestAssured.given();
//
//		// Here we created data which we can send along wiht post request
//		JSONObject requestParam = new JSONObject();
//
//		requestParam.put("name", "leena");
//		requestParam.put("salary", "34500");
//		requestParam.put("age", "32");
//
//		// Add header starting the request body is json
//		httpRequest.header("Content-Type", "application/json");
//
//		// Add the Json to the body of the request
//		httpRequest.body(requestParam.toJSONString());
//
//		// post request send
//		Response respons = httpRequest.request(Method.POST, "/create");
//
//		// capture response body to perform validations
//		String responsebody = respons.getBody().asString();
//
//		Assert.assertEquals(responsebody.contains("leena"), true);
//		Assert.assertEquals(responsebody.contains("34500"), true);
//		Assert.assertEquals(responsebody.contains("32"), true);
//
//		int statusCode = respons.getStatusCode();
//
//		Assert.assertEquals(statusCode, 200);
//
//	}
	
	@Test(dataProvider = "empDataProvider")
	public void postNewEmployee(String ename, String salary, String age) {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Here we created data which we can send along wiht post request
		JSONObject requestParam = new JSONObject();

		requestParam.put("name", ename);
		requestParam.put("salary", salary);
		requestParam.put("age", age);

		// Add header starting the request body is json
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParam.toJSONString());

		// post request send
		Response respons = httpRequest.request(Method.POST, "/create");

		// capture response body to perform validations
		String responsebody = respons.getBody().asString();

		System.out.println("RESPONSE BODY IS:" + responsebody);

		Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(salary), true);
		Assert.assertEquals(responsebody.contains(age), true);

		int statusCode = respons.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@DataProvider(name = "empDataProvider")
	public String[][] getEmpData() throws IOException {
		
		
		//Read data from Excel
		String path = System.getProperty("user.dir")+ "/src/test/java/datatDrivenTesting/EmpData.xlsx";
		
		int rowsnum = XUtil.getRowCount(path, "Sheet1");
		int colcount = XUtil.getCellCount(path, "Sheet1", 1);
		
		String empdata[][]=new String[rowsnum][colcount];
		for(int i= 1; i<=rowsnum; i++) {
			for(int j=0; j<colcount; j++) {
				empdata[i-1][j] = XUtil.getCellData(path, "Sheet1", 1, j);
			}
		}
		
		
		
		
		
//		String empdata[][] = { { "meena", "3000", "45" }, { "Tom", "3400", "55" }, { "Harry", "5000", "25" } };
		return (empdata);
	}

}
