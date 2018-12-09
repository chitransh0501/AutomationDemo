package testClasses;



import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UnitTestClass {

	public static RequestSpecification REQUEST_SPECIFICATION;

	@Test()
	public void getAdvice() throws Exception {

		Response response = RestAssured.given().spec(getRequestSpecification()).when()
				.get("	https://api.adviceslip.com/advice/43");
		System.out.println(response.getBody().asString());

		Map<String, String> jsonObj = response.getBody().jsonPath().getMap("slip");

		Assert.assertEquals(jsonObj.get("advice").toString(), "Try to pay at least one person a compliment every day.", "Slip Advice does not match");

		/*
		 * response =
		 * RestAssured.given().spec(getRequestSpecification()).when().get(
		 * "http://192.168.51.122/PersonWebService/services");
		 * System.out.println(response.getBody().asString());
		 */
	}

	@Test()
	public void launchFacebook() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:/seleniumAlok/chromedriver.exe");
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
}
