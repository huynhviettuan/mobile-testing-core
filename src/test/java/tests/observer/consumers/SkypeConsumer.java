package tests.observer.consumers;

import tests.observer.Consumer;
import tests.observer.object.Scenario;

public class SkypeConsumer implements Consumer<Scenario> {

    @Override
    public void notifyResult(Scenario scenario) {
        System.out.println("Result is sent to skype groups: " + scenario.getScenarioName() + " is " + scenario.getResult());
    }
}
