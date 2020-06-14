package test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAllergy.class, TestDoctor.class, TestEmployee.class, TestPatient.class, TestMedicalRecord.class,
		TestPatientHistory.class, TestMedication.class, TestTreatment.class })
public class AllModelTests {

}
