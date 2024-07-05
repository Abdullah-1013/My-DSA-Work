/*class Node1 {
    int data;
    Node next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private Node top;
    private int size;
    private int capacity;

    public LinkedListStack(int capacity) {
        this.top = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void addAtEnd(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot add more elements.");
            return;
        }

        Node newNode = new Node(data);
        if (isEmpty()) {
            top = newNode;
        } else {
            Node temp = top;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public int deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot delete.");
            return -1;
        }

        if (size == 1) {
            int data = top.data;
            top = null;
            size--;
            return data;
        }

        Node temp = top;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node temp = top;
        while (temp != null) {
            result.append(temp.data);
            if (temp.next != null) {
                result.append(", ");
            }
            temp = temp.next;
        }
        result.append("]");
        return result.toString();
    }
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(5);

        stack.addAtEnd(10);
        stack.addAtEnd(20);
        stack.addAtEnd(30);

        System.out.println("Stack after adding elements: " + stack);

        stack.deleteAtEnd();
        System.out.println("Stack after deleting an element: " + stack);

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());
    }
}





*/