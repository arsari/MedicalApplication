package test.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.model.Doctor;
import src.services.DoctorService;

public class TestDoctorService {
	DoctorService reference;
	private List<Doctor> doctors;

	@Before
	public void before() {
		reference = DoctorService.getReference();
		doctors = reference.getAllDoctors();
	}

	@Test
	public void testGetDoctorReference() {
		assertNotNull("Doctor service object is null", reference);
	}

	@Test
	public void testAddDoctor() {
		boolean doctorSuccess = reference.addDoctor("John Colon", "1234");
		boolean doctorDuplicate = reference.addDoctor("Jose Ruiz", "1234");

		assertTrue("Doctor Service failed to add doctor: 1234", doctorSuccess);
		assertNotNull("Doctor list is null", doctors);
		assertFalse("Able to add duplicate doctor id", doctorDuplicate);
		assertTrue("Unable to locate specified doctor id: 1234",
				doctors.stream().anyMatch(doctor -> doctor.getId().equals("1234")));
		assertTrue("Unable to locate specified doctor name: John Colon",
				doctors.stream().anyMatch(doctor -> doctor.getName().equals("John Colon")));
	}

	@Test
	public void testGetAllDoctors() {
		boolean doctorOne = reference.addDoctor("Richard McNee", "4321");
		boolean doctorTwo = reference.addDoctor("John Ruiz", "8765");

		assertTrue("Doctor Service failed to add doctor: 4321", doctorOne);
		assertTrue("Doctor Service failed to add doctor: 8765", doctorTwo);
		assertNotNull("Doctors List is null", doctors);
		assertTrue("Unable to locate doctor: Richard McNee",
				doctors.stream().anyMatch(doctor -> doctor.getName().equals("Richard McNee")));
		assertTrue("Unable to locate doctor ID: 8765",
				doctors.stream().anyMatch(doctor -> doctor.getId().equals("8765")));
	}

	@After
	public void after() {
		reference = null;
		doctors = null;
	}

}
