/*class Node2 {
    int data;
    Node next;
}

class QueueLinkedList {
    Node front;
    Node rear;

    boolean enqueue(int v) {
        Node newNode = new Node();
        newNode.data = v;
        newNode.next = null;
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        return true;
    }

    Node dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Node removedNode = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return removedNode;
    }

    boolean isFull() {
        return false; // Assuming unlimited capacity for a linked list based queue
    }

    boolean isEmpty() {
        return front == null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = front;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString();
    }

    Node front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front;
    }
}

class Main3 {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue: " + queue);
        System.out.println("Front element: " + queue.front().data);

        Node dequeuedNode = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedNode.data);
        System.out.println("Queue after dequeue: " + queue);

        System.out.println("Is empty? " + queue.isEmpty());
    }
}
*/