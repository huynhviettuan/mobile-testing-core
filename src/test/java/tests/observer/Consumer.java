package tests.observer;

public interface Consumer<T> {
    void notifyResult(T t);
}
