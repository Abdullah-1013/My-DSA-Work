
class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {

        return top == -1;
    }
    public boolean isFull() {

        return top == capacity - 1;
    }
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot add element.");
            return;
        }
        arr[++top] = element;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot delete element.");
            return -1;
        }
        return arr[top--];
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            result.append(arr[i]);
            if (i < top) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack elements: " + stack);
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack elements after popping: " + stack);
    }
}


