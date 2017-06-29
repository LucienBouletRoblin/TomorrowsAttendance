package com.test;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.TA.model.Service;

@Stateless
@Path("/allservices")
public class ServiceRSTEST {
	
	@PersistenceContext(unitName = "tomorrowsAttendance")
	EntityManager entityManager;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Service> get(){
		List<Service> listRslt = entityManager.createQuery("SELECT t FROM Service t", Service.class).getResultList();
		System.out.println(listRslt);
		return listRslt;
		//List<Service> listResult = entityManager.createNamedQuery("service.findAll", Service.class).getResultList();
		//System.out.println(listResult);
		//return this.entityManager.createNamedQuery("service.findAll", Service.class).getResultList();
	}


	
}
