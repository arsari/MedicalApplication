package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Allergy;
import src.model.Medication;
import src.model.PatientHistory;
import src.model.Treatment;

public class TestPatientHistory {
	private PatientHistory history;
	private Treatment treatment = new Treatment("May 31, 2020", "Sinus", "A sac or cavity in any organ or tissue.");
	private Allergy allergy = new Allergy("Rhinitis");
	private Medication medication = new Medication("Fluticasone", "May 30, 2020", "August 30, 2020",
			"Use 1 spray in each nostril, once a day.");

	@Before
	public void before() {
		this.history = new PatientHistory();
	}

	@Test
	public void testAddTreatmentToHistory() {
		history.addTreatment(treatment);
		assertFalse("Error adding Treatment", history.getAllTreatments().isEmpty());
	}

	@Test
	public void testAddAllergyToHistory() {
		history.addAllergy(allergy);
		assertFalse("Error adding Allergy", history.getAllergies().isEmpty());
	}

	@Test
	public void testAddMedicationToHistory() {
		assertNotNull("Treatment not in history", treatment != null);
		history.addMedication(medication);
		assertFalse("Error adding Medication", history.getAllMedications().isEmpty());
	}

	@Test
	public void testGetAllTreatmentsHistory() {
		history.addTreatment(treatment);
		assertTrue("Treatment history is empty", history.getAllTreatments().size() >= 1);
	}

	@Test
	public void testGetAllergiesHistory() {
		history.addAllergy(allergy);
		assertTrue("Allergies history is empty", history.getAllergies().size() >= 1);
	}

	@Test
	public void testGetMedicationsHistory() {
		history.addMedication(medication);
		assertTrue("Medications history is empty", history.getAllMedications().size() >= 1);
	}
}
