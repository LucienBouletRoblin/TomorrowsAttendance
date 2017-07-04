package com.TA.ressource;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.TA.model.Service;

import io.restassured.RestAssured;

@ManagedBean
public class TestServiceRS extends EJBTest{
	
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
		String serviceJson = "{\"date\":\"2017-07-09T22:00:00.000Z\",\"service\":2,\"customerCount\":26}";
		
		given().contentType("application/json").body(serviceJson).
	    when().
        	post(this.serviceURI).then().
	        statusCode(200);
		
	}
	
	@Test
	public void persistService() throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {	
		assertEquals(0L, em.createNativeQuery("Select COUNT(*) FROM service").getSingleResult());
		Service service = new Service(1L, LocalDate.now(), 26L);
	    tx.begin();
		em.persist(service);
	    tx.commit();
		assertEquals(1L, em.createNativeQuery("Select COUNT(*) FROM service").getSingleResult());
	}
	

}
