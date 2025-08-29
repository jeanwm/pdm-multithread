import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> queue;
    private int capacity;

    private Object full  = new Object();
    private Object empty = new Object();

    public Buffer(final int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public boolean isFull() {
        return queue.size() == capacity;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(int value) {
        synchronized (queue) {
            queue.offer(value);
        }
    }

    public Integer dequeue() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    public void produce (int value) {
        while (isFull()) {
            System.out.print("Buffer cheio, aguardando...");

            try {
                synchronized (full) {
                    full.wait();
                }
            } catch (InterruptedException e) {
            }
        }

        enqueue(value);
        synchronized (empty) {
            empty.notifyAll();
        }
    }
}
