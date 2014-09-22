package com.mySampleApplication.shared;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/test")
@Produces("application/json")
public interface MySampleApplicationService {

	@GET
	@Path("/message")
	String getMessage(@QueryParam("msg") String msg);

	@GET
	@Path("test")
	String getTest();
}
