package com.TA.ressources;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.TA.model.Service;

@Path("/rs/service")
@Stateless
public class ServiceRS {
	
	@PersistenceContext(unitName = "tomorrowsAttendance")
	EntityManager entityManager;
	
	@GET
	@Path("/allservices")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Service> getAllServices(){
		List<Service> listRslt = entityManager.createQuery("SELECT t FROM Service t", Service.class).getResultList();
		return listRslt;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postService(Service service, @Context UriInfo uriInfo){
		System.out.println(service.getDate());
		this.entityManager.persist(service);
		
		URI location = uriInfo.getRequestUriBuilder()
                .path("/allservices")
                .build();
			
		return Response.seeOther(location).build();
	}
	
}
