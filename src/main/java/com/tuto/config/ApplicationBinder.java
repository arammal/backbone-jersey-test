package com.tuto.config;

import javax.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.tuto.service.PetService;
import com.tuto.service.PetServiceImpl;
import com.tuto.service.PetServiceMock;;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		boolean isMock = Boolean.valueOf(System.getProperty("tutoApp.isMock"));

		if (isMock) {
			bind(PetServiceMock.class).to(PetService.class).in(Singleton.class);
		} else {
			bind(PetServiceImpl.class).to(PetService.class).in(Singleton.class);
		}

	}
}
