package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Employee;

public class TestEmployee {
	private Employee employee;
	private String inputName = "Mike";
	private String inputId = "1111";
	private String inputPassword = "Testing";

	@Before
	public void before() {
		this.employee = new Employee(inputName, inputId);
	}

	@Test
	public void testGetEmployeeName() {
		String name = employee.getName();
		assertTrue(name.equals(inputName));
	}

	@Test
	public void testGetEmployeeId() {
		String id = employee.getId();
		assertTrue(id.equals(inputId));
	}

	@Test
	public void testGetEmployeePassword() {
		String password = employee.getPassword();
		assertFalse(password.equals(inputPassword));
	}
}
