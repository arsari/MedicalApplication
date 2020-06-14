package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Patient;

public class TestPatient {
	private Patient patient;
	private String name, id;

	@Before
	public void before() {
		this.patient = new Patient(name, id);
	}

	@Test
	public void testSetPatientName() {
		String inputName = "Jose Colon";
		patient.setName(inputName);
		name = patient.getName();
		assertTrue(name.equals(inputName));
	}

	@Test
	public void testSetPatientId() {
		String inputId = "5678";
		patient.setId(inputId);
		name = patient.getId();
		assertTrue(name.equals(inputId));
	}

	@Test
	public void testToStringReturn() {
		name = "Jose Colon";
		id = "5678";
		patient.setName(name);
		patient.setId(id);
		System.out.println(patient.toString());
	}
}
