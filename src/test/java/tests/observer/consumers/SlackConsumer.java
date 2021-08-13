package tests.observer.consumers;

import tests.observer.Consumer;
import tests.observer.object.Scenario;

public class SlackConsumer implements Consumer<Scenario> {
    @Override
    public void notifyResult(Scenario scenario) {
        System.out.println("Result is sent to slack channels: " + scenario.getScenarioName() + " is " + scenario.getResult());
    }
}
