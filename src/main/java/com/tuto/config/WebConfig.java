package com.tuto.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class WebConfig extends ResourceConfig {
	public WebConfig() {
		register(new ApplicationBinder());
		register(JacksonFeature.class);
		packages("com.tuto.resource");
	}
}
