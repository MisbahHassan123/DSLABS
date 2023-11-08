public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap[size] = value;
        size++;
        // Maintain the max heap property by "bubbling up" the newly inserted element.
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parentIndex]) {
            // Swap the current element with its parent until the max heap property is restored.
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int extractMax() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot extract max.");
            return -1;
        }

        int max = heap[0];
        // Replace the root with the last element and reduce the size.
        heap[0] = heap[size - 1];
        size--;
        // Maintain the max heap property by "bubbling down" the new root.
        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int largest = index;

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            // Swap the current element with the largest child until the max heap property is restored.
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getMax() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot get max.");
            return -1;
        }
        return heap[0];
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(15);

        System.out.println("Max value: " + maxHeap.getMax());

        maxHeap.extractMax();

        System.out.println("Max value after extraction: " + maxHeap.getMax());
    }
}
