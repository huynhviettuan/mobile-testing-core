package tests.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"tests.cucumber"},
        tags = "@ContactSearch_S01",
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
        }

)
public class CucumberTestRunner {
}
