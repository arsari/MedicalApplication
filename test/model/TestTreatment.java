package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Treatment;

public class TestTreatment {
	private Treatment treatment;
	private String date, diagnose, description;

	@Before
	public void before() {
		this.treatment = new Treatment(date, diagnose, description);
	}

	@Test
	public void testSetTreatmentDate() {
		String inputDate = "May 31, 2020";
		treatment.setTreatmentDate(inputDate);
		date = treatment.getTreatmentDate();
		assertTrue(date.equals(inputDate));
	}

	@Test
	public void testSetTreatmentDiagnose() {
		String inputDiagnose = "Sinus";
		treatment.setDiagnose(inputDiagnose);
		diagnose = treatment.getDiagnose();
		assertTrue(diagnose.equals(inputDiagnose));
	}

	@Test
	public void testSetTreatmentDescription() {
		String inputDescription = "A sac or cavity in any organ or tissue.";
		treatment.setDescription(inputDescription);
		description = treatment.getDescription();
		assertTrue(description.equals(inputDescription));
	}

	@Test
	public void testToStringReturn() {
		date = "May 31, 2020";
		diagnose = "Sinus";
		description = "A sac or cavity in any organ or tissue.";
		treatment.setTreatmentDate(date);
		treatment.setDiagnose(diagnose);
		treatment.setDescription(description);
		System.out.println(treatment.toString());
	}
}
