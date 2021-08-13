package core;

import com.google.inject.Inject;
import com.google.inject.Injector;
import core.capability.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected Logger log = LogManager.getLogger(this);

    @Inject
    protected Injector injector;

    @Inject
    protected Service service;

    @BeforeSuite
    public void setupSuite() {
        log.info("injector: " + injector.toString());
    }

}
