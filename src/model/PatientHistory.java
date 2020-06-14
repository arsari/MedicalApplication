package src.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class represents a patient history model in the system
 *
 */
public class PatientHistory {

	private List<Treatment> treatments;
	private List<Medication> medications;
	private List<Allergy> allergies; // correct typo Allergey to Allergy and variable allegry to allergies

	public PatientHistory() {
		this.treatments = new ArrayList<Treatment>();
		this.medications = new ArrayList<Medication>();
		this.allergies = new ArrayList<Allergy>(); // correct typo Allergey to Allergies
	}

	public void addTreatment(Treatment treatment) {
		treatments.add(treatment);
	}

	public void addAllergy(Allergy allergy) { // correct typo Allergey to Allergy and allegry to allergy
		allergies.add(allergy);
	}

	public void addMedication(Medication medication) {
		if (treatments != null) {
			medications.add(medication);
		}
	}

	public List<Allergy> getAllergies() { // correct typo Allergey to Allergy and getAlergies to getAllergies
		return allergies; // correct variable allergy to allergies
	}

	public List<Treatment> getAllTreatments() {
		return treatments;
	}

	public List<Medication> getAllMedications() {
		return medications;
	}

}
