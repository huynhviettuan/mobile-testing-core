package tests.observer;

import tests.observer.object.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manage các consumer
 * Nhận kết quả test từ Hooks
 * Deliver kết quả tới các consumer mà nó quản lý
 */
public class ResultConsumerManager implements Manager<Result>{

    //    private List<Consumer> consumerList;
    private Map<ConsumerType, Consumer<Result>> consumerList;

    public ResultConsumerManager() {
        consumerList = new HashMap<>();
    }

    /**
     * Method để các consumer đăng ký với manager
     */
    public void subscribe(ConsumerType type, Consumer<Result> consumer) {
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
    public void notifyResult(Result result, ConsumerType type) {
        Consumer<Result> c = consumerList.get(type);
        c.notifyResult(result);
    }

    /**
     * nhận kết quả test từ hook
     */
    public void notifyResult(Result result) {
        Set<ConsumerType> types = consumerList.keySet();
        for (ConsumerType t : types) {
            Consumer<Result> c = consumerList.get(t);
            c.notifyResult(result);
        }
    }


}
