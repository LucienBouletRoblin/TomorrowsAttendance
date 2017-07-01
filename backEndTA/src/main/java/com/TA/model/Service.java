package com.TA.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.util.LocalDateDeserializer;
import com.util.LocalDateSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "service")
@NamedQuery(name = "service.findAll", query = "SELECT t FROM Service t")
public class Service implements Serializable {
	
		private static final long serialVersionUID = 4046352721505678179L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Long service;
		
		@JsonDeserialize(using = LocalDateDeserializer.class)
	    @JsonSerialize(using = LocalDateSerializer.class)
		private LocalDate date;
		
		private Long customerCount;

		public Service() {}

		public Service(Long service, LocalDate date, Long customerCount) {

			this.setService(service);
			this.setLocalDate(date);
			this.setCustomerCount(customerCount);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getService() {
			return service;
		}

		public void setService(Long service) throws NullPointerException {
			if (service == null){
				throw new NullPointerException();
			}
			else {
				this.service = service;
			}
		}


		public LocalDate getDate() {
			return date;
		}


		public void setLocalDate(LocalDate date) {
			if (date == null){
				throw new NullPointerException();
			}
			else {
				this.date = date;
			}
		}


		public Long getCustomerCount() {
			return customerCount;
		}

		public void setCustomerCount(Long customerCount) {
			if (customerCount == null){
				throw new NullPointerException();
			}
			else {
				this.customerCount = customerCount;
			}
		}

}
