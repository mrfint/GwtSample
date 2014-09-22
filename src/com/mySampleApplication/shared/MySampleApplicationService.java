package com.mySampleApplication.shared;

import com.mySampleApplication.client.CacheInterceptor;
import org.jboss.errai.common.client.api.interceptor.InterceptedCall;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/test")
@Produces("application/json")
@InterceptedCall(CacheInterceptor.class)
public interface MySampleApplicationService {

	@GET
	@Path("/message")
	Message getMessage(@QueryParam("msg") String msg);

	@GET
	@Path("test")
	String getTest();
}
