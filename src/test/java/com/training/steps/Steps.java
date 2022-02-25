package com.training.steps;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Steps {
	String UriLogin,UriGetData;
	Response response;
	static String token;
	
	@Given("Set the EndPoint")
	public void set_the_end_point() {
		UriLogin="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login";
	}

	@When("Send Post HTTP request")
	public void send_post_http_request() {
		 response=	RestAssured.
				given().
				contentType(ContentType.JSON).
				body("{\"username\":\"mithun@ta.com\",\"password\":\"mithun\"}").
				when().post(UriLogin);
	}

	@Then("Validate the response")
	public void validate_the_response() {
		System.out.println("1st tc executing");
	   response.prettyPrint();
	   response.then().assertThat().statusCode(201);
	   response.then().assertThat().contentType(ContentType.JSON);
	   response.then().assertThat().time(Matchers.lessThan(5000L));
	   token=response.jsonPath().get("[0].token");
	}
	
	
	
	@Given("Set the EndPoint_GatData")
	public void set_the_end_point_gat_data() {
	   UriGetData="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata";
	}

	@When("Send Get HTTP request")
	public void send_get_http_request() {
		Header header1=new Header("token",token);
		response=	RestAssured.
				given().
				header(header1).
				when().get(UriGetData);
	}

	@Then("Validate the response for getData")
	public void validate_the_response_for_get_data() {
		System.out.println("2nd tc executing");
	  System.out.println(response.jsonPath().get("$.size()"));
	  response.then().assertThat().statusCode(200);
	  response.then().assertThat().contentType(ContentType.JSON);
	  response.then().assertThat().time(Matchers.lessThan(5000L));
	}

}