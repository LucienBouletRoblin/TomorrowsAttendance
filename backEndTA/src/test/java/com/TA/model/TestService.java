package com.TA.model;

import java.util.Date;
import org.junit.Test;

public class TestService {
	
	@SuppressWarnings("unused")
	private Service service;
	
	//public Service(Long service, Date date, Long customerCount) 	
	
	@Test(expected = NullPointerException.class)
	public void test_NullService() {
		service = new Service(null, new Date(), 1L);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_NullDate() {
		service = new Service(1L, null, 1L);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_NullCustomerCount() {
		service = new Service(1L, new Date(), null);
	}

}

