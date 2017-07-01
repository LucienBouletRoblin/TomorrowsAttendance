package com.TA.model;

import java.time.LocalDate;

import org.junit.Test;

public class TestService {
	
	@SuppressWarnings("unused")
	private Service service;
	private LocalDate date = LocalDate.now();
	
	@Test(expected = NullPointerException.class)
	public void test_NullService() {
		service = new Service(null, date, 1L);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_NullDate() {
		service = new Service(1L, null, 1L);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_NullCustomerCount() {
		service = new Service(1L, date, null);
	}
	
}

