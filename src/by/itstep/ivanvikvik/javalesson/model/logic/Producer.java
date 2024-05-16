package by.itstep.ivanvikvik.javalesson.model.logic;

import by.itstep.ivanvikvik.javalesson.model.entity.Market;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private boolean running;
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
                synchronized (market) {
                    if (!market.isFlag()) {
                        market.put(product);
                        stream.println("Producer put product: " + product++);
                        market.setFlag(true);
                        market.notifyAll();
                    } else {
                        market.wait();
                    }
                }
            } catch (InterruptedException exception) {
                stream.println(exception.toString());
            }
        }
    }

    public void stop() {
        running = false;
    }
}
