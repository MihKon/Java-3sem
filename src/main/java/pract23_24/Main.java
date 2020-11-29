package pract23_24;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Worker worker = new Worker();
        while (true) {
            worker.doTasks();
            try {
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
