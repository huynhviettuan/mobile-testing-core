package tests.cucumber;


import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;


public class CustomListener implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
    }


    private void handleTestStepStarted(TestStepStarted event) {
        TestStep step = event.getTestStep();
        if (step instanceof PickleStepTestStep)
            System.out.println("TESTSTEP STARTED: " + ((PickleStepTestStep) step).getStep().getText());
    }
}
