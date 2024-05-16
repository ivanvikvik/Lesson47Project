package by.itstep.ivanvikvik.javalesson.controller;

import by.itstep.ivanvikvik.javalesson.model.entity.Market;
import by.itstep.ivanvikvik.javalesson.model.logic.Consumer;
import by.itstep.ivanvikvik.javalesson.model.logic.Producer;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        Producer producer = new Producer(market, System.out);
        Consumer consumer1 = new Consumer(market, System.out, 1);
        Consumer consumer2 = new Consumer(market, System.out, 2);
        Consumer consumer3 = new Consumer(market, System.out, 3);
        Consumer consumer4 = new Consumer(market, System.out, 4);

        TimeUnit.SECONDS.sleep(10);
        producer.stop();
        consumer1.stop();
        consumer2.stop();
        consumer3.stop();
        consumer4.stop();
    }
}
