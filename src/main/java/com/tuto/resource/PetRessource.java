package com.tuto.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tuto.dto.PetDTO;
import com.tuto.service.PetService;

@Path("/pets")
public class PetRessource {
	@Inject	
	PetService petService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PetDTO> getAll() {
		return petService.getAll();
	};
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public PetDTO get(@PathParam("id") String id) {
		return petService.get(Integer.parseInt(id));
	}
	
	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public PetDTO edit(PetDTO pet) {
		return petService.edit(pet);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public PetDTO create(PetDTO pet) {
		return petService.create(pet);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void remove(@PathParam("id") int id) {
		petService.remove(id);
	}
}
