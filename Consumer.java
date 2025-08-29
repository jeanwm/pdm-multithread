import java.util.Random;

public class Consumer extends Thread {
    private final Buffer buffer;
    private final Random random;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        random = new Random();
    }

    public void run() {
        while(true) {
            var value = random.nextInt(500);
            buffer.consume();

            System.out.println("Consumindo" + value);

            try {
                Thread.sleep(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
