package com.epam.assignment;

import java.util.Map;
import java.util.Set;

import com.epam.assignment.dto.Developer;
import com.epam.assignment.dto.DevelopmentTaskSummary;

public interface DeveloperService {

	public Map<Developer, Set<DevelopmentTaskSummary>> getDeveloperTasks();
	
}
