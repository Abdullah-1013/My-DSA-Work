public class BinaryHeap {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public BinaryHeap() {
        this.heap = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }
    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }
    public int deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int minValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return minValue;
    }
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[index] < heap[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }


    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && heap[rightChildIndex(index)] < heap[smallerChildIndex]) {
                smallerChildIndex = rightChildIndex(index);
            }
            if (heap[index] > heap[smallerChildIndex]) {
                swap(index, smallerChildIndex);
            } else {
                break;
            }
            index = smallerChildIndex;
        }
    }
    private boolean isEmpty() {
        return size == 0;
    }
    private void ensureCapacity() {
        if (size == heap.length) {
            int[] newHeap = new int[heap.length * 2];
            for (int i = 0; i < size; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
    }
    private boolean hasParent(int index) {
        return index > 0;
    }
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryHeap();
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        System.out.println("Min element: " + minHeap.deleteMin());

    }
}
