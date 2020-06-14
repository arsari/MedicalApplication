package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Allergy;
import src.model.MedicalRecord;
import src.model.Medication;
import src.model.Patient;
import src.model.Treatment;

public class TestMedicalRecord {
	private MedicalRecord record;
	private Patient patient = new Patient("Jose Colon", "2468");;
	private Treatment treatment = new Treatment("May 31, 2020", "Sinus", "A sac or cavity in any organ or tissue.");
	private Allergy allergy = new Allergy("Rhinitis");
	private Medication medication = new Medication("Fluticasone", "May 30, 2020", "August 30, 2020",
			"Use 1 spray in each nostril, once a day.");

	@Before
	public void before() {
		this.record = new MedicalRecord(patient);
	}

	@Test
	public void testGetPatient() {
		assertTrue("Patient not in records", record.getPatient() != null);
	}

	@Test
	public void testGetHistory() {
		record.getHistory().addTreatment(treatment);
		assertFalse("Ërror getting patient Treatments", record.getHistory().getAllTreatments().isEmpty());

		record.getHistory().addAllergy(allergy);
		assertFalse("Ërror getting patient allergies", record.getHistory().getAllergies().isEmpty());

		record.getHistory().addMedication(medication);
		assertFalse("Error getting patient medications", record.getHistory().getAllMedications().isEmpty());
	}
}
