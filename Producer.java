import java.util.Random;

public class Producer {
    private final Buffer buffer;
    private final Random random;

    public Producer(final Buffer buffer) {
        this.buffer = buffer;
        random = new Random();
    }

    public void run() {
        while (true) {
            int value = random.nextInt(500);

            try {
                Thread.sleep(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Produzindo " + value);
            buffer.produce(value);
        }
    }
}
