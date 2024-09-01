package com.medex.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medex.communicationmodules.PersonnelInfo;
import com.medex.communicationmodules.Status;
import com.medex.model.Personnel;
import com.medex.services.PersonnelService;



//Request resources which acts as a layer before our Personnel services
@Path("/personnel")
public class PersonnelResources {
	PersonnelService personnelService = new PersonnelService();

	public PersonnelResources() {
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonnelInfo> getPersonnels() {
		return personnelService.getAllPersonnels();
	}

	@GET
	@Path("{Personnelid}")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonnelInfo getPersonnel(@PathParam("Personnelid") int id) {
		return personnelService.getPersonnel(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonnelInfo addPersonnel(Personnel aPersonnel) {
		return personnelService.addPersonnel(aPersonnel);
	}

	@PUT
	@Path("{Personnelid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonnelInfo updatePersonnel(@PathParam("Personnelid") int id, Personnel Personnel) {
		Personnel.setId(id);
		return personnelService.updatePersonnel(Personnel);
	}

	@DELETE
	@Path("{Personnelid}")
	public Status removePersonnel(@PathParam("Personnelid") int personnelid, Personnel Personnel) {
		return personnelService.removePersonnel(personnelid);
	}
	
	@Path("{Personnelid}/orders")
	public OrderResources getOrders()
	{
		return new OrderResources();
	}
	
	@GET
	@Path("/login/{username}/{password}")
	public Personnel getPersonnelLogin(@PathParam("username") String username, @PathParam("password") String password)
	{
		return personnelService.getPersonnelLogin(username, password);
	}
	
}
