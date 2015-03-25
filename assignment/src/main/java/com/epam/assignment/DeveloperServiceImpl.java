package com.epam.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.epam.assignment.dto.Developer;
import com.epam.assignment.dto.DevelopmentTask;
import com.epam.assignment.dto.DevelopmentTaskSummary;

public class DeveloperServiceImpl implements DeveloperService {

	private List<DevelopmentTask> allJobs;

	@Inject
	public DeveloperServiceImpl(List<DevelopmentTask> allJobs) {
		this.allJobs = allJobs;
	}

	public Map<Developer, Set<DevelopmentTaskSummary>> getDeveloperTasks() {
		Map<Developer, Set<DevelopmentTaskSummary>> developmentTaskMap = new HashMap<Developer, Set<DevelopmentTaskSummary>>();
		for (DevelopmentTask developmentTask : allJobs) {
			List<Developer> assignedList = developmentTask.getAssigned();
			if (assignedList != null) {
				for (Developer developer : assignedList) {
					Set<DevelopmentTaskSummary> taskSet = developmentTaskMap.get(developer);
					if (taskSet == null) {
						taskSet = new HashSet<DevelopmentTaskSummary>();
						developmentTaskMap.put(developer, taskSet);
					}
					DevelopmentTaskSummary dts = new DevelopmentTaskSummary(developmentTask.getId(), developmentTask.getName());
					taskSet.add(dts);
				}
			}
		}
		return developmentTaskMap;
	}

}
