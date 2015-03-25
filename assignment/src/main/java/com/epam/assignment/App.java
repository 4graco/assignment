package com.epam.assignment;

import java.util.Map;
import java.util.Set;

import com.epam.assignment.dto.Developer;
import com.epam.assignment.dto.DevelopmentTaskSummary;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

	public static void main(String...args) {
		Injector injector = Guice.createInjector(new DeveloperServiceModule());
		DeveloperService developerService = injector.getInstance(DeveloperService.class);
		Map<Developer, Set<DevelopmentTaskSummary>> result = developerService.getDeveloperTasks();
	}
	
}
