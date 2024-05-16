package by.itstep.ivanvikvik.javalesson.model.logic;

import by.itstep.ivanvikvik.javalesson.model.entity.Market;

import java.io.PrintStream;

public class Consumer implements Runnable {
    private Market market;
    private PrintStream stream;
    private int id;

    private Thread thread;
    private volatile boolean running;

    public Consumer(Market market, PrintStream stream, int id) {
        this.market = market;
        this.stream = stream;
        this.id = id;
        running = true;
        thread = new Thread(this);
        thread.start();


    }

    @Override
    public void run() {
        while (running) {
            market.get();
        }
    }

    public void stop() {
        running = false;
    }
}
