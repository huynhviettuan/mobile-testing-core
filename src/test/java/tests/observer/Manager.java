package tests.observer;

public interface Manager<O> {
    void subscribe(ConsumerType type, Consumer<O> consumer);

    void unsubscribe(ConsumerType type);

    void notifyResult(O result, ConsumerType type);

    void notifyResult(O result);
}
