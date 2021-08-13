package tests.observer.consumers;

import tests.observer.Consumer;
import tests.observer.object.Result;

public class DbConsumer implements Consumer<Result> {
    @Override
    public void notifyResult(Result result) {
        System.out.println("Result is updated to db: " + result.getScenarioName() + " is " + result.getResult());
    }
}
