import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.model.AllModelTests;
import test.services.AllServiceTests;
import test.util.AllUtilTests;

@RunWith(Suite.class)
@SuiteClasses({ AllModelTests.class, AllServiceTests.class, AllUtilTests.class })
public class AllTests {

}
