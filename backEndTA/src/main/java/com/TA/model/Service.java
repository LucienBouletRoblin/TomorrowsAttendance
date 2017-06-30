package com.TA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service")
@NamedQuery(name = "service.findAll", query = "SELECT t FROM Service t")
public class Service implements Serializable {
	
		private static final long serialVersionUID = 4046352721505678179L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Long service;
		@Temporal(TemporalType.DATE)
		private Date date;
		private Long customerCount;

		public Service() {}

		public Service(Long service, Date date, Long customerCount) {

			this.setService(service);
			this.setDate(date);
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


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
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
