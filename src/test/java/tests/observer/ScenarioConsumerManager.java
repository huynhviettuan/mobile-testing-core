package tests.observer;

import tests.observer.object.Scenario;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manage các consumer
 * Nhận kết quả test từ Hooks
 * Deliver kết quả tới các consumer mà nó quản lý
 */
public class ScenarioConsumerManager implements Manager<Scenario> {

    //    private List<Consumer> consumerList;
    private Map<ConsumerType, Consumer<Scenario>> consumerList;

    public ScenarioConsumerManager() {
        consumerList = new HashMap<>();
    }

    /**
     * Method để các consumer đăng ký với manager
     */
    public void subscribe(ConsumerType type, Consumer<Scenario> consumer) {
        consumerList.put(type, consumer);
    }

    /**
     * method để bỏ các consumer đã đăng ký: unsubscibe
     */
    public void unsubscribe(ConsumerType type) {
        consumerList.remove(type);
    }

    /**
     * method để notify cho 1 kiểu (type) consumer nào đó: notifyResult(Result result, ConsumerType type)
     */
    public void notifyResult(Scenario scenario, ConsumerType type) {
        Consumer<Scenario> c = consumerList.get(type);
        c.notifyResult(scenario);
    }

    /**
     * nhận kết quả test từ hook
     */
    public void notifyResult(Scenario scenario) {
        Set<ConsumerType> types = consumerList.keySet();
        for (ConsumerType t : types) {
            Consumer<Scenario> c = consumerList.get(t);
            c.notifyResult(scenario);
        }
    }


}
