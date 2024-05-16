package by.itstep.ivanvikvik.javalesson.controller;

import by.itstep.ivanvikvik.javalesson.model.entity.Market;
import by.itstep.ivanvikvik.javalesson.model.logic.Consumer;
import by.itstep.ivanvikvik.javalesson.model.logic.Producer;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        Producer producer = new Producer(market, System.out);
        Consumer consumer = new Consumer(market, System.out, 1);

        TimeUnit.SECONDS.sleep(10);
        producer.stop();
        consumer.stop();
    }
}
