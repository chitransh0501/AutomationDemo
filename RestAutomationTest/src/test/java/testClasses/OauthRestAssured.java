package testClasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OauthRestAssured {

	public static String token;

	@Test(description = "This is OAuth 1.0", enabled = false)
	public void postTweetByOAuth1() {
		Response res = RestAssured.given().auth().oauth("", "", "", "").post();// access token, secret access token, api
																				// key, api secret key.

		int statusCode = res.getStatusCode();

		assertTrue(statusCode == 200, "API is not authorized.");
	}

	@Test(description = "This is OAuth 2.0 ", dependsOnMethods = "generateAccessToken")
	public void postTweetByOAuth2() {
		/*
		 * Response res =
		 * RestAssured.given().auth().oauth2("fbbf190d658708eb5609d4fa0a4ef18304945ebb")
		 * .post("http://coop.apps.symfonycasts.com/api/401/chickens-feed");// token key
		 */

		Response res = RestAssured.given().auth().oauth2(token)
				.post("http://coop.apps.symfonycasts.com/api/401/chickens-feed");// token key

		System.out.println(res.getBody().asString());

		int statusCode = res.getStatusCode();

		assertTrue(statusCode == 200, "API is not authorized.");
	}

	@Test(description = "Generate Access token")
	public void generateAccessToken() {
		Response res = RestAssured.given().formParam("client_id", "AlokApp")
				.formParam("client_secret", "7ae8caefda4133828a4b27858cc821db")
				.formParam("grant_type", "client_credentials").post("http://coop.apps.symfonycasts.com/token");
		System.out.println(res.getBody().jsonPath().prettify());
		System.out.println(res.getBody().jsonPath().get("access_token"));
		token = res.getBody().jsonPath().get("access_token");
	}
}
