package com.epam.assignment;

import java.util.List;

import com.epam.assignment.dto.DevelopmentTask;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class DeveloperServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Database.class).to(DatabaseImpl.class);
		bind(DeveloperService.class).to(DeveloperServiceImpl.class);
	}

	@Provides
	List<DevelopmentTask> getAllJobs(Database database) {
		return database.getAllJobs();
	}

}
