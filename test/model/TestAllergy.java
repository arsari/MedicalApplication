package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.model.Allergy;

public class TestAllergy {
	private Allergy allergy;
	private String name;

	@Before
	public void before() {
		this.allergy = new Allergy(name);
	}

	@Test
	public void testSetAllergyName() {
		String inputName = "Rhinitis";
		allergy.setName(inputName);
		name = allergy.getName();
		assertTrue(name.equals(inputName));
	}

	@Test
	public void testToStringReturn() {
		name = "Rhinitis";
		allergy.setName(name);
		System.out.println(allergy.toString());
	}

}
