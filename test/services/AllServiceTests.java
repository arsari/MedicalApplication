package test.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDoctorService.class, TestMedicalRecordService.class })
public class AllServiceTests {

}
