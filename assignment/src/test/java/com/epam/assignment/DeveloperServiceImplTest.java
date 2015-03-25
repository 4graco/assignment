package com.epam.assignment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epam.assignment.dto.Developer;
import com.epam.assignment.dto.DevelopmentTask;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;

public class DeveloperServiceImplTest extends AbstractModule {

	private Database database = mock(Database.class);

	@Before
	public void setUp() {
	}

	@Override
	protected void configure() {
		bind(Database.class).toInstance(database);
		bind(DeveloperService.class).to(DeveloperServiceImpl.class);
	}

	@Provides
	List<DevelopmentTask> getAllJobs(Database database) {
		return database.getAllJobs();
	}

	@Test(expected = ProvisionException.class)
	public void testGetDeveloperTasksNull() {
		when(database.getAllJobs()).thenReturn(null);
		DeveloperService developerService = Guice.createInjector(this)
				.getInstance(DeveloperService.class);
		developerService.getDeveloperTasks();
	}

	@Test
	public void testGetDeveloperTasksEmpty() {
		when(database.getAllJobs())
				.thenReturn(new ArrayList<DevelopmentTask>());
		DeveloperService developerService = Guice.createInjector(this)
				.getInstance(DeveloperService.class);
		assertThat(developerService.getDeveloperTasks().size(), is(0));
	}

	@Test
	public void testGetDeveloperTasksAssignedNull() {
		List<DevelopmentTask> testList = new ArrayList<DevelopmentTask>();
		testList.add(new DevelopmentTask(123, "taskName123"));
		testList.add(new DevelopmentTask(456, "taskName456"));
		when(database.getAllJobs()).thenReturn(testList);
		DeveloperService developerService = Guice.createInjector(this)
				.getInstance(DeveloperService.class);
		// because assignedList == null for all items
		assertThat(developerService.getDeveloperTasks().size(), is(0));
	}

	@Test
	public void testGetDeveloperTasksAssignedEmpty() {
		List<Developer> developerList = new ArrayList<Developer>();
		List<DevelopmentTask> testList = new ArrayList<DevelopmentTask>();
		testList.add(new DevelopmentTask(123, "taskName123", developerList));
		testList.add(new DevelopmentTask(456, "taskName456", developerList));
		when(database.getAllJobs()).thenReturn(testList);
		DeveloperService developerService = Guice.createInjector(this)
				.getInstance(DeveloperService.class);
		// because assignedList is empty for all items
		assertThat(developerService.getDeveloperTasks().size(), is(0));
	}
	
	@Test
	public void testGetDeveloperTasksAssigned() {
		List<Developer> developerList1 = new ArrayList<Developer>();
		developerList1.add(new Developer(111, "devName111"));
		developerList1.add(new Developer(222, "devName222"));

		List<Developer> developerList2 = new ArrayList<Developer>();
		developerList2.add(new Developer(333, "devName333"));
		developerList2.add(new Developer(444, "devName444"));

		List<DevelopmentTask> testList = new ArrayList<DevelopmentTask>();
		testList.add(new DevelopmentTask(123, "taskName123", developerList1));
		testList.add(new DevelopmentTask(456, "taskName456", developerList2));
		when(database.getAllJobs()).thenReturn(testList);
		DeveloperService developerService = Guice.createInjector(this)
				.getInstance(DeveloperService.class);
		assertThat(developerService.getDeveloperTasks().size(), is(4));
	}
	
}
