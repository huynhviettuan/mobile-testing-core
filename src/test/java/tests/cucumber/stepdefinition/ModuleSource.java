package tests.cucumber.stepdefinition;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import core.drivermanager.DriverModule;
import tests.PageModule;

public class ModuleSource implements InjectorSource {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(Stage.DEVELOPMENT,
                CucumberModules.createScenarioModule(),
                new DriverModule(),
                new PageModule());
    }
}