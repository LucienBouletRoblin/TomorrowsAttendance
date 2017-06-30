package com.TA.ressource;

import static io.restassured.RestAssured.when;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class TestServiceRS {

	@BeforeClass
	public static void configConnection(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
		RestAssured.basePath = "/TomorrowsAttendance";
		//RestAssured.authentication = basic("lu", "lu");
		//RestAssured.useRelaxedHTTPSValidation();
	}
	
	@Test public void ServiceRS() {
		   
	    when().
        	get("/allservices").
        then().
	        statusCode(200);

	}
	

}
