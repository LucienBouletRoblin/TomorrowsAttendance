package com.TA.ressource;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.net.MediaType;

import io.restassured.RestAssured;

public class TestServiceRS {
	
	private String serviceURI = "/rs/service";

	@BeforeClass
	public static void configConnection(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
		RestAssured.basePath = "/TomorrowsAttendance";
	}
	
	@Test public void getAllServices() {
	    when().
        	get(this.serviceURI + "/allservices").
        then().
	        statusCode(200).
	        body("service", hasItems(1));
	}	
	
	@Test public void postNewService() {
		String serviceJson = "{\"date\":\"2015-02-17\",\"service\":2,\"customerCount\":26}";
		
		given().contentType("application/json").body(serviceJson).
	    when().
        	post(this.serviceURI).then().
	        statusCode(200);
	}	

}
