package com.TA.ressource;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.net.MediaType;

import io.restassured.RestAssured;

public class TestServiceRS {

	@BeforeClass
	public static void configConnection(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
		RestAssured.basePath = "/TomorrowsAttendance";
	}
	
	@Test public void getAllServices() {
	    when().
        	get("/allservices").
        then().
	        statusCode(200).
	        body("service", hasItems(1));
	}	
	
	@Test public void postNewService() {
		String serviceJson = "{\"date\":\"1968-11-16T00:00:00\",\"service\":2,\"customerCount\":26}";
		String serviceURI = "/rs/service";
		
		given().contentType("application/json").body(serviceJson).
	    when().
        	post(serviceURI);
	}	

}
