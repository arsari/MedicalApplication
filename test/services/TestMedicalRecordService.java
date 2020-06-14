package test.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import src.model.Allergy;
import src.model.MedicalRecord;
import src.model.Patient;
import src.services.MedicalRecordService;

public class TestMedicalRecordService {
	private MedicalRecordService reference;
	private List<Patient> patients;

	@Before
	public void before() {
		reference = MedicalRecordService.getReference();
		patients = reference.getAllPatients();
	}

	@Test
	public void testGetReference() {
		assertNotNull("Medical record service object is null", reference);
	}

	@Test
	public void testAddPatient() {
		boolean patientSuccess = reference.addPatient("Jose Colon", "2468");
		boolean patientDuplicate = reference.addPatient("John Perez", "2468");

		assertTrue("MedicalRecordService failed to add patient: 2468", patientSuccess);
		assertNotNull("Patient list is null", patients);
		assertFalse("Able to add duplicate patient id", patientDuplicate);
		assertTrue("Unable to locate specified patient id",
				patients.stream().anyMatch(patient -> patient.getId().equals("2468")));
		assertTrue("Unable to locate specified patient name",
				patients.stream().anyMatch(patient -> patient.getName().equals("Jose Colon")));
	}

	@Test
	public void testGetPatient() {
		boolean patientSuccess = reference.addPatient("Jose Ruiz", "8642");
		Patient patient = reference.getPatient("8642");

		assertTrue("Medical Record Service failed to add patient: 8642", patientSuccess);
		assertNotNull("getPatient returned null object", patient);
		assertEquals("Patient: 1357 returned incorrect name", patient.getName(), "Jose Ruiz");
		assertEquals("Patient: Jose Ruiz returned incorrect ID", patient.getId(), "8642");
	}

	@Test
	public void testGetPatientMedicalRecord() {
		MedicalRecord medicalRecord = reference.getMedicalRecord("1357");
		Patient patient = medicalRecord.getPatient();

		assertNotNull("MedicalRecordService returned null object", medicalRecord);
		assertEquals("Patient: 1357 returned incorrect name", patient.getName(), "John Kellog");
		assertEquals("patient: John Perez returned incorrect ID", patient.getId(), "1357");
	}

	@Test
	public void testGetAllPatient() {
		boolean patientOne = reference.addPatient("John Kellog", "1357");
		boolean patientTwo = reference.addPatient("Jose Gomez", "7531");

		assertTrue("Medical Record Service failed to add patient: 1357", patientOne);
		assertTrue("Medical Record Service failed to add patient: 7351", patientTwo);
		assertNotNull("Patients List is null", patients);
		assertTrue("Unable to locate Patient: Jose Gomez",
				patients.stream().anyMatch(patient -> patient.getName().equals("Jose Gomez")));
		assertTrue("Unable to locate Doctor Id: 1357",
				patients.stream().anyMatch(patient -> patient.getId().equals("1357")));
	}

	@Test
	public void testGetPatientsWithAllergies() {
		String patientId = "2468";
		Allergy patientAllergy = new Allergy("Rhinitis");

		reference.addPatient("Jose Colon", patientId);
		MedicalRecord medicalRecord = reference.getMedicalRecord(patientId);
		medicalRecord.getHistory().addAllergy(patientAllergy);

		List<Patient> patientsList = reference.getPatientsWithAllergies("Rhinitis");
		assertNotNull("aAllergy object is null", patientAllergy);
		assertNotNull("MedicalRecord object is null", medicalRecord);
		assertNotNull("PatientList object is null", medicalRecord);
		assertFalse("testGetPatientsWithAllergies returned null or 0", patientsList.isEmpty());
	}

	@After
	public void after() {
		reference = null;
		patients = null;
	}
}
