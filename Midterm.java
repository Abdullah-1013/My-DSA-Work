import java.util.*;

class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private PriorityQueue<Integer> minHeap;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
        this.minHeap = new PriorityQueue<>();
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || (front == rear + 1);
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Enqueue operation failed.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        queue[rear] = element;
        minHeap.add(element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Dequeue operation failed.");
            return -1;
        }

        int minElement = queue[front];
        minHeap.remove(minElement);

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return minElement;
    }

    public int getMinimum() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No minimum element.");
            return -1;
        }
        return minHeap.peek();
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = front;
        do {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        } while (i != (rear + 1) % capacity);
        System.out.println();
    }
}

class Main_10{
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);

        System.out.println("Original Queue:");
        circularQueue.printQueue();

        int minElement = circularQueue.dequeue();
        System.out.println("Dequeued minimum element: " + minElement);

        System.out.println("Queue after dequeue:");
        circularQueue.printQueue();
    }
}
