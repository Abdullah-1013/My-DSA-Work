class QueueUsingArray {
    public int[] arr;
    public int front;
    public int rear;
    public int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = this.rear = -1;
    }

    public boolean enqueue(int v) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear++;
        }
        arr[rear] = v;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return value;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = front; i <= rear; i++) {
            result.append(arr[i]).append(" ");
        }
        return result.toString();
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }
}

class Queue {
    public static void main(String[] args) {
        QueueUsingArray queueArray = new QueueUsingArray(5);

        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        System.out.println("Queue using Array: " + queueArray);
        System.out.println("Front element: " + queueArray.front());
        System.out.println("Dequeue: " + queueArray.dequeue());
        System.out.println("Queue after dequeue: " + queueArray);
        System.out.println("Is empty? " + queueArray.isEmpty());
        System.out.println("Is full? " + queueArray.isFull());
    }
}