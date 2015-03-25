package com.epam.assignment.dto;

import java.util.List;

public class DevelopmentTask {

	private String name;
	private int id;
	private List<Developer> assigned;

	public DevelopmentTask() {

	}

	public DevelopmentTask(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public DevelopmentTask(int id, String name, List<Developer> assigned) {
		this.name = name;
		this.id = id;
		this.assigned = assigned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Developer> getAssigned() {
		return assigned;
	}

	public void setAssigned(List<Developer> assigned) {
		this.assigned = assigned;
	}

}
