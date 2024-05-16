package by.itstep.ivanvikvik.javalesson.model.entity;

public class Market {
    private int product;
    private volatile boolean flag;

    public Market() {
    }

    public Market(int product) {
        this.product = product;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized void get() {
        try {
            if (flag) {
                flag = false;
                System.out.println("Consumer use product: " + product);
                notify();
                wait();
            }
        } catch (InterruptedException exception) {
            System.err.println(exception.toString());
        }
    }

    public synchronized void put(int product) {
        try {
            if (!flag) {
                this.product = product;
                System.out.println("Producer put product: " + product);
                flag = true;
                notify();
                wait();
            }

        } catch (InterruptedException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
