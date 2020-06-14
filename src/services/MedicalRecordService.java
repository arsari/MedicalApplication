package src.services

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.model.MedicalRecord;
import src.model.Patient;

/**
 *
 * This class uses a singleton pattern to mock a service instead of using
 * dependency injection
 *
 * In addition, it stores data in memory only using Lists
 *
 */
public class MedicalRecordService {
	private static MedicalRecordService reference = new MedicalRecordService();
	private List<Patient> patients;
	private List<MedicalRecord> medicalRecords;

	public static MedicalRecordService getReference() {
		return reference;
	}

	MedicalRecordService() {
		this.patients = new ArrayList<Patient>();
		this.medicalRecords = new ArrayList<MedicalRecord>();
	}

	public boolean addPatient(String name, String id) {
		boolean patientAdded = !patients.stream().anyMatch(patient -> patient.getId().equals(id));
		if (patientAdded) {
			Patient newPatient = new Patient(name, id);
			patients.add(newPatient);
			medicalRecords.add(new MedicalRecord(newPatient));
		}
		return patientAdded;
	}

	public MedicalRecord getMedicalRecord(String patientId) {
		return medicalRecords.stream().filter(medicalRecord -> medicalRecord.getPatient().getId().equals(patientId))
				.findFirst().get();
	}

	// Code with Bug that can't be resolved
	public Patient getPatient(String patientId) {
		return patients.stream().filter(patient -> patient.getId().equals(patientId)).findFirst().get();

	}

	public List<Patient> getAllPatients() {
		return patients;
	}

	public List<Patient> getPatientsWithAllergies(String allergyName) {
		for (Patient patient : getAllPatients()) {
			if (getMedicalRecord(patient.getId()).getHistory().getAllergies().stream()
					.filter(allergy -> allergy.getName().equals(allergyName)).findFirst().get() != null) {
				return Collections.singletonList(patient);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Updated Code public List<Patient> getPatientsWithAllergies(String
	 * allergyName) { List<Patient> patientsList = new ArrayList<Patient>();
	 * for(Patient patient : getAllPatients()) { if
	 * (getMedicalRecord(patient.getId()).getHistory().getAllergies().stream().filter(allergy
	 * -> allergy.getName().equals(allergyName)).findFirst().get() != null){ //
	 * correct typo getAlergies to getAllergies patientsList.add(patient); } }
	 * return patientsList; }
	 */
}
