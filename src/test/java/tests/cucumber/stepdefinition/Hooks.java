package tests.cucumber.stepdefinition;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tests.cucumber.MobileApplicationHooks;
import tests.cucumber.WebHooks;
import tests.observer.ConsumerType;
import tests.observer.ResultConsumerManager;
import tests.observer.ScenarioConsumerManager;
import tests.observer.consumers.DbConsumer;
import tests.observer.consumers.EmailConsumer;
import tests.observer.consumers.SkypeConsumer;
import tests.observer.consumers.SlackConsumer;
import tests.observer.object.Result;

public class Hooks {

    @Inject
    private MobileApplicationHooks mobile;

    @Inject
    private WebHooks web;

    private ResultConsumerManager manager;
    private ScenarioConsumerManager scenarioConsumerManager;

    public Hooks() {
        manager = new ResultConsumerManager();
        scenarioConsumerManager = new ScenarioConsumerManager();
        EmailConsumer email = new EmailConsumer();
        DbConsumer db = new DbConsumer();
        SlackConsumer slack = new SlackConsumer();
        SkypeConsumer skype = new SkypeConsumer();

        manager.subscribe(ConsumerType.EMAIL, email);
        manager.subscribe(ConsumerType.DB, db);

        scenarioConsumerManager.subscribe(ConsumerType.SLACK, slack);
        scenarioConsumerManager.subscribe(ConsumerType.SKYPE, skype);
    }

    @Before(value = "@Mobile")
    public void setupScenarioMobile() {
        mobile.start();
    }

    @After(value = "@Mobile")
    public void teardownScenarioMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName();
            String imageName = scenarioName + ".png";
            scenario.attach(mobile.takeScreenshotMobile(imageName), "image/png", scenarioName);
        }
        mobile.quit();

        // notify result
        // - email
        // - skype
        // - slack
        // - db update

        // Hooks (after scenario) là produce result
        // email, skype, slack, db là consume result
        // object là result
        // manager: sẽ phải tạo

        Result result = new Result();
        result.setScenarioName(scenario.getName());
        result.setResult("" + scenario.getStatus());
        manager.notifyResult(result);

        tests.observer.object.Scenario sc = new tests.observer.object.Scenario();
        sc.setScenarioName(scenario.getName());
        sc.setResult("" + scenario.getStatus());
        scenarioConsumerManager.notifyResult(sc);
    }


//    @Before(value = "@Web")
//    public void setupScenarioWeb() {
//        web.start();
//    }
//
//    @After(value = "@Web")
//    public void teardownScenarioWeb() {
//        web.quit();
//    }
}
