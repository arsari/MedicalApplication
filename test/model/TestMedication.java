package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Medication;

public class TestMedication {
	private Medication medication;
	private String name, startDate, endDate, dose;

	@Before
	public void before() {
		this.medication = new Medication(name, startDate, endDate, dose);
	}

	@Test
	public void testSetMedicationName() {
		String inputName = "Fluticasone";
		medication.setName(inputName);
		name = medication.getName();
		assertTrue(name.equals(inputName));
	}

	@Test
	public void testSetMedicationStartDate() {
		String inputDate = "May 31, 2020";
		medication.setStartDate(inputDate);
		startDate = medication.getStartDate();
		assertTrue(startDate.equals(inputDate));
	}

	@Test
	public void testSetMedicationEndDate() {
		String inputDate = "August 31, 2020";
		medication.setEndDate(inputDate);
		startDate = medication.getEndDate();
		assertTrue(startDate.equals(inputDate));
	}

	@Test
	public void testSetMedicationDose() {
		String inputDose = "Use 1 spray in each nostril, once a day.";
		medication.setDose(inputDose);
		dose = medication.getDose();
		assertTrue(dose.equals(inputDose));
	}

	@Test
	public void testToStringReturn() {
		name = "Fluticasone";
		startDate = "May 31, 2020";
		endDate = "August 31, 2020";
		dose = "Use 1 spray in each nostril, once a day.";
		medication.setName(name);
		medication.setStartDate(startDate);
		medication.setEndDate(endDate);
		medication.setDose(dose);
		System.out.println(medication.toString());
	}
}
