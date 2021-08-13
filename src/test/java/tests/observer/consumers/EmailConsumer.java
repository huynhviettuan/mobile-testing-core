package tests.observer.consumers;

import tests.observer.Consumer;
import tests.observer.object.Result;

public class EmailConsumer implements Consumer<Result> {
    @Override
    public void notifyResult(Result result) {
// logic to send email
        System.out.println("Result is sent via email: " + result.getScenarioName() + " is " + result.getResult());
    }
}
