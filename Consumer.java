import java.util.Random;

public class Consumer extends Thread {
    public void run() {
        while(true) {
            var value = buffer.consume();

            System.out.println("Consumindo" + value);
        }
    }
}
