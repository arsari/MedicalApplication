package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Doctor;

public class TestDoctor {
	private Doctor doctor;
	private String name;
	private String id;

	@Before
	public void before() {
		this.doctor = new Doctor(name, id);
	}

	@Test
	public void testSetDoctorName() {
		String inputName = "John Doe";
		doctor.setName(inputName);
		name = doctor.getName();
		assertTrue(name.equals(inputName));
	}

	@Test
	public void testSetDoctorId() {
		String inputId = "1234";
		doctor.setId(inputId);
		name = doctor.getId();
		assertTrue(name.equals(inputId));
	}

	@Test
	public void testToStringReturn() {
		name = "John Doe";
		id = "1234";
		doctor.setName(name);
		doctor.setId(id);
		System.out.println(doctor.toString());
	}
}
