package testClasses;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.messages.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Example;

public class UnitTestClass {

	public static RequestSpecification REQUEST_SPECIFICATION;

	@Test(enabled = false)
	public void getAdvice() throws Exception {

		Response response = RestAssured.given().spec(getRequestSpecification()).when()
				.get("	https://api.adviceslip.com/advice/43");
		System.out.println(response.getBody().asString());

		Map<String, String> jsonObj = response.getBody().jsonPath().getMap("slip");

		Assert.assertEquals(jsonObj.get("advice").toString(), "Try to pay at least one person a compliment every day.",
				"Slip Advice does not match");

		/*
		 * response = RestAssured.given().spec(getRequestSpecification()).when().get(
		 * "http://192.168.51.122/PersonWebService/services");
		 * System.out.println(response.getBody().asString());
		 */
	}

	@Test(enabled = false)
	public void launchFacebook() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}

	public static RequestSpecification getRequestSpecification() {
		REQUEST_SPECIFICATION = new RequestSpecBuilder().addHeader("Accept", "Application/json").build();
		return REQUEST_SPECIFICATION;
	}

	@Test()
	public void getUserDetailsByPojo() throws Exception {

		Response response = RestAssured.given().spec(getRequestSpecification()).when()
				.get("https://reqres.in/api/users/2");

		System.out.println(response.getStatusCode());

		System.out.println(response.getBody().asString());

		ObjectMapper objectMapper = new ObjectMapper();
		Example example1 = null;
		try {
			example1 = objectMapper.readValue(response.getBody().asString(), Example.class);
			System.out.println(example1.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// By GSON library
		Gson gson = new Gson();

		Example example = gson.fromJson(response.getBody().asString(), Example.class);

		System.out.println(example.toString());
		System.out.println(example.getData().getEmail());
		System.out.println(example.getData().getFirst_name());
		System.out.println(example.getData().getLast_name());
		System.out.println(example.getData().getAvatar());
		System.out.println(example.getData().getId());

		// Assert.assertEquals(data.getFirst_name(), "janet.weaver@reqres.in");
	}

}
