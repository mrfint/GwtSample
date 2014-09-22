package com.mySampleApplication.server.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.mySampleApplication.server.MySampleApplicationServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {
	public RestApplication() {
		register(JacksonJsonProvider.class);
		register(MySampleApplicationServiceImpl.class);
	}
}
