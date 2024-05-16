package by.itstep.ivanvikvik.javalesson.model.logic;

import by.itstep.ivanvikvik.javalesson.model.entity.Market;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private volatile boolean running;
    private Market market;
    private Thread thread;
    private PrintStream stream;

    public Producer(Market market, PrintStream stream) {
        this.market = market;
        this.stream = stream;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int product = 1;

        while (running) {
            try {
                if (!market.isFlag()) {
                    market.put(product);
                    stream.println("Producer put product: " + product++);
                    market.setFlag(true);
                }
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException exception) {
                stream.println(exception);
            }
        }
    }

    public void stop() {
        running = false;
    }
}